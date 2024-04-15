package com.project.hotel_management_app.service;

import com.project.hotel_management_app.exception.UsernameNotFoundException;
import com.project.hotel_management_app.model.Role;
import com.project.hotel_management_app.model.User;

import java.util.List;

public interface IRoleService {
    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId) throws UsernameNotFoundException;
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);
}
