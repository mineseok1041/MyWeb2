import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/*")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public member() {
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		memberService mbService = new memberService();
		MemberDTO MemberDTO = new MemberDTO();

		String action = request.getPathInfo();
		
		if (action.equals("/login.do")) {
			HttpSession session = request.getSession();
			
			MemberDTO.setId(request.getParameter("id"));
			MemberDTO.setPw(request.getParameter("pw"));
			
			MemberDTO = mbService.Login(MemberDTO); //로그인 성공시 MemberDTO에 회원 정보가 담김, 실패시 null
			if (MemberDTO != null) {
				session.setAttribute("id", MemberDTO.getId());
				session.setAttribute("name", MemberDTO.getName());
				
				response.sendRedirect(request.getContextPath());

			} else {
				System.out.println("로그인 실패");
				session.setAttribute("LoginErr", "true");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		}
		
		if (action.equals("/logout.do")) {
			mbService.Logout(request);
			System.out.println("로그아웃");
			response.sendRedirect(request.getContextPath());
		}
		
		if (action.equals("/signup.do")) {
			MemberDTO.setId(request.getParameter("id"));
			MemberDTO.setPw(request.getParameter("pw"));
			MemberDTO.setName(request.getParameter("name"));
			MemberDTO.setEmail(request.getParameter("email"));

			mbService.SignUp(MemberDTO);
			response.sendRedirect(request.getContextPath());
		}
		
		if (action.equals("/isValidID.do")) {
			MemberDTO.setId(request.getParameter("id"));
			
            boolean IDresult = mbService.isValidID(MemberDTO);
            
			if (IDresult) {
				System.out.println(MemberDTO.getId());
				response.getWriter().print("valid");
			} else {
				response.getWriter().print("invalid");
			}
        }
	}
}
