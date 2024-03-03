
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		blogService blogService = new blogService();
		BlogDTO BlogDTO = new BlogDTO();
		List<BlogDTO> BlogList = new ArrayList<BlogDTO>();

		String action = request.getPathInfo();

		if (action.equals("/writeBlog.do")) {
			HttpSession session = request.getSession();
			String loginID = (String) session.getAttribute("id");
			String loginName = (String) session.getAttribute("name");

			if (loginID != null) {
				BlogDTO.setWriter(loginName);
				BlogDTO.setTitle(request.getParameter("title"));
				BlogDTO.setContents(request.getParameter("contents"));
				BlogDTO.setWriterID(loginID);

				blogService.addBlog(BlogDTO);

				out.print("<script>alert('새 글이 등록되었습니다.'); location.href='");
				out.print(request.getContextPath());
				out.print("';</script>");
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		}

		if (action.equals("/blogList.do")) {
			BlogList = blogService.getBlogList(10, true, null);

			request.setAttribute("BlogList", BlogList);
			request.getRequestDispatcher("/blogList.jsp").forward(request, response);
		}
		
		if (action.equals("/blogSearch.do")) {
			String search = request.getParameter("search");
			
            BlogList = blogService.getBlogList(10, true, search);
            
            request.setAttribute("BlogList", BlogList);
            request.getRequestDispatcher("/blogList.jsp").forward(request, response);
		}
		
		if (action.equals("/myBlogList.do")) {
			HttpSession session = request.getSession();
			String loginID = (String) session.getAttribute("id");
			
			if (loginID == null) {
				out.print("<script>alert('로그인이 필요합니다.'); location.href='");
				out.print(request.getContextPath());
				out.print("/login.jsp';</script>");
			} else {
				BlogList = blogService.getmyBlogList(10, true, loginID);

				request.setAttribute("BlogList", BlogList);
				request.getRequestDispatcher("/myBlogList.jsp").forward(request, response);
			}
		}
	}
}
