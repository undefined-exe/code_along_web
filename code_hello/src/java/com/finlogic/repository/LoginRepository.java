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
public class LoginRepository {
    
    String username="root";
    String password="opformysql@123";
    String url="jdbc:mysql://localhost:3306/std";
    public int checkLoginInfo(String user, String pass) throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("select count(username) from stud where username=? and password=?");
        pstmt.setString(1, user);
        pstmt.setString(2, pass);
        ResultSet rs = pstmt.executeQuery();
        int status = 0;
        if (rs.next()) {
            status=rs.getInt(1);
        }
        return status;
    }
    
}
