package admindao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

@WebServlet("/detailreport")
public class detailReport extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String examNumber = request.getParameter("value1");
		String email = request.getParameter("value2");
		OracleDataSource ods=null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("manager");
			System.out.println("Connection to DB successful");
			Connection con = ods.getConnection();
			String sql ="SELECT QUES,OPT1,OPT2,OPT3,OPT4,ANS FROM QUESTION WHERE EX_NUM =? ORDER BY ID";
			String sql1 ="SELECT OPT_ATTEND FROM CLIENT_ATTEMPT WHERE EX_NUM =?  AND EMAIL=? ORDER BY QUES_NO";
			PreparedStatement st = con.prepareStatement(sql);
			PreparedStatement st1 = con.prepareStatement(sql1);
			st.setString(1, examNumber);
			st1.setString(1, examNumber);
			st1.setString(2,email);
			rs = st.executeQuery();
			rs1 = st1.executeQuery();
			
			int J=1;
			while(rs.next() && rs1.next())
			{
				out.println("QUESTION  "+J+":"+rs.getString("QUES"));
				out.println("OPTION1:  "+rs.getString("OPT1"));
				out.println("OPTION2: "+rs.getString("OPT2"));
				out.println("OPTION3: "+rs.getString("OPT3"));
				out.println("OPTION4: "+rs.getString("OPT4"));
				out.println("CORRECT OPTION= "+rs.getString("ANS"));
				out.println("USER CHOOSEN  OPTION FOR QUESTION "+ J +"  IS=  "+rs1.getString("OPT_ATTEND"));
				out.println();
				out.println();
				
				J++;
				
				
			}
			
			
//			while(rs1.next())
//			{
//				out.println("USER CHOOSEN FOR QUESTION "+ i +"  IS=  "+rs1.getString("OPT_ATTEND"));
//				out.println();
//				out.println();
//				i++;
//			}
//			
		} 
		catch (Exception e)
		{
		System.out.println(e);
		System.out.println("Connection to DB unsuccessful");
		}
		
	}
}
