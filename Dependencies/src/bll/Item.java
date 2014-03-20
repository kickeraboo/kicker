/**
 * 
 */
package bll;

/**
 * @author Hanlet
 * 
 */
public class Item {

	private int mItemID;
	private String mItemName;

	/**
	 * @return the mItemID
	 */
	public int getItemID() {
		return mItemID;
	}

	/**
	 * @param mItemID
	 *            the mItemID to set
	 */
	public void setItemID(int pItemID) {
		this.mItemID = pItemID;
	}

	/**
	 * @return the mItemName
	 */
	public String getItemName() {
		return mItemName;
	}

	/**
	 * @param mItemName
	 *            the mItemName to set
	 */
	public void setItemName(String pItemName) {
		this.mItemName = pItemName;
	}

	/**
	 * 
	 */
	public Item(int pItemID, String pItemName) {
		this.mItemID = pItemID;
		this.mItemName = pItemName;
	}

}
