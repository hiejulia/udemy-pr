package com.project.webstore.domain;

import java.io.Serializable;

import javax.validation.constraints.Size;
// customer buy course = student buy course to learn 
public class Customer implements Serializable{

   private static final long serialVersionUID = 2284040482222162898L;
   
   private Long customerId;
   @Size(min=4, max=50, message="{Size.Customer.name.validation}")
   private String name;
   private Address billingAddress;
   private String phoneNumber;
   private Organisation organisation;
   
   public Customer() {
      super();
      this.billingAddress = new Address();
   }
   
   public Customer(Long customerId, String name) {
      this();
      this.customerId = customerId;
      this.name = name;
   }

   public Long getCustomerId() {
      return customerId;
   }

   public void setCustomerId(long customerId) {
      this.customerId = customerId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Address getBillingAddress() {
      return billingAddress;
   }

   public void setBillingAddress(Address billingAddress) {
      this.billingAddress = billingAddress;
   }
   
   public Organisation getOrganisation() {
	   return organisation;
   } 
   public void setOrganisation(Organisation org) {
	   this.organisation = org;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Customer other = (Customer) obj;
      if (customerId == null) {
         if (other.customerId != null)
            return false;
      } else if (!customerId.equals(other.customerId))
         return false;
      return true;
   }
}
