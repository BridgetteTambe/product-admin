package com.bree.com.repositories;

import com.bree.com.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Long> {
}
