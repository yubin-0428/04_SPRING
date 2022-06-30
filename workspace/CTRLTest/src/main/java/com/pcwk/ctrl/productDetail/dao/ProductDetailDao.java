package com.pcwk.ctrl.productDetail.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.ReviewVO;

public interface ProductDetailDao {
	
	/**
	 * 상품 상세 페이지에 필요한 정보 셀렉
	 * @param vo
	 * @return ProductVO
	 */
	ProductVO doProductDetailSelect(ProductVO vo);
}