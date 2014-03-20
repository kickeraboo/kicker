/**
 * 
 */
package bll;

/**
 * @author Hanlet
 * 
 */
public class Role {

	private int mRoleID;
	private String mRoleName;
	private boolean mStatus;

	/**
	 * @return the mRoleID
	 */
	public int getRoleID() {
		return mRoleID;
	}

	/**
	 * @param mRoleID
	 *            the mRoleID to set
	 */
	public void setRoleID(int pRoleID) {
		this.mRoleID = pRoleID;
	}

	/**
	 * @return the mRoleName
	 */
	public String getRoleName() {
		return mRoleName;
	}

	/**
	 * @param mRoleName
	 *            the mRoleName to set
	 */
	public void setRoleName(String pRoleName) {
		this.mRoleName = pRoleName;
	}

	/**
	 * @return the mStatus
	 */
	public boolean getStatus() {
		return mStatus;
	}

	/**
	 * @param mStatus
	 *            the mStatus to set
	 */
	public void setStatus(boolean pStatus) {
		this.mStatus = pStatus;
	}

	/**
	 * 
	 */
	public Role(int pRoleID, String pRoleName, boolean pStatus) {
		this.mRoleID = pRoleID;
		this.mRoleName = pRoleName;
		this.mStatus = pStatus;
	}

}
