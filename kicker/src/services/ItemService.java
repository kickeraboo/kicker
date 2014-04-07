package services;

import bll.Item;

public class ItemService
{
   public static String getItemsByBucketId(int bucketId)
   {     
      try
      {       
         return JsonWrapper.toJson((Item.getItemsByBucketId(bucketId)));
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "";
   }
}