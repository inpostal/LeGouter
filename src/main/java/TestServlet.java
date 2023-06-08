import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDAO;
import com.member.model.IMemberDAO;
import com.member.model.MemberVO;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8");
		
		IMemberDAO memberDAO = new MemberDAO();
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("Test MemberDao findByPrimaryKey(1)!");
		MemberVO memberVO = memberDAO.findByPrimaryKey(1);
		writer.println(memberVO);
		
		writer.println("-------------------------------------");
		
		writer.println("Test MemberDao getALL()!");
		List<MemberVO> list = memberDAO.getAll();
		for (MemberVO m : list) {
			writer.println(m);
		}
	
		writer.println("-------------------------------------");
		
//		writer.println("Test MemberDao insert()!");
//		memberDAO.insert(memberVO);
		
		writer.println("-------------------------------------");
		
//		writer.println("Test MemberDao update()!");
//		memberVO.setMemberId(5);
//		memberVO.setMemberName("測試");
//		memberDAO.update(memberVO);
		
	}
}
