package bll;

import java.util.List;

import dal.JdbcState;
import dal.StateDao;

public class State
{
   private int mStateID;
   private String mName;
   private String mAbbreviation;
   
   public State (int pStateID, String pName, String pAbbreviation)
   {
      this.mStateID = pStateID;
   }
   
   /**
    * @return the mStateID
    */
   public int getStateID()
   {
      return mStateID;
   }
   /**
    * @param mStateID the mStateID to set
    */
   public void setStateID(int mStateID)
   {
      this.mStateID = mStateID;
   }
   /**
    * @return the mName
    */
   public String getName()
   {
      return mName;
   }
   /**
    * @param mName the mName to set
    */
   public void setName(String mName)
   {
      this.mName = mName;
   }
   /**
    * @return the mAbbreviation
    */
   public String getAbbreviation()
   {
      return mAbbreviation;
   }
   /**
    * @param mAbbreviation the mAbbreviation to set
    */
   public void setAbbreviation(String mAbbreviation)
   {
      this.mAbbreviation = mAbbreviation;
   }
   
   public static State getStateById(int StateId)
   {
      StateDao state = new JdbcState();
      return state.getStateById(StateId);
      
   }
   
   public static List<State> getAll()
   {
      StateDao state = new JdbcState();
      return state.getAll();
   }
}
