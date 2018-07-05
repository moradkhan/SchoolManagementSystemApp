/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MORAD HOSSAIN
 */
@ManagedBean
public class Fess {

    private int rollno;
    private String clas;
    private String name;
    private String date;
    private double monthfees;
    private double amount;
    private double backamount;
    private double pendingamount;
    private String recieveDate;
    private List stList = new ArrayList();
    MyConnection connection = new MyConnection();

    public Fess() {
        doShow();
    }

    public Fess(int rollno, String clas, String name, String date, double monthfees, double amount, double backamount, double pendingamount, String recieveDate) {
        this.rollno = rollno;
        this.clas = clas;
        this.name = name;
        this.date = date;
        this.monthfees = monthfees;
        this.amount = amount;
        this.backamount = backamount;
        this.pendingamount = pendingamount;
        this.recieveDate = recieveDate;
    }

   

    public String getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(String recieveDate) {
        this.recieveDate = recieveDate;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void feesInsert() throws Exception {

        Connection conn = connection.doConnect();
        PreparedStatement pstmt = conn.prepareStatement("insert into fees values(?,?,?,?)");
        pstmt.setInt(1, rollno);
        pstmt.setString(2, date);
        pstmt.setDouble(3, amount);
        pstmt.setString(4, recieveDate);
        int i = pstmt.executeUpdate();

    }

    public void doShow() {
        try {

            Connection conn = connection.doConnect();

            String ss = "select * from fees";

            PreparedStatement psment = conn.prepareStatement(ss);

            ResultSet rs = psment.executeQuery();

            while (rs.next()) {
                Fess s = new Fess(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9));
                stList.add(s);
            }
        } catch (Exception e) {
        }
    }

    public List<Integer> getIdLoad() {
        List<Integer> idList = new ArrayList<Integer>();
        try {
            Connection conn = connection.doConnect();

            String ss = "select * from fees";

            PreparedStatement psment = conn.prepareStatement(ss);

            ResultSet rs = psment.executeQuery();

            while (rs.next()) {
                Fess s = new Fess(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9));
                idList.add(s.getRollno());
            }
        } catch (Exception e) {
        }
        return idList;
    }

    public void ajaxList() {
        try {
            Connection conn = connection.doConnect();

            String ss = "select * from fees where id = ?";

            PreparedStatement psment = conn.prepareStatement(ss);

            psment.setInt(1, rollno);

            ResultSet rs = psment.executeQuery();

            while (rs.next()) {
                setRollno(rs.getInt(1));
                setDate(rs.getString(2));
                setAmount(rs.getDouble(3));
                setRecieveDate(rs.getString(4));
            }
        } catch (Exception e) {
        }
    }

    public List getStList() {
        return stList;
    }

    public void setStList(List stList) {
        this.stList = stList;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthfees() {
        return monthfees;
    }

    public void setMonthfees(double monthfees) {
        this.monthfees = monthfees;
    }

    public double getBackamount() {
        return backamount;
    }

    public void setBackamount(double backamount) {
        this.backamount = backamount;
    }

    public double getPendingamount() {
        return pendingamount;
    }

    public void setPendingamount(double pendingamount) {
        this.pendingamount = pendingamount;
    }

}
