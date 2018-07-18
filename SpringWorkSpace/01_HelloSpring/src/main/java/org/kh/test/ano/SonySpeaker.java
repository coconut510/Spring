package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("����Ŀ ��ü ���� �Ϸ�");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SonySpeaker ==> ������ �������ϴ�.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SonySpeaker ==> ������ �������ϴ�.");
	}
}

