/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MORAD HOSSAIN
 */
public class RegistrationDAO {

   

    public boolean login(String username, String password) throws SQLException {
        MyConnection connection = new MyConnection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = connection.doConnect();
        pstmt = conn.prepareStatement("select username,password from registration where username=? and password=?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }

   
}
