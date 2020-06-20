/**
 * 
 */
package com.tijaarata.tran.order;

import java.util.Date;
import java.util.List;

import com.tijaarata.dto.BaseDTO;
import com.tijaarata.master.customer.Customer;
import com.tijaarata.tran.order.details.OrderDetails;

/**
 * @author User
 *
 */
public class OrderDTO extends BaseDTO {

	public OrderDTO() {

	}

	private Integer id;

	private Integer userId;

	private Integer storeId;

	private Integer customerId;

	private String shipingAddress;

	private Date shipingDate;

	private String shippingStatus;

	private Date orderDate;

	private String orderStatus;

	private List<OrderDetails> orderDetails;

	private Customer customer;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the storeId
	 */
	public Integer getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the shipingAddress
	 */
	public String getShipingAddress() {
		return shipingAddress;
	}

	/**
	 * @param shipingAddress the shipingAddress to set
	 */
	public void setShipingAddress(String shipingAddress) {
		this.shipingAddress = shipingAddress;
	}

	/**
	 * @return the shipingDate
	 */
	public Date getShipingDate() {
		return shipingDate;
	}

	/**
	 * @param shipingDate the shipingDate to set
	 */
	public void setShipingDate(Date shipingDate) {
		this.shipingDate = shipingDate;
	}

	/**
	 * @return the shippingStatus
	 */
	public String getShippingStatus() {
		return shippingStatus;
	}

	/**
	 * @param shippingStatus the shippingStatus to set
	 */
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
