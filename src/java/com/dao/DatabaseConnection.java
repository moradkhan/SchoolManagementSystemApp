package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private Connection conn;

    private PreparedStatement pstmt;
    private ResultSet rs;

    private String databaseName = "jdbc:mysql://localhost:3306/school";
    private String userName = "root";
    private String password = "32079";

    public Connection databaseConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseName, userName, password);
        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }

        return conn;
    }

    public PreparedStatement databaseStatement(String statement) {
        try {
            conn = databaseConnection();
            pstmt = conn.prepareStatement(statement);
        } catch (Exception ex) {

        }

        return pstmt;
    }

    // Dynamicly data insert.
    public boolean databaseUpdate(String statement, List<String> stg) {
        try {
            int count = 1;
            conn = databaseConnection();
            pstmt = conn.prepareStatement(statement);

            for (Object o : stg) {

                pstmt.setObject(count++, o);
            }

            int n = pstmt.executeUpdate();
            
            databaseCloseUpdate();

        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public ResultSet databaseResultset(String statement) {

        try {
            pstmt = databaseStatement(statement);
            rs = pstmt.executeQuery();
        } catch (Exception ex) {

        }

        return rs;
    }

   

    //Data qurey data
    public Vector databseQuery(String statement) {

        rs = databaseResultset(statement);
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        try {

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(md.getColumnLabel(i)));
                   
                }
                data.add(vector);
               

            }

            databaseCloseQuery();
        } catch (Exception e) {

        }
        return data;
    }

    public Vector<String> databaseColoumnName(String statement) {

        Vector<String> columnNames = new Vector<String>();
        try {
            rs = databaseResultset(statement);

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            if (rs.next()) {
                for (int j = 1; j <= columnCount; j++) {
                    columnNames.add(md.getColumnLabel(j));
                }
            }

            databaseCloseQuery();
        } catch (Exception e) {

        }
        return columnNames;
    }

     public void databaseCloseUpdate() {
        try {
            rs.close();
            pstmt.close();
        } catch (Exception ex) {

        }

    }
    public void databaseCloseQuery() {
        try {
            rs.close();
            pstmt.close();
            rs.close();
        } catch (Exception ex) {

        }

    }
}
