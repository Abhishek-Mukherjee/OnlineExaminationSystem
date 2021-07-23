package adminarea;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admindao.Dao;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		Dao d = new Dao();
		if (d.login(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("login", uname);
			response.sendRedirect("Welcome.jsp");
			}
		else {
				request.setAttribute("k", "LOGIN DENIED PLEASE CHECK YOUR INFORMATION ");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
		}
	}
}
