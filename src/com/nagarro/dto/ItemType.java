/* 
 * @class ItemType
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 15/01/2019 at 1:00 PM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 17/01/2019 at 04:00 PM
 */

package com.nagarro.dto;

/**
 * The ItemType class of ItemManager Project
 * basically used for Describe the Item type 
 * Constant of Item Class.
 * 
 * @author naveenjain
 *
 */

public enum ItemType {
	
	/*CONSTANTS For Item Type.*/
	
	RAW("raw"), MANUFACTURE("manufacture"), IMPORTED("imported");
	
	/*Field For Custom Value Of Item Type.*/
	
	private String type;
	
	/*Constructor for setting the Custom Value to Item Type.*/
	
	private ItemType(String type) {
		this.type = type;
	}
	
	/*Method to get the Custom Value Of Item Type Constant*/
	
	public String getType()
	{
		return this.type;
	}
}
