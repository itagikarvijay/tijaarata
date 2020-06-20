/**
 * 
 */
package com.tijaarata.tran.order;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tijaarata.entity.BaseEntity;
import com.tijaarata.master.customer.Customer;
import com.tijaarata.tran.order.details.OrderDetails;

/**
 * @author User
 *
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "store_id")
	private Integer storeId;

//	@Column(name = "customer_id")
//	private Integer customerId;

	@Column(name = "shiping_address")
	private String shipingAddress;

	@Column(name = "shiping_date")
	private Date shipingDate;

	@Column(name = "shipping_status")
	private String shippingStatus;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	@JsonManagedReference
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order() {

	}

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

//	/**
//	 * @return the customerId
//	 */
//	public Integer getCustomerId() {
//		return customerId;
//	}
//
//	/**
//	 * @param customerId the customerId to set
//	 */
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((shipingAddress == null) ? 0 : shipingAddress.hashCode());
		result = prime * result + ((shipingDate == null) ? 0 : shipingDate.hashCode());
		result = prime * result + ((shippingStatus == null) ? 0 : shippingStatus.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Order other = (Order) obj;
//		if (customerId == null) {
//			if (other.customerId != null)
//				return false;
//		} else if (!customerId.equals(other.customerId))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (shipingAddress == null) {
			if (other.shipingAddress != null)
				return false;
		} else if (!shipingAddress.equals(other.shipingAddress))
			return false;
		if (shipingDate == null) {
			if (other.shipingDate != null)
				return false;
		} else if (!shipingDate.equals(other.shipingDate))
			return false;
		if (shippingStatus == null) {
			if (other.shippingStatus != null)
				return false;
		} else if (!shippingStatus.equals(other.shippingStatus))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", customerId=" +" customerId"
				+ ", shipingAddress=" + shipingAddress + ", shipingDate=" + shipingDate + ", shippingStatus="
				+ shippingStatus + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}

}
