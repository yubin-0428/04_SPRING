package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppleSpeaker implements Speaker {

	final Logger LOG = LogManager.getLogger(getClass());
	private String brand = "Apple Speaker";
	
	public AppleSpeaker() {}
	
	@Override
	public void volumeUp() {
		LOG.debug(brand+"volumeUp() 호출");
		
	}

	@Override
	public void volumeDown() {
		LOG.debug(brand+"volumeDown() 호출");

	}

}
