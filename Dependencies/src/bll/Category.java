/**
 * 
 */
package bll;

import java.util.Date;

/**
 * @author Hamlet
 * 
 */
public class Category {

	private int mCategoryID;
	private String mCategoryName;
	private String mDescription;
	private Date mCreationDate;

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

	/**
	 * @return the mCategoryName
	 */
	public String getCategoryName() {
		return mCategoryName;
	}

	/**
	 * @param mCategoryName
	 *            the mCategoryName to set
	 */
	public void setCategoryName(String pCategoryName) {
		this.mCategoryName = pCategoryName;
	}

	/**
	 * @return the mDescription
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * @param mDescription
	 *            the mDescription to set
	 */
	public void setDescription(String pDescription) {
		this.mDescription = pDescription;
	}

	/**
	 * @return the mCreationDate
	 */
	public Date getCreationDate() {
		return mCreationDate;
	}

	/**
	 * @param mCreationDate
	 *            the mCreationDate to set
	 */
	public void setCreationDate(Date pCreationDate) {
		this.mCreationDate = pCreationDate;
	}

	/**
	 * 
	 */
	public Category(int pCategoryID, String pCategoryName, String pDescription,
			Date pCreationDate) {
		this.mCategoryID = pCategoryID;
		this.mCategoryName = pCategoryName;
		this.mDescription = pDescription;
		this.mCreationDate = pCreationDate;
	}

}
