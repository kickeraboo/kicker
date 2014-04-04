/**
 * 
 */
package bll;

import java.util.Date;
import java.util.List;

import dal.BucketDao;
import dal.JdbcBucket;

/**
 * @author Hamlet
 * 
 */
public class Bucket
{

   private int mBucketID;
   private int mUserID;
   private String mBucketName;
   private Date mCreationDate;
   private String mDescription;
   private int mCityID;

   /**
    * @return the mBucketID
    */
   public int getBucketID()
   {
      return mBucketID;
   }

   /**
    * @param mBucketID
    *           the mBucketID to set
    */
   public void setBucketID(int pBucketID)
   {
      this.mBucketID = pBucketID;
   }

   /**
    * @return the mUserID
    */
   public int getUserID()
   {
      return mUserID;
   }

   /**
    * @param mUserID
    *           the mUserID to set
    */
   public void setUserID(int pUserID)
   {
      this.mUserID = pUserID;
   }

   /**
    * @return the mBucketName
    */
   public String getBucketName()
   {
      return mBucketName;
   }

   /**
    * @return the creationDate
    */
   public Date getCreationDate()
   {
      return mCreationDate;
   }

   /**
    * @param creationDate
    *           the creationDate to set
    */
   public void setCreationDate(Date pCreationDate)
   {
      mCreationDate = pCreationDate;
   }

   /**
    * @param mBucketName
    *           the mBucketName to set
    */
   public void setBucketName(String pBucketName)
   {
      this.mBucketName = pBucketName;
   }

   /**
    * @return the mDescription
    */
   public String getDescription()
   {
      return mDescription;
   }

   /**
    * @param mDescription
    *           the mDescription to set
    */
   public void setDescription(String mDescription)
   {
      this.mDescription = mDescription;
   }

   /**
    * @return the mCityID
    */
   public int getCityID()
   {
      return mCityID;
   }

   /**
    * @param mCityID
    *           the mCityID to set
    */
   public void setCityID(int mCityID)
   {
      this.mCityID = mCityID;
   }

   /**
	 * 
	 */
   public Bucket(int pBucketID, int pUserID, String pBucketName, Date pCreationDate, String pDescription, int pCityID)
   {
      this.mBucketID = pBucketID;
      this.mUserID = pUserID;
      this.mBucketName = pBucketName;
      this.mCreationDate = pCreationDate;
      this.mDescription = pDescription;
      this.mCityID = pCityID;
   }

   public static List<Bucket> getAll()
   {
      BucketDao bucket = new JdbcBucket();
      return bucket.getAll();
   }

   public static List<Bucket> getBucketsByUserId(int userId)
   {
      BucketDao bucket = new JdbcBucket();
      return bucket.getBucketsByUserId(userId);
   }
   
   public static Bucket CreateBucket(int pUserID, String pBucketName, String pDescription, int pCityID)
   {
      BucketDao bucket = new JdbcBucket();
      return bucket.createBucket(new Bucket(0, pUserID, pBucketName, null, pDescription, pCityID));
   }
}
