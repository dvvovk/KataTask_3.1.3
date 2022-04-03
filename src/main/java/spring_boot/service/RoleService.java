package spring_boot.service;

import spring_boot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);
}
