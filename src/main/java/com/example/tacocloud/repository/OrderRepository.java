package com.example.tacocloud.repository;

import java.util.UUID;

import com.example.tacocloud.domainobj.TacoOrder;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
    
}
