package com.github.luizns.desafio.service;

import com.github.luizns.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {

        var basicValue = order.getBasic();
        var discount = basicValue * (order.getDiscount() / 100.0);
        var shipmentCost = shippingService.shipment(order);

        return basicValue - discount + shipmentCost;
    }
}
