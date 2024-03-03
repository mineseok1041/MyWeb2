import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BlogDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public BlogDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBlog(BlogDTO blogDTO) {
		String title = blogDTO.getTitle();
		String contents = blogDTO.getContents();
		String writer = blogDTO.getWriter();
		String writerID = blogDTO.getWriterID();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "insert into blog_t";
			query += " (blogNum, title, contents, writer, writeDate, writerID)";
			query += " values(blogIndex.nextval, ?,?,?, sysdate, ?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, writer);
			pstmt.setString(4, writerID);
			pstmt.executeUpdate();
			System.out.println("New blog added : ");
			System.out.println("Title : " + title 
							+ " Contents : " + contents
							+ " Writer : " + writer
							+ " WriterID : " + writerID);
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BlogDTO getBlogInfo(BlogDTO BlogDTO) {
		int blogNum = BlogDTO.getBlogNum();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from blog_t where blogNum=?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, blogNum);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			BlogDTO.setBlogNum(rs.getInt("blogNum"));
			BlogDTO.setTitle(rs.getString("title"));
			BlogDTO.setContents(rs.getString("contents"));
			BlogDTO.setWriter(rs.getString("writer"));
			BlogDTO.setWriteDate(rs.getDate("writeDate"));

			rs.close();
			pstmt.close();
			con.close();
			
			return BlogDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<BlogDTO> getBlogList(int max, boolean isDesc, String search) {
		try {
			con = dataFactory.getConnection();

			String query = "select * from ( select * from blog_t";
			if (search != null) {
				query += " where (title||contents||writer) like '%" + search + "%'";
			}
			if (isDesc) {
				query += " order by blogNum desc";
			} else {
				query += " order by blogNum asc";
			}
			query += " ) where rownum <= ?";
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, max);
		
			ResultSet rs = pstmt.executeQuery();

			List<BlogDTO> BlogList = new ArrayList<BlogDTO>();
			
			while (rs.next()) {
				BlogDTO BlogDTO = new BlogDTO();
				
				BlogDTO.setBlogNum(rs.getInt("blogNum"));
				BlogDTO.setTitle(rs.getString("title"));
				BlogDTO.setWriter(rs.getString("writer"));
				BlogDTO.setWriteDate(rs.getDate("writeDate"));

				BlogList.add(BlogDTO);
			}

			rs.close();
			pstmt.close();
			con.close();

			return BlogList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<BlogDTO> getmyBlogList(int max, boolean isDesc, String ID) {
		try {
			con = dataFactory.getConnection();

			String query = "select * from ( select * from blog_t";
			query += " where (writerID) like '%" + ID + "%'";
			if (isDesc) {
				query += " order by blogNum desc";
			} else {
				query += " order by blogNum asc";
			}
			query += " ) where rownum <= ?";
			
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, max);
		
			ResultSet rs = pstmt.executeQuery();

			List<BlogDTO> BlogList = new ArrayList<BlogDTO>();
			
			while (rs.next()) {
				BlogDTO BlogDTO = new BlogDTO();
				
				BlogDTO.setBlogNum(rs.getInt("blogNum"));
				BlogDTO.setTitle(rs.getString("title"));
				BlogDTO.setWriter(rs.getString("writer"));
				BlogDTO.setWriteDate(rs.getDate("writeDate"));

				BlogList.add(BlogDTO);
			}

			rs.close();
			pstmt.close();
			con.close();

			return BlogList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
