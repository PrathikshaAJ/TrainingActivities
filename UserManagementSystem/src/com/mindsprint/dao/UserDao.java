package com.mindsprint.dao;
import com.mindsprint.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public int addUser(User user) throws SQLException;
    public List<User> getAllUser() throws SQLException;
    public int updateUser(User user,int id) throws SQLException;
    public int deleteUser(int id) throws SQLException;
    public User searchUser(String name);

}
