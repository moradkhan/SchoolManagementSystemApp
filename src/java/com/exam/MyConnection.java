/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MORAD HOSSAIN
 */
public class MyConnection {
    Connection conn;
    String url="jdbc:mysql://localhost:3306/schoolmanagement";
    String user="root";
    String pass="32079";
    public Connection doConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return conn;
    }
}
