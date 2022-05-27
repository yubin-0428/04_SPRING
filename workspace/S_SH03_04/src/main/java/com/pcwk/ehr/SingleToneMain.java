package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleToneMain {

   final static Logger LOG = LogManager.getLogger(SingleToneMain.class);
   public static void main(String[] args) {
      
      DaoFactory factory = new DaoFactory();
      UserDao userDao01 = factory.userDao();
      UserDao userDao02 = factory.userDao();
      
      LOG.debug("--------------------------");
      LOG.debug("-userDao01-"+userDao01);
      LOG.debug("-userDao02-"+userDao02);
      LOG.debug("--------------------------");
      
      //싱글톤 패턴
      //애플리케이션 내에서 제한된 인스턴스 개수, 이름처럼 하나만 존재하도록 강제하는 패턴
      ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
      UserDao userDao03 = (UserDao)context.getBean("userDao");
      UserDao userDao04 = context.getBean("userDao",UserDao.class);
      
      LOG.debug("===========================");
      LOG.debug("=userDao03="+userDao03);
      LOG.debug("=userDao04="+userDao04);
      LOG.debug("===========================");
      
   }

}