package news;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showNewsServelt
 */
@WebServlet(urlPatterns = "/showNewsServelt")
public class showNewsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showNewsServelt() {
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
		int id= Integer.parseInt(request.getParameter("id"));
		DBUtil db= new DBUtil();
		Connection conn= db.getConn();
		ArrayList<news> others = new ArrayList<news>();
		String sql="select * from newsdetail where id=?";
		String sql1=" select * from newsdetail where type=? and id!=?";
		ResultSet res=null;
		news n=new news();
		
		String types=null;
	
	    if(conn==null) {
	    	conn=db.getConn();
	    }
	    try {
	    	PreparedStatement ps=conn.prepareStatement(sql);
	    	ps.setInt(1, id);
	    	res=ps.executeQuery();
	    	
	    	while(res.next()) {
	    		
	    		n.setId(res.getInt("id"));
	    		n.setTitle(res.getString("title"));
	    		n.setContent(res.getString("content"));
	    		n.setAuthor(res.getString("author"));
	    		n.setTime(res.getDate("time"));
	    		n.setType(res.getString("type"));
	    		types=res.getString("type");
	    		}
	    	ps=conn.prepareStatement(sql1);
	    	ps.setString(1, types);
	    	ps.setInt(2, id);
	    	res=ps.executeQuery();
	    	while(res.next()) {
	    		news other=new news();
	    		other.setId(res.getInt("id"));
	    		other.setTitle(res.getString("title"));
	    		other.setContent(res.getString("content"));
	    		other.setAuthor(res.getString("author"));
	    		other.setTime(res.getDate("time"));
	    		other.setType(res.getString("type"));
	    		others.add(other);
	    		}
	    	res.close();
	    	 conn.close();
	    	 db.conn.close();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    request.setAttribute("others", others);
	   request.setAttribute("n",n);
	    	 request.getRequestDispatcher("/showNews.jsp").forward(request, response);
		
	}

}
