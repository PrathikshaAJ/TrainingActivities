package com.mindsprint.main;

import com.mindsprint.dao.UserDao;
import com.mindsprint.daoimp.UseDaoImp;
import com.mindsprint.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws SQLException {
      UserDao dao=new UseDaoImp();
       //System.out.println(dao.updateUser());
//       try
//       {
//           dao.addUser(new User("lex","lex@gmail.com","US"));
//       }
//       catch (SQLException e)
//       {
//           e.printStackTrace();
//       }


    }
}
