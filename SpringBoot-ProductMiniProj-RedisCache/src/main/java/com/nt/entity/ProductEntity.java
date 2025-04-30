package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="PRODUCT_DETAILS")
@Entity
@Data
public class ProductEntity {
  @Id
  @GeneratedValue
  private Integer productId;
  private String productName;
  private Integer productPrice;
  private Integer productQty;
}
