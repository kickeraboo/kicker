package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.SubCategory;

public class JdbcSubCategory implements SubCategoryDao
{
   /**
    * createSubCategory Creates a new subCategory in the database.
    * @param newSubCategory The subCategory instance to be inserted.
    * @return Returns the subCategory inserted from the database, or null if error.
    */
   @Override
   public SubCategory createSubCategory(SubCategory newSubCategory)
   {
      // format the string
      String query = "INSERT INTO SubCategories(SubCategoryName, CategoryID)";
      query += " VALUES ('%1$s', '%2$s')";
      
      query = String.format(query, newSubCategory.getSubCategoryName(), newSubCategory.getCategoryID());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getSubCategoryById(insertedId);
      }
      
      return null;
   }
   
   /**
    * getSubCategoryById Obtains an subCategory from the database, given an id.
    * @param subCategoryId The unique identifier of the subCategory to retrieve.
    * @return Returns the subCategory with this id in the database.
    */
   @Override
   public SubCategory getSubCategoryById(int subCategoryId)
   {
      String query = "SELECT * FROM SubCategories WHERE SubCategoryID = " + subCategoryId;
      ResultSet rs = DataService.getData(query);
      
      try
      {
         if (rs.next())
         {
            return convertResultSetToSubCategory(rs);
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
    * updateSubCategory Updates a subCategory in the database.
    * @param newSubCategory The subCategory instance to be updated.
    * @return Returns true or false if the subCategory was updated or not.
    */
   @Override
   public boolean updateSubCategory(SubCategory newSubCategory)
   {
      // format the string
      String query = "UPDATE SubCategories SET SubCategoryName = '%1$s', CategoryID = '%2$s', SubCategoryname = '%3$s'";
      
      query = String.format(query, newSubCategory.getSubCategoryName(), newSubCategory.getCategoryID());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }
   
   /**
    * deleteSubCategory Deletes a subCategory from the database.
    * @param oldSubCategory The subCategory instance to be deleted.
    * @return Returns true if the subCategory was deleted and false if the subCategory was not deleted.
    */
   @Override
   public boolean deleteSubCategory(SubCategory oldSubCategory)
   {
      return deleteSubCategory(oldSubCategory.getSubCategoryID());
   }
   
   /**
    * deleteSubCategory Deletes a subCategory from the database.
    * @param subCategoryId The id of the subCategory to be deleted in the database.
    * @return Returns true if the subCategory was deleted and false if the subCategory was not deleted.
    */
   @Override
   public boolean deleteSubCategory(int subCategoryId)
   {
      String query = "DELETE FROM SubCategories WHERE SubCategoryID = " + subCategoryId;
      return DataService.executeDelete(query);
   }
   
   /**
    * getAll Obtains all of the SubCategories from the database.
    * @return A Generic list of subCategories from the database.
    */
   @Override
   public List<SubCategory> getAll()
   {
      
      ResultSet rs = DataService.getData("SELECT * FROM SubCategories");
      
      List<SubCategory> subCategories = new ArrayList<SubCategory>();
      
      try
      {
         while (rs.next())
         {
            subCategories.add(convertResultSetToSubCategory(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return subCategories;
   }
   
   /**
    * convertResultSetToSubCategory for lack of implicit/explicit operators, we manually convert a row in the result set, into an subCategory.
    * @param rs The result set to convert into a SubCategory object.
    * @return A subCategory object.
    */
   public SubCategory convertResultSetToSubCategory(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pSubCategoryID = rs.getInt("SubCategoryID");
            String pSubCategoryName = rs.getString("SubCategoryName");
            String pCategoryID = rs.getString("CategoryID");
            
            return new SubCategory(pSubCategoryID, pSubCategoryName, pCategoryID);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      
      return null;
   }
}
