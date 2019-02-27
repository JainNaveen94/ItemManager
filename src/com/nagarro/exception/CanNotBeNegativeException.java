/* 
 * @class CanNotBeNegativeException
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 17/01/2019 at 11:00 AM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 17/01/2019 at 04:00 PM
 */

package com.nagarro.exception;

/**
 * The CanNotBeNegativeException class of 
 * ItemManager Project basically used for
 * Describe the User Defined Exception.
 * 
 * @author naveenjain
 *
 */

@SuppressWarnings("serial")
public class CanNotBeNegativeException extends Exception{
	
	/*Default Constructor*/
	
	public CanNotBeNegativeException() {}
	
	/*Parameterized Constructor*/
	
	public CanNotBeNegativeException(String str) { 
		super(str);									
	}
	
	
}
