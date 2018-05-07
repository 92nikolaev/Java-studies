package by.it.academy.database;

import by.it.academy.model.UserRole;

import java.util.List;

public interface UserRoleDao {

    UserRole readUserRole(int id);
    UserRole createUserRole(UserRole userRole);
    List<UserRole> readAllUserRole();
}
