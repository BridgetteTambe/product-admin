package com.bree.com.services.impl;

import com.bree.com.models.Order;
import com.bree.com.models.Product;
import com.bree.com.models.Status;
import com.bree.com.repositories.OrderRepository;
import com.bree.com.services.OrderService;
import com.bree.com.services.ProductService;
import com.bree.com.services.StatusService;
import com.bree.com.utils.ConstantString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * @param order 
     * @return
     * @throws Exception
     */
    @Override
    public Order placeOrder(Order order) throws Exception {
        return null;
    }

    /**
     * @param order 
     * @return
     * @throws Exception
     */
    @Override
    public Order approveOrder(Order order) throws Exception {
        return null;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Order findById(Long id) {
        return null;
    }

    /**
     * @param order 
     * @return
     * @throws Exception
     */
    @Override
    public Order cancelOrder(Order order) throws Exception {
        return null;
    }

    /**
     * @param pageable 
     * @return
     */
    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }
}
