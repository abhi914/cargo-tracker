package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Employee;

/**
 * Servlet implementation class TrackingView
 */
@WebServlet("/TrackingView")
public class TrackingView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
        out.println("<script src='asset/tracking.js'></script>");
        HttpSession ses=request.getSession();
		out.println("<html>");
		int  eid=0;
		try{
		 Employee E=(Employee)ses.getValue("SEMPLOYEE");	
		  eid=E.getEmployeeid(); 
		 
		  		 
			
		}catch(Exception e)
		{
	     response.sendRedirect("EmployeeLogin");		
		}     
		out.print("<html>");
		out.println("<table>");
		out.println("<input type=hidden id=eid value="+eid+">");
		out.println("<tr><td><b><i>Tracking Id:</i></b></td><td><input type=text name=tid id=tid></td><td><input type=button value='Search' id=btn></tr>");
		out.println("</table><br>");
		out.println("<span id=result></div>");
		out.print("</html>");
		}
      }
