package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.Item;

public class JdbcItem implements ItemDao {
	/**
	 * createItem Creates a new item in the database.
	 * 
	 * @param newItem
	 *            The item instance to be inserted.
	 * @return Returns the item inserted from the database, or null if error.
	 */
	@Override
	public Item createItem(Item newItem) {
		// format the string
		String query = "INSERT INTO Items (ItemName)";
		query += " VALUES ('%1$s')";

		query = String.format(query, newItem.getItemName());

		// if everything worked, inserted id will have the identity key
		// or primary key
		int insertedId = DataService.executeCreate(query);
		if (insertedId > 0) {
			return getItemById(insertedId);
		}

		return null;
	}

	/**
	 * getItemById Obtains an item from the database, given an id.
	 * 
	 * @param itemId
	 *            The unique identifier of the item to retrieve.
	 * @return Returns the item with this id in the database.
	 */
	@Override
	public Item getItemById(int itemId) {
		String query = "SELECT * FROM Items WHERE ItemID = " + itemId;
		ResultSet rs = DataService.getData(query);

		try {
			if (rs.next()) {
				return convertResultSetToItem(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * updateItem Updates a item in the database.
	 * 
	 * @param newItem
	 *            The item instance to be updated.
	 * @return Returns true or false if the item was updated or not.
	 */
	@Override
	public boolean updateItem(Item newItem) {
		// format the string
		String query = "UPDATE Items SET ItemName = '%1$s' WHERE ItemID = %2$d";

		query = String.format(query, newItem.getItemName());

		// if everything worked, inserted id will have the identity key
		// or primary key
		return DataService.executeUpdate(query);
	}

	/**
	 * deleteItem Deletes a item from the database.
	 * 
	 * @param oldItem
	 *            The item instance to be deleted.
	 * @return Returns true if the item was deleted and false if the item was
	 *         not deleted.
	 */
	@Override
	public boolean deleteItem(Item oldItem) {
		return deleteItem(oldItem.getItemID());
	}

	/**
	 * deleteItem Deletes a item from the database.
	 * 
	 * @param itemId
	 *            The id of the item to be deleted in the database.
	 * @return Returns true if the item was deleted and false if the item was
	 *         not deleted.
	 */
	@Override
	public boolean deleteItem(int itemId) {
		String query = "DELETE FROM Items WHERE ItemID = " + itemId;
		return DataService.executeDelete(query);
	}

	/**
	 * getAll Obtains all of the Items from the database.
	 * 
	 * @return A Generic list of items from the database.
	 */
	@Override
	public List<Item> getAll() {

		ResultSet rs = DataService.getData("SELECT * FROM Items");

		List<Item> items = new ArrayList<Item>();

		try {
			while (rs.next()) {
				items.add(convertResultSetToItem(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;
	}

	/**
	 * convertResultSetToItem for lack of implicit/explicit operators, we
	 * manually convert a row in the result set, into an item.
	 * 
	 * @param rs
	 *            The result set to convert into a Item object.
	 * @return A item object.
	 */
	public Item convertResultSetToItem(ResultSet rs) {
		if (rs != null) {
			try {
				int pItemID = rs.getInt("ItemID");
				String pItemName = rs.getString("ItemName");

				return new Item(pItemID, pItemName);
			} catch (Exception e) {
				// TODO: Handle
			}
		}

		return null;
	}
}