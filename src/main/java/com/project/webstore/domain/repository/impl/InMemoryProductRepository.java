package com.project.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.webstore.domain.Product;
import com.project.webstore.domain.repository.ProductRepository;
import com.project.webstore.exception.ProductNotFoundException;
/**
 * IN MEMORY PRODUCT REPOSITORY
 * @author hien
 * @implements ProductRepository
 */
@Repository
public class InMemoryProductRepository implements ProductRepository{
  
   @Autowired
   private NamedParameterJdbcTemplate jdbcTemplate;

   @Override
   public List<Product> getAllProducts() {
      Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
      
        return result;
   }

   private static final class ProductMapper implements RowMapper<Product> {
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
         Product product = new Product();
         product.setProductId(rs.getString("ID"));
         product.setName(rs.getString("NAME"));
         product.setDescription(rs.getString("DESCRIPTION"));
         product.setPrice(rs.getBigDecimal("PRICE"));
         product.setTeacher(rs.getString("TEACHER"));
         product.setCategory(rs.getString("CATEGORY"));
         product.setCondition(rs.getString("CONDITION"));
         product.setSeatAvailable(rs.getLong("SEAT_AVAILABLE"));
         product.setNumOfSeats(rs.getLong("NUM_OF_SEATS"));
         product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
         return product;
      }
   }
   

   
   
   @Override 
   public void updateProductCourse(String productId, long seatAvailable) {
	   String sql = "update PRODUCTS set SEAT_AVAILABLE =:seatAvailable where ID =:id";
	   Map<String, Object> params = new HashMap<>();
	      params.put("seatAvailable", seatAvailable); 
	      params.put("id", productId); 
	     
	      jdbcTemplate.update(sql, params); 
	   
	   
   }
   
   
   
   
   @Override
   public List<Product> getProductsByCategory(String category) {
      String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("category", category);

      return jdbcTemplate.query(SQL, params, new ProductMapper());
   }
   // get product by teacher
   @Override 
   public List<Product> getProductsByTeacher(String teacher){
	   String SQLQuery = "select * from PRODUCTS where TEACHER =:teacher";
	   Map<String,Object> params = new HashMap<String,Object>();
	   params.put("teacher", teacher);
	   
	   return jdbcTemplate.query(SQLQuery, params,new ProductMapper());
   }
   

   // filter search for product course
   @Override
   public List<Product> getProductsByFilter(Map<String,List<String>> filterParams){
	   String sqlQuery = "select * from PRODUCTS where CATEGORY in (:category) and TEACHER in (:teacher)";
	   return jdbcTemplate.query(sqlQuery,filterParams,new ProductMapper());
   }
   
   
   
   
   
   /**
    * get product by id
    */
   @Override
   public Product getProductById(String productID) {
      String SQL = "SELECT * FROM PRODUCTS WHERE ID = :id";  
      Map<String, Object> params = new HashMap<>();
      params.put("id", productID);  
         
      try {
         return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
      } catch (DataAccessException e) {
    	  // throw exception of product not found exception
         throw new ProductNotFoundException(productID);
      }   
   }

   // add product course
   @Override
   public void addProduct(Product product) {
         String SQL = "INSERT INTO PRODUCTS (ID, "
               + "NAME,"
               + "DESCRIPTION,"
               + "PRICE,"
               + "TEACHER,"
               + "CATEGORY,"
               + "CONDITION,"
               + "NUM_OF_SEAT,"
               + "SEAT_AVAILABLE,"
               + "DISCONTINUED) "
               + "VALUES (:id, :name, :desc, :price, :teacher, :category, :condition, :numOfSeat, :seatAvailable, :discontinued)";  
         
         Map<String, Object> params = new HashMap<>();
         params.put("id", product.getProductId());  
         params.put("name", product.getName());  
         params.put("desc", product.getDescription());  
         params.put("price", product.getPrice());  
         params.put("teacher", product.getTeacher());  
         params.put("category", product.getCategory());  
         params.put("condition", product.getCondition());  
         params.put("seatAvailable", product.getSeatAvailable());  
         params.put("numOfSeat", product.getNumOfSeats());  
         params.put("discontinued", product.isDiscontinued());  

         jdbcTemplate.update(SQL, params);     
      }


}