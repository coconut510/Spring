package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	
	public AppleSpeaker() {
		super();
	}
	
	@Override
	public void powerOn() {
		System.out.println("AppleSpeaker ==> ������ �������ϴ�.");
	}

	@Override
	public void powerOff() {
		System.out.println("AppleSpeaker ==> ������ �������ϴ�.");
	}

}
