package com.pcwk.ctrl.cmn;

public class ReviewVO extends DTO {
	private long rNum; // 댓글번호
	private String dNum; // 주문 상세 번호
	private long oNum; // 주문번호
	private String rContent; // 내용
	private String oName; // 작성자
	private String rDt; // 작성일
	
	public ReviewVO() {}

	public ReviewVO(long rNum, String dNum, long oNum, String rContent, String oName, String rDt) {
		super();
		this.rNum = rNum;
		this.dNum = dNum;
		this.oNum = oNum;
		this.rContent = rContent;
		this.oName = oName;
		this.rDt = rDt;
	}

	public long getrNum() {
		return rNum;
	}

	public void setrNum(long rNum) {
		this.rNum = rNum;
	}

	public String getdNum() {
		return dNum;
	}

	public void setdNum(String dNum) {
		this.dNum = dNum;
	}

	public long getoNum() {
		return oNum;
	}

	public void setoNum(long oNum) {
		this.oNum = oNum;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getrDt() {
		return rDt;
	}

	public void setrDt(String rDt) {
		this.rDt = rDt;
	}

	@Override
	public String toString() {
		return "ReviewVO [rNum=" + rNum + ", dNum=" + dNum + ", oNum=" + oNum + ", rContent=" + rContent + ", oName="
				+ oName + ", rDt=" + rDt + ", toString()=" + super.toString() + "]";
	}
}
