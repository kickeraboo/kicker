package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DataService
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/kickeraboo";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "k1ck3rab00";

	public static ResultSet getData(String query)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//get the cached row set
			CachedRowSet rowset = new CachedRowSetImpl();
			rowset.populate(rs);
			
			//clean up
			rs.close();
			stmt.close();
			conn.close();
			
			//return it
			return rowset;
		} 
		catch (SQLException se)
		{
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e)
		{
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally
		{
			// finally block used to close resources
			try
			{
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2)
			{
			}// nothing we can do
			try
			{
				if (conn != null)
					conn.close();
			} catch (SQLException se)
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
