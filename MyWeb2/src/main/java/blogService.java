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
	
	public BlogDTO getBlogInfo(BlogDTO BlogDTO) {
		return BlogDAO.getBlogInfo(BlogDTO);
	}
}
