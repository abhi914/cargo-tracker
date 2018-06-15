package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.ConsigneeController;
import com.nis.controller.ConsignerController;
import com.nis.controller.DispatchController;
import com.nis.controller.TrackingController;
import com.nis.model.Consignee;
import com.nis.model.Consigner;
import com.nis.model.Dispatch;
import com.nis.model.Tracking;

/**
 * Servlet implementation class DispatchSubmit
 */
@WebServlet("/DispatchSubmit")
public class DispatchSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	/*
	 * 
	 * 
	 * http://localhost:88/CargoTracking/DispatchSubmit?
	 * &dispatchdate=ee&dispatchtime=ee&consigner=5&consignee=2&productdesc=ee&producttype=Liquid&totalbox=ee&quantInbox=e&amount=e&chargeofdispatch=e&dispatchfrom=e&dispa
	 * tchto=e&dispatchby=Sea+Route&veichelno=e&approxday=e	
	 */
		PrintWriter out=response.getWriter();
		Dispatch D=new Dispatch();
		D.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
	    D.setDispatch_Date(request.getParameter("dispatchdate"));
	    D.setDispatch_Time(request.getParameter("dispatchtime"));
	    D.setConsigner_Id(Integer.parseInt(request.getParameter("consigner")));
	    D.setConsignee_Id(Integer.parseInt(request.getParameter("consignee")));
        D.setProduct_Desc(request.getParameter("productdesc"));
       	D.setProduct_Type(request.getParameter("producttype"));
       	D.setTotal_Box(request.getParameter("totalbox"));
       	D.setQuantity_In_Box(request.getParameter("quantInbox"));
       	D.setAmount(request.getParameter("quantInbox"));
       	D.setCharge_Of_Dispatch(request.getParameter("chargeofdispatch"));
        D.setDispatch_From(request.getParameter("dispatchfrom"));
        D.setDispatch_To(request.getParameter("dispatchto"));
	    D.setDispatch_By(request.getParameter("dispatchby"));
	    D.setVeichel_No(request.getParameter("veichelno"));
	    D.setApproxdays(request.getParameter("approxday"));
	    
	    boolean st=DispatchController.addNewRecord(D);
        out.println("<html>");
        if(st)
        {out.println("<b><i>Record Submitted</i></b>");
         
        int tid=DispatchController.getTrackingid();
        ////Insert Record in Tracking Table
        Tracking T=new Tracking();
        T.setTrackingid(tid);
        T.setEmployeeid(D.getEmployeeid());
        T.setTdate(D.getDispatch_Date());
        T.setTtime(D.getDispatch_Time());
        StringBuffer des=new StringBuffer();
        des.append("Dispatch From:"+D.getDispatch_From()+"\r");
        des.append("Dispatch To:"+D.getDispatch_To()+"\r");
        des.append("Dispatch By:"+D.getDispatch_By()+"\r");
        des.append("Vehicle No: "+D.getVeichel_No());
        T.setDescription(des.toString());
        T.setLat("0");
        T.setLng("0");
        TrackingController.addNewRecord(T);
        
        ///////////////
        
        
        
        
        
        SmsServlet sms=new SmsServlet();
         Consigner Cr=new Consigner();
         
         Cr=ConsignerController.displayById(D.getConsigner_Id());
          System.out.print(Cr.getMobileno());
         sms.SendSms("COM4",Cr.getMobileno() ,"Your Product Has Been Dispatched..Ur Tracking is "+tid);
       Consignee Ce=new  Consignee();
       Ce=ConsigneeController.displayById(D.getConsignee_Id());
       System.out.print(Ce.getMobileno());
       sms.SendSms("COM4",Ce.getMobileno() ,"Your Product Has Been Dispatched..Ur Tracking is "+tid);
        }
        else
        {out.println("<b><i>Fail to Submit Record</i></b>");
        	
        }
        out.println("</html>");
        out.flush();
	

	    
	    
	    
	}

}
