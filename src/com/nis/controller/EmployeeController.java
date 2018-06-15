package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;


import com.nis.model.Employee;

public interface EmployeeController {
	   public static boolean addNewRecord(Employee E){
    	   try{
    		   Connection cn=DBHelper.openConnection();
    		                                                                                                                                        
               String q="Insert into Employee (employeename,dob,address,country,state,city,Phone,mobile,qualification,designation,photograph,password) values ('"+E.getEmployeename()+"','"+E.getDob()+"','"+E.getAddress()+"','"+E.getCountry()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getPhone()+"','"+E.getMobile()+"','"+E.getQualification()+"','"+E.getDesignation()+"','"+E.getPhotograph()+"','"+E.getPassword()+"')";
               boolean st=DBHelper.executeUpdate(cn, q);
               return (st);
           }
    	   catch(Exception e){
    		   System.out.println("EmployeeController:addNewRecord:"+e);
    		   return false;	
    	   }
       }


       public static ResultSet displayAll()
       {try{
       	Connection cn=DBHelper.openConnection();
       	String q="select employeeid,employeename,dob,address,(select countryname from country C where C.countryid=CC.country),(select statename from state S where S.stateid=CC.state), (select cityname from city CI where CI.cityid=CC.city) ,Phone,mobile,qualification,designation,photograph from Employee CC";
       	ResultSet rs=DBHelper.executeQuery(cn, q);
       	return(rs);
         }
       catch(Exception e)
       {System.out.println("EmployeeController:displayAll:"+e);
       return null;	
       }
       }	

     public static Employee displayById(int cid)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="select employeeid,employeename,dob,address,country,(select countryname from country C where C.countryid=CC.country),state,(select statename from state S where S.stateid=CC.state),city, (select cityname from city CI where CI.cityid=CC.city) ,phone,mobile,qualification,designation,photograph  from Employee CC where CC.employeeid="+cid;
     	ResultSet rs=DBHelper.executeQuery(cn, q);
     	if(rs.next())
     	{ Employee E=new Employee();
     	  E.setEmployeeid(Integer.parseInt(rs.getString(1)));
     	  E.setEmployeename(rs.getString(2));
     	  E.setDob(rs.getString(3));
     	  E.setAddress(rs.getString(4));
     	  E.setCountry(rs.getString(5)+","+rs.getString(6));
     	  E.setState(rs.getString(7)+","+rs.getString(8));
     	  E.setCity(rs.getString(9)+","+rs.getString(10));
     	  E.setPhone(rs.getString(11));
     	  E.setMobile(rs.getString(12));
     	  E.setQualification(rs.getString(13));
     	  E.setDesignation(rs.getString(14));
     	  E.setPhotograph(rs.getString(15));
     		return(E);
     	}
     	else
     	{
     	return(null);	
     	}
     	 
       }
     catch(Exception e)
     {System.out.println("EmployeeController:displayById:"+e);
     return null;	
     }
     }	
 
     public static boolean editRecord(Employee E)
     {try{
    //employeeid, employeename, dob,       address, country, state, city, Phone, mobile, qualification, designation, photograph, password	 
     	Connection cn=DBHelper.openConnection();
     	String q="update  Employee set employeename='"+E.getEmployeename()+"',dob='"+E.getDob()+"',address='"+E.getAddress()+"',country='"+E.getCountry()+"',state='"+E.getState()+"',city='"+E.getCity()+"',phone='"+E.getPhone()+"',mobile='"+E.getMobile()+"',qualification='"+E.getQualification()+"',designation='"+E.getDesignation()+"' where employeeid="+E.getEmployeeid();
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("EmployeeController:editRecord:"+e);
     return false;	
     }
     }

     
     
     
     public static boolean updatePicture(Employee E)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="update  employee set photograph='"+E.getPhotograph()+"' where employeeid="+E.getEmployeeid();
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("EmployeeController:updatePicture:"+e);
     return false;	
     }
     }

     
     public static boolean deleteRecord(int id)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="Delete from employee where employeeid="+id;
     			 
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("EmployeeController:deleteRecord:"+e);
     return false;	
     }
     } 
     
     public static Employee checkLogin(String aid,String pass){
 		try{
 			Connection cn=DBHelper.openConnection();
 			String q="select * from employee where employeeid="+aid+" and password='"+pass+"'";
 			System.out.println(q);  
 			ResultSet rs=DBHelper.executeQuery(cn, q);
 			if(rs.next()){
 				Employee E=new Employee();
 				System.out.println("OK");
 				E.setEmployeeid(Integer.parseInt(rs.getString(1)));
 				E.setMobile(rs.getString(9));
 				E.setEmployeename(rs.getString(2));
 				E.setPhotograph(rs.getString(12));
 				return E;
 			}
 			else{
 				System.out.println("INVALID");
 				return null;
 			}
 		}catch(Exception e){
 			System.out.println("EmployeeController:checkLogin"+e);
 			return null;
 		}
 	}

}
