package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {

}
