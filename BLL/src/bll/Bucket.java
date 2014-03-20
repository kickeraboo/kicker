/**
 * 
 */
package bll;

import java.util.Date;

/**
 * @author Hamlet
 * 
 */
public class Bucket {

	private int mBucketID;
	private int mUserID;
	private String mBucketName;
	private Date mCreationDate;

	/**
	 * @return the mBucketID
	 */
	public int getBucketID() {
		return mBucketID;
	}

	/**
	 * @param mBucketID
	 *            the mBucketID to set
	 */
	public void setBucketID(int pBucketID) {
		this.mBucketID = pBucketID;
	}

	/**
	 * @return the mUserID
	 */
	public int getUserID() {
		return mUserID;
	}

	/**
	 * @param mUserID
	 *            the mUserID to set
	 */
	public void setUserID(int pUserID) {
		this.mUserID = pUserID;
	}

	/**
	 * @return the mBucketName
	 */
	public String getBucketName() {
		return mBucketName;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return mCreationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date pCreationDate) {
		mCreationDate = pCreationDate;
	}

	/**
	 * @param mBucketName
	 *            the mBucketName to set
	 */
	public void setBucketName(String pBucketName) {
		this.mBucketName = pBucketName;
	}

	/**
	 * 
	 */
	public Bucket(int pBucketID, int pUserID, String pBucketName,
			Date pCreationDate) {
		this.mBucketID = pBucketID;
		this.mUserID = pBucketID;
		this.mBucketName = pBucketName;
		this.mCreationDate = pCreationDate;
	}
}
