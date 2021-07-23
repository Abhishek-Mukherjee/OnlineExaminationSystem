package BEAN;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oracle.jdbc.pool.OracleDataSource;

@WebServlet("/date")
public class date extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OracleDataSource ods=null;
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
			
			
		String s = request.getParameter("date");
		PrintWriter out = response.getWriter();
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(s);
			out.println("entered date and time: "+s+"date object: "+date);
			
			Connection con = ods.getConnection();
			String sql = "INSERT INTO datedisp(NO,D) VALUES(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, 2);
			java.sql.Date sqlDate = new java.sql.Date( date.getTime());
			st.setDate(2, sqlDate);
			int i = st.executeUpdate();
			if(i>0)
				System.out.println("inserted");
		} catch (ParseException | SQLException e) {
			//error if wrong date format input or any other input
			//redirect with massage
			System.out.println(e);
		}
	
	}
}
