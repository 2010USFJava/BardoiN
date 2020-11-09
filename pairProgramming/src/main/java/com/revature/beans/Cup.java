package com.revature.beans;

import com.revature.beans.skillsets.SipSkillSet;

public class Cup {
	
	private int amount = 10;
	private int sip;
	private SipSkillSet skillset;
	
	public Cup() {
		super();
	}

	public Cup(int amount, int sip, SipSkillSet skillset) {
		super();
		this.amount = amount;
		this.sip = sip;
		this.skillset = skillset;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getSip() {
		
		return sip;
	}

	public void setSip(int sip) {
		this.sip = sip;
	}

	public SipSkillSet getSkillset() {
		return skillset;
	}

	public void setSkillset(SipSkillSet skillset) {
		this.skillset = skillset;
	}

	@Override
	public String toString() {
		return "Cup [amount=" + amount + ", skillset=" + skillset + "]";
	}
	
	
	
}
