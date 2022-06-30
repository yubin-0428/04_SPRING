package com.pcwk.ctrl.productDetail.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.productDetail.service.ProductDetailService;

@Controller("productDetailController")
@RequestMapping("productDetail")
public class ProductDetailController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	ProductDetailService detailService;
	
	public ProductDetailController() {}

	@RequestMapping(value = "/doSelect.do", method = RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String  doProductDetailSelect(ProductVO inVO) throws IOException {
		String jsonString = "";
		LOG.debug("=================================");
		LOG.debug("productDetail()");
		LOG.debug("=================================");
		
		ProductVO outVO = detailService.doProductDetailSelect(inVO);
	    LOG.debug("outVO : " + outVO);	
		
		jsonString = new Gson().toJson(outVO);
		LOG.debug("=================================");
		LOG.debug("jsonString : " + jsonString);
		LOG.debug("=================================");

		return jsonString;
	}
	
	@RequestMapping(value="/view.do", method = RequestMethod.GET)
	public String productDetailView(Model model, ProductVO inVO) {
		LOG.debug("==================");
	    LOG.debug("=productDetailView()=");
	    LOG.debug("=inVO=" + inVO);
	    LOG.debug("==================");
		
	    model.addAttribute("productInfo", inVO);
		return "productDetail/productDetail";
	}
	
}
