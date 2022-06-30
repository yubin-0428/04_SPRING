package com.pcwk.ctrl.cmn;

public class ProductVO extends DTO {
	private String pNum; // 상품번호
	private String pCategory; // 카테고리
	private String pName; // 상품이름
	private long pPrice; // 가격
	private String pSize; // 용량
	
	public ProductVO() {}

	public ProductVO(String pNum, String pCategory, String pName, long pPrice, String pSize) {
		super();
		this.pNum = pNum;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
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

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	@Override
	public String toString() {
		return "ProductVO [pNum=" + pNum + ", pCategory=" + pCategory + ", pName=" + pName + ", pPrice=" + pPrice
				+ ", pSize=" + pSize + ", toString()=" + super.toString() + "]";
	}
}
