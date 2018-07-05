/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.result.projsp.calculation.SSCMarksheetCalculation;
import com.result.projsp.calculation.SSCMarksheetCalculation1;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Rasel
 */
public class NewClass {

    public static void main(String args[]) {
        DatabaseConnection db = new DatabaseConnection();

        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        
        List<String> li = new ArrayList<String>();
        List<String> li2 = new ArrayList<String>();
        List<String> li3 = new ArrayList<String>();
        li.add("30");
        li.add("55");
        li.add("55");
        li.add("90");
        
        list.add((ArrayList<String>) li);
        
        li2.add("30");
        li2.add("50");
        li2.add("90");
        li2.add("90");
        list.add((ArrayList<String>) li2);

        SSCMarksheetCalculation1 n = new SSCMarksheetCalculation1();
        n.resultValue(list);
        
        DatabaseQuery dbq = new DatabaseQuery();
        
       for(Object i:  dbq.databseQuery("SELECT * FROM studentresult")){
           System.out.println(i);
       }
        
        
//        ArrayList l = n.mGradeL();
//        ArrayList p= n.mGradeP();
//        
//        String ap = n.avgGPALetterE();
//        
//        List<ArrayList<Object>> total = n.allResult();
//        
//            int count = 0;
//        for(ArrayList<Object> i : n.allResult()){
//                if(count == 0){
//                    System.out.println("\t mainGradeL");
//                for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//                }else if(count == 1){
//                    System.out.println("\n\t mainGradeP");
//                    for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//                }else if(count == 2){
//                    System.out.println("\n\t editionalGradeL");
//                    for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//           
//                }else if(count == 3){
//                    System.out.println("\n\t editionalGradeP");
//                    for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//           
//                }else if(count == 4){
//                    System.out.println("\n\t mainGroupSubject");
//                    for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//           
//                }else if(count == 5){
//                    System.out.println("\n\t editionalGroupSubject");
//                    for(Object j : i){
//                        System.out.print("\t"+j);
//                }
//           
//                }else if(count == 6){
//                    System.out.println("\n\t editionalGroupSubject");
//                    for(Object j : i){
//                        System.out.println("\t"+j);
//                }
//           
//                }
//                
//                 count += 1;
//        }
//        //System.out.println(5/2);
////        ArrayList g = n.mainGroupSubject();
////        
////        System.out.println("Main : "+n.avgGPAPointM());
////        System.out.println("Editional : "+n.avgGPAPointE());
////        System.out.println("Result : "+n.totalResult());
//        
//        for(Object i: l){
//            System.out.println(i);
//        }
//        
//        for(Object i: p){
//            System.out.println(i);
//        }
//        for(Object i: g){
//            System.out.println("mainGroupSubject  "+i);
//        }

//        String statement = "INSERT INTO studentresult (rollNo, regNo, dob) VALUES (?, ?, ?)";
//        
       // db.databaseUpdate(statement, list);
//        String statement = "Select * from students_from";
//        try {
//         for(Object s:   db.databaseColoumnName(statement)){
//             
//             //for(Object i : (Vector)s){
//                 System.out.print(s+"\t");
//                 
//                 
//            // }System.out.println("\t");
//            System.out.println("\t");
//         }
//
//            db.databaseClose();
//        } catch (Exception e) {
//        }
//        try {
//         for(Object s:   db.databseQuery(statement)){
//             
//             for(Object i : (Vector)s){
//                 System.out.print(i+"\t");
//                 
//                 
//            }System.out.println("\t");
//         }
//
//            db.databaseClose();
//        } catch (Exception e) {
//        }
   
    }
    }
