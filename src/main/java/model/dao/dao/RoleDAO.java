package model.dao.dao;

import model.entity.Role;

import java.util.List;

public interface RoleDAO {
    Role createRole(Role role);
    void deleteRole(int id);
    List<Role> getAllRoles();
    Role getRoleById(int id);
    void updateRole(int id, String name);
}
