package dal;

import java.util.List;

import bll.City;

public interface CityDao
{
   public City getCityById(int cityId);
   public List<City> getAll();
   public List<City> getCitiesByStateId(int stateId);
   public List<City> getCitiesByStateIdAndPartialName(int stateId, String partialName);
}
