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
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		
		System.out.println(con);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		try {
			PrintWriter out=response.getWriter();
//
//			HttpSession session2 =request.getSession(false);
//			String un=session2.getAttribute("username").toString();
//			out.println("<h1> Welcome from login "+un+" </h1>");
//			System.out.println(un);
			
			
		
			out.println("<caption>Category'S Are :</caption></br>");
			out.println("<select id=\"cat\" name=\"category\" required=\"required\">");
			out.println("<option >Choose Catagory</option>");
			out.println("<option value=\"gold\" required=\"required\">GOLD</option>");
			out.println("<option value=\"silver\" required=\"required\" >SILVER</option>");
			out.println("</select> <br> <br>");
			
			
            String cat=request.getParameter("category");
			
			
			PreparedStatement pst=con.prepareStatement("Select * from inventory where category='?'");
			pst.setString(3, cat);
			out.println("<table width=90% border=1>");
			
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int totalColumn =rsmd.getColumnCount();
			out.println("<tr>");
			
			for(int i=1;i<=totalColumn;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			
			out.print("</tr>");
			
			boolean i=rs.next();
			while(i) {
				out.print("<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
								+ "<td>"+rs.getString(2)+"</td>"
										+ "<td>"+rs.getString(3)+"</td>"
												+ "<td>"+rs.getInt(4)+"</td>"
														+ "<td>"+rs.getInt(5)+"</td>"
																+ "<td>"+rs.getString(6)+"</td>"
										+"<td>"+"<a href="+"./generateBill.jsp?id="+rs.getInt(1)+"&cname="+rs.getString(2)+"&mob="+rs.getString(3)+"&add="+rs.getString(4)+">Select</a>"+"</td>"
												+ "</tr>");	
				i=rs.next();
			}
			
			out.print("</table>");
			
//			if(totalColumn == 0)
//			{
//				RequestDispatcher rd=request.getRequestDispatcher("Addcustomer.jsp");
//				rd.forward(request, response);
//			}
//			else
//			{
//				
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
