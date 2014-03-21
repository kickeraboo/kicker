package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.User;

public class JdbcUser implements UserDao
{
   /**
    * createUser Creates a new user in the database.
    * @param newUser The user instance to be inserted.
    * @return Returns the user inserted from the database, or null if error.
    */
   @Override
   public User createUser(User newUser)
   {
      // format the string
      String query = "INSERT INTO Users(Email, FacebookID, Username, RoleID, Status)";
      query += " VALUES ('%1$s', '%2$s', '%3$s', %4$d, %5$d)";
      
      query = String.format(query, newUser.getEmail(), newUser.getFacebookID(),
            newUser.getUsername(), newUser.getRoleID(),
            (newUser.getStatus() ? 0 : 1));
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getUserById(insertedId);
      }
      
      return null;
   }
   
   /**
    * getUserById Obtains an user from the database, given an id.
    * @param userId The unique identifier of the user to retrieve.
    * @return Returns the user with this id in the database.
    */
   @Override
   public User getUserById(int userId)
   {
      String query = "SELECT * FROM Users WHERE UserID = " + userId;
      ResultSet rs = DataService.getData(query);
      
      try
      {
         if (rs.next())
         {
            return convertResultSetToUser(rs);
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }
   
   /**
    * updateUser Updates a user in the database.
    * @param newUser The user instance to be updated.
    * @return Returns true or false if the user was updated or not.
    */
   @Override
   public boolean updateUser(User newUser)
   {
      // format the string
      String query = "UPDATE Users SET Email = '%1$s', FacebookID = '%2$s', Username = '%3$s', RoleID = %4$d, Status = %5$d WHERE UserID = %6$d";
      
      query = String.format(query, newUser.getEmail(), newUser.getFacebookID(),
            newUser.getUsername(), newUser.getRoleID(),
            (newUser.getStatus() ? 0 : 1), newUser.getUserID());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }
   
   /**
    * deleteUser Deletes a user from the database.
    * @param oldUser The user instance to be deleted.
    * @return Returns true if the user was deleted and false if the user was not deleted.
    */
   @Override
   public boolean deleteUser(User oldUser)
   {
      return deleteUser(oldUser.getUserID());
   }
   
   /**
    * deleteUser Deletes a user from the database.
    * @param userId The id of the user to be deleted in the database.
    * @return Returns true if the user was deleted and false if the user was not deleted.
    */
   @Override
   public boolean deleteUser(int userId)
   {
      String query = "DELETE FROM Users WHERE UserID = " + userId;
      return DataService.executeDelete(query);
   }
   
   /**
    * getAll Obtains all of the Users from the database.
    * @return A Generic list of users from the database.
    */
   @Override
   public List<User> getAll()
   {
      
      ResultSet rs = DataService.getData("SELECT * FROM Users");
      
      List<User> users = new ArrayList<User>();
      
      try
      {
         while (rs.next())
         {
            users.add(convertResultSetToUser(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return users;
   }
   
   /**
    * convertResultSetToUser for lack of implicit/explicit operators, we manually convert a row in the result set, into an user.
    * @param rs The result set to convert into a User object.
    * @return A user object.
    */
   public User convertResultSetToUser(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pUserID = rs.getInt("UserID");
            String pEmail = rs.getString("Email");
            String pFacebookID = rs.getString("FacebookID");
            String pUsername = rs.getString("Username");
            int pRoleID = rs.getInt("RoleID");
            boolean pStatus = rs.getBoolean("Status");
            
            return new User(pUserID, pEmail, pFacebookID, pUsername, pRoleID,
                  pStatus);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      
      return null;
   }
}
