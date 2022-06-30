package com.pcwk.ctrl.cmn;

public class NoticeVO {
	private long nNum;
	private String nTitle;
	private String nContent;
	private String nName;
	private String nRegdt;
	
	public NoticeVO() {}

	public NoticeVO(long nNum, String nTitle, String nContent, String nName, String nRegdt) {
		super();
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nName = nName;
		this.nRegdt = nRegdt;
	}

	public long getnNum() {
		return nNum;
	}

	public void setnNum(long nNum) {
		this.nNum = nNum;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnName() {
		return nName;
	}

	public void setnName(String nName) {
		this.nName = nName;
	}

	public String getnRegdt() {
		return nRegdt;
	}

	public void setnRegdt(String nRegdt) {
		this.nRegdt = nRegdt;
	}

	@Override
	public String toString() {
		return "NoticeVO [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nName=" + nName
				+ ", nRegdt=" + nRegdt + ", toString()=" + super.toString() + "]";
	}
}
