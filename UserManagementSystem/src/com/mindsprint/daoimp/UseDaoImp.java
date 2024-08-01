package com.mindsprint.daoimp;

import com.mindsprint.dao.UserDao;
import com.mindsprint.model.User;
import com.mindsprint.util.DBConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseDaoImp implements UserDao {

    @Override
    public int addUser(User user) throws SQLException {
        Connection conn= DBConfig.getConnection();
        PreparedStatement pst=conn.prepareStatement("insert into user (name,email,country) values(?,?,?)");
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3,user.getCountry());
        conn.close();
        return pst.executeUpdate();
    }

    @Override
    public List<User> getAllUser() throws SQLException{
        Connection conn= DBConfig.getConnection();
            Statement st= conn.createStatement();
            ResultSet result=st.executeQuery("select * from user");
            ArrayList arr=new ArrayList();
            while (result.next())
            {
                arr.add(new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4)));

            }
        return arr;
    }

    @Override
    public int updateUser(User user, int id) throws SQLException{
        Connection conn= DBConfig.getConnection();
        Scanner sc=new Scanner(System.in);

            String sql="update user set name=?,email=?,password=? where id=?";
            PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3,user.getCountry());
//            System.out.println("enter name to update");
//            String name=sc.next();
//            System.out.println("enter email to update");
//            String email=sc.next();
//            System.out.println("enter password to update");
//            String password=sc.next();
//            statement.setString(1,name);
//            statement.setString(2,email);
//            statement.setString(3,password);
            int cnt=pst.executeUpdate();
            System.out.println(cnt+" record inserted");
            return cnt;


    }

    @Override
    public int deleteUser(int id) throws SQLException {
        Connection conn=DBConfig.getConnection();
        try{
            PreparedStatement st = conn.prepareStatement("Delete from user where id = ?");
            st.setString(1, String.valueOf(id));
            int count = st.executeUpdate();
            conn.close();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User searchUser(String name) {
        Connection conn = DBConfig.getConnection();
        try{
            String sql = "Select * from user where name = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet result = pst.executeQuery();
            User user = new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4));
            conn.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
