package com.pcwk.ctrl.cmn;

public class MemberVO extends DTO {
	private String mNum; // 회원번호
	private String mName; // 이름
	private String mEmail; // 이메일
	private String mTel; // 전화번호
	private String mAddr; // 주소
	private String mGrade; // 등급
	
	public MemberVO() {}

	public MemberVO(String mNum, String mName, String mEmail, String mTel, String mAddr, String mGrade) {
		super();
		this.mNum = mNum;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mTel = mTel;
		this.mAddr = mAddr;
		this.mGrade = mGrade;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public String getmGrade() {
		return mGrade;
	}

	public void setmGrade(String mGrade) {
		this.mGrade = mGrade;
	}

	@Override
	public String toString() {
		return "MemberVO [mNum=" + mNum + ", mName=" + mName + ", mEmail=" + mEmail + ", mTel=" + mTel + ", mAddr="
				+ mAddr + ", mGrade=" + mGrade + ", toString()=" + super.toString() + "]";
	}
	
	
}