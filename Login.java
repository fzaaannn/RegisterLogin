package registrationProcess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/mylogin")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Email2=(String)req.getParameter("mail2");
		String pass2=(String)req.getParameter("pass2");
		PrintWriter out=resp.getWriter();		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnc=	DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdata","root","faizan");
		   PreparedStatement ps=  cnc.prepareStatement("SELECT * FROM info WHERE Email=? AND Password=?");
		   ps.setString(1,Email2);
		   ps.setString(2, pass2);
		  ResultSet i= ps.executeQuery();	
		  if(i.next()) {
			  HttpSession session=req.getSession();
			  session.setAttribute("Db_name", i.getString("Name"));
			  resp.setContentType("text/html");
				out.print("<h3 style='color:Green'>Login Sucessfully</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
				rd.include(req,resp);
		  }
		  else {
			  resp.setContentType("text/html");
				out.print("<h3 style='color:Red'>Error Ocuur:Email & Password Didnt Match</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req,resp);
		  }
		} 
		
		catch (Exception e) {
			resp.setContentType("text/html");
			out.print("<h3 style='color:Red'>Error Ocuur:"+ e.getLocalizedMessage()+"</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.include(req,resp);
		e.printStackTrace();	
		}
	}
	

}
