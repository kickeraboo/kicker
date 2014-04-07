package dal;

import java.util.List;

import bll.Bucket;
import bll.Item;

public interface BucketDao {
   public Bucket createBucket(Bucket newBucket);
   public Bucket getBucketById(int bucketId);
   public boolean updateBucket(Bucket newBucket);
   public boolean deleteBucket(Bucket dBucket);
   public boolean deleteBucket(int bucketId);
   public List<Bucket> getAll();
   public List<Bucket> getBucketsByUserId(int userId);
}