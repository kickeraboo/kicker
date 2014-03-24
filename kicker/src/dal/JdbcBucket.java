package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.Bucket;

public class JdbcBucket implements BucketDao
{
   /**
    * createBucket Creates a new bucket in the database.
    * @param newBucket The bucket instance to be inserted.
    * @return Returns the bucket inserted from the database, or null if error.
    */
      @Override
      public User createBucket(User newBucket)
   {
      // format the string
      String query = "INSERT INTO Buckets(UserID, BucketName, CreationDate)";
      query += " VALUES ('%1$s', '%2$s', '%3$s)";

      query = String.format(query, newBucket.getUserID(), newUser.getBucketName(),
                            newUser.getCreationDate());

      // if everything worked, inserted id will have the identity key
      // or primary key
      int insertedId = DataService.executeCreate(query);
      if (insertedId > 0)
      {
         return getBucketById(insertedId);
      }

      return null;
   }

   /**
    * getBucketById Obtains an bucket from the database, given an id.
    * @param bucketId The unique identifier of the bucket to retrieve.
    * @return Returns the bucket with this id in the database.
    */
      @Override
      public User getBucketById(int bucketId)
   {
      String query = "SELECT * FROM Buckets WHERE BucketID = " + bucketId;
      ResultSet rs = DataService.getData(query);

            try
            {
               if (rs.next())
               {
                  return convertResultSetToBucket(rs);
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
    * updateBucket Updates a bucket in the database.
    * @param newBucket The bucket instance to be updated.
    * @return Returns true or false if the bucket was updated or not.
    */
      @Override
      public boolean updateBucket(User newBucket)
   {
      // format the string
      String query = "UPDATE Buckets SET UserID = '%1$s', BucketName = '%2$s', CreationDate = '%3$s' WHERE BucketID = %6$d";

      query = String.format(query, newBucket.getUserID(), newBucket.getBucketName(),
                            newBucket.getCreationDate());

      // if everything worked, inserted id will have the identity key
      // or primary key
      return DataService.executeUpdate(query);
   }

   /**
    * deleteBucket Deletes a bucket from the database.
    * @param oldBucket The bucket instance to be deleted.
    * @return Returns true if the bucket was deleted and false if the bucket was not deleted.
    */
      @Override
      public boolean deleteBucket(User oldBucket)
   {
      return deleteBucket(oldBucket.getBucketID());
   }

   /**
    * deleteBucket Deletes a bucket from the database.
    * @param bucketId The id of the bucket to be deleted in the database.
    * @return Returns true if the bucket was deleted and false if the bucket was not deleted.
    */
      @Override
      public boolean deleteBucket(int bucketId)
   {
      String query = "DELETE FROM Buckets WHERE BucketID = " + bucketId;
      return DataService.executeDelete(query);
   }

   /**
    * getAll Obtains all of the Buckets from the database.
    * @return A Generic list of buckets from the database.
    */
      @Override
      public List<Bucket> getAll()
   {

      ResultSet rs = DataService.getData("SELECT * FROM Buckets");

      List<Bucket> buckets = new ArrayList<Bucket>();

            try
            {
               while (rs.next())
               {
                  buckets.add(convertResultSetToBucket(rs));
               }
            }
            catch (SQLException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

            return buckets;
   }

   /**
    * convertResultSetToBucket for lack of implicit/explicit operators, we manually convert a row in the result set, into a bucket.
    * @param rs The result set to convert into a Bucket object.
    * @return A bucket object.
    */
   public User convertResultSetToBucket(ResultSet rs)
   {
      if (rs != null)
      {
                  try
                  {
                     int pBucketID = rs.getInt("BucketID");
                     int pUserID = rs.getInt("UserID");
                     String pBucketName = rs.getString("BucketName");

                     //Not sure about this one being a Date object
                     Date pCreationDate = rs.getDate("CreationDate");

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