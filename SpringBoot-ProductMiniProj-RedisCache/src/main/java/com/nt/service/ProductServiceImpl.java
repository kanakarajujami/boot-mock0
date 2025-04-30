/**
 * 
 */
package com.nt.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.nt.entity.ProductEntity;
import com.nt.repository.IProductRepository;
public class ProductServiceImpl implements IProductMgmtService {
	@Autowired
     private IProductRepository prodRepo;
	@Override
	
	public ProductEntity registerProduct(ProductEntity prodEntity) {
	     ProductEntity entity=prodRepo.save(prodEntity);
		return entity;
	}

	@Override
	@Cacheable(value="prods")
	public List<ProductEntity> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	@Cacheable(value = "prods",key="#productId")
	public ProductEntity findProductById(Integer pId) {
		return prodRepo.findById(pId).get();
	}

	@Override
	@CacheEvict(value="prods",key = "#productId")
	public String deleteProductById(Integer pId) {
		  Optional<ProductEntity> optEntity=prodRepo.findById(pId);
		  if(optEntity.isPresent()) {
			   prodRepo.deleteById(optEntity.get().getProductId());
		  }
		return "product deleted";
	}

}
