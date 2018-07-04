package org.kh.test.ano;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("computer")
public class Computer {
	@Resource(name="apple")
	private Speaker speaker;
	public Computer() {		
		System.out.println("��ü ���� ����!");
	}
	public void powerOn()
	{
		System.out.println("������ �������ϴ�.");
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
}
