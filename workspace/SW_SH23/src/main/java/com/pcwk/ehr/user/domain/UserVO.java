package com.pcwk.ehr.user.domain;

import com.pcwk.ehr.cmn.DTO;

public class UserVO extends DTO {
	private String uId;  // 사용자 아이디
	private String name; // 이름
	private String passwd; // 비밀번호
	
	private Level  level;//등급: 1 -> BASIC,2 -> SILVER,3 -> GOLD
	private int    login; //로그인
	private int    recommend;//추천수
	private String email;//이메일
	private String regDt;//등록일
	
	private int intLevel;//mybatis level
	
	public UserVO() {}
	
	public UserVO(String uId, String name, String passwd, Level level, int login, int recommend, String email,
			String regDt) {
		super();
		this.uId = uId;
		this.name = name;
		this.passwd = passwd;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
		this.email = email;
		this.regDt = regDt;
		
		this.intLevel = level.getValue();
	}
	
	
	
	public int getIntLevel() {
		return intLevel;
	}

	public void setIntLevel(int intLevel) {
		this.intLevel = intLevel;
		//mybatis
		this.level=Level.valueOf(intLevel);
		
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		
		//mybatis
		if(null !=level) {
			this.intLevel = this.level.getValue();
		}
	}
   
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", name=" + name + ", passwd=" + passwd + ", level=" + level + ", login=" + login
				+ ", recommend=" + recommend + ", email=" + email + ", regDt=" + regDt + ", toString()="
				+ super.toString() + "]";
	}

    //
	/**
	 * 다음 레벨로 up
	 */
	public void upgradeLevel() {
		Level nextLevel = this.level.nextLevel();
		if(null == nextLevel) {
			throw new IllegalArgumentException(this.level+"더이상 등업이 불가능 합니다.");
		}else {
			this.level = nextLevel;
			
			//mybatis
			this.intLevel = this.level.getValue();
		}
	}
	

	
	
}
