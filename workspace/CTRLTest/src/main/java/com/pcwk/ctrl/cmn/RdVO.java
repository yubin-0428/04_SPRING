package com.pcwk.ctrl.cmn;

public class RdVO extends DTO {
	private long rNum; // 댓글번호
	private String rdCon; // 내용
	private String rdReg; // 작성일
	private String rdName; // 작성자
	private String mNum; // 회원번호
	
	public RdVO() {}

	public RdVO(long rNum, String rdCon, String rdReg, String rdName, String mNum) {
		super();
		this.rNum = rNum;
		this.rdCon = rdCon;
		this.rdReg = rdReg;
		this.rdName = rdName;
		this.mNum = mNum;
	}

	public long getrNum() {
		return rNum;
	}

	public void setrNum(long rNum) {
		this.rNum = rNum;
	}

	public String getRdCon() {
		return rdCon;
	}

	public void setRdCon(String rdCon) {
		this.rdCon = rdCon;
	}

	public String getRdReg() {
		return rdReg;
	}

	public void setRdReg(String rdReg) {
		this.rdReg = rdReg;
	}

	public String getRdName() {
		return rdName;
	}

	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	@Override
	public String toString() {
		return "RdVO [rNum=" + rNum + ", rdCon=" + rdCon + ", rdReg=" + rdReg + ", rdName=" + rdName + ", mNum=" + mNum
				+ ", toString()=" + super.toString() + "]";
	}

	
}
