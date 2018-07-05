/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MORAD HOSSAIN
 */
@ManagedBean
public class Registration {

    private String username;
    private String firstname;
    private String lastname;

    private String password;
    private String gender;
    private String dob;
    private String nationality;
    private String email;
    private String mobileno;
    private String address;
    private String message;

    public Registration() {
    }

    public Registration(String username, String firstname, String lastname, String password, String gender, String dob, String nationality, String email, String mobileno, String address, String message) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.email = email;
        this.mobileno = mobileno;
        this.address = address;
        this.message = message;
    }

    

     public void doInsert() throws Exception {
        MyConnection connection = new MyConnection();
        Connection conn = connection.doConnect();
        PreparedStatement pstmt = conn.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?,?)");
        pstmt.setString(2, firstname);
        pstmt.setString(3, lastname);
        pstmt.setString(1, username);
        pstmt.setString(4, password);
        pstmt.setString(5, gender);
        pstmt.setString(6, dob);
        pstmt.setString(7, nationality);
        pstmt.setString(8, email);
        pstmt.setInt(9, Integer.parseInt(mobileno));
        pstmt.setString(10, address);
        int i = pstmt.executeUpdate();
        
    }

    public String loginAction() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.login(username, password);
        if (result) {
            return "originalPage";
        } else {
            setMessage("Login Fail");
            setUsername("");
            setPassword("");
            return "studentLogin";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
