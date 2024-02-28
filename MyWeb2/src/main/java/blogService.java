
public class blogService {
	BlogDAO BlogDAO = new BlogDAO();
	
	public blogService() {
	}
	
	public void addBlog(BlogDTO BlogDTO) {
		BlogDAO.addBlog(BlogDTO);
	}
}
