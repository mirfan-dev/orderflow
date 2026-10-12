package com.axlero.orderflow.service;

import com.axlero.orderflow.entity.Customer;
import com.axlero.orderflow.entity.Trade;
import com.axlero.orderflow.entity.TradeOrder;
import com.axlero.orderflow.enums.OrderSide;
import com.axlero.orderflow.enums.OrderType;

import java.util.List;
import java.util.Optional;
public interface OrderPersistenceService {


    TradeOrder createAndSaveOrder(String orderId, OrderSide side, OrderType orderType, double price, int quantity, Customer customer);

    void recordTradeExecution(String buyOrderId, String sellOrderId, int quantity, double price, long executionLatencyMicros);

    boolean cancelOrder(String orderId);

    Optional<TradeOrder> getOrderByOrderId(String orderId);

    List<TradeOrder> getOrdersByCustomer(Customer customer);

    List<TradeOrder> getRecentOrders();

    List<Trade> getRecentTrades();

    List<Trade> getTradesByCustomer(Long customerId);
}
