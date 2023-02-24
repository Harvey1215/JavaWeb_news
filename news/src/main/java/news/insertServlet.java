package news;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		String title =request.getParameter("title");
		String type =request.getParameter("type");
		String author =request.getParameter("author");
		String centent =request.getParameter("centent");
		String  time =request.getParameter("time");
		DBUtil db= new DBUtil();
		db.getConn();
		String[] addarr=new String[] {title,centent,author,time,type};
		String sql ="insert into newsdetail (title,content,author,time,type) values(?,?,?,?,?)";
		try {
			
			int res=db.executeSql(sql,addarr);
			if(res>0) {
				out.println("<script>alert('发布成功！');window.location.href='/news/newsContent'</script>");
			}else {
				out.println("<script>alert('发布失败！');window.location.href='/insert.jsp'</script>");
				System.out.print("失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(db!=null) {
				db.release();
			}
		}
//		
				

		
		
	}

}
