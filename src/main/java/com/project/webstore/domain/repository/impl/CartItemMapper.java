package com.project.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.webstore.domain.CartItem;
import com.project.webstore.service.ProductService;
/**
 * CART MAPPER CLASS
 * @author hien
 * @product
 */
public class CartItemMapper implements RowMapper<CartItem> {
   private ProductService productService;
   
   public CartItemMapper(ProductService productService) {
      this.productService = productService;
   }

 
   
   @Override 
   public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
	   CartItem c = new CartItem(rs.getString("ID"));
	   c.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
	      c.setQuantity(rs.getInt("QUANTITY"));
	      return c;
   }
   
   
   
}
