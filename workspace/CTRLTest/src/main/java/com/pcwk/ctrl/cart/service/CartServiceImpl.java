package com.pcwk.ctrl.cart.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cart.dao.CartDao;
import com.pcwk.ctrl.cmn.CartVO;


@Service("cartService")
public class CartServiceImpl implements CartService {

	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired
	private CartDao cartDao;

	@Override
	public CartVO doCartSelect(CartVO inVO) {
		return cartDao.doCartSelect(inVO);
	}

	
}