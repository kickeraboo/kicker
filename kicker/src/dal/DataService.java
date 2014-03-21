package dal;

import helpers.PropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DataService
{
   
   // Database credentials
   static final String USER = PropertiesHelper.getProperty("DB_USER");
   static final String PASS = PropertiesHelper.getProperty("DB_PASS");
   static final String JDBC_DRIVER = PropertiesHelper
         .getProperty("JDBC_DRIVER");
   static final String DB_URL = PropertiesHelper
         .getProperty("DB_CONNECTION_STRING");
   
   public static Connection getConnection() throws SQLException,
         ClassNotFoundException
   {
      Class.forName(JDBC_DRIVER);
      return DriverManager.getConnection(DB_URL, USER, PASS);
   }
   
   public static ResultSet getData(String query)
   {
      Connection conn = null;
      Statement stmt = null;
      try
      {
         conn = getConnection();
         stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);
         
         // get the cached row set
         CachedRowSet rowset = new CachedRowSetImpl();
         rowset.populate(rs);
         
         // clean up
         rs.close();
         stmt.close();
         conn.close();
         
         // return it
         return rowset;
      }
      catch (SQLException se)
      {
         // Handle errors for JDBC
         se.printStackTrace();
      }
      catch (Exception e)
      {
         // Handle errors for Class.forName
         e.printStackTrace();
      }
      finally
      {
         // finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         }
         catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         }
         catch (SQLException se)
         {
            se.printStackTrace();
         }// end finally try
      }// end try
      return null;
   }
   
   public static boolean executeDelete(String query)
   {
      try
      {
         Connection conn = getConnection();
         Statement smt = conn.createStatement();
         return smt.executeUpdate(query)  > 0  ? true : false;
         
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return false;
      
   }
   
   public static boolean executeUpdate(String query)
   {
      try
      {
         Connection conn = getConnection();
         Statement smt = conn.createStatement();
         return smt.executeUpdate(query) > 0 ? true : false;
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return false;
      
   }
   
   public static int executeCreate(String query)
   {
      int insertedId = -1;
      try
      {
         ResultSet rs = null;
         
         Connection conn = getConnection();
         Statement stmt = conn.prepareStatement(query,
               Statement.RETURN_GENERATED_KEYS);
         int affectedRows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
         
         if (affectedRows > 0)
         {
            rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
               insertedId = rs.getInt(1);
            }
         }
         
         conn.close();
         stmt.close();
         rs.close();
      }
      catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return insertedId;
   }
}
