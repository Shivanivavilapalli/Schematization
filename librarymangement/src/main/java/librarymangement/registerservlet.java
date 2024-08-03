package librarymangement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("username");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	String conpass = req.getParameter("confirmpassword");
	
	PrintWriter pw = resp.getWriter();
//	pw.println("Name : " + name +"\n" +"Email : " + email +"\n" +"Password : " + password +"\n" +"confirm password : " + conpass);
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");
		
		String sql = "insert into student(username,email,password,confirmpassword) values (?,?,?,?)";
		
		PreparedStatement pmst = conn.prepareStatement(sql);
		
		pmst.setString(1, name);
		pmst.setString(2, email);
		pmst.setString(3, password);
		pmst.setString(4, conpass);
		
		
		int i = pmst.executeUpdate();
		
		
		if (i>0) {
			
			pw.println("successfully inserted");
		}
		else {
			
			pw.println("invalid");
		}
		
		conn.close();
		pmst.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	}
	
	

}
