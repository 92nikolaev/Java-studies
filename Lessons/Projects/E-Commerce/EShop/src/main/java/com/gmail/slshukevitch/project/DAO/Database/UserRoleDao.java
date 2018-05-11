package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.UserRole;

import java.util.List;

public interface UserRoleDao {

    UserRole readUserRole(int id);
    UserRole createUserRole(UserRole userRole);
    List<UserRole> readAllUserRole();
}
