package com.pcwk.ctrl.cart.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cart.service.CartService;
import com.pcwk.ctrl.cmn.CartVO;

@Controller("cart_controller")
@RequestMapping("cart")
public class CartController {

final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	CartService cartService;
	
	public CartController() {}

	@RequestMapping(value = "/doSelect.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String  doCartSelect(CartVO inVO) throws IOException {
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("productDetail()");
		LOG.debug("=================================");
		
		CartVO outVO = cartService.doCartSelect(inVO);
	    LOG.debug("outVO : " + outVO);	
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("=================================");
		LOG.debug("jsonString : " + jsonString);
		LOG.debug("=================================");

		return jsonString;
	}
}