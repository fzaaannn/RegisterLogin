package registrationProcess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings({ "serial" })
@WebServlet("/regform")
public class Register extends HttpServlet {
	
	//getValue from page
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=(String)req.getParameter("name1");
		String email=(String)req.getParameter("email1");
		String pass=(String)req.getParameter("pass1");
		String gender=(String)req.getParameter("gender1");
		String city=(String)req.getParameter("city1");
		//make connection using try and catch block
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cnc=	DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdata","root","faizan");
	PreparedStatement ps =cnc.prepareStatement("insert into info values(?,?,?,?,?)");
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, pass);
	ps.setString(4, gender);
	ps.setString(5, city);
	int i=ps.executeUpdate();
	if(i>0) {
		resp.setContentType("text/html");
		out.print("<h3 style='color:green'>Regester Sucessfully</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
		rd.include(req,resp);
	}
	else {
		resp.setContentType("text/html");
		out.print("<h3 style='color:Red'>Error Ocuur</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
		rd.include(req,resp);
	}
		
			
		} catch (Exception e) {
			resp.setContentType("text/html");
			out.print("<h3 style='color:Red'>Exception Occur:"+e.getMessage()+"</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
			rd.include(req,resp);
			
		}
		
	}
}
