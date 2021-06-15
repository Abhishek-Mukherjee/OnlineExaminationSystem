package adminarea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admindao.Dao;

@WebServlet("/viewExam")
public class viewExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public viewExam() {
        super();
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Dao obj = new Dao();
		PrintWriter out = response.getWriter();
		String ex_num = request.getParameter("ex_num");
		//out.println(ex_num);
		ResultSet rs = obj.viewexam(ex_num);
	
				try 
				{		
							while(rs.next())
							{
								out.println("NAME              :-  "   +rs.getString(1));
								out.println("EMAIL             :-  "  +rs.getString(2));
								out.println("EX_NUM            :-  " +rs.getString(3));
								out.println("MARKS             :-  "  +rs.getInt(4));
							}							
				} 
				catch (Exception e)
				{
					System.out.println(e);
				}	
		
	}

}
