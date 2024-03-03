import java.util.ArrayList;
import java.util.List;

public class blogService {
	BlogDAO BlogDAO = new BlogDAO();
	
	public blogService() {
	}
	
	public void addBlog(BlogDTO BlogDTO) {
		BlogDAO.addBlog(BlogDTO);
	}
	
	public List<BlogDTO> getBlogList(int max, boolean isDesc, String search) {
		List<BlogDTO> BlogList = new ArrayList<BlogDTO>();
		BlogList = BlogDAO.getBlogList(max, isDesc, search);
		
		return BlogList;
	}
	
	public List<BlogDTO> getmyBlogList(int max, boolean isDesc, String ID) {
		List<BlogDTO> BlogList = new ArrayList<BlogDTO>();
		BlogList = BlogDAO.getmyBlogList(max, isDesc, ID);
		
		return BlogList;
	} 
	
	public BlogDTO getBlogInfo(BlogDTO BlogDTO) {
		return BlogDAO.getBlogInfo(BlogDTO);
	}
	
	public void deleteBlog(BlogDTO BlogDTO) {
		BlogDAO.deleteBlog(BlogDTO);
	}
	
	public void updateBlog(BlogDTO BlogDTO) {
		BlogDAO.updateBlog(BlogDTO);
	}
}
