package admindao;

import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

//import BEAN.admin;
import oracle.jdbc.pool.OracleDataSource;

public class Dao {
public static OracleDataSource ods;
static {
		try {
			 ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("manager");
			System.out.println("Connection to DB successful");
		} 
		catch (Exception e)
		{
		System.out.println(e);
		System.out.println("Connection to DB unsuccessful");
		}
}
public OracleDataSource ods()
{
	return ods;
}
public boolean Signup(String name, String email, String uname, String pass) 
{
	
	try {
//		 OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection con = ods.getConnection();
		String sql = "INSERT INTO ADMIN(NAME , EMAIL, UNAME, PASS) VALUES(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, uname);
		st.setString(4, pass);
		int i = st.executeUpdate();
		if(i>0) {
			return true;
		}
	} 
	catch (Exception e)
	{
		System.out.println("EXCEPTION");	
		return false;
	}
	return false;
}

public boolean login(String uname, String pass) {
	try {
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection conn = ods.getConnection();
		String q = "SELECT *FROM ADMIN WHERE UNAME=?";
		PreparedStatement st = conn.prepareStatement(q);
		st.setString(1, uname);
		ResultSet r = st.executeQuery();
		if(r.next())
		{
			if(pass.equals(r.getString("PASS")))
			{
				return true;
			
			}
		}
		} 
		catch (Exception f)
		{
			System.out.println(" not enter");
			System.out.println(f);	
		}
	return false;	
	}

public boolean newexam(String ex_num,String uname,String pass,Integer time,Integer marks,Integer num_ques,String exdate) {
	try {
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(exdate);
		java.sql.Date sqlDate = new java.sql.Date( date.getTime());
			Connection conn = ods.getConnection();
			String query = "insert into EXAMDETAILS(EX_NUM , UNAME , PASS, TIME, NUM_QUES, MARKS, EXDATE) values(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, ex_num);
			st.setString(2, uname);
			st.setString(3, pass);
			st.setInt(4, time);
			st.setInt(5, marks);
			st.setInt(6, num_ques);
			st.setDate(7, sqlDate);
			int k = st.executeUpdate();
			if (k>0) 
			{
				return true;
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	
	return false;	
}


public boolean insertquestion(int id,String ex_num,String ques,String opt1,String opt2,String opt3,String opt4,int ans,String uname)
{
	try 
	{
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection con = ods.getConnection();
		String sql = "insert into question(id , ex_num, ques, opt1, opt2, opt3, opt4, ans,uname) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.setString(2, ex_num);
		st.setString(3, ques);
		st.setString(4, opt1);
		st.setString(5, opt2);
		st.setString(6, opt3);
		st.setString(7, opt4);
		st.setInt(8, ans);
		st.setString(9, uname);
		int rs = st.executeUpdate();
		if(rs>0)
		{
			return true;
		}
	} catch (Exception e) 
	{
		System.out.println(e);
	}
	
	return false;
}

public ResultSet viewexam(String ex_num) 
{
	ResultSet r = null;
	try {
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection conn = ods.getConnection();
		String q = "select *from client where ex_num=?";
		PreparedStatement st = conn.prepareStatement(q);
		st.setString(1, ex_num);
		r = st.executeQuery();
	} catch (Exception e) {
		System.out.println(e);
	}
	return r;
}


public ResultSet listexam(String uname) 
{
	ResultSet r = null;
	try 
	{
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection conn = ods.getConnection();
		String q = "select ex_num from examdetails where uname=?";
		PreparedStatement st = conn.prepareStatement(q);
		st.setString(1, uname);
		r = st.executeQuery();
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	return r;
}

public ResultSet fetchques(String ex_num,String uname)
{
	ResultSet rs = null;
	try
	{
		Connection con = ods.getConnection();
		String Sql = "Select *from question where ex_num=? and uname=?";
		PreparedStatement st = con.prepareStatement(Sql);
		st.setString(1, ex_num);
		st.setString(2, uname);
		rs = st.executeQuery();
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
	return rs;
}

public boolean updatequestion(int id, String ex_num, String ques, String opt1, String opt2, String opt3, String opt4,int ans,String uname) {
	
	try {
//	
//		OracleDataSource ods = new OracleDataSource();
//		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//		ods.setUser("SYSTEM");
//		ods.setPassword("manager");
		Connection con = ods.getConnection();
		String sql = "update question set ques=?, opt1=?, opt2=?, opt3=?, opt4=?, ans=? where ex_num=? and id=? and uname=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, ques);
		st.setString(2, opt1);
		st.setString(3, opt2);
		st.setString(4, opt3);
		st.setString(5, opt4);
		st.setInt(6, ans);
		st.setString(7, ex_num);
		st.setInt(8, id);
		st.setString(9, uname);
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




