import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class memberService {
	MemberDAO MemberDAO = new MemberDAO();
	
	public memberService() {
	}
	
	public MemberDTO Login(MemberDTO MemberDTO) {
		if (MemberDAO.isExisted(MemberDTO)) {
			System.out.println(MemberDTO.getId() + " " + MemberDTO.getPw() + "로 로그인");
			return MemberDAO.getMemberInfo(MemberDTO.getId());
		} else {
			return null;
		}
	}
	
	public void Logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃");
	}
	
	public void SignUp(MemberDTO MemberDTO) {
		MemberDAO.addMember(MemberDTO);
    }
	
	public boolean isValidID(MemberDTO MemberDTO) {
		boolean result = MemberDAO.isExisted(MemberDTO);
		return !result;
	}
}