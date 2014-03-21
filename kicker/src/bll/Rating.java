/**
 * 
 */
package bll;

/**
 * @author Hamlet
 * 
 */
public class Rating {
	private int mRatingID;
	private int mItemID;
	private int mRating;
	private String mComment;

	public int getRatingID() {
		return mRatingID;
	}

	public void setRatingID(int pRatingID) {
		this.mRatingID = pRatingID;
	}

	public int getItemID() {
		return mItemID;
	}

	public void setItemID(int pItemID) {
		this.mItemID = pItemID;
	}

	public int getRating() {
		return mRating;
	}

	public void setRating(int pRating) {
		this.mRating = pRating;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String pComment) {
		this.mComment = pComment;
	}

	public Rating(int pRatingID, int pItemID, int pRating, String pComment) {
		this.mRatingID = pRatingID;
		this.mItemID = pItemID;
		this.mRating = pRating;
		this.mComment = pComment;
	}

}
