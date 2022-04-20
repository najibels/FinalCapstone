package com.example.capstone.services;

import com.example.capstone.entity.Order;
import com.example.capstone.exceptions.OrderException;
import com.example.capstone.models.CartInfo;
import com.example.capstone.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//import javax.security.auth.login.OrderNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private Order order;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(CartInfo order) {
        return null;
    }


    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }


    /**
     * Returns an Order object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an Order
     * @return      Order object
     */
    @Override
    public Order getOrderById(String id) throws OrderException {

        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return order;
        }
        throw new OrderException();
    }

    @Override
    public Optional<Order> getOrderByName(String name) throws OrderException {
        Optional<Order> order = orderRepository.findById(name);
        if (order == null) {
            throw new OrderException();
        }
        return order;
    }

    @Override
    public void deleteOrderById(String id) {
        orderRepository.deleteById(id);
    }
}
