package com.revature.services;

import com.revature.beans.Cup;

public class Drink {

	public enum sipType{
		BASIC,
		BIG
		}
	
	public static void sipPhase(Cup a, sipType aType) {
		 int amt = a.getAmount();
		 int sipAmt;
		 if(aType.equals(sipType.BASIC)) {
			 sipAmt = a.getSkillset().basicSip();
		 } else if(aType.equals(sipType.BIG)) {
			 sipAmt = a.getSkillset().bigSip();
		 } else {
			 System.out.println("How did you mess this up?");
				sipAmt = 0;
		 }
		 amt = amt - sipAmt;
		 a.setAmount(amt);
		 System.out.println("Cup amount is now " + amt);
		}
	
}
