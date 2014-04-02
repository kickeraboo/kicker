package services;

import bll.State;

public class StateService
{
   public static String getAllStates()
   {     
      try
      {       
         return JsonWrapper.toJson((State.getAll()));
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return "";
   }
}
