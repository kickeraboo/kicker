package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.Rating;

public class JdbcRating implements RatingDao
{
   /**
    * createRating Creates a new rating in the database.
    * @param newRating The Rating instance to be inserted.
    * @return Returns the rating inserted from the database, or null if error.
    */
      @Override
      public Rating createRating(Rating newRating)
   {
      // format the string
      String query = "INSERT INTO Ratings(ItemId, Rating, Comment)";
      query += " VALUES ('%1$s', '%2$s', '%3$s')";

      query = String.format(query, newRating.getItemID(), newRating.getRating(),
                            newRating.getComment());

      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getRatingById(insertedId);
      }

      return null;
   }

   /**
    * getUserById Obtains a rating from the database, given an id.
    * @param ratingId The unique identifier of the user to retrieve.
    * @return Returns the rating with this id in the database.
    */
      @Override
      public Rating getRatingById(int ratingId)
   {
      String query = "SELECT * FROM Ratings WHERE UserID = " + ratingId;
      ResultSet rs = DataService.getData(query);

            try
            {
               if (rs.next())
               {
                  return convertResultSetToRating(rs);
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
    * updateRating Updates a rating in the database.
    * @param newRating The rating instance to be updated.
    * @return Returns true or false if the rating was updated or not.
    */
      @Override
      public boolean updateRating(Rating newRating)
   {
      // format the string
      String query = "UPDATE Ratings SET ItemID = '%1$s', Rating = '%2$s', Comment = '%3$s' WHERE RatingID = %6$d";

      query = String.format(query, newRating.getItemID(), newRating.getRating(),
    		  newRating.getComment(), newRating.getRatingID());

      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }

   /**
    * deleteRating Deletes a rating from the database.
    * @param oldRating The rating instance to be deleted.
    * @return Returns true if the rating was deleted and false if the rating was not deleted.
    */
      @Override
      public boolean deleteRating(Rating oldRating)
   {
      return deleteRating(oldRating.getRatingID());
   }

   /**
    * deleteRating Deletes a rating from the database.
    * @param ratingId The id of the rating to be deleted in the database.
    * @return Returns true if the rating was deleted and false if the rating was not deleted.
    */
      @Override
      public boolean deleteRating(int ratingId)
   {
      String query = "DELETE FROM Ratings WHERE RatingID = " + ratingId;
      return DataService.executeDelete(query);
   }

   /**
    * getAll Obtains all of the Ratings from the database.
    * @return A Generic list of ratings from the database.
    */
      @Override
      public List<Rating> getAll()
   {

      ResultSet rs = DataService.getData("SELECT * FROM Ratings");

      List<Rating> ratings = new ArrayList<Rating>();

            try
            {
               while (rs.next())
               {
                  ratings.add(convertResultSetToRating(rs));
               }
            }
            catch (SQLException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

            return ratings;
   }

   /**
    * convertResultSetToUser for lack of implicit/explicit operators, we manually convert a row in the result set, into an user.
    * @param rs The result set to convert into a User object.
    * @return A user object.
    */
   public Rating convertResultSetToRating(ResultSet rs)
   {
      if (rs != null)
      {
                  try
                  {
                     int pRatingID = rs.getInt("RatingID");
                     int pItemID = rs.getInt("ItemID");
                     int pRating = rs.getInt("Rating");
                     String pComment = rs.getString("Comment");

                     return new Rating(pRatingID, pItemID, pRating, pComment);
                  }
                  catch (Exception e)
                  {
                     // TODO: Handle
                  }
      }

      return null;
   }
}