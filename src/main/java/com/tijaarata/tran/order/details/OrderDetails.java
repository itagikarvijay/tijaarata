/**
 * 
 */
package com.tijaarata.tran.order.details;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tijaarata.entity.BaseEntity;
import com.tijaarata.tran.order.Order;

/**
 * @author User
 *
 */

@Entity
@Table(name = "order_details")
public class OrderDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

//	@Column(name = "order_id")
//	private Integer orderId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "quantity")
	private Float quantity;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "price")
	private Integer price;

	@Column(name = "amount")
	private Float amount;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderDetails() {
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

//	/**
//	 * @return the order_id
//	 */
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	/**
//	 * @param order_id the order_id to set
//	 */
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}

	/**
	 * @return the product_id
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public Float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the item_id
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param item_id the item_id to set
	 */
	public void setItem_id(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
//		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
//		if (orderId == null) {
//			if (other.orderId != null)
//				return false;
//		} else if (!orderId.equals(other.orderId))
//			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + "orderId" + ", productId=" + productId + ", quantity="
				+ quantity + ", itemId=" + itemId + ", price=" + price + ", amount=" + amount + "]";
	}

}
