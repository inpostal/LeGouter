import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberVO;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		
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
	}
}
