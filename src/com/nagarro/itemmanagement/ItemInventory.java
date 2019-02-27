/* 
 * @class ItemInventory
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
 * @lastUpdateDate 18/01/2019 at 12:00 PM
 */

package com.nagarro.itemmanagement;

import java.util.Scanner;

import java.util.InputMismatchException;
import com.nagarro.service.Deletion;
import com.nagarro.service.Display;
import com.nagarro.service.Insertion;

/**
 * The ItemInventory class of ItemManager Project
 * basically the Main Class having Main Function
 * Inside it with Menu Of Operation a user Can
 * Perform.
 * 
 * @author naveenjain
 *
 */

public class ItemInventory {

	public static void main(String[] args) {
		
		/*Fields*/
		
		String option = "yes";					
		int choice = -1;
		boolean check1 = true;
		
		/*Scanner Objects*/
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		
		/*Menu Options Start From here*/
		
		System.out.println("(@-@)**Welcome To The "
				+ "Item Inventory Management(@-@)**");
		do {
			
			System.out.println("(@**@)::Menu::(@**@)");
			System.out.println("1. For Add Items.");
			System.out.println("2. For Delete Items.");
			System.out.println("3. For Display List Of Items.");
			System.out.println("4. For Display Particular Item.");
			System.out.println("5. Exit.");

			do {
				System.out.print("Enter Your Choice::");
				try{
					choice = sc1.nextInt();
					check1 = false;
				} catch(InputMismatchException e1) {
					System.out.println("**Choice Should Be Enter "
							+ "in a Number**");
					sc1.next();
				} 
			} while (check1 == true);
			
			switch(choice) {
				case 1:
					Insertion insertion = new Insertion();
					insertion.addItemToList();
					System.out.println("**Item is Successfully "
							+ "Added Into DataBase**");
					break;
					
				case 2:
					Deletion deletion = new Deletion();
					boolean check = deletion.deleteItemFromList();
					if(check == true) {
						System.out.println("\n**Item is "
								+ "Successfullyn Deleted**");
					} else {
						System.out.println("\n**Item is Not Exist "
								+ "in The DataBase**");
					}
					break;
					
					
				case 3:
					Display display1 = new Display();
					display1.displayCompleteListInfo();
					break;
					
				case 4:
					Display display2 = new Display();
					display2.displayParticularItemInfo();
					break;
					
				case 5:
					System.out.println("\n @ **Thank You For Using "
							+ "Inventry Management Software** @ :-)");
					System.exit(0);
					break;
					
				default:
					System.out.println("You Enter the Wrong Choice "
							+ "Try Again Plz::");
					break;
			}
			
			System.out.print("\nDo You Want to Continue (Yes/No)::");
			option = sc3.nextLine();
			
		} while (option.equalsIgnoreCase("yes") 
					|| option.equalsIgnoreCase("y"));
		
		/*Closing Of Scanner Objects*/
		
		sc1.close();
		sc3.close();
		
		if (option.equalsIgnoreCase("no") 
				|| option.equalsIgnoreCase("n")) {
			System.out.println("\n @ **Thank You For Using "
					+ "Inventry Management Software** @ :-)");
		}
	}
}
