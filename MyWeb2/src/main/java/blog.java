

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/blog/*")
public class blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public blog() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		blogService blogService = new blogService();
		BlogDTO BlogDTO = new BlogDTO();
		
		String action = request.getPathInfo();
		
		if (action.equals("/writeBlog.do")) {
			HttpSession session = request.getSession();
			String loginID = (String) session.getAttribute("id");
			
			if (loginID != null) {
				BlogDTO.setWriter(loginID);
				BlogDTO.setTitle(request.getParameter("title"));
				BlogDTO.setContents(request.getParameter("contents"));

				blogService.addBlog(BlogDTO);
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
			
		}
	}

}
