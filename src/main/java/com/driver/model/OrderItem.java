package com.driver.model;

public class OrderItem {
	private long item_id;
	private String name;
	private int quantity;
	private double unitPrice;
	private int averageFoodPreaparationTime; // average food prep. time in minutes, it can vary based on many condition

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAverageFoodPreaparationTime() {
		return averageFoodPreaparationTime;
	}

	public void setAverageFoodPreaparationTime(int averageFoodPreaparationTime) {
		this.averageFoodPreaparationTime = averageFoodPreaparationTime;
	}

}
