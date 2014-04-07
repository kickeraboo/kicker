package dal;

import java.util.List;

import bll.Item;


public interface ItemDao {
   public Item createItem(Item newitem);
   public Item getItemById(int itemId);
   public boolean updateItem(Item newitem);
   public boolean deleteItem(Item dItem);
   public boolean deleteItem(int itemId);
   public List<Item> getAll();
   public List<Item> getItemsByBucketId(int bucketId);
}