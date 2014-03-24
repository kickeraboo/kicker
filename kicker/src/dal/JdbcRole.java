package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.Role;

public class JdbcRole implements RoleDao
{
   /**
    * createRole Creates a new role in the database.
    * @param newRole The role instance to be inserted.
    * @return Returns the role inserted from the database, or null if error.
    */
   @Override
   public Role createRole(Role newRole)
   {
      // format the string
      String query = "INSERT INTO Roles(RoleName, Status)";
      query += " VALUES ('%1$s', '%2$s')";
      
      query = String.format(query, newRole.getRoleName(), newRole.getStatus());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getRoleById(insertedId);
      }
      
      return null;
   }
   
   /**
    * getRoleById Obtains an role from the database, given an id.
    * @param roleId The unique identifier of the role to retrieve.
    * @return Returns the role with this id in the database.
    */
   @Override
   public Role getRoleById(int roleId)
   {
      String query = "SELECT * FROM Roles WHERE RoleID = " + roleId;
      ResultSet rs = DataService.getData(query);
      
      try
      {
         if (rs.next())
         {
            return convertResultSetToRole(rs);
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
    * updateRole Updates a role in the database.
    * @param newRole The role instance to be updated.
    * @return Returns true or false if the role was updated or not.
    */
   @Override
   public boolean updateRole(Role newRole)
   {
      // format the string
      String query = "UPDATE Roles SET RoleName = '%1$s', Status = '%2$s'";
      
      query = String.format(query, newRole.getRoleName(), newRole.getStatus());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }
   
   /**
    * deleteRole Deletes a role from the database.
    * @param oldRole The role instance to be deleted.
    * @return Returns true if the role was deleted and false if the role was not deleted.
    */
   @Override
   public boolean deleteRole(Role oldRole)
   {
      return deleteRole(oldRole.getRoleID());
   }
   
   /**
    * deleteRole Deletes a role from the database.
    * @param roleId The id of the role to be deleted in the database.
    * @return Returns true if the role was deleted and false if the role was not deleted.
    */
   @Override
   public boolean deleteRole(int roleId)
   {
      String query = "DELETE FROM Roles WHERE RoleID = " + roleId;
      return DataService.executeDelete(query);
   }
   
   /**
    * getAll Obtains all of the Roles from the database.
    * @return A Generic list of roles from the database.
    */
   @Override
   public List<Role> getAll()
   {
      
      ResultSet rs = DataService.getData("SELECT * FROM Roles");
      
      List<Role> roles = new ArrayList<Role>();
      
      try
      {
         while (rs.next())
         {
            roles.add(convertResultSetToRole(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return roles;
   }
   
   /**
    * convertResultSetToRole for lack of implicit/explicit operators, we manually convert a row in the result set, into an role.
    * @param rs The result set to convert into a Role object.
    * @return A role object.
    */
   public Role convertResultSetToRole(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pRoleID = rs.getInt("RoleID");
            String pRoleName = rs.getString("RoleName");
            String pStatus = rs.getString("Status");
            
            return new Role(pRoleID, pRoleName, pStatus);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      
      return null;
   }
}
