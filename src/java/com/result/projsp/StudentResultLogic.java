
package com.result.projsp;


public class StudentResultLogic {
   
    private int editional=2;

    public int getEditional() {
        return editional;
    }

    public void setEditional(int editional) {
        this.editional = editional;
    }
    
    

    // Each Letter Grade point Calculation.
    public String letterGrade(double subNum) {
        String g = "";
        if (subNum < 0) {
            g = "F";
        } else if (subNum < 33) {
            g = "F";
        } else if (subNum < 40) {
            g = "D";
        } else if (subNum < 50) {
            g = "C";
        } else if (subNum < 60) {
            g = "B";
        } else if (subNum < 70) {
            g = "A-";
        } else if (subNum < 80) {
            g = "A";
        } else if (subNum <= 100) {
            g = "A+";
        } else if (subNum > 100) {
            g = "F";
        }

        return g;
    }

    //  Each Grade point Calculation.
    public double gradePoint(double subNum) {
        double g = 0.0;

        if (subNum < 0) {
            g = 0.0f;
        } else if (subNum < 33) {
            g = 0.0f;
        } else if (subNum < 40) {
            g = 1.0f;
        } else if (subNum < 50) {
            g = 2.0f;
        } else if (subNum < 60) {
            g = 3.0f;
        } else if (subNum < 70) {
            g = 3.5f;
        } else if (subNum < 80) {
            g = 4.0f;
        } else if (subNum <= 100) {
            g = 5.0f;
        } else if (subNum > 100) {
            g = 0.0f;
        }

        return g;
    }
    
    // All Letter Grade Calculation.
    public String letterGPA(double allSubP) {
        String g = "";
        if (allSubP < 1.0f) {
            g = "F";
        } else if (allSubP < 2.0f) {
            g = "D";
        } else if (allSubP < 3.0f) {
            g = "C";
        } else if (allSubP < 3.5f) {
            g = "B";
        } else if (allSubP < 4.0f) {
            g = "A-";
        } else if (allSubP < 5.0f) {
            g = "A";
        } else if (allSubP == 5.0f) {
            g = "A+";
        }

        return g;
    }
    
    // All point Grade  Calculation.
    public boolean pointGPA(double allSubP) {
        boolean flag = false;
        if (allSubP < 33) {
            flag = false;
        } else if (allSubP < 40) {
           flag = true;
        } else if (allSubP < 50) {
           flag = true;
        } else if (allSubP < 60) {
           flag = true;
        } else if (allSubP < 70) {
            flag = true;
        } else if (allSubP < 80) {
            flag = true;
        } else if (allSubP <= 100) {
            flag = true;
        }

        return flag;
    }
}
