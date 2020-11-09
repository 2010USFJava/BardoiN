package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.beans.Cup;
import com.revature.beans.skillsets.SipSkillSet;
import com.revature.services.Drink;
import com.revature.services.Drink.sipType;

public class DrinkTest {
	static Cup a;
	
	@BeforeClass
	public static void loadCup() {
		SipSkillSet skillSet= Mockito.mock(SipSkillSet.class);
		a= new Cup(10,0,skillSet);
		System.out.println("Loaded Characters...");
		System.out.println(a.toString());
	}
	
	@Test
	public void sipPhaseBasicTest() {
		Mockito.when(a.getSkillset().basicSip()).thenReturn(1);
		Drink.sipPhase(a,sipType.BASIC);
		int remainingAmt= a.getAmount();
		assertEquals(remainingAmt,9);
	}
}
