package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.State;

public class JdbcState implements StateDao
{
   @Override
   public State getStateById(int StateId)
   {
      String query = "SELECT * FROM States WHERE StateID = " + StateId;
      ResultSet rs = DataService.getData(query);

      try
      {
         if (rs.next())
         {
            return convertResultSetToState(rs);
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
   public List<State> getAll()
   {
      ResultSet rs = DataService.getData("SELECT * FROM States");

      List<State> states = new ArrayList<State>();

      try
      {
         while (rs.next())
         {
            states.add(convertResultSetToState(rs));
         }
      }
      catch (SQLException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return states;
   }

   public State convertResultSetToState(ResultSet rs)
   {
      if (rs != null)
      {
         try
         {
            int pStateId = rs.getInt("StateID");
            String pName = rs.getString("Name");
            String pAbbreviation = rs.getString("Abbreviation");

            return new State(pStateId, pName, pAbbreviation);
         }
         catch (Exception e)
         {
            // TODO: Handle
         }
      }
      return null;
   }
}