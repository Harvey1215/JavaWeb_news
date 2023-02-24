package news;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name=request.getParameter("username");
	String pass=request.getParameter("password");
	String sql="select * from admin where adminname=? and adminpass=?";
	String [] arg= {name,pass};
	DBUtil db=new DBUtil();
	db.getConn();
	ResultSet res=null;
	HttpSession session=request.getSession();
	try {
		res=db.getResult(sql, arg);
		if(res!=null && res.next()) {
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);
			
			request.getRequestDispatcher("/SYSTEM/manageServlet").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

}
