package com.pcwk.ctrl.cmn;

public class OrderVO extends DTO {
	private long oNum; // 주문번호
	private String oAddr; // 주소
	private String oName; // 이름
	private String oTel; // 전화번호
	private String oStatus; // 주문상태
	private String oDt; // 주문날짜
	private String mNum; // 회원번호
	
	public OrderVO() {}

	public OrderVO(long oNum, String oAddr, String oName, String oTel, String oStatus, String oDt, String mNum) {
		super();
		this.oNum = oNum;
		this.oAddr = oAddr;
		this.oName = oName;
		this.oTel = oTel;
		this.oStatus = oStatus;
		this.oDt = oDt;
		this.mNum = mNum;
	}

	public long getoNum() {
		return oNum;
	}

	public void setoNum(long oNum) {
		this.oNum = oNum;
	}

	public String getoAddr() {
		return oAddr;
	}

	public void setoAddr(String oAddr) {
		this.oAddr = oAddr;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoTel() {
		return oTel;
	}

	public void setoTel(String oTel) {
		this.oTel = oTel;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	public String getoDt() {
		return oDt;
	}

	public void setoDt(String oDt) {
		this.oDt = oDt;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	@Override
	public String toString() {
		return "OrderVO [oNum=" + oNum + ", oAddr=" + oAddr + ", oName=" + oName + ", oTel=" + oTel + ", oStatus="
				+ oStatus + ", oDt=" + oDt + ", mNum=" + mNum + ", toString()=" + super.toString() + "]";
	}
	
	
}
