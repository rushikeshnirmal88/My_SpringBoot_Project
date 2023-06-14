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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
	private Object un;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
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
    	ServletContext ctx = config.getServletContext();
    	
    	 con =(Connection) ctx.getAttribute("mycon");
    	System.out.println("in login sdrvlet init method"+con);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("in do post");
		
		try {
			PrintWriter out=response.getWriter();
			
			
			
			String un=request.getParameter("username");
			String pass=request.getParameter("password");
			String mn=request.getParameter("mobilenumber");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", un);
			out.print("<h1> Welcome "+un+"</h1>");
			System.out.println(un);
			
			
			PreparedStatement pst =con.prepareStatement("select username from adminrushi where username=? and password=? and mobile=?");
			
			pst.setString(1, un);
			pst.setString(2, pass);
			pst.setString(3, mn);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd =request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
				
				out.println("<h1 color=red>login field</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
