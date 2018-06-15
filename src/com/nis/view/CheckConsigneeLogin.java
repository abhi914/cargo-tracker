package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.ConsigneeController;
import com.nis.model.Consignee;



/**
 * Servlet implementation class CheckConsigneeLogin
 */
@WebServlet("/CheckConsigneeLogin")
public class CheckConsigneeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckConsigneeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		String password=request.getParameter("password");
		Consignee C=ConsigneeController.checkPassword(cid, password);
		if(C!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("SADMIN", C);
			ses.putValue("LTIME", new java.util.Date());
			response.sendRedirect("ConsigneeHome");
		}
		else
		{
			out.println("Invalid AdminID/Password");
		}
	}

}
