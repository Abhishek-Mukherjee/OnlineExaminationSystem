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

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SignUpServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		Dao d = new Dao();
		PrintWriter o = response.getWriter();
		if(d.Signup(name,email,uname,pass)) {
			request.setAttribute("k", "SIGNUP SUCCESSFULL");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("k", "SIGNUP UN-SUCCESSFULL PLEASE CHECK YOUR INFORMATION");
			RequestDispatcher rd = request.getRequestDispatcher("AdminSignup.jsp");
			rd.forward(request, response);
		}

	}

}
