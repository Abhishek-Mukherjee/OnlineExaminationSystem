package BEAN;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;
@WebFilter("/clientlogin")
public class filter1 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("in filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String examNumber = req.getParameter("ex_num");
		System.out.println(examNumber);
		OracleDataSource ods=null;
		ResultSet rs = null;
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("manager");
			System.out.println("Connection to DB successful");
			Connection con = ods.getConnection();
			String sql = "select *from examdetails where EX_NUM=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, examNumber);
			rs = st.executeQuery();
			rs.next();
		} 
		catch (Exception e)
		{
		System.out.println(e);
		System.out.println("Connection to DB unsuccessful");
		}
		
		
		
		
		try {
			Date sdate = (java.util.Date)rs.getDate("exdate");
			Date cdate = new Date();
		
			if(cdate.after(sdate)) {
				System.out.println("not ok");
				RequestDispatcher rd = req.getRequestDispatcher("Clientlogin.jsp");
				req.setAttribute("massage","Link is invalid now");
				rd.forward(req, res);
			}
			else
			{
				System.out.println("ok");
			}
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
