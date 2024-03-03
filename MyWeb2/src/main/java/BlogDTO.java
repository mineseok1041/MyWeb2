import java.sql.Date;

public class BlogDTO {
	private int blogNum;
	private String title;
	private String contents;
	private String writer;
	private Date writeDate;
	private String writerID;
	
	public BlogDTO() {
	}
	
	public BlogDTO(int blogNum, String title, String contents, String writer) {
		this.blogNum = blogNum;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	public BlogDTO(int blogNum, String title, String contents, String writer, Date writeDate) {
		this.blogNum = blogNum;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	
	public int getBlogNum() {
		return blogNum;
	}
	
	public void setBlogNum(int blogNum) {
		this.blogNum = blogNum;
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
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public String getWriterID() {
		return writerID;
	}
	
	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}
}
