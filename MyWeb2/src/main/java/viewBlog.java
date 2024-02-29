

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/blog/viewBlog/*")
public class viewBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public viewBlog() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		blogService blogService = new blogService();
		BlogDTO BlogDTO = new BlogDTO();
		
		String pathInfo = request.getPathInfo();
        String[] pathSegments = pathInfo.split("/");
        int blogId = Integer.parseInt(pathSegments[pathSegments.length - 1]);
	
        BlogDTO.setBlogNum(blogId);
		BlogDTO = blogService.getBlogInfo(BlogDTO);

		request.setAttribute("BlogDTO", BlogDTO);
		request.getRequestDispatcher("/viewBlog.jsp").forward(request, response);
	}
}
