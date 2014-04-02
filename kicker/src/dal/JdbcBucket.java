package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bll.Bucket;

public class JdbcBucket implements BucketDao
{
   /**
    * createBucket Creates a new bucket in the database.
    * @param newBucket The bucket instance to be inserted.
    * @return Returns the bucket inserted from the database, or null if error.
    */
      @Override
      public Bucket createBucket(Bucket newBucket)
   {
      // format the string
      String query = "INSERT INTO Buckets(UserID, BucketName, CreationDate, Description, CityID)";
      query += " VALUES (%1$d, '%2$s', '%3$s', '%4$s', %3$d)";

      query = String.format(query, newBucket.getUserID(), newBucket.getBucketName(),
    		  newBucket.getCreationDate(), newBucket.getDescription(), newBucket.getCityID());

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
      public Bucket getBucketById(int bucketId)
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
      public boolean updateBucket(Bucket newBucket)
   {
      // format the string
      String query = "UPDATE Buckets SET UserID = %1$d, BucketName = '%2$s', CreationDate = '%3$s', Description = '%4$s', CityID = %5$d WHERE BucketID = %6$d";

      query = String.format(query, newBucket.getUserID(), newBucket.getBucketName(),
                            newBucket.getCreationDate(), newBucket.getDescription(), newBucket.getCityID(), newBucket.getBucketID());

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
      public boolean deleteBucket(Bucket oldBucket)
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
   public Bucket convertResultSetToBucket(ResultSet rs)
   {
      if (rs != null)
      {
                  try
                  {
                     int pBucketID = rs.getInt("BucketID");
                     int pUserID = rs.getInt("UserID");
                     String pBucketName = rs.getString("BucketName");
                     String pDescription = rs.getString("Description");
                     int pCityID = rs.getInt("CityID");

                     //Not sure about this one being a Date object
                     Date pCreationDate = rs.getDate("CreationDate");

                     return new Bucket(pBucketID, pUserID, pBucketName, pCreationDate, pDescription, pCityID);
                  }
                  catch (Exception e)
                  {
                     // TODO: Handle
                  }
      }

      return null;
   }
   
   public List<Bucket> getBucketsByUserId(int userId)
   {
      ResultSet rs = DataService.getData("SELECT * FROM Buckets WHERE UserID = " + userId);

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
}