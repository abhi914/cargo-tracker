package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Admin;
import com.nis.model.Employee;

/**
 * Servlet implementation class DispatchView
 */
@WebServlet("/DispatchView")
public class DispatchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchView() {
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
        
		out.println("<html>");
		String eid="";
		try{
			Employee E=(Employee)ses.getValue("SEMPLOYEE");	
		 String nav="<h5><i>Employee id:"+E.getEmployeeid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+E.getEmployeename()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/"+E.getPhotograph()+" width=35 height=35></i></h5><hr>";	
		eid=E.getEmployeeid()+"";
		 // out.println(nav);		 
			
		}catch(Exception e)
		{
	     response.sendRedirect("EmployeeLogin");		
		}
    	out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
        out.println("<script src='asset/dispatch.js'></script>");

        out.println("<form action=DispatchSubmit method=get  enctype='multipart/form-data'>");
        out.println("<table width=70%>");
        out.println("<caption><b><i>Dispatch Form</i></b></caption>");
        out.println("<tr>");
        out.println("<td><b><i>Employee ID:</i></b></td><td><input type=text name=employeeid value="+eid+" readonly=true size=30></td>");
        out.println("</tr>");
        Calendar C=Calendar.getInstance();
        String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
        String ct=C.get(Calendar.HOUR)+":"+(C.get(Calendar.MINUTE))+":"+C.get(Calendar.SECOND);
                
        
        out.println("<tr>");
        out.println("<td><b><i>Dispacth Date:</i></b></td><td><input type=text name=dispatchdate required value='"+cd+"' size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Dispatch Time:</i></b></td><td><input type=text required name=dispatchtime value='"+ct+"' size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Consigner ID:</i></b></td><td><select id=consigner name=consigner></select></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Consignee ID:</i></b></td><td><select id=consignee name=consignee></select></td>");
        out.println("</tr>");
        
       
        
        out.println("<tr>");
        out.println("<td><b><i>Product Description :</i></b></td><td><input type=text name=productdesc required size=30></td>");
        out.println("</tr>");
       
        out.println("<tr>");
        out.println("<td><b><i>Product Type</i></b></td><td><select  name=producttype><option>-Select-</option><option>Solid</option><option>Liquid</option><option>Exploxives</option><option>Others</option></select></td>");
        out.println("</tr>");
        
        
        
        
        out.println("<tr>");
        out.println("<td><b><i>Total Box:</i></b></td><td><input type=text name=totalbox required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Quaintity_In_Box:</i></b></td><td><input type=text name=quantInbox required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Amount:</i></b></td><td><input type=text name=amount  required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Charge of Dispatch:</i></b></td><td><input type=text name=chargeofdispatch required size=30></td>");
        out.println("</tr>");
        
        
        
        
        
        
        
        out.println("<tr>");
        out.println("<td><b><i>Dispatch From:</i></b></td><td><input type=text name=dispatchfrom required size=30></td>");
        out.println("</tr>");
        
		
        out.println("<tr>");
        out.println("<td><b><i>Dispacth To:</i></b></td><td><input type=text required name=dispatchto></td>");
        out.println("</tr>");
        
		
        out.println("<tr>");
        out.println("<td><b><i>Dispatch By</i></b></td><td><select  name=dispatchby><option>-Select-</option><option>Air</option><option>Sea Route</option><option>Road</option><option>Others</option></select></td>");
        out.println("</tr>");
        
        
        
        
        
        
        out.println("<tr>");
        out.println("<td><b><i>Veichel Number:</i></b></td><td><input type=text required name=veichelno size=30 ></td>");
        out.println("</tr>");
    
        
        out.println("<tr>");
        out.println("<td><b><i>Approx Days:</i></b></td><td><input type=text required name=approxday size=30 ></td>");
        out.println("</tr>");
    
        out.println("<tr>");
        out.println("<td><input type=submit id=btn></td><td><input type=reset></td>");
        out.println("</tr>");
        out.println("</table></form></html>");
        out.flush();
		

	
	
	
	
	
	
	
	
	
	
	}

}
