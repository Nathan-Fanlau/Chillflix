package models;

import java.util.Date;

public class Payment {
	private int id;
	private double price;
	private Date date;
	private String status;
	
	public Payment(int id, double price, Date date, String status) {
		super();
		this.id = id;
		this.price = price;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
