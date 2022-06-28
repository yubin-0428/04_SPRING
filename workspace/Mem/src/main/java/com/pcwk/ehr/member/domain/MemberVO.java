package com.pcwk.ehr.member.domain;

import com.pcwk.ehr.cmn.DTO;

public class MemberVO extends DTO {
	private int mNum;
	private String mId;
	private String mPw;
	private String mMail;
	private String mPhone;
	
	public MemberVO(int mNum, String mId, String mPw, String mMail, String mPhone) {
		super();
		this.mNum = mNum;
		this.mId = mId;
		this.mPw = mPw;
		this.mMail = mMail;
		this.mPhone = mPhone;
	}
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmMail() {
		return mMail;
	}
	public void setmMail(String mMail) {
		this.mMail = mMail;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	@Override
	public String toString() {
		return "MemberVO [mNum=" + mNum + ", mId=" + mId + ", mPw=" + mPw + ", mMail=" + mMail + ", mPhone=" + mPhone
				+ "]";
	}
	
	
	
}