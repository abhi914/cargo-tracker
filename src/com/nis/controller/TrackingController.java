package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Employee;
import com.nis.model.Tracking;

public class TrackingController {
	 public static boolean addNewRecord(Tracking T){
  	   try{
  		   Connection cn=DBHelper.openConnection();
  		                                                                                                                                        
             String q="Insert into tracking (trackingid,employeeid,tdate,ttime,description,lat,lng) values ("+T.getTrackingid()+","+T.getEmployeeid()+",'"+T.getTdate()+"','"+T.getTtime()+"','"+T.getDescription()+"','"+T.getLat()+"','"+T.getLng()+"')";
             		  
             boolean st=DBHelper.executeUpdate(cn, q);
             return (st);
         }
  	   catch(Exception e){
  		   System.out.println("TrackingController:addNewRecord:"+e);
  		   return false;	
  	   }
     }
	 
	 public static ResultSet searchByTrackingId(int tid){
	  	   try{
	  		   Connection cn=DBHelper.openConnection();
	  		                                                                                                                                        
	  		   
	             String q="select T.*,d.*,C.ownername CNO ,C.firmname CNF,CE.ownername CEO,CE.firmname CEF,CE.contactperson CEC,C.contactperson CNC from tracking T,dispatch D,consignee CE,consigner C where T.trackingid="+tid+" and D.transactionid="+tid+" and D.consignerid=C.id and D.consigneeid=CE.id";
	             System.out.println(q);
	             		  
	             ResultSet rs=DBHelper.executeQuery(cn, q);
	             return (rs);
	         }
	  	   catch(Exception e){
	  		   System.out.println("TrackingController:addNewRecord:"+e);
	  		   return null;	
	  	   }
	     }
}
