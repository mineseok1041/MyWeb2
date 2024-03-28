import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("id");
		
		PrintWriter out = response.getWriter();
		String action = request.getPathInfo();
		
		if (action.equals("/login.do")) {
			
			MemberDTO.setId(request.getParameter("id"));
			MemberDTO.setPw(request.getParameter("pw"));
			
			MemberDTO = mbService.Login(MemberDTO); //로그인 성공시 MemberDTO에 회원 정보가 담김, 실패시 null
			if (MemberDTO != null) {
				session.setAttribute("id", MemberDTO.getId());
				session.setAttribute("name", MemberDTO.getName());
				
				response.sendRedirect(request.getContextPath());
			} else {
				request.setAttribute("LoginErr", "true");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		
		if (action.equals("/logout.do")) {
			mbService.Logout(request);
			response.sendRedirect(request.getContextPath());
		}
		
		if (action.equals("/signup.do")) {
			MemberDTO.setId(request.getParameter("id"));
			MemberDTO.setPw(request.getParameter("pw"));
			MemberDTO.setName(request.getParameter("name"));
			MemberDTO.setEmail(request.getParameter("email"));

			mbService.SignUp(MemberDTO);
			
			out.print("<script>alert('회원가입 되었습니다.'); location.href='");
			out.print(request.getContextPath());
			out.print("';</script>");
		}
		
		if (action.equals("/isValidID.do")) {
			MemberDTO.setId(request.getParameter("id"));
			
            boolean IDresult = mbService.isValidID(MemberDTO);
            
			if (IDresult) {
				response.getWriter().print("valid");
			} else {
				response.getWriter().print("invalid");
			}
        }
		
		if (action.equals("/memberList.do")) {
			List<MemberDTO> memberList = mbService.getMemberList(MemberDTO);
			
			request.setAttribute("BlogList", memberList);
			request.getRequestDispatcher("/memberList.jsp").forward(request, response);
		}
		
		if (action.equals("/delMember.do")) {
			MemberDTO.setId(request.getParameter("id"));
			
			if (loginID.equals("admin")) {
				mbService.delMember(MemberDTO);
				
				out.print("<script>alert('회원 삭제되었습니다.'); location.href='");
				out.print(request.getContextPath());
				out.print("';</script>");
			} else {
				out.print("<script>alert('관리자만 삭제 가능합니다.'); location.href='");
				out.print(request.getContextPath());
				out.print("';</script>");
			}
		}
	}
}
