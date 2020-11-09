package com.revature.beans.skillsets;

import com.revature.beans.SipSet;

public class SipSkillSet implements SipSet{

	public int basicSip() {
		
		return 1;
	}

	public int bigSip() {
		int basic=basicSip();
		int big=(basic*4)/2;
		return big;
	}
	

	

}
