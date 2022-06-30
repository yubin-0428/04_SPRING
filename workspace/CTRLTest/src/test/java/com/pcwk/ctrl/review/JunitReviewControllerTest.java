package com.pcwk.ctrl.review;


import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.review.dao.ReviewDao;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                 "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"      
}) //applicationContext.xml loading
public class JunitReviewControllerTest {
   
   final Logger LOG = LogManager.getLogger(this.getClass());
   
   @Autowired
   WebApplicationContext webApplicationContext;
   
   //브라우저 대역(Mock)
   MockMvc mockMvc;
   
   @Autowired
   ReviewDao dao;
   ReviewVO review01;
   
     @Before
     public void setUp()throws Exception{
        LOG.debug("====================");
        LOG.debug("=0.setUp()=");
        LOG.debug("====================");

        review01 = new ReviewVO(164, "1", 1, "안녕하세요, junitReviewrControllerTest입니다.", "kjh", "날짜_사용안함");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        LOG.debug("webApplicationContext : "+ webApplicationContext);
        LOG.debug("mockMvc : "+ mockMvc);
        
        assertNotNull(webApplicationContext);
        assertNotNull(mockMvc);
     }

     @Test
     public void doReviewInsert() throws Exception {
         //호출url, param, 호출방식(get/post)
         //GET방식으로 : http://localhost:8081/ehr/user/add.do?uId=p12
         MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/review/reviewInsert.do")       
               .param("d_num",review01.getdNum())        
               .param("o_num",review01.getoNum()+"")        
               .param("contents",review01.getrContent())        
               .param("o_name",review01.getoName());
         
         //대역 객체 통해 호출
         ResultActions resultActions = mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
         String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
         
         LOG.debug("====================");
         LOG.debug("result : "+ result);
         LOG.debug("====================");      
     }
}












