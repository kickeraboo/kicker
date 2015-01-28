package services;

import bll.City;

public class CityService
{
   public static String getCitiesByStateId(int stateId)
   {     
      try
      {       
         return JsonWrapper.toJson(City.getCitiesByStateId(stateId));
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "";
   }
   
   public static String getCitiesByStateIdAndPartialName(int stateId, String partialName)
   {     
      try
      {       
         return JsonWrapper.toJson(City.getCitiesByStateIdAndPartialName(stateId, partialName));
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "";
   }
}
