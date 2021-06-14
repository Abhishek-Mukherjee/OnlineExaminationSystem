package BEAN;
import java.sql.*;
 class database 
 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{ 
		//############## logical part class object ################
		nn n = new nn();
		n.display("admin");
		
	}
 }
class nn{
	beanmy obj = new beanmy();
	public void display(String uname) throws ClassNotFoundException, SQLException 
	{
		 obj.setUname(uname);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
		 String sql = "select * from admin where uname=?";
		 PreparedStatement st = conn.prepareStatement(sql);
		 st.setString(1, obj.getUname());
		 ResultSet rs = st.executeQuery();
		 rs.next();
		 System.out.println(rs.getString("email"));
	}
}