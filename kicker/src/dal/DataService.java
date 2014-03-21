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
   
   public static ResultSet getData(String query)
   {
      Connection conn = null;
      Statement stmt = null;
      try
      {
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
   
   public static boolean execute(String procedureName)
   {
      return false;
   }
}
