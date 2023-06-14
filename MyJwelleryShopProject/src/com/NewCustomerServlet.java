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
 * Servlet implementation class NewCustomerServlet
 */
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	int pcust;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}       
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext ctx=config.getServletContext();
		con=(Connection) ctx.getAttribute("mycon");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);        
		
		try {
			PrintWriter out=response.getWriter();
			String cfn = request.getParameter("fname");
			String cln = request.getParameter("lname");
			String cadd = request.getParameter("add");
			String cmob = request.getParameter("mno");
			
			PreparedStatement pst1= con.prepareStatement("select coustomer_id  from coustomer_details order by coustomer_id");
			
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) 
			{
			pcust=rs.getInt(1);
			}
			System.out.println(pcust);
			pcust++;
			
			PreparedStatement pst=con.prepareStatement("insert into coustomer_details values (?,?,?,?,?)");
			
			pst.setInt(1, pcust);
			pst.setString(2, cfn);
			pst.setString(3, cmob);
			pst.setString(4, cadd);
			pst.setString(5, cln);
			
			int rs1=pst.executeUpdate();
			
			if(rs1!=0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
				rd.forward(request, response);
				out.println(" Customer Added Successfully");
			}
			else
			{
				out.print("<font color=red>Failde to add.........!!!</font>");
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
