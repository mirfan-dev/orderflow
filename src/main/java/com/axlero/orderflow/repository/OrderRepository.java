package com.axlero.orderflow.repository;

import com.axlero.orderflow.entity.Customer;
import com.axlero.orderflow.entity.TradeOrder;
import com.axlero.orderflow.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<TradeOrder, Long> {

    Optional<TradeOrder> findByOrderId(String orderId);

    List<TradeOrder> findByCustomerOrderByCreatedAtDesc(Customer customer);

    List<TradeOrder> findTop50ByOrderByCreatedAtDesc();

    List<TradeOrder> findByStatusOrderByCreatedAtDesc(OrderStatus status);
}
