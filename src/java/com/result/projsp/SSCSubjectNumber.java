/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.result.projsp;

import com.dao.DatabaseConnection;
import com.dao.DatabaseQuery;
import com.result.projsp.calculation.SSCMarksheetCalculation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasel
 */
public class SSCSubjectNumber extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            List<String> studentinfo = new ArrayList<String>();

            String rollNo = request.getParameter("rollNo");
            String regNo = request.getParameter("regNo");
            String studentN = request.getParameter("studentN");
            String faName = request.getParameter("faName");
            String moName = request.getParameter("moName");
            String nIstitution = request.getParameter("nIstitution");
            String group = request.getParameter("group");
            String dob = request.getParameter("dob");

            studentinfo.add(rollNo);
            studentinfo.add(regNo);
            studentinfo.add(studentN);
            studentinfo.add(faName);
            studentinfo.add(moName);

            studentinfo.add(nIstitution);
            studentinfo.add(group);
            studentinfo.add(dob);

            data.add((ArrayList<String>) studentinfo);

            int bang1 = inte(request.getParameter("bang1"));
            int bang2 = inte(request.getParameter("bang2"));

            int eng1 = inte(request.getParameter("eng1"));
            int eng2 = inte(request.getParameter("eng2"));

            int gMath = inte(request.getParameter("gMath"));
            int religiousE = inte(request.getParameter("religiousE"));
            int socialS = inte(request.getParameter("socialS"));
            int physicsS = inte(request.getParameter("physicsS"));
            int chemistryS = inte(request.getParameter("chemistryS"));
            int hMath = inte(request.getParameter("hMath"));
            int biologyS = inte(request.getParameter("biologyS"));
            int computerS = inte(request.getParameter("computerS"));

            studentinfo.add(String.valueOf(bang1));
            studentinfo.add(String.valueOf(bang2));
            studentinfo.add(String.valueOf(eng1));
            studentinfo.add(String.valueOf(eng2));
            studentinfo.add(String.valueOf(gMath));

            studentinfo.add(String.valueOf(gMath));
            studentinfo.add(String.valueOf(gMath));
            studentinfo.add(String.valueOf(physicsS));
            studentinfo.add(String.valueOf(chemistryS));
            studentinfo.add(String.valueOf(hMath));

            studentinfo.add(String.valueOf(biologyS));
            studentinfo.add(String.valueOf(computerS));
            //data.add((ArrayList<String>) studentinfo);
//            studentinfo.add(rollNo);
//            studentinfo.add(regNo);

            DatabaseConnection db = new DatabaseConnection();
            DatabaseQuery dbq = new DatabaseQuery();
            
            String statement = "INSERT INTO studentresult VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

           boolean dataInset = db.databaseUpdate(statement, studentinfo);
           
           request.setAttribute("boll", dataInset);

            SSCMarksheetCalculation mc = new SSCMarksheetCalculation(bang1, bang2, eng1, eng2, gMath, religiousE,
                    socialS, physicsS, chemistryS, hMath, biologyS, computerS);

            String statement1 = "SELECT * FROM studentresult";
              
            
           request.setAttribute("table1", db.databseQuery(statement1));

            request.setAttribute("bangL", mc.letterGrade(Math.abs((bang1 + bang2) / 2)));
            request.setAttribute("bangP", mc.gradePoint(Math.abs((bang1 + bang2) / 2)));

            request.setAttribute("engL", mc.letterGrade(Math.abs((eng1 + eng2) / 2)));
            request.setAttribute("engP", mc.gradePoint(Math.abs((eng1 + eng2) / 2)));

            request.setAttribute("gMathL", mc.letterGrade(gMath));
            request.setAttribute("gMathP", mc.gradePoint(gMath));

            request.setAttribute("religiousEL", mc.letterGrade(religiousE));
            request.setAttribute("religiousEP", mc.gradePoint(religiousE));

            request.setAttribute("socialSL", mc.letterGrade(religiousE));
            request.setAttribute("socialSP", mc.gradePoint(religiousE));

            request.setAttribute("physicsSL", mc.letterGrade(physicsS));
            request.setAttribute("physicsSP", mc.gradePoint(physicsS));

            request.setAttribute("chemistrySL", mc.letterGrade(chemistryS));
            request.setAttribute("chemistrySP", mc.gradePoint(chemistryS));

            request.setAttribute("hMathL", mc.letterGrade(hMath));
            request.setAttribute("hMathP", mc.gradePoint(hMath));

            request.setAttribute("biologySL", mc.letterGrade(biologyS));
            request.setAttribute("biologySP", mc.gradePoint(biologyS));

            request.setAttribute("computerSL", mc.letterGrade(computerS));
            request.setAttribute("computerSP", mc.gradePoint(computerS));

            request.setAttribute("letterGPA", mc.letterGPA());
            request.setAttribute("gradeGPA", mc.gradeGPA());

            RequestDispatcher dispatcher = request.getRequestDispatcher("sscSubjectNumber1.jsp");
            dispatcher.forward(request, response);

        }
    }

    public int inte(String stgn) {
        int i = 0;
        try {
            i = Integer.parseInt(stgn);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
