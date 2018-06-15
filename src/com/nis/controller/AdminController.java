package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Admin;

public class AdminController {
	public static Admin checkPassword(String aid,String password)
	{try{
		Connection cn=DBHelper.openConnection();
		String q="select * from admin where adminid='"+aid+"' and password='"+password+"'";
		ResultSet rs=DBHelper.executeQuery(cn, q);
		if(rs.next())
		{Admin A=new Admin();
		A.setAdminid(rs.getString(1));
		A.setAdminname(rs.getString(2));
		A.setPicture(rs.getString(4));
		return(A);
			
			
		}
		else
		{return(null);
			
		}
		 
	  }
	catch(Exception e)
	{System.out.println("ConsignerController:displayAll:"+e);
	return null;	
	}
	}	
}
