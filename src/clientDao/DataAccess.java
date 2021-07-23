package clientDao;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import oracle.jdbc.pool.OracleDataSource;

public class DataAccess {
	public static OracleDataSource ods;

static {
	try {
		ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ods.setUser("SYSTEM");
		ods.setPassword("manager");
	} 
	catch (Exception e){System.out.println(e);}
}

public Connection connectdb() {
	Connection con = null;
	try {
		ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ods.setUser("SYSTEM");
		ods.setPassword("manager");
		con = ods.getConnection();
		
	} 
	catch (Exception e){System.out.println(e);}
	return con;
}
public boolean login(String ex_num, String password) {
	try {
		Connection con = ods.getConnection();
		String q = "select *from examdetails where ex_num=?";
		PreparedStatement st = con.prepareStatement(q);
		st.setString(1,ex_num);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
			if(password.equals(rs.getString(3)))
			{
				return true;
			}
		}
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return false;
}

public boolean saveclient(String name, String email, String ex_num,String phone)
	{
		int marks=0;

		try
		{
			Connection conn = ods.getConnection();
			String query = "insert into client(name,email,ex_num,marks,phone) values(?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3,ex_num);
			st.setInt(4, marks);
			st.setString(5, phone);
		//System.out.println("hi");
			int i = st.executeUpdate();
			//System.out.println("hi1");
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			//System.out.println("hi2");
			}
		
		return false;
	}

//=============================  Returns whole table of table question  ==========================================================

public ResultSet showques(String ex_num) {
	ResultSet rs=null;
	try {
		Connection conn = ods.getConnection();
		String sql = "select *from question where ex_num=?";
		PreparedStatement st =conn.prepareStatement(sql);
		st.setString(1, ex_num);
		rs = st.executeQuery();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return rs;
}

public ResultSet marks0feach(String ex_num) 
{
	ResultSet rs = null;
	try 
	{
		Connection con = ods.getConnection();
		String sql = "select * from examdetails where ex_num=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, ex_num);
		rs = stmt.executeQuery();
		
	} catch (Exception e)
	{
		System.out.println(e);
	}
	return rs;
}

public boolean updatemarks(int marks,String email)
{
	try 
	{
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection conn = ods.getConnection();
		String sql = "update client set marks = ? where email=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, marks);
		st.setString(2, email);
		int k = st.executeUpdate();
		if(k>0) {
			return true;
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return false;
}

//------------------End-------------------------------------
public boolean attempt(String email,String ex_num,int ques_no,String opt_attend)
{
	try 
	{

		Connection con = ods.getConnection();
		String sql = "insert into client_attempt(email , ex_num, ques_no, opt_attend) values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, ex_num);
		st.setInt(3, ques_no);
		st.setString(4, opt_attend);
		
		int rs = st.executeUpdate();
		if(rs>0)
		{
			return true;
		}
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
	
	return false;
}
}

