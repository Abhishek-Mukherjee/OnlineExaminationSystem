package clientarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientDao.DataAccess;

@WebServlet("/clientdetails")
public class clientdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public clientdetails() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		DataAccess obj = new DataAccess();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String ex_num = (String) session.getAttribute("ex_num");
		if(obj.saveclient(name, email,ex_num)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("email", email);
			response.sendRedirect("clientquestion.jsp");
		}
		else {
			out.println("please correct your information");
		}
	}

}
