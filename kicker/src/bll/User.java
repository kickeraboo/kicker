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
    * Default User Constructor. Not userID allowed.
    */
   public User(int pUserID, String pEmail, String pFacebookID, String pUsername,
         int pRoleID, boolean pStatus)
   {
      this.mUserID = pUserID;
      this.mEmail = pEmail;
      this.mFacebookID = pFacebookID;
      this.mUsername = pUsername;
      this.mRoleID = pRoleID;
      this.mStatus = pStatus;
   }
   
   /**
    * Default constructor.
    */
   public User()
   {
   }
   
   /**
    * getAll Retrieves all users from the database.
    * 
    * @return A list of User objects.
    */
   public static List<User> getAll()
   {
      UserDao user = new JdbcUser();
      return user.getAll();
   }
   
   /**
    * Creates a new user in the database.
    * 
    * @param newUser
    *           The user to be inserted.
    * @return A User object that was just created.
    */
   public static User createUser(User newUser)
   {
      UserDao user = new JdbcUser();
      return user.createUser(newUser);
   }
   
   /**
    * Creates a user in the database.
    * 
    * @param Email
    *           The email of the user.
    * @param FacebookID
    *           FacebookID of the user.
    * @param Username
    *           Username of the user.
    * @param RoleID
    *           RoleID of the user.
    * @param Status
    *           Indicates if the user is enabled or disabled in the system.
    * @return A user object that was just created.
    */
   public static User createUser(String Email, String FacebookID,
         String Username, int RoleID, boolean Status)
   {
      UserDao user = new JdbcUser();
      return user.createUser(new User(0, Email, FacebookID, Username, RoleID,
            Status));
   }
   
   /**
    * deleteUser Deletes a user from the database.
    * 
    * @param userId
    *           The id of the user to be removed.
    * @return True/false if the user was deleted or not.
    */
   public static boolean deleteUser(int userId)
   {
      UserDao user = new JdbcUser();
      return user.deleteUser(userId);
   }
   
   /**
    * deleteUser Deletes a user from the database.
    * 
    * @param User
    *           An user instance that will be deleted from the database.
    * @return True/false if the user was deleted or not.
    */
   public static boolean deleteUser(User usr)
   {
      return deleteUser(usr.getUserID());
   }
   
   /**
    * updateUser Updates an user in the database with new data.
    * 
    * @param usr
    *           The user instance to be updated.
    * @return True/false if the user was updated or not.
    */
   public static boolean updateUser(User usr)
   {
      UserDao user = new JdbcUser();
      return user.updateUser(usr);
   }
   
   /**
    * getUserById Obtains a user from the database given a userId.
    * 
    * @param userId
    *           The id of the user to be retrieved.
    * @return A user object obtained from the id.
    */
   public static User getUserById(int userId)
   {
      UserDao user = new JdbcUser();
      return user.getUserById(userId);
      
   }
}
