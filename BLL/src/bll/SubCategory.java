/**
 * 
 */
package bll;

/**
 * @author Hamlet
 * 
 */
public class SubCategory {

	private int mSubCategoryID;
	private String mSubCategoryName;
	private int mCategoryID;

	/**
	 * @return the mSubCategoryID
	 */
	public int getSubCategoryID() {
		return mSubCategoryID;
	}

	/**
	 * @param mSubCategoryID
	 *            the mSubCategoryID to set
	 */
	public void setSubCategoryID(int pSubCategoryID) {
		this.mSubCategoryID = pSubCategoryID;
	}

	/**
	 * @return the mSubCategoryName
	 */
	public String getSubCategoryName() {
		return mSubCategoryName;
	}

	/**
	 * @param mSubCategoryName
	 *            the mSubCategoryName to set
	 */
	public void setSubCategoryName(String pSubCategoryName) {
		this.mSubCategoryName = pSubCategoryName;
	}

	/**
	 * @return the mCategoryID
	 */
	public int getCategoryID() {
		return mCategoryID;
	}

	/**
	 * @param mCategoryID
	 *            the mCategoryID to set
	 */
	public void setCategoryID(int pCategoryID) {
		this.mCategoryID = pCategoryID;
	}

	public SubCategory(int pSubCategoryID, String pSubCategoryName,
			int pCategoryID) {
		this.mSubCategoryID = pSubCategoryID;
		this.mSubCategoryName = pSubCategoryName;
		this.mCategoryID = pCategoryID;
	}
}
