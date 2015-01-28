package bll;

import java.util.List;

import dal.CityDao;
import dal.JdbcCity;

public class City
{
   private int mCityID;
   private String mName;
   private String mZipCode;
   private String mTimeZone;
   private int mStateID;
   
   public City(int pCityID, String pName, String pZipCode, String pTimeZone, int pStateID)
   {
      this.mCityID = pCityID;
      this.mName = pName;
      this.mZipCode = pZipCode;
      this.mTimeZone = pTimeZone;
      this.mStateID = pStateID;
   }
   
   /**
    * @return the mCityID
    */
   public int getCityID()
   {
      return mCityID;
   }
   /**
    * @param mCityID the mCityID to set
    */
   public void setCityID(int mCityID)
   {
      this.mCityID = mCityID;
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
    * @return the mZipCode
    */
   public String getZipCode()
   {
      return mZipCode;
   }
   /**
    * @param mZipCode the mZipCode to set
    */
   public void setZipCode(String mZipCode)
   {
      this.mZipCode = mZipCode;
   }
   /**
    * @return the mTimeZone
    */
   public String getTimeZone()
   {
      return mTimeZone;
   }
   /**
    * @param mTimeZone the mTimeZone to set
    */
   public void setTimeZone(String mTimeZone)
   {
      this.mTimeZone = mTimeZone;
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
   
   public static List<City> getAll()
   {
      CityDao city = new JdbcCity();
      return city.getAll();
   }
   
   public static List<City> getCitiesByStateId(int stateId)
   {
      CityDao city = new JdbcCity();
      return city.getCitiesByStateId(stateId);
   }
   
   public static List<City> getCitiesByStateIdAndPartialName(int stateId, String partialName)
   {
      CityDao city = new JdbcCity();
      return city.getCitiesByStateIdAndPartialName(stateId, partialName);
   }
   
   public static City getByCityId(int cityId)
   {
      CityDao city = new JdbcCity();
      return city.getCityById(cityId);
   }
   
   
}
