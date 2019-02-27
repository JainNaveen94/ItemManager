/*
 * @class DataBase
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 16/01/2019 at 1:00 PM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 18/01/2019 at 11:00 AM
 */

package com.nagarro.dao;

import java.util.ArrayList;

import com.nagarro.dto.Item;

/**
 * The DataBase class of ItemManager Project
 * basically used for Storing the Items into 
 * the DataBase which is Array List.
 * 
 * @author naveenjain
 *
 */

public class DataBase {
	
	/*Fields*/
	
	private static DataBase database = null;				//Instance of Database Class.
	private ArrayList<Item> list = new ArrayList<Item>();	//Used to Store item in List.
	
	/*Default Constructor*/
	
	private DataBase() {}
	
	/*Methods*/
	
	public static DataBase getDataBase() {					// used to return the single
		if(database == null) {								// instance of DataBase class
			database = new DataBase();						// for entire Project.
		}
		return database;
	}
	
	public void addItem(Item item) {						// Used to Add the Items
		list.add(item);										// Information Into List.
	}
	
	public void deleteItem(Item item) {						// Used to Delete the Items
		list.remove(item);									// Information From List.
	}
	
	public ArrayList<Item> giveItemList() {					// Used For Return The
		return list;										// Complete list.
	}
}
