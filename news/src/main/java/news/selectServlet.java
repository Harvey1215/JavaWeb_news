package news;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectServlet
 */
@WebServlet(urlPatterns = "/selectServlet")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	String key= request.getParameter("select");
	DBUtil db=new DBUtil();
	db.getConn();
	ArrayList<news> select = new ArrayList<news>();
	String sql1="Select * from newsdetail where  title like ?";
	String arg[]= {"%"+key+"%"};
	ResultSet res=null;
	res=db.getResult(sql1, arg);
	try {
		while(res.next()){
			news n=new news();
			n.setId(res.getInt("id"));
    		n.setTitle(res.getString("title"));
    		n.setContent(res.getString("content"));
    		n.setAuthor(res.getString("author"));
    		n.setTime(res.getDate("time"));
    		n.setType(res.getString("type"));
			select.add(n);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	request.setAttribute("select",select);
	request.getRequestDispatcher("/select.jsp").forward(request, response);
	
	}
}
