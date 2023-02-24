package news;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newsContent
 */
@WebServlet(urlPatterns = "/newsContent")
public class newsContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newsContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		DBUtil db = new DBUtil();
		 Connection conn=db.getConn();
		String sql = "select * from newsdetail";
		ArrayList<news> list = new ArrayList<news>();
		ResultSet res = null;
		try {
			res = db.getResult(sql);
			while (res.next()) {
				news News = new news();
				News.setId(res.getInt("id"));
				News.setTitle(res.getString("title"));
				News.setContent(res.getString("content"));
				News.setAuthor(res.getString("author"));
				News.setTime(res.getDate("time"));
				News.setType(res.getString("type"));
				list.add(News);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(!res.isClosed())
				res.close();
			if(!conn.isClosed())
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/news_Index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
