package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SamsungTV implements Tv {
	final Logger LOG = LogManager.getLogger(getClass());
	final String brand = "삼성 TV ";
	private SonySpeaker speaker;
	
	public SamsungTV() {
		LOG.debug(brand+"default 생성자 SamsungTV()");
	}
	
	// 생성자 인덱션
	public SamsungTV(SonySpeaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	
	// 생성자 다음 초기화
	public void initMethod() {
		LOG.debug(brand+"initMethod()");
	}
	

	// 자원반납, applicationContext 종료시 수행
	public void destroyMethod() {
		LOG.debug(brand+"destroyMethod()");
	}
	
	@Override
	public void powerOn() {
		LOG.debug(brand+"전원을 켠다.");
	}

	@Override
	public void powerOff() {
		LOG.debug(brand+"전원을 끈다.");

	}

	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		// LOG.debug(brand+"볼륨을 높인다..");
		speaker.volumUp();
	}

	@Override
	public void volumeDown() {
		//speaker = new SonySpeaker();
		// LOG.debug(brand+"볼륨을 낮춘다..");
		speaker.volumeDown();
	}

}
