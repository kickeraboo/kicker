/**
 * This class represents a user.
 */
package bll;

import java.util.List;

import dal.JdbcUser;
import dal.UserDao;

/**
 * @author Hamlet
 * 
 */
public class User
{
   
   private int mUserID;
   private String mEmail;
   private String mFacebookID;
   private String mUsername;
   private int mRoleID;
   private boolean mStatus;
   
   /**
    * @return the mEmail
    */
   public String getEmail()
   {
      return mEmail;
   }
   
   /**
    * @param mEmail
    *           the mEmail to set
    */
   public void setEmail(String pEmail)
   {
      this.mEmail = pEmail;
   }
   
   /**
    * @return the mUserID
    */
   public int getUserID()
   {
      return mUserID;
   }
   
   /**
    * @param mUserID
    *           the pUserID to set
    */
   public void setUserID(int pUserID)
   {
      this.mUserID = pUserID;
   }
   
   /**
    * @return the mFacebookID
    */
   public String getFacebookID()
   {
      return mFacebookID;
   }
   
   /**
    * @param mFacebookID
    *           the mFacebookID to set
    */
   public void setFacebookID(String pFacebookID)
   {
      this.mFacebookID = pFacebookID;
   }
   
   /**
    * @return the mUsername
    */
   public String getUsername()
   {
      return mUsername;
   }
   
   /**
    * @param mUsername
    *           the mUsername to set
    */
   public void setUsername(String pUsername)
   {
      this.mUsername = pUsername;
   }
   
   /**
    * @return the mRoleID
    */
   public int getRoleID()
   {
      return mRoleID;
   }
   
   /**
    * @param mRoleID
    *           the mRoleID to set
    */
   public void setRoleID(int pRoleID)
   {
      this.mRoleID = pRoleID;
   }
   
   /**
    * @return the mStatus
    */
   public boolean getStatus()
   {
      return mStatus;
   }
   
   /**
    * @param mStatus
    *           the mStatus to set
    */
   public void setStatus(boolean pStatus)
   {
      this.mStatus = pStatus;
   }
   
   /**
    * Default User Constructor.
    */
   public User(int pUserID, String pEmail, String pFacebookID,
         String pUsername, int pRoleID, boolean pStatus)
   {
      this.mUserID = pUserID;
      this.mEmail = pEmail;
      this.mFacebookID = pFacebookID;
      this.mUsername = pUsername;
      this.mRoleID = pRoleID;
      this.mStatus = pStatus;
   }
   
   public User()
   {
      // TODO Auto-generated constructor stub
   }
   
   public static List<User> getAll()
   {
      UserDao user = new JdbcUser();
      return user.getAll();
   }
   
   public static User createUser(User newUser)
   {
      UserDao user = new JdbcUser();
      return user.createUser(newUser);
   }
   
   public static User createUser(String Email, String FacebookID, String Username, int RoleID, boolean Status)
   {
      UserDao user = new JdbcUser();
      return user.createUser(new User(0, Email, FacebookID, Username, RoleID, Status));
   }
   
   public static boolean deleteUser(int userId)
   {
      UserDao user = new JdbcUser();
      return user.deleteUser(userId);
   }
   
   public static boolean deleteUser(User usr)
   {
      return deleteUser(usr.getUserID());
   }
   
   public static boolean updateUser(User usr)
   {
      UserDao user = new JdbcUser();
      return user.updateUser(usr);
   }
   
  public static User getUserById(int userId)
  {
     UserDao user = new JdbcUser();
     return user.getUserById(userId);
     
  }
}
