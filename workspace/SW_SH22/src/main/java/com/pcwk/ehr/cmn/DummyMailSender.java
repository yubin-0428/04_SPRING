package com.pcwk.ehr.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
    final Logger LOG = LogManager.getLogger(getClass());
	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOG.debug("**************************************");
		LOG.debug("**개발에서는 메일이 발송되지 않습니다.^^*");
		LOG.debug("**************************************");

	}

	@Override
	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		// TODO Auto-generated method stub

	}

}
