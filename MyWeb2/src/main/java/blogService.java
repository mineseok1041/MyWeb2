import java.util.ArrayList;
import java.util.List;

public class blogService {
	BlogDAO BlogDAO = new BlogDAO();
	
	public blogService() {
	}
	
	public void addBlog(BlogDTO BlogDTO) {
		BlogDAO.addBlog(BlogDTO);
	}
	
	public List<BlogDTO> getBlogList() {
		List<BlogDTO> BlogList = new ArrayList<BlogDTO>();
		BlogList = BlogDAO.getBlogList();
		
		return BlogList;
	}
	
	public BlogDTO getBlogInfo(BlogDTO BlogDTO) {
		return BlogDAO.getBlogInfo(BlogDTO);
	}
}
