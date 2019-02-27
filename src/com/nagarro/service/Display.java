/* 
 * @class Display
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
 * @lastUpdateDate 15/01/2019 at 01:00 PM
 */

package com.nagarro.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nagarro.dao.DataBase;
import com.nagarro.dto.Item;

/**
 * The Display class of ItemManager 
 * Project basically used for display
 * purpose.
 * 
 * @author naveenjain
 *
 */

public class Display {
	
	/*Fields*/
	Item item;
	
	/*Scanner Objects*/
	Scanner sc3 = new Scanner(System.in);
	
	/*Methods*/
	
	public static Item searchItem(String name) {				// for Search item.
		for(Item item2: DataBase.getDataBase().giveItemList()) {
			if(item2.getName().equalsIgnoreCase(name)) {
				return item2;
			}
		}
		return null;
	}
	
	public void displayCompleteListInfo() {						// Display complete list.
		System.out.println("**::List Of Items::**");
		for(Item item1: DataBase.getDataBase().giveItemList()) {
			System.out.println("\nName::" + item1.getName() + 
					"\tCost Price::" + item1.getPrice() + 
					"\tSales Tax::" + item1.getSalestax() +
					"\tFinal Cost::" + item1.getFinalprice());
		}
	}
	
	public void displayParticularItemInfo() {					// Display Particular item.
		String name = "";
		int check1 = 1;
		@SuppressWarnings("unused")
		int check2;
		boolean numeric = true;
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
		item = Display.searchItem(name);
		if (item == null) {
			System.out.println("\n**Item Is Not Exist In The System**");
		} else {
			System.out.println("**::Item Info::**");
			System.out.println("\nName::" + item.getName() + 
					"\tCost Price::" + item.getPrice() + 
					"\tSales Tax::" + item.getSalestax() +
					"\tFinal Cost::" + item.getFinalprice());
		}
	}
	

}
