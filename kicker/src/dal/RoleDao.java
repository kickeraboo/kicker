package dal;

import java.util.List;

import bll.Role;

public interface RoleDao {
	public Role createRole(Role newRole);
	public Role getRoleById(int roleId);
	public Role getRoleByName(String roleName);
	public boolean updateRole(Role newRole);
	public boolean deleteRole(Role dRole);
	public boolean deleteRole(int roleId);
	public List<Role> getAll();
}
