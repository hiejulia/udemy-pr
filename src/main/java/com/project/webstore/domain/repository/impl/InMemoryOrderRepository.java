package com.project.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.project.webstore.domain.Address;
import com.project.webstore.domain.Customer;
import com.project.webstore.domain.Order;
import com.project.webstore.domain.Organisation;
import com.project.webstore.domain.ShippingDetail;
import com.project.webstore.domain.repository.OrderRepository;
import com.project.webstore.service.CartService;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTempleate;

	@Autowired
	private CartService CartService;

//	private static final class OrderMapper implements RowMapper<Order> {
//		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Order order = new Order();
////			order.setOrderId(rs.getString("ID"));
//			return order;
//			
//		}
//	}

	@Override
	public long saveOrder(Order order) {

		Long customerId = saveCustomer(order.getCustomer());
		Long shippingDetailId = saveShippingDetail(order.getShippingDetail());

		order.getCustomer().setCustomerId(customerId);
		order.getShippingDetail().setId(shippingDetailId);

		long createdOrderId = createOrder(order);
		CartService.clearCart(order.getCart().getId());//CLEAR CART

		return createdOrderId;
	}

	@Override
	public Order getOrderById(long id) {
		String sql = "select * from ORDERS where ID =:id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);

		try {
			return (Order) jdbcTempleate.queryForList(sql, params);
		} catch (DataAccessException e) {
			// throw new ProductNotFoundException(productID);
		}
		return (Order) jdbcTempleate.queryForList(sql, params);

	}

	private long saveShippingDetail(ShippingDetail shippingDetail) {
		long addressId = saveAddress(shippingDetail.getShippingAddress());

		String SQL = "INSERT INTO SHIPPING_DETAIL(NAME,SHIPPING_DATE,SHIPPING_ADDRESS_ID) "
				+ "VALUES (:name, :shippingDate, :addressId)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", shippingDetail.getName());
		params.put("shippingDate", shippingDetail.getShippingDate());
		params.put("addressId", addressId);

		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTempleate.update(SQL, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}

	// save customer
	private long saveCustomer(Customer customer) {

		long addressId = saveAddress(customer.getBillingAddress());
		long organisationId = saveOrganisation(customer.getOrganisation());

		String SQL = "INSERT INTO CUSTOMER(NAME,PHONE_NUMBER,BILLING_ADDRESS_ID,ORGANISATION) "
				+ "VALUES (:name, :phoneNumber, :addressId,:organisation)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", customer.getName());
		params.put("phoneNumber", customer.getPhoneNumber());
		params.put("addressId", addressId);
		params.put("organisation", organisationId);

		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTempleate.update(SQL, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}

	private long saveAddress(Address address) {
		String SQL = "INSERT INTO ADDRESS(DOOR_NO,STREET_NAME,AREA_NAME,STATE,COUNTRY,ZIP) "
				+ "VALUES (:doorNo, :streetName, :areaName, :state, :country, :zip)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("doorNo", address.getDoorNo());
		params.put("streetName", address.getStreetName());
		params.put("areaName", address.getAreaName());
		params.put("state", address.getState());
		params.put("country", address.getCountry());
		params.put("zip", address.getZipCode());

		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTempleate.update(SQL, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}

	// save organisation
	private long saveOrganisation(Organisation org) {
		String sql = "insert into ORGANISATION(name) " + "values (:name)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", org.getName());
		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTempleate.update(sql, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}
// CREATE ORDER
	private long createOrder(Order order) {

		String SQL = "INSERT INTO ORDERS(CART_ID,CUSTOMER_ID,SHIPPING_DETAIL_ID) "
				+ "VALUES (:cartId, :customerId, :shippingDetailId)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", order.getOrderId());
		params.put("cartId", order.getCart().getId());
		params.put("customerId", order.getCustomer().getCustomerId());
		params.put("shippingDetailId", order.getShippingDetail().getId());

		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTempleate.update(SQL, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}
	
	 
	
}
