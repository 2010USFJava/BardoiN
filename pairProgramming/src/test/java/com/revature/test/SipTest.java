package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.skillsets.SipSkillSet;


public class SipTest {
	@BeforeClass
	public static void initialSetUp() {
		System.out.println("I run once before everything");
	}
	
	@Before
	public void runBeforeEachTest() {
		System.out.println("I run before each test");
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void test2() {
		//assertFalse(true);
		
		//expected value vs the actual value
		assertEquals(1,1);
	}
	
	@Test
	public void basicSipTest() {
		SipSkillSet wss= new SipSkillSet();
		int actual= wss.basicSip();
		assertEquals(1,actual);
	}
	
	@Test
	public void bigSipTest() {
		SipSkillSet wss= new SipSkillSet();
		int expected=2;
		int actual=wss.bigSip();
		assertEquals(expected,actual);
	}
	
}
