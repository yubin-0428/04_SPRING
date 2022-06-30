package com.pcwk.ctrl.order.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.order.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	OrderService orderService;
	
	public OrderController() {}
	
	@RequestMapping(value = "/orderList.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	public String orderList(Model model, MemberVO inVO) throws SQLException {
		LOG.debug("=================================");
		LOG.debug("orderList()");
		LOG.debug("=================================");
		
		if(null == inVO.getmNum()) {
			inVO.setmNum("1");
		}
		
		List<Map<String, DTO>> list = orderService.doRetrieve(inVO);
	    LOG.debug("list : " + list);
		model.addAttribute("list", list);
	    
	    return "order/order_list";
	}
}
