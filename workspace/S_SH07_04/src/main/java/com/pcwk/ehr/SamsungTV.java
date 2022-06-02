package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SamsungTV implements Tv {
	
	final Logger LOG = LogManager.getLogger(getClass());
	String brand = "삼성 TV";
	private SonySpeaker speaker;
	private int price;
	
//	public SamsungTV(String brand) {
//		this.brand = brand;
//	}
	
	public SamsungTV() {
		LOG.debug(brand + " dafault 생성자 SamsungTV()");
	}
	
	//생성자 인젝션
	public SamsungTV(SonySpeaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	//인자 여러개 생성자 인젝션
	public SamsungTV(SonySpeaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
		
		LOG.debug(brand + "인자 2개 생성자 호출");
		LOG.debug("price" + price);
	}
	
	//생성자 다음 초기화
	public void initMethod() {
		LOG.debug(brand + " initMethod()");
	}


	//자원반납, applicationContext 종료시 수행
	public void destroyMethod() {
		LOG.debug(brand + " destroyMethod()");
	}

	@Override
	public void powerOn() {
		LOG.debug(brand + " 전원을 켠다");
	}

	@Override
	public void powerOff() {
		LOG.debug(brand + " 전원을 끈다");
	}

	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		//LOG.debug(brand + " 볼륨을 높인다");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//speaker = new SonySpeaker();
		//LOG.debug(brand + " 볼륨을 낮춘다");
		speaker.volumeDown();
	}

}
