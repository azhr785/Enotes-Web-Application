/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author azhar
 */
public class DBConnection {
  private static  Connection conn;
  
  public static Connection getConn()
  {
      try{
          
        if(conn==null)
   {
     Class.forName("com.mysql.jdbc.Driver");
     conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Azharudin@123");
     
   }
      }
      catch(Exception e)
      {
      e.printStackTrace();
      }
      
      return conn;
  }

}
