/* 
 * @class Deletion
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
 * The Deletion class of ItemManager 
 * Project basically used for Deleting
 * the item from the DataBase.
 * 
 * @author naveenjain
 *
 */

public class Deletion {
	
	/*Fields*/
	
	Item item;										// Item Object of Item Class type.
	
	/*Scanner Objects*/
	
	Scanner sc3 = new Scanner(System.in);
	
	/*Methods*/
	
	public boolean deleteItemFromList() {			//Use for Deleting Item.
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
		if(item == null) {
			return false;
		} else {
			DataBase database = DataBase.getDataBase();
			database.deleteItem(item);
			return true;
		}
	}
}
