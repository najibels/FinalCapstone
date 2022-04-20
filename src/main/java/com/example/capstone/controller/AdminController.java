package com.example.capstone.controller;

import com.example.capstone.forms.ProductFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//
//import com.example.capstone.entity.Album;
//import com.example.capstone.forms.AlbumForm;
//import com.example.capstone.forms.ProductFormValidator;
//import com.example.capstone.models.OrderDetailInfo;
//import com.example.capstone.models.OrderInfo;
//import com.example.capstone.pagination.PaginationResult;
//import com.example.capstone.repos.AlbumDAO;
////import org.apache.tomcat.util.ExceptionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.apache.commons.lang.exception.ExceptionUtils;
//
//
//import java.util.List;
//
//@Controller
//@Transactional
//public class AdminController {
//
//    @Autowired
//    private OrderDAO orderDAO;
//
//    @Autowired
//    private AlbumDAO albumDAO;
//
//    @Autowired
//    private ProductFormValidator productFormValidator;
//
//    @InitBinder
//    public void myInitBinder(WebDataBinder dataBinder) {
//        Object target = dataBinder.getTarget();
//        if (target == null) {
//            return;
//        }
//        System.out.println("Target=" + target);
//
//        if (target.getClass() == AlbumForm.class) {
//            dataBinder.setValidator(productFormValidator);
//        }
//    }
//
//    // GET: Show Login Page
//    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
//    public String login(Model model) {
//
//        return "login";
//    }
//
//    @RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
//    public String accountInfo(Model model) {
//
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getPassword());
//        System.out.println(userDetails.getUsername());
//        System.out.println(userDetails.isEnabled());
//
//        model.addAttribute("userDetails", userDetails);
//        return "accountInfo";
//    }
//
//    @RequestMapping(value = { "/admin/orderList" }, method = RequestMethod.GET)
//    public String orderList(Model model, //
//                            @RequestParam(value = "page", defaultValue = "1") String pageStr) {
//        int page = 1;
//        try {
//            page = Integer.parseInt(pageStr);
//        } catch (Exception e) {
//        }
//        final int MAX_RESULT = 5;
//        final int MAX_NAVIGATION_PAGE = 10;
//
//        PaginationResult<OrderInfo> paginationResult //
//                = orderDAO.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);
//
//        model.addAttribute("paginationResult", paginationResult);
//        return "orderList";
//    }
//
//    // GET: Show album.
//    @RequestMapping(value = { "/admin/album" }, method = RequestMethod.GET)
//    public String album(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
//        AlbumForm albumForm = null;
//
//        if (code != null && code.length() > 0) {
//            Album album = albumDAO.findAlbum(code);
//            if (album != null) {
//                albumForm = new AlbumForm(album);
//            }
//        }
//        if (albumForm == null) {
//            albumForm = new AlbumForm();
//            albumForm.setNewAlbum(true);
//        }
//        model.addAttribute("albumForm", albumForm);
//        return "album";
//    }
//
//    // POST: Save album
//    @RequestMapping(value = { "/admin/album" }, method = RequestMethod.POST)
//    public String albumSave(Model model, //
//                              @ModelAttribute("albumForm") @Validated AlbumForm albumForm, //
//                              BindingResult result, //
//                              final RedirectAttributes redirectAttributes) {
//
//        if (result.hasErrors()) {
//            return "album";
//        }
//        try {
//            albumDAO.save(albumForm);
//        } catch (Exception e) {
//            Throwable rootCause = ExceptionUtils.getRootCause(e);
//            String message = rootCause.getMessage();
//            model.addAttribute("errorMessage", message);
//            // Show album form.
//            return "album";
//        }
//
//        return "redirect:/productList";
//    }
//
//    @RequestMapping(value = { "/admin/order" }, method = RequestMethod.GET)
//    public String orderView(Model model, @RequestParam("orderId") String orderId) {
//        OrderInfo orderInfo = null;
//        if (orderId != null) {
//            orderInfo = this.orderDAO.getOrderInfo(orderId);
//        }
//        if (orderInfo == null) {
//            return "redirect:/admin/orderList";
//        }
//        List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);
//        orderInfo.setDetails(details);
//
//        model.addAttribute("orderInfo", orderInfo);
//
//        return "order";
//    }
//
//}
@Controller
public class AdminController {
    @GetMapping("/addProduct") public String addProduct(Model model) {
        model.addAttribute("productForm", new ProductFormValidator());
        return "addProduct";

    }
}
