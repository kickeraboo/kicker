package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bll.User;

public class JdbcUser implements UserDao {

	@Override
	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User dUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {

		ResultSet rs = DataService.getData("SELECT * FROM Users");

		List<User> users = new ArrayList<User>();

		try {
			while (rs.next()) {
				int pUserID = rs.getInt("UserID");
				String pEmail = rs.getString("Email");
				String pFacebookID = rs.getString("FacebookID");
				String pUsername = rs.getString("Username");
				int pRoleID = rs.getInt("RoleID");
				boolean pStatus = rs.getBoolean("Status");

				users.add(new User(pUserID, pEmail, pFacebookID, pUsername,
						pRoleID, pStatus));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

}
