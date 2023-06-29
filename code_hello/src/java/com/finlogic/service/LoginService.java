/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.service;

import com.finlogic.repository.LoginRepository;
import java.sql.SQLException;

/**
 *
 * @author ASHISH
 */
public class LoginService {
 
    public int verifyLoginInfo(String user, String pass) throws SQLException{
        LoginRepository loginRepository = new LoginRepository();
        return loginRepository.checkLoginInfo(user, pass);
    }
}
