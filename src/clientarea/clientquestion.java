package clientarea;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientDao.DataAccess;

@WebServlet("/clientquestion")
public class clientquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public clientquestion() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	System.out.println("HELLO WORLD");
//			int notattend=0,correct=0,wrong=0,marks=0;
//			
//			PrintWriter out = response.getWriter();
//			
//			DataAccess object = new DataAccess();
//			HttpSession session = request.getSession();
//			String email = (String)session.getAttribute("email");
//			String ex_num = (String)session.getAttribute("ex_num");
//			System.out.println("check1");
//			ResultSet rs = object.showques(ex_num);
//			System.out.println("check2");
//			int i=1;
//			String ans = null;
//				try 
//				{
//						while(rs.next())
//						{
//							ans = request.getParameter("question"+i++);
//							System.out.println("ans: "+ans);
//							if(ans==null)	{	notattend++;	}
//							else if (ans.equals(rs.getString(8)))
//							{	correct++;	}
//							else{	wrong++;	}i++;
//						}
//						ResultSet mark = object.marks0feach(ex_num);
//						mark.next();
//						marks = correct*mark.getInt(6);
//						if(object.updatemarks(marks,email))
//						{
//							out.println("successfully updated the record");
//						}else {
//							out.println("failed to updated the record@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//						}
//						
//						System.out.println("correct: "+ correct+ "wrong: "+ wrong);
//				} catch (Exception e) {
//					System.out.println("custom error checking"+e);
//				}
//				finally 
//				{
//					out.println("Thank you, !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//					out.println("you may leave now @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//					session.removeAttribute("ex_num");
//					session.invalidate();
//				}
				
			}
}
