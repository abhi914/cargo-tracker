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
import com.nis.controller.EmployeeController;
import com.nis.model.Admin;
import com.nis.model.Employee;

/**
 * Servlet implementation class EmployeeLoginCheck
 */
@WebServlet("/EmployeeLoginCheck")
public class EmployeeLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String aid=request.getParameter("eid");
		String password=request.getParameter("password");
		Employee E=EmployeeController.checkLogin(aid,password);
		if(E!=null){
			HttpSession ses=request.getSession();
			  ses.putValue("SEMPLOYEE", E);
			  ses.putValue("LTIME", new java.util.Date());
			response.sendRedirect("EmployeeHome");
		}
		else{
			out.print("Invalid ID/Password");
		}
	}

}
