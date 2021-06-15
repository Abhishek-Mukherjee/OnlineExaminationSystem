package adminarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import admindao.Dao;

@WebServlet("/adminquestion")
public class adminquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public adminquestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession ses = request.getSession();
		
		String ex_num = ses.getAttribute("ex_num").toString();
		PrintWriter out = response.getWriter();
		int i;
		String num = ses.getAttribute("number_question").toString();
		int n = Integer.parseInt(num);
		Boolean flag = null;
		for(i=1;i<=n;i++)
		{
			int id = i;//*****************STATIC FOR TESTING ONLY HAVE TO CHANGE FOR SURE
			String ques = request.getParameter("question"+i);
			String opt1 = request.getParameter("1opt"+i);
			String opt2 = request.getParameter("2opt"+i);
			String opt3 = request.getParameter("3opt"+i);
			String opt4 = request.getParameter("4opt"+i);
			String answer = request.getParameter("ans"+i);
			int ans = Integer.parseInt(answer);
				Dao d = new Dao();
				if(d.insertquestion(id, ex_num, ques, opt1, opt2, opt3, opt4, ans))
				{
					flag=true;
				}else
				{
					flag=false;
				}
		}
		
		if (flag) {
			out.println("<h1>Successful</h1>");
			
		}else {
			out.println("<h1>wrong input please check</h1>");
		}
		
	}

}
