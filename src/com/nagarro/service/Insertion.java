/* 
 * @class Insertion
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 15/01/2019 at 01:00 PM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 18/01/2019 at 11:00 AM
 */

package com.nagarro.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nagarro.dao.DataBase;
import com.nagarro.dto.Item;
import com.nagarro.dto.ItemType;
import com.nagarro.exception.CanNotBeNegativeException;
import com.nagarro.exception.TypeCheckException;

/**
 * The Insertion class of ItemManager 
 * Project basically used for inserting
 * the item into the DataBase.
 * 
 * @author naveenjain
 *
 */

public class Insertion {
	
	/* Fields */
	
	String name = "";					// Name Of the Item.
	String type = "";					// Type of the Item.
	int quantity = 0;					// Quantity of the Item.
	double cost = 0.0;					// Cost Of the Item.
	double salestax = 0.0;				// Sales Tax On Item.
	double finalcost = 0.0;				// Final Cost Of the Item.
	Boolean numeric = true;				// use for validation of input.
	int check1 = 0;						// use for validation of input.
	int check2 = 0;						// use for validation of input.
	Item item;							// Item Class Object
	
	/* Scanner Class object */
	
	Scanner sc1 = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	Scanner sc3 = new Scanner(System.in);
	
	/*Methods*/
	
	/*
	 * It is method to get a Name from the user
	 * in such a way it must be String and then
	 * set it to name instant variable.
	 */
	
	public void setName() {
		check1 =1;
		check2 =1;
		numeric = true;
		do {
			System.out.print("Enter The Item Name:: ");
			try {
				name = sc3.nextLine();
				try {
					check2 = Integer.parseInt(name);
				} catch (NumberFormatException n) {
					numeric = false;
				}
				
				if (numeric == true) {
					throw new InputMismatchException();
				}
				check1 = 0;
			} catch (InputMismatchException m) {
				System.out.println("**Name Should not be Number**");
			}	
		} while (check1 == 1);
	}
	
	/*
	 * It is method to get a Quantity from the user
	 * in such a way it must be Number & greater than 0
	 * and then set it to quantity instant variable.
	 */
	
	public void setQuantity() {
		check1 = 1;
		do {
			System.out.print("\nEnter The Item Quantity:: ");
			try {
				quantity = sc1.nextInt();
				
				if (quantity == 0 || quantity < 0) {
					throw new CanNotBeNegativeException();
				}
				
				check1 = 0;
			} catch (InputMismatchException m) {
				System.out.println("**Quantity Should be Number**");
				sc1.next();
			} catch (CanNotBeNegativeException e) {
				System.out.println("**Quantity Should be Greater then 0**");
			}
		} while (check1 == 1);
	}
	
	/*
	 * It is method to get a Cost & type Of Item
	 * from the user in such a way that ::
	 * 1. cost must be Number & greater than 0.
	 * 2. Type must be raw/manufactured/imported.
	 */
	
	public void setCostAndType() {
		String cost_type = null;
		check1 = 1;
		numeric = true;
		int costcount=0;
		Double num = null;
		do {
			System.out.print("\nEnter The Item Type(Raw/Manufactured/Imported) and Cost (Sepearted With ','):: ");
			try {
				cost_type = sc3.nextLine();
				String[] cost_type_arr = cost_type.split(",");
				for(String str: cost_type_arr) {
					try {
						num = Double.parseDouble(str);
					} catch(NumberFormatException e) {
						numeric = false;
					}
					if (numeric == true) {
						cost = num;
						costcount++;
					} else {
						type = str;
					}
					numeric = true;
				}
				
				// Check the Cost Validation
				
				if (costcount == 0) {
					throw new InputMismatchException();
				}
				if (cost <= 0) {
					throw new CanNotBeNegativeException();
				}
				
				
				// Check the type Validation
				
				if (type.equalsIgnoreCase(ItemType.RAW.toString()) || 
						type.equalsIgnoreCase("manufacture") || 
						type.equalsIgnoreCase("imported")) {
					check1 = 0;
				} else {
					throw new TypeCheckException();
				}
				
				check1 = 0;
				
			} catch (TypeCheckException e1) {
				System.out.println("**Type Should be In (Raw/Manufactured/Imported)**");
			} catch (CanNotBeNegativeException e2) {
				System.out.println("**Cost Should Greater than 0**");
			} catch (InputMismatchException e3) {
				System.out.println("**Cost Should be a Number**");
			}
		} while (check1 == 1);
		
	}
	
	/*
	 * It is method to get Valid Data
	 * Related to Items From the user
	 * and set it to the Item Object.
	 */
	
	public void getData() {
		setName();
		setCostAndType();
		setQuantity();
		item = new Item(name, type, cost, quantity);
		salestax = Calculation.salesTaxCalculation(cost, type);
		item.setSalestax(salestax);
		finalcost = Calculation.finalCostCalculation(cost, type);
		item.setFinalprice(finalcost);
	}
	
	/*
	 * It is method which is used to add
	 * Item Into the data base.
	 */
	
	public void addItemToList() {
		getData();
		DataBase database = DataBase.getDataBase();
		database.addItem(item);
	}
}
