package com.pcwk.ctrl.cmn;

public class DetailVO extends DTO {
	private long oNum; // 주문번호
	private String dNum; // 주문 상세 번호
	private String dBuy; // 구매수량
	private String pNum; // 상품번호
	
	public DetailVO() {}

	public DetailVO(int oNum, String dNum, String dBuy, String pNum) {
		super();
		this.oNum = oNum;
		this.dNum = dNum;
		this.dBuy = dBuy;
		this.pNum = pNum;
	}

	public long getoNum() {
		return oNum;
	}

	public void setoNum(long oNum) {
		this.oNum = oNum;
	}

	public String getdNum() {
		return dNum;
	}

	public void setdNum(String dNum) {
		this.dNum = dNum;
	}

	public String getdBuy() {
		return dBuy;
	}

	public void setdBuy(String dBuy) {
		this.dBuy = dBuy;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "DetailVO [oNum=" + oNum + ", dNum=" + dNum + ", dBuy=" + dBuy + ", pNum=" + pNum + ", toString()="
				+ super.toString() + "]";
	}
}
