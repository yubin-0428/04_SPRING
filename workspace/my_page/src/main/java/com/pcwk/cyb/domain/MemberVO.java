package com.pcwk.cyb.domain;

public class MemberVO {
	
	// MemberVO : 순수하게 값을 저장하려는 용도
	
	private String K_NUM; // 회원번호
	private String K_NAME; // 이름
	private String K_EMAIL; // 이메일
	private String K_TEL; // 전화번호
	private String K_ADDR; // 주소
	private String K_GRADE; // 등급
	
	public MemberVO() {}
	
	public MemberVO(String k_NUM, String k_NAME, String k_EMAIL, String k_TEL, String k_ADDR, String k_GRADE) {
		super();
		K_NUM = k_NUM;
		K_NAME = k_NAME;
		K_EMAIL = k_EMAIL;
		K_TEL = k_TEL;
		K_ADDR = k_ADDR;
		K_GRADE = k_GRADE;
	}

	public String getK_NUM() {
		return K_NUM;
	}

	public void setK_NUM(String k_NUM) {
		K_NUM = k_NUM;
	}

	public String getK_NAME() {
		return K_NAME;
	}

	public void setK_NAME(String k_NAME) {
		K_NAME = k_NAME;
	}

	public String getK_EMAIL() {
		return K_EMAIL;
	}

	public void setK_EMAIL(String k_EMAIL) {
		K_EMAIL = k_EMAIL;
	}

	public String getK_TEL() {
		return K_TEL;
	}

	public void setK_TEL(String k_TEL) {
		K_TEL = k_TEL;
	}

	public String getK_ADDR() {
		return K_ADDR;
	}

	public void setK_ADDR(String k_ADDR) {
		K_ADDR = k_ADDR;
	}

	public String getK_GRADE() {
		return K_GRADE;
	}

	public void setK_GRADE(String k_GRADE) {
		K_GRADE = k_GRADE;
	}

	@Override
	public String toString() {
		return "MemberVO [K_NUM=" + K_NUM + ", K_NAME=" + K_NAME + ", K_EMAIL=" + K_EMAIL + ", K_TEL=" + K_TEL
				+ ", K_ADDR=" + K_ADDR + ", K_GRADE=" + K_GRADE + "]";
	}
	
	
	
}
