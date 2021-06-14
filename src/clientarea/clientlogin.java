package clientarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import clientDao.DataAccess;

@WebServlet("/clientlogin")
public class clientlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public clientlogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ex_num = request.getParameter("ex_num");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		DataAccess obj = new DataAccess();
		
		if(obj.login(ex_num, pass))
			{
				HttpSession session = request.getSession();
				session.setAttribute("ex_num", ex_num);
				response.sendRedirect("clienthome.jsp");
			}
			else 
			{
				out.println("Wrong input");
			}
		
	}

}
