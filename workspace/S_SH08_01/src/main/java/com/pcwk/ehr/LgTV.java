package com.pcwk.ehr;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("tv")
@Repository // lgTV로 바꾸면 가능
public class LgTV implements Tv {
	final Logger LOG = LogManager.getLogger(getClass());
	final String brnad = "엘지Tv";
	
	@Resource(name = "appleSpeaker")
	private Speaker speaker;
	
	public LgTV() {}
	
	@Override
	public void powerOn() {
		LOG.debug(brnad+" 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		LOG.debug(brnad+" 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		//LOG.debug(brnad+" 볼륨을 높인다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//LOG.debug(brnad+" 볼륨을 내린다.");
		speaker.volumeDown();

	}

}
