/* 
 * @class Calculation
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 15/01/2019 at 12:00 PM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 15/01/2019 at 012:00 PM
 */

package com.nagarro.service;

import com.nagarro.dto.ItemType;

/**
 * The Calculation class of ItemManager 
 * Project basically used for Calculation
 * purpose.
 * 
 * @author naveenjain
 *
 */

public class Calculation {
	
	/*Method Which Calculates the Sales Tax.*/
	
	public static double salesTaxCalculation(double cost, 
			String type) {
		double salestax = 0.00;							// value of sales tax which 
														// is initially 0.
		
		if (type.equalsIgnoreCase(ItemType.RAW.getType())) {
			salestax = 0.125 * cost;
		} else if (type.equalsIgnoreCase(ItemType.MANUFACTURE.getType())) {
			salestax = 0.125 * cost;
			salestax += 0.002 * (cost + salestax);
		} else {
			double importduty = 0.10 * cost;			// used to calculate 
														// import duty.
			salestax = (0.125 * cost) + importduty;
			double finalcost = cost + salestax; 		// final cost after apply
														// taxes and import Duty.
			
			if ((finalcost > 0.00) && 
					(finalcost <= 100.00)) {
				salestax += 5;
			} else if ((finalcost > 100.00) && 
					(finalcost <= 200.00)) {
				salestax += 10;
			} else {
				salestax += 0.05 * finalcost;
			}
		}
		
		return salestax;
	}
	
	/*Method Which Calculate Final Cost.*/
	
	public static double finalCostCalculation(double cost, String type) {
		double finalcost = 0.00;
		double salestax = Calculation.salesTaxCalculation(cost, type);
		finalcost = salestax + cost;
		return finalcost;
	}
}
