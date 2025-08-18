package com.example.luyenjdbctransaction.dao;

import com.example.luyenjdbctransaction.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, List<Integer> permission);

    public void insertUpdateWithoutTransaction();

    List<User> getAllUsersBySP();
    void updateUserBySP(User user) throws SQLException;
    void deleteUserBySP(int id) throws SQLException;

}