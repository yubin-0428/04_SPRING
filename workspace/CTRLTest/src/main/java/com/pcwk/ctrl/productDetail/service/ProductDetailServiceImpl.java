package com.pcwk.ctrl.productDetail.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.productDetail.dao.ProductDetailDao;

@Service("productDetailService")
public class ProductDetailServiceImpl implements ProductDetailService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private ProductDetailDao productDetailDao;

	@Override
	public ProductVO doProductDetailSelect(ProductVO inVO) {
		return productDetailDao.doProductDetailSelect(inVO);
	}

	
}
