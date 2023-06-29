/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.service;

import com.finlogic.repository.StudentRepository;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASHISH
 */
public class StudentService {
    
    StudentRepository studentRepository = new StudentRepository();
    public ResultSet getAllStudents() throws SQLException{
        return studentRepository.getAllStudents();
    }
    
    public int insertStudent(String name, String address, String email, String state, String city) throws SQLException{
        return studentRepository.insertStudent(name, address, email, state, city);
    }
    
    public ResultSet getStudentDetails(int id) throws SQLException{
        return studentRepository.getStudentDetails(id);
    }
    public int EditStudents (int id, String name, String address, String email, String state, String city) throws SQLException{
        return studentRepository.editStudents(id, name, address, email, state, city);
    }
    
    public int deleteStudent(int id) throws SQLException{
        return studentRepository.deleteStudent(id);
    }
}
