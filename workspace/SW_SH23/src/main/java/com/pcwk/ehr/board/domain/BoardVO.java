/**
* <pre>
* com.pcwk.ehr.board.domain
* Class Name : BoardVO.java
* Description: 게시판 Value Object
* Author: ITSC
* Since: 2022/06/24
* Version 0.1
* Copyright (C) by KandJang All right
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/06/24 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.board.domain;

import com.pcwk.ehr.cmn.DTO;

/**
 * @author ITSC
 *
 */
public class BoardVO extends DTO {

	private int seq	            ;//순번	    
	private String title	    ;//제목	    
	private String contents	    ;//내용	    
	private int    readCnt	    ;//조회수	    
	private String div	        ;//게시구분	
	private String regDt	    ;//등록일	    
	private String regId	    ;//등록자	    
	private String modDt	    ;//수정일	    
	private String modId	    ;//수정자	 
	
	
	public BoardVO() {}


	public BoardVO(int seq, String title, String contents, int readCnt, String div, String regDt, String regId,
			String modDt, String modId) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.readCnt = readCnt;
		this.div = div;
		this.regDt = regDt;
		this.regId = regId;
		this.modDt = modDt;
		this.modId = modId;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public int getReadCnt() {
		return readCnt;
	}


	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}


	public String getDiv() {
		return div;
	}


	public void setDiv(String div) {
		this.div = div;
	}


	public String getRegDt() {
		return regDt;
	}


	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}


	public String getRegId() {
		return regId;
	}


	public void setRegId(String regId) {
		this.regId = regId;
	}


	public String getModDt() {
		return modDt;
	}


	public void setModDt(String modDt) {
		this.modDt = modDt;
	}


	public String getModId() {
		return modId;
	}


	public void setModId(String modId) {
		this.modId = modId;
	}


	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", readCnt=" + readCnt + ", div="
				+ div + ", regDt=" + regDt + ", regId=" + regId + ", modDt=" + modDt + ", modId=" + modId
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
