/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASHISH
 */

public class SignupRepository {
    String username="root";
    String password="opformysql@123";
    String url="jdbc:mysql://localhost:3306/std";
    public int getSignup(String user, String email, String pass) throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("insert into stud (username,email,password) values (?,?,?)");
        pstmt.setString(1, user);
        pstmt.setString(2, email);
        pstmt.setString(3, pass);
//        pstmt.setString(4, cnfpass);
        int status = pstmt.executeUpdate();
        return status;
    }
}
