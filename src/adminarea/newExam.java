package adminarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admindao.Dao;

@WebServlet("/newExam")
public class newExam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public newExam() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao d = new Dao();
		String flag = "";
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		
		
			String ex_num = request.getParameter("ex_num");
			String uname =  (String)session.getAttribute("login");
			String pass = request.getParameter("pass");
			int time,num_ques,marks,date;
			time  = Integer.parseInt(request.getParameter("time"));
			num_ques = Integer.parseInt(request.getParameter("num_ques"));
			marks = Integer.parseInt(request.getParameter("marks"));
			date = Integer.parseInt(request.getParameter("date"));
			try
			{
				 if(d.newexam(ex_num,uname,pass,time,num_ques,marks,date)) 
				 {
						session.setAttribute("ex_num", ex_num);
						session.setAttribute("number_question", num_ques);
						RequestDispatcher r = request.getRequestDispatcher("adminquestionset.jsp");
						r.forward(request, response);
				 }
				 else
				 {
					    flag = "Same input";
					    request.setAttribute("name", flag);
					    RequestDispatcher r = request.getRequestDispatcher("newexam.jsp");
						r.forward(request, response);
				 }
				out.println(ex_num+" "+uname+" "+pass+" "+time+" "+num_ques+" "+marks+" "+date);
			}
			catch (Exception e)
			{	
				flag = "Please input correct input to corresponding fields";
				request.setAttribute("name", flag);
				request.getRequestDispatcher("newexam.jsp").forward(request, response);
			}
		
		
	}
	
}