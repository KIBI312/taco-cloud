package com.example.tacocloud.repository;

import java.util.List;

import com.example.tacocloud.domainobj.TacoOrder;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
