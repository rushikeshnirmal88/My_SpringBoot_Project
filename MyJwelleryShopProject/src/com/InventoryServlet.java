package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InventoryServlet
 */
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	int pnext;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response); 
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext ctx =config.getServletContext();
		
		con=(Connection) ctx.getAttribute("mycon");
		
		
		System.out.println("in inventory servlet");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			PrintWriter out=response.getWriter(); 


			String ptname=request.getParameter("pname");
			String ct=request.getParameter("category");
			String qun=request.getParameter("quantity");
			String weightt=request.getParameter("weight");
			String carat=request.getParameter("carat");
		
System.out.println(ptname+" "+ct+" "+qun+" "+weightt+" "+carat );
			
		
			
		PreparedStatement pst1= con.prepareStatement("select particular_id  from inventory order by particular_id");
			
		ResultSet rs=pst1.executeQuery();
		while(rs.next()) 
		{
		pnext=rs.getInt(1);
		}
		System.out.println(pnext);
		pnext++;
		

		HttpSession session3 =request.getSession();
		String un=session3.getAttribute("username").toString();
		out.print("<h1> Welcome from login "+un+" </h1>");
		System.out.println(" Welcome from login :"+un);
		
		PreparedStatement pst =con.prepareStatement("insert into inventory values (?,?,?,?,?,? )");
			//pst.setInt(1, num)
	       	pst.setInt(1, pnext);
			pst.setString(2, ptname);
			pst.setString(3, ct);
			pst.setString(4, qun);
			pst.setString(5, weightt);
			pst.setString(6, carat);
			
			int i=pst.executeUpdate();
			
			if(i!=0)
			{
				
				out.println("item addes successfully");

				
			}
			
			else
			{
				out.println("falied to insert");
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
