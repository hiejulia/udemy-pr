package com.project.webstore.validator;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.project.webstore.domain.Product;
/**
 * USING SPRING VALIDATOE
 * @author hien
 *
 */
@Component
public class UnitsInStockValidator implements Validator{

   public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);  
   }

   public void validate(Object target, Errors errors) {
      Product product = (Product) target;

//      if(product.getPrice()!= null && new BigDecimal(1000).compareTo(product.getPrice())<=0 && product.getUnitsInStock()>99) {
//         errors.rejectValue("unitsInStock", "com.project.webstore.validator.UnitsInStockValidator.message");
//      }
   }

}
