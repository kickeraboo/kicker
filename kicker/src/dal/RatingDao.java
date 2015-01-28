package dal;

import java.util.List;

import bll.Rating;;

public interface RatingDao {
   public Rating createRating(Rating newRating);
   public Rating getRatingById(int ratingId);
   public boolean updateRating(Rating newRating);
   public boolean deleteRating(Rating dRating);
   public boolean deleteRating(int ratingId);
   public List<Rating> getAll();
}