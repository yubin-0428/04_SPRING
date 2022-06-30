package com.pcwk.ctrl.cmn;

public class ReviewRdVO {
	private long rNum; // 댓글번호
	private String rContent; // 리뷰 내용
	private String rdCon; // 관리자 댓글 내용
	private String rdName; // 관리자 댓글 작성자
	private String pNum; // 상품번호
	private String oName; // 회원 이름
	private String mNum; // 회원번호
	private long oNum; // 주문번호
	private String dNum; // 주문 상세 번호
	
	public ReviewRdVO(long rNum, String rContent, String rdCon, String pNum, String oName, String mNum, long oNum,
			String dNum) {
		super();
		this.rNum = rNum;
		this.rContent = rContent;
		this.rdCon = rdCon;
		this.pNum = pNum;
		this.oName = oName;
		this.mNum = mNum;
		this.oNum = oNum;
		this.dNum = dNum;
	}

	public long getrNum() {
		return rNum;
	}

	public void setrNum(long rNum) {
		this.rNum = rNum;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getRdCon() {
		return rdCon;
	}

	public void setRdCon(String rdCon) {
		this.rdCon = rdCon;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
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

	@Override
	public String toString() {
		return "ReviewRdVO [rNum=" + rNum + ", rContent=" + rContent + ", rdCon=" + rdCon + ", pNum=" + pNum
				+ ", oName=" + oName + ", mNum=" + mNum + ", oNum=" + oNum + ", dNum=" + dNum + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
