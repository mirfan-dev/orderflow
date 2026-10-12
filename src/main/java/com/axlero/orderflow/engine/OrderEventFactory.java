package com.axlero.orderflow.engine;

import com.axlero.orderflow.dto.OrderEvent;
import com.lmax.disruptor.EventFactory;


public class OrderEventFactory implements EventFactory<OrderEvent> {
    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
