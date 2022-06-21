package com.pcwk.dao;

public class MemberDAO {
	private PreparedStatement pstmt;
    private Connection con;
    private DataSource dataFactory;
    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List listmembers(MemberVO memberVO) {
        List<MemberVO> membersList = new ArrayList<MemberVO>();
        String name_1 = memberVO.getName();
        try {
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            
            if((name_1 != null && name_1.length() != 0)) {
                query += " where name=?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, name_1);
            }else {
                pstmt = con.prepareStatement(query);
            }
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                
                membersList.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return membersList;
    }
}
}
