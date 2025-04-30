package com.nt.service;

import java.util.List;

import com.nt.entity.ProductEntity;

public interface IProductMgmtService {
   public ProductEntity registerProduct(ProductEntity prodEntity);
   public List<ProductEntity> getAllProducts();
   public ProductEntity findProductById(Integer pId);
   public String deleteProductById(Integer pId);
   
}
