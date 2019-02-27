/* 
 * @class Item
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 14/01/2019 at 1:00 PM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 18/01/2019 at 11:00 AM
 */

package com.nagarro.dto;

/**
 * The Item class of ItemManager Project
 * basically used for Representing the Items 
 * And Its Related Operation.
 * 
 * @author naveenjain
 *
 */

public class Item {
	
	/*Fields*/
	
	String name;			// Name Of The Item.
	String type;			// Type Of The Item which Should be
							// Raw, Manufactured and Imported.
	double price;			// cost price of the item.
	double salestax;		// Sales tax which apply on cost.
	double finalprice;		// Final Price (cost + sales tax).
	int quantity;			// Quantity Of Particular Item.
	
	/* Default Constructor*/
	
	public Item() {
		this.name = "unknown name";
		this.type = null;
		this.price = 0.00;
		this.salestax = 0.00;
		this.finalprice = 0.00;
		this.quantity = 0;
	}
	
	/*Parameterized Constructor*/
	
	public Item(String name, String type, double price,int quantity) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	
	/*Method (getter / Setter)*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSalestax() {
		return salestax;
	}

	public void setSalestax(double salestax) {
		this.salestax = salestax;
	}

	public double getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
