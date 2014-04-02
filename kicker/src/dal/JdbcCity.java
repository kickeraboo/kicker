package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.City;


public class JdbcCity implements CityDao
{

   @Override
   public City getCityById(int cityId)
   {
      String query = "SELECT * FROM Cities WHERE CityID = " + cityId;
      ResultSet rs = DataService.getData(query);

      try
      {
         if (rs.next())
         {
            return convertResultSetToCity(rs);
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return null;
   }

   @Override
   public List<City> getAll()
   {
      ResultSet rs = DataService.getData("SELECT * FROM Cities");

      List<City> cities = new ArrayList<City>();

      try
      {
         while (rs.next())
         {
            cities.add(convertResultSetToCity(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return cities;
   }

   @Override
   public List<City> getCitiesByStateId(int stateId)
   {
      ResultSet rs = DataService.getData("SELECT * FROM Cities WHERE StateID=" + stateId);

      List<City> cities = new ArrayList<City>();

      try
      {
         while (rs.next())
         {
            cities.add(convertResultSetToCity(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return cities;
   }

   @Override
   public List<City> getCitiesByStateIdAndPartialName(int stateId, String partialName)
   {
      ResultSet rs = DataService.getData("SELECT * FROM Cities WHERE StateID=" + stateId + " AND LOWER(Name) LIKE '%" + partialName.toLowerCase() + "%'");

      List<City> cities = new ArrayList<City>();

      try
      {
         while (rs.next())
         {
            cities.add(convertResultSetToCity(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return cities;
   }
   
   public City convertResultSetToCity(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pCityID = rs.getInt("CityID");
            String pName = rs.getString("Name");
            String pZipCode = rs.getString("ZipCode");
            String pTimeZone = rs.getString("TimeZone");
            int pStateID = rs.getInt("StateID");

            return new City(pCityID, pName, pZipCode, pTimeZone, pStateID);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      return null;
   }

}
