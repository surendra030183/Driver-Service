package com.driver.model;

import java.util.Date;
import java.util.List;

public class Order {

	private String id;
	private long orderId;
	private long customerId;
	private long restaurantId;
	private double distance;
	private String orderStatus;
	private Date orderDate;
	private double totalPrice;
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	private int foodPreparationTime;
	private List<OrderItem> list;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getFoodPreparationTime() {
		return foodPreparationTime;
	}

	public void setFoodPreparationTime(int foodPreparationTime) {
		this.foodPreparationTime = foodPreparationTime;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


}
