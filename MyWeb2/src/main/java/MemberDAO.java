import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberDTO> listMembers() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			con = dataFactory.getConnection();
			MemberDTO MemberDTO = new MemberDTO();
			
			String query = "select * from MyWebUser_t ";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO.setId(rs.getString("id"));
				MemberDTO.setPw(rs.getString("pw"));
				MemberDTO.setName(rs.getString("name"));
				MemberDTO.setEmail(rs.getString("email"));
				MemberDTO.setJoinDate(rs.getDate("joinDate"));
				
				list.add(MemberDTO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberDTO memberDTO) {
		try {
			con = dataFactory.getConnection();
			
			String id = memberDTO.getId();
			String pw = memberDTO.getPw();
			String name = memberDTO.getName();
			String email = memberDTO.getEmail();
			
			String query = "insert into MyWebUser_t";
			query += " (id,pw,name,email)";
			query += " values(?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			System.out.println("addmember : " + id + pw + name + email);
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			String query = "delete from MyWebUser_t" + " where id=?";
			System.out.println("prepareStatememt:" + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberDTO memberDTO) {
		boolean result = false;
		String id = memberDTO.getId();
		String pw = memberDTO.getPw();
		System.out.println(id);
		System.out.println(pw);
		try {
			con = dataFactory.getConnection();
			String query = "select decode(count(*),1,'true','false') as result from mywebuser_t";
			query += " where id=? and pw=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(query);
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberDTO getMemberInfo(String id) {
		MemberDTO MemberDTO = new MemberDTO();
		
        try {
            con = dataFactory.getConnection();
            
            String query = "select * from MyWebUser_t where id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            
            MemberDTO.setId(rs.getString("id"));
			MemberDTO.setPw(rs.getString("pw"));
			MemberDTO.setName(rs.getString("name"));
			MemberDTO.setEmail(rs.getString("email"));
			MemberDTO.setJoinDate(rs.getDate("joinDate"));
            
            rs.close();
            pstmt.close();
            con.close();
            
            return MemberDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}

