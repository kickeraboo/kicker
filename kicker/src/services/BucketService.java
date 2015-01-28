package services;

import bll.Bucket;

public class BucketService
{
   public static String getBucketsByUserId(int userId)
   {     
      try
      {       
         return JsonWrapper.toJson((Bucket.getBucketsByUserId(userId)));
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "";
   }
}
