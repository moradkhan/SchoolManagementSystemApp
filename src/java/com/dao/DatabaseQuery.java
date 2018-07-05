/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Rasel
 */
public class DatabaseQuery {
 
    
    DatabaseConnection dbc = new DatabaseConnection();
    public  List<Object> databseQuery(String statement) {

       ResultSet rs = dbc.databaseResultset(statement);
        List<Object> tab = new ArrayList<Object>();
        
       Map<String,String> test = new HashMap<String, String>();
       
        try {

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            while (rs.next()) {
                List<Object> vector = new ArrayList<Object>();
                Vector row = new Vector();
                for (int i = 1; i <= columnCount; i++) {
                    //vector.add(rs.getObject(i));
                    row.add(rs.getObject(md.getColumnLabel(i)));
                }
                //data.add(vector);
                tab.add(vector);

            }

            dbc.databaseCloseQuery();
        } catch (Exception e) {

        }
        return tab;
    }
    public Vector databaseColoumnName(String statement) {

        Vector columnNames = new Vector<String>();
        try {
           ResultSet rs = dbc.databaseResultset(statement);

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            if (rs.next()) {
                for (int j = 1; j <= columnCount; j++) {
                    columnNames.add(md.getColumnLabel(j));
                }
            }

            dbc.databaseCloseQuery();
        } catch (Exception e) {

        }
        return columnNames;
    }

   
}
