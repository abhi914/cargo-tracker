package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AdminController;
import com.nis.model.Admin;

/**
 * Servlet implementation class CheckAdminLogin
 */
@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	String aid=request.getParameter("aid");
	String password=request.getParameter("password");
	Admin A=AdminController.checkPassword(aid, password);
		if(A!=null)
		{  HttpSession ses=request.getSession();
		   ses.putValue("SADMIN", A);
		   ses.putValue("LTIME", new java.util.Date());
			response.sendRedirect("AdminHome");
			
		}
		else
		{out.println("Invalid AdminID/Password");
			
		}
	
	
	}

}
