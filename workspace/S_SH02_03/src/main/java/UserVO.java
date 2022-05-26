

public class UserVO {

	private String uId; // 사용자 아이디
	private String name; // 이름
	private String passwd; // 비번

	public UserVO() {
		
	}

	public UserVO(String uId, String name, String passwd) {
		super();
		this.uId = uId;
		this.name = name;
		this.passwd = passwd;
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
		return "UserVO [uId=" + uId + ", name=" + name + ", passwd=" + passwd + "]";
	}

	
}
