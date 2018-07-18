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
		System.out.println("객체 생성 성공!");
	}
	public void powerOn()
	{
		System.out.println("전원이 켜졌습니다.");
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
}
