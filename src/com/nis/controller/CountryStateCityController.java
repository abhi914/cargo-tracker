package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class CountryStateCityController {
 public static ResultSet getAllCountry()
 {
   try{
	   Connection cn=DBHelper.openConnection();
	ResultSet rs=DBHelper.executeQuery(cn,"Select * from country");   
	   return(rs);
   }catch(Exception e){
	System.out.println(e);
	return(null);
   }	 
	 
 }
 public static ResultSet getAllState(int countryId)
 {
   try{
	   Connection cn=DBHelper.openConnection();
	ResultSet rs=DBHelper.executeQuery(cn,"Select * from state where countryid="+countryId);   
	   return(rs);
   }catch(Exception e){
	System.out.println(e);
	return(null);
   }	 
	 
 }	
	
 public static ResultSet getAllCity(int stateid)
 {
   try{
	   Connection cn=DBHelper.openConnection();
	ResultSet rs=DBHelper.executeQuery(cn,"Select * from city where stateid="+stateid);   
	   return(rs);
   }catch(Exception e){
	System.out.println(e);
	return(null);
   }	 
	 
 }	
 
 
 
}
