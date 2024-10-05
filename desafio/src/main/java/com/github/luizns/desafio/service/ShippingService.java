package com.github.luizns.desafio.service;

import com.github.luizns.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basicValue = order.getBasic();

        if (basicValue < 100.0) {
            return 20.00;
        } else if (basicValue < 200.0) {
            return 12.00;
        } else {
            return 0.0;
        }
    }
}
