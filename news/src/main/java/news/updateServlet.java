package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet(urlPatterns = "/SYSTEM/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		PrintWriter out =response.getWriter();
		
		String content =request.getParameter("centent");
		int id= Integer.parseInt(request.getParameter("id"));
	   String title = request.getParameter("title");
	   String author = request.getParameter("author");
	   String type=request.getParameter("type");
	   DBUtil db = new DBUtil();
	   Connection conn=db.getConn();
	   String sql = "update newsdetail set title =?,content = ?,author = ?, type=? where id =?";
	  try {
	   PreparedStatement ps = conn.prepareStatement(sql);
		//给占位符赋值
		ps.setString(1, title);
		ps.setString(2, content);
		ps.setString(3, author);
		ps.setString(4, type);
		ps.setInt(5, id);
		int res = ps.executeUpdate();
		if(res>0){//修改成功
			out.println("<script> alert('修改成功！');window.location.href='/news/SYSTEM/manageServlet'</script>");
		}
		   else
		   {
			   out.println("<script>alert('修改失败!');window.location.href='/news/update.jsp'</script>");
			 System.out.println("修改失败");
		   }
		
	 	if(!db.getConn().isClosed()){
			db.getConn().close();
		}
	 	if(!ps.isClosed()) {
	 		ps.close();
	 	}
	  }
	  catch(SQLException E) {
		  E.printStackTrace();
	  }
		//判断
		
	}
	
}

