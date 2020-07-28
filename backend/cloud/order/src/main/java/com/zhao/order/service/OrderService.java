package com.zhao.order.service;

import com.zhao.order.domain.Order;

/**
 * @author 12236
 */
public interface OrderService {
    /**
     * @param order
     */
    void create(Order order);

    Order getOrder(Long id);

    void update(Order order);

    void delete(Long id);
}
