package news;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class manageServlet
 */
@WebServlet(urlPatterns = "/SYSTEM/manageServlet")
public class manageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageServlet() {
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
		List <news> articlesList=new ArrayList<news>();
		news article;
		DBUtil db=new DBUtil();
		db.getConn();
		ResultSet rs=db.getResult("select * from newsdetail");
		try {
		while(rs.next()){
		article=new news();
		article.setId(rs.getInt("id"));
		//System.out.println(rs.getInt("id"));
		article.setTitle(rs.getString("title"));
		//System.out.println(rs.getString("title"));
		article.setContent(rs.getString("content"));
		//System.out.println(rs.getString("content"));
		article.setAuthor(rs.getString("author"));
		//System.out.println(rs.getString("author"));
		article.setTime(rs.getDate("time"));
		//System.out.println(rs.getDate("time"));
		article.setType(rs.getString("type"));
		//System.out.println(rs.getInt("type"));
		
		articlesList.add(article);
		}
		request.setAttribute("articlesList",articlesList);
		request.getRequestDispatcher ("/manage_index.jsp").forward (request,response);
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally{
				if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			if(db!=null)
			db.release();
			}
		}
			public void init() throws ServletException {
			
			}
	}


