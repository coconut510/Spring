package org.kh.tv.model.vo;

public class SamsungTV implements TV {
	public void powerOn()
	{
		System.out.println("SamSungTV-----������ �Ҵ�.");
	}
	public void powerOff()
	{
		System.out.println("SamSungTV-----������ ����.");
	}
	public void volumeUp()
	{
		System.out.println("SamSungTV-----�Ҹ��� �ø���.");
	}
	public void volumeDown()
	{
		System.out.println("SamSungTV-----�Ҹ��� ������.");
	}
}
