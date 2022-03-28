package com.example.tacocloud.repository;

import java.util.UUID;

import com.example.tacocloud.domainobj.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, UUID> {
    
}
