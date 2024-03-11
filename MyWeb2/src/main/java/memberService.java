import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class memberService {
	MemberDAO MemberDAO = new MemberDAO();
	
	public memberService() {
	}
	
	public MemberDTO Login(MemberDTO MemberDTO) {
		if (MemberDAO.isExisted(MemberDTO)) {
			return MemberDAO.getMemberInfo(MemberDTO);
		} else {
			return null;
		}
	}
	
	public void Logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	public void SignUp(MemberDTO MemberDTO) {
		MemberDAO.addMember(MemberDTO);
    }
	
	public boolean isValidID(MemberDTO MemberDTO) {
		boolean result = MemberDAO.isExisted(MemberDTO);
		return !result;
	}
	
	public List<MemberDTO> getMemberList(MemberDTO MemberDTO) {
		return MemberDAO.listMembers();
	}
	
	public void delMember(MemberDTO MemberDTO) {
		MemberDAO.delMember(MemberDTO);
	}
}