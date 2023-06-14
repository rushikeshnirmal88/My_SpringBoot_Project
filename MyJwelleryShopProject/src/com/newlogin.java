package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newlogin
 */
public class newlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext ctx=config.getServletContext();
		
		 con =(Connection) ctx.getAttribute("mycon");
		 System.out.println("in login sdrvlet init method"+con);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("in do post newsuer");
		
		try {
			PrintWriter out=response.getWriter();
			 String username =request.getParameter("Username");
			 String password =request.getParameter("Password");
			 String mobilenumber=request.getParameter("Mobilenumber");
			 
			// out.println("\n"+con+" "+username+" "+password+""+mobilenumber);
			 
			 PreparedStatement pst= con.prepareStatement("insert into adminrushi values (?,?,?)");
			 
			 pst.setString(1, username);
			 pst.setString(2, password);
			 pst.setString(3, mobilenumber);
			 System.out.println("Registered Successfully.........");
			 
			 int i=pst.executeUpdate();
			 
			 if(i!=0)
			 {
				 out.println("Registered Successfully.........");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("login.html");
				 rd.forward(request, response);
				 
			 }
			 else
			 {
				 out.println("failed to add user");
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
