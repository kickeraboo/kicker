package dal;

import java.util.List;

import bll.State;

public interface StateDao
{
   public State getStateById(int StateId);
   public List<State> getAll();
}
