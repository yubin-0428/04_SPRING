package com.pcwk.cyb.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.pcwk.cyb.domain.MemberVO;

public class MemberDao {
	
	// MemberDao : 데이터 베이스에 접근하는 클래스 정의
	
	private static MemberDao instance = new MemberDao();
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private MemberDao() {}
	
	public MemberDao getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		
	}
}

