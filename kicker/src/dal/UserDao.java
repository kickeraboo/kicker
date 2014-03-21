package dal;

import java.util.List;

import bll.User;

public interface UserDao {
	public User createUser(User newUser);
	public User getUserById(int userId);
	public boolean updateUser(User newUser);
	public boolean deleteUser(User dUser);
	public boolean deleteUser(int userId);
	public List<User> getAll();
}
