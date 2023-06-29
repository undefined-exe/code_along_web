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
public class StudentRepository {
    
    String username="root";
    String password="opformysql@123";
    String url="jdbc:mysql://localhost:3306/std";
    
    public ResultSet getAllStudents() throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("select id,name,address,email,city,state from studentexample");
        ResultSet rs = pstmt.executeQuery();
        
        return rs;
    }
    public int insertStudent(String name, String address, String email, String state, String city)throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("insert into studentexample (name,address,email,state,city) values (?,?,?,?,?)");
        pstmt.setString(1, name);
        pstmt.setString(2, address);
        pstmt.setString(3, email);
        pstmt.setString(4, state);
        pstmt.setString(5, city);
//        pstmt.setString(4, cnfpass);
        int status = pstmt.executeUpdate();
        return status; 
    }
    public ResultSet getStudentDetails(int id) throws SQLException{
        
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("select id,name,address,email,state,city from studentexample where id=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    public int editStudents(int id, String name, String address, String email, String state, String city) throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("update studentexample set name=?,address=?,email=?,state=?,city=? where id=?");
        pstmt.setString(1, name);
        pstmt.setString(2, address);
        pstmt.setString(3, email);
        pstmt.setString(4, state);
        pstmt.setString(5, city);
        pstmt.setInt(6, id);
//        pstmt.setString(4, cnfpass);
        int status = pstmt.executeUpdate();
        return status;
    }
    public int deleteStudent(int id) throws SQLException{
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pstmt = con.prepareStatement("delete from studentexample where id =?");
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }
}
