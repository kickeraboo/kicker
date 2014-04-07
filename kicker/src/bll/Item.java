/**
 * 
 */
package bll;

import java.util.List;

import dal.ItemDao;
import dal.JdbcItem;

/**
 * @author Hanlet
 * 
 */
public class Item
{

   private int mItemID;
   private String mItemName;
   private String mDescription;

   /**
    * @return the mItemID
    */
   public int getItemID()
   {
      return mItemID;
   }

   /**
    * @param mItemID
    *           the mItemID to set
    */
   public void setItemID(int pItemID)
   {
      this.mItemID = pItemID;
   }

   /**
    * @return the mItemName
    */
   public String getItemName()
   {
      return mItemName;
   }

   /**
    * @param mItemName
    *           the mItemName to set
    */
   public void setItemName(String pItemName)
   {
      this.mItemName = pItemName;
   }

   /**
    * @return the mDescription
    */
   public String getDescription()
   {
      return mDescription;
   }

   /**
    * @param mDescription the mDescription to set
    */
   public void setDescription(String mDescription)
   {
      this.mDescription = mDescription;
   }

   /**
	 * 
	 */
   public Item(int pItemID, String pItemName, String pItemDescription)
   {
      this.mItemID = pItemID;
      this.mItemName = pItemName;
      this.mDescription = pItemDescription;
   
   }
   
   public static Item create(Item pItem)
   {
	   ItemDao itemDao = new JdbcItem();
	   
	   return itemDao.createItem(pItem);
   }
   
   public static List<Item> getItemsByBucketId(int bucketId)
   {
	   ItemDao itemDao = new JdbcItem();
	   
	   return itemDao.getItemsByBucketId(bucketId);
   }

}
