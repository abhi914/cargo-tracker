package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.print("<html><form action=EmployeeLoginCheck method=post>");
		out.println("<table><caption><b><i>Employee Login</i></b></caption></br><tr><td>Employee Id:</td> <td><input type=text name=eid></td></tr>");
		out.println("<tr><td>Password:</td><td> <input type=password name=password></td></tr>");
		out.println("<tr><td><input type=submit value='Sign in'></td><td>&nbsp;</td></tr></table></form></html>");
	}


}
