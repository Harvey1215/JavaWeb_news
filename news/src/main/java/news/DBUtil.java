package news;
import java.sql.*;
public class DBUtil {
	Connection conn=null;
    Statement stat=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    /**
     * 得到连接
     */
    @SuppressWarnings("deprecation")
	public Connection getConn(){
		try {
			//1.加载驱动(java反射)
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//2.建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/news","root","root");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
    }
    /**
     * 关闭连接回收资源 
     */
    public void release(){
		try {
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
   // 查询
    public ResultSet getResult(String sql,String []args){
		rs=null;
		if(conn==null){
    		conn=this.getConn();
    	}
		try {
			ps=conn.prepareStatement(sql);
			for (int i=0;i<args.length;i++) {
				ps.setString(i+1,args[i]);//参数从1开始
			}
			//4.执行sql语句，生成resultset结果,并打印
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }
    public ResultSet getResult(String sql){
    	rs=null;
    	if(conn==null){
    		conn=this.getConn();
    	}
    	try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }
    //增删改
    public int executeSql(String sql,String []args){
    	int result=0;//sql增删改时，返回的不是ResultSet，而是int
    	if(conn==null){
    		conn=this.getConn();
    	}
    	try {
    		ps=conn.prepareStatement(sql);
			for (int i=0;i<args.length;i++) {
				ps.setString(i+1,args[i]);//参数从1开始
			}
			result=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	return result;
    }
  //增删改
    public int executeSql(String sql){
    	int result=0;//sql增删改时，返回的不是ResultSet，而是int
    	if(conn==null){
    		conn=this.getConn();
    	}
    	try {
			stat=conn.createStatement();
			result =stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
}
