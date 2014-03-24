package dal;

import java.util.List;

import bll.Item;

public interface ItemDao {
   public Item createItem(User newitem);
   public Item getUserById(int itemId);
   public boolean updateItem(User newitem);
   public boolean deleteItem(User dItem);
   public boolean deleteItem(int itemId);
   public List<Item> getAll();
} 