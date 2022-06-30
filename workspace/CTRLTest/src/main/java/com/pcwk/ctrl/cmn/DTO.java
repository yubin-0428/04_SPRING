package com.pcwk.ctrl.cmn;

public class DTO {
	private int no;//순번
	
	public DTO() {}

	public DTO(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "DTO [no=" + no + "]";
	}
}
