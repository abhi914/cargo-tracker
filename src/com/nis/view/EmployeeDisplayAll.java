package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.EmployeeController;
import com.nis.model.Admin;


/**
 * Servlet implementation class EmployeeDisplayAll
 */
@WebServlet("/EmployeeDisplayAll")
public class EmployeeDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 HttpSession ses=request.getSession();
		 
			try{
			 Admin A=(Admin)ses.getValue("SADMIN");	
			 String nav="<h5><i>Admin id:"+A.getAdminid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/"+A.getPicture()+" width=35 height=35></i></h5>";	
		//	 out.println (nav);		 
				
			}catch(Exception e)
			{
		     response.sendRedirect("AdminLogin");		
			}
		   
		   
		try{
		ResultSet rs=EmployeeController.displayAll();
		out.println("<html>");
		out.println("<a href=EmployeeView>Add  New Employee</a><br>");

		if(rs.next())
		{out.print("<table border=1>");
		out.print("<caption><i><b>List of Employee</b></i></caption>");
		  out.println("<tr>");
		  //  employeeid,employeename,dob,address,(select countryname from country C where C.countryid=CC.country),(select statename from state S where S.stateid=CC.state), (select cityname from city CI where CI.cityid=CC.city) ,Phone,mobile,qualification,designation,photograph from Employee CC";
		    
		  out.println("<th>Sno</th><th>Id/EmployeeName</th><th>DOB</th><th>Address</th><th>Qualifications</th><th>Designation</th><th>Photograph</th><th>Update</th></tr>");
	 		int sn=1;
			do{
				out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"/<br>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(7)+","+rs.getString(6)+"<br>"+rs.getString(5)+"<br>Mob:"+rs.getString(8)+" Ph:"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td><img src=images/"+rs.getString(12)+" width=45 height=45><br>"+"</a></td><td><a href=EmployeeDisplayById?cid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
				
				
			sn++;
		}while(rs.next());
			out.println("</table></html>");
		}
		else
		{
		out.println("Record Not Found");	
		}
			
		}catch(Exception e){
			out.println(e);
			
		}

	
	
	}

}
