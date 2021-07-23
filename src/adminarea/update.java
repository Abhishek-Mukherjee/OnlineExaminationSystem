package adminarea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admindao.Dao;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public update() {
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			HttpSession ses = request.getSession();
			String ex_num =ses.getAttribute("ex_num").toString();
			String uname =ses.getAttribute("login").toString();
			
			PrintWriter out = response.getWriter();
			int i=1;
			Dao obj = new Dao();
			ResultSet rs = obj.fetchques(ex_num,uname);
			Boolean flag = null;
			try {
				while(rs.next())
				{
					int id = i;//*****************STATICK FOR TESTING ONLY HAVE TO CHANGE FOR SURE
					String ques = request.getParameter("question"+i);
					String opt1 = request.getParameter("1opt"+i);
					String opt2 = request.getParameter("2opt"+i);
					String opt3 = request.getParameter("3opt"+i);
					String opt4 = request.getParameter("4opt"+i);
					String answer = request.getParameter("ans"+i);
					int ans = Integer.parseInt(answer);
						Dao d = new Dao();
						if(d.updatequestion(id,ex_num, ques, opt1, opt2, opt3, opt4, ans,uname))
						{
							flag=true;
						}
						else
						{
							flag=false;
							//out.println(" UPDATE FAILED");
							break;
						}
						i++;
				}
			} catch (Exception e) {
				
				System.out.println(e);
				out.println(" UPDATE FAILED please fill the information correctly");
				
				
			}
		
			if (flag) {
				out.println("<h1>Successful</h1>");
			
			}
			else {
				out.println("<h1>wrong input please check</h1>");
			}
		}

}
