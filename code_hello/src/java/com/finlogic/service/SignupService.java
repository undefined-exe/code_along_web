/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.service;

import com.finlogic.repository.SignupRepository;
import java.sql.SQLException;

/**
 *
 * @author ASHISH
 */
public class SignupService {
    public int verifySignup(String user, String email, String pass)throws SQLException{
        SignupRepository signupRepository = new SignupRepository();
        return signupRepository.getSignup(user, email, pass);
    }
}
