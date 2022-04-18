package com.example.capstone.repos;

import com.example.capstone.entity.Album;
import com.example.capstone.forms.AlbumForm;
import com.example.capstone.models.ProductInfo;
import com.example.capstone.pagination.PaginationResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

import javax.persistence.NoResultException;
import java.io.IOException;

@Transactional
@Repository
public class AlbumDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Album findAlbum(String code) {
        try {
            String sql = "Select e from " + Album.class.getName() + " e Where e.code =:code ";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Album> query = session.createQuery(sql, Album.class);
            query.setParameter("code", code);
            return (Album) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public ProductInfo findProductInfo(String code) {
        Album product = this.findAlbum(code);
        if (product == null) {
            return null;
        }
        return new ProductInfo(product.getCode(), product.getName(), product.getPrice());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void save(AlbumForm albumForm) {

        Session session = this.sessionFactory.getCurrentSession();
        String code = albumForm.getCode();

        Album album = null;

        boolean isNew = false;
        if (code != null) {
            album = this.findAlbum(code);
        }
        if (album == null) {
            isNew = true;
            album = new Album();
            album.setCreateDate(new Date());
        }
        album.setCode(code);
        album.setName(albumForm.getName());
        album.setPrice(albumForm.getPrice());

        if (albumForm.getFileData() != null) {
            byte[] image = null;
            try {
                image = albumForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            if (image != null && image.length > 0) {
                album.setImage(image);
            }
        }
        if (isNew) {
            session.persist(album);
        }
        // If error in DB, Exceptions will be thrown out immediately
        session.flush();
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
                                                       String likeName) {
        String sql = "Select new " + ProductInfo.class.getName() //
                + "(p.code, p.name, p.price) " + " from "//
                + Album.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        }
        sql += " order by p.createDate desc ";
        //
        Session session = this.sessionFactory.getCurrentSession();
        Query<ProductInfo> query = session.createQuery(sql, ProductInfo.class);

        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
        return queryProducts(page, maxResult, maxNavigationPage, null);
    }

}
