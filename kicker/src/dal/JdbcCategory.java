package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.Category;

public class JdbcCategory implements CategoryDao
{
   /**
    * createCategory Creates a new category in the database.
    * @param newCategory The category instance to be inserted.
    * @return Returns the category inserted from the database, or null if error.
    */
   @Override
   public Category createCategory(Category newCategory)
   {
      // format the string
      String query = "INSERT INTO Categories(CategoryName, Description, CreationDate)";
      query += " VALUES ('%1$s', '%2$s', '%3$s')";
      
      query = String.format(query, newCategory.getCategoryName(), newCategory.getDescription(),
            newCategory.getCreationDate());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getCategoryById(insertedId);
      }
      
      return null;
   }
   
   /**
    * getCategoryById Obtains an category from the database, given an id.
    * @param categoryId The unique identifier of the category to retrieve.
    * @return Returns the category with this id in the database.
    */
   @Override
   public Category getCategoryById(int categoryId)
   {
      String query = "SELECT * FROM Categories WHERE CategoryID = " + categoryId;
      ResultSet rs = DataService.getData(query);
      
      try
      {
         if (rs.next())
         {
            return convertResultSetToCategory(rs);
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
    * updateCategory Updates a category in the database.
    * @param newCategory The category instance to be updated.
    * @return Returns true or false if the category was updated or not.
    */
   @Override
   public boolean updateCategory(Category newCategory)
   {
      // format the string
      String query = "UPDATE Categories SET CategoryName = '%1$s', Description = '%2$s', CreationDate = '%3$s'";
      
      query = String.format(query, newCategory.getCategoryName(), newCategory.getDescription(),
            newCategory.getCreationDate());
      
      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }
   
   /**
    * deleteCategory Deletes a category from the database.
    * @param oldCategory The category instance to be deleted.
    * @return Returns true if the category was deleted and false if the category was not deleted.
    */
   @Override
   public boolean deleteCategory(Category oldCategory)
   {
      return deleteCategory(oldCategory.getCategoryID());
   }
   
   /**
    * deleteCategory Deletes a category from the database.
    * @param categoryId The id of the category to be deleted in the database.
    * @return Returns true if the category was deleted and false if the category was not deleted.
    */
   @Override
   public boolean deleteCategory(int categoryId)
   {
      String query = "DELETE FROM Categories WHERE CategoryID = " + categoryId;
      return DataService.executeDelete(query);
   }
   
   /**
    * getAll Obtains all of the Categories from the database.
    * @return A Generic list of categories from the database.
    */
   @Override
   public List<Category> getAll()
   {
      
      ResultSet rs = DataService.getData("SELECT * FROM Categories");
      
      List<Category> categories = new ArrayList<Category>();
      
      try
      {
         while (rs.next())
         {
            categories.add(convertResultSetToCategory(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return categories;
   }
   
   /**
    * convertResultSetToCategory for lack of implicit/explicit operators, we manually convert a row in the result set, into an category.
    * @param rs The result set to convert into a Category object.
    * @return A category object.
    */
   public Category convertResultSetToCategory(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pCategoryID = rs.getInt("CategoryID");
            String pCategoryName = rs.getString("CategoryName");
            String pDescription = rs.getString("Description");
            String pCreationDate = rs.getString("CreationDate");
            int pRoleID = rs.getInt("RoleID");
            boolean pStatus = rs.getBoolean("Status");
            
            return new Category(pCategoryID, pCategoryName, pDescription, pCreationDate);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      
      return null;
   }
}
