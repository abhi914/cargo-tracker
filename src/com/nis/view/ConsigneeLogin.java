package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsigneeLogin
 */
@WebServlet("/ConsigneeLogin")
public class ConsigneeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsigneeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<form action=CheckConsigneeLogin method=post>");
		out.println("<table>");
		out.println("<caption><b><i>Consignee Login</i></b></cation>");
		out.println("<tr><td><b><i>Consignee Id:</i></b></td><td><input type=text name=cid></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password name=password></td></tr>");
		out.println("<tr><td><input type=submit value='SignIn'></td><td>&nbsp;</td></tr>");
		out.println("</table></form></html>");
		out.flush();
	}

}
