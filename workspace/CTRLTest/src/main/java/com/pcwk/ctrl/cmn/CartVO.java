package com.pcwk.ctrl.cmn;

public class CartVO extends DTO {
	private String pNum; // 상품번호
	private String pName; // 상품이름
	private long pPrice; // 가격

	public CartVO(String pNum, String pName, long pPrice) {
		super();
		this.pNum = pNum;
		this.pName = pName;
		this.pPrice = pPrice;
	}
	
	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public long getpPrice() {
		return pPrice;
	}

	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}
	
	@Override
	public String toString() {
		return "CartVO [pNum=" + pNum + ", pName=" + pName + ", pPrice=" + pPrice + ", toString()=" + super.toString() + "]";
	}
	
}