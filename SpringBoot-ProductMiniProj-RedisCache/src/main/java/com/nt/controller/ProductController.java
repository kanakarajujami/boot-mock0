package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.ProductEntity;
import com.nt.service.IProductMgmtService;

@RestController
@RequestMapping("/prod-api")
public class ProductController {
    @Autowired	
	private IProductMgmtService service;
   @GetMapping("/save")	
   public ResponseEntity<String> saveProduct(@RequestBody ProductEntity entity){
	  ProductEntity savedentity=service.registerProduct(entity);
	  return new ResponseEntity<String>("product saved::"+savedentity,HttpStatus.OK);
	  
   }
   
   @GetMapping("/allprods")
   public ResponseEntity<List<ProductEntity>> showAllProducts(){
	   List<ProductEntity> listProds=service.getAllProducts();
	   return new ResponseEntity<List<ProductEntity>>(listProds,HttpStatus.OK);
   }
   
   @GetMapping("/find/{prodId}")
  public ResponseEntity<ProductEntity> showProductById(@PathVariable Integer prodId){
	  ProductEntity entity=service.findProductById(prodId);
	  return new ResponseEntity<ProductEntity>(entity,HttpStatus.OK);
  }
   
   
   
   @DeleteMapping("delete/{prodId}")
   public ResponseEntity<String> deleteProductById(@PathVariable Integer prodId){
	    String msg=service.deleteProductById(prodId);
	    return new ResponseEntity<String>(msg,HttpStatus.OK);
   }
}
