package com.result.projsp.calculation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SSCMarksheetCalculation {

    private int bang1;
    private int bang2;

    private int eng1;
    private int eng2;

    private int gMath;
    private int religiousE;
    private int socialS;
    private int physicsS;
    private int chemistryS;
    private int hMath;
    private int biologyS;
    private int computerS;
    
    

    public SSCMarksheetCalculation(int bang1, int bang2, int eng1, int eng2, int gMath,
            int religiousE, int socialS, int physicsS, int chemistryS, int hMath, int biologyS, int computerS) {
        this.bang1 = bang1;
        this.bang2 = bang2;
        this.eng1 = eng1;
        this.eng2 = eng2;
        this.gMath = gMath;
        this.religiousE = religiousE;
        this.socialS = socialS;
        this.physicsS = physicsS;
        this.chemistryS = chemistryS;
        this.hMath = hMath;
        this.biologyS = biologyS;
        this.computerS = computerS;
    }

    public float gradeGPA() {
        float gp = 0.0f;
        if (((bang1 + bang2) / 2) >= 33 && ((eng1 + eng2) / 2) >= 33 && gMath >= 33 && religiousE >= 33 && socialS >= 33
                && physicsS >= 33 && chemistryS >= 33 && hMath >= 33 && biologyS >= 33 && computerS >= 33) {

            float gpaResult = gradePoint(Math.abs((bang1 + bang2) / 2)) + gradePoint(Math.abs((eng1 + eng2) / 2)) + gradePoint(gMath) + gradePoint(religiousE)
                    + gradePoint(socialS) + gradePoint(physicsS) + gradePoint(chemistryS) + gradePoint(hMath) + gradePoint(biologyS) + gradePoint(computerS);

            gp = (gpaResult / 10);

            return gp;
        } else {

            gp = 0.0f;
        }

        return gp;
    }

    public int totalNumber() {
        return bang1 + bang2 + eng1 + eng2 + gMath + religiousE + socialS + physicsS + chemistryS + hMath
                + biologyS + computerS;
    }

    public String letterGPA() {
        String g = "";
        if (gradeGPA() < 1.0f) {
            g = "F";
        } else if (gradeGPA() < 2.0f) {
            g = "D";
        } else if (gradeGPA() < 3.0f) {
            g = "C";
        } else if (gradeGPA() < 3.5f) {
            g = "B";
        } else if (gradeGPA() < 4.0f) {
            g = "A-";
        } else if (gradeGPA() < 5.0f) {
            g = "A";
        } else if (gradeGPA() == 5.0f) {
            g = "A+";
        }

        return g;
    }

    //Letter point
    public String letterGrade(int subNum) {
        String g = "";
        if (subNum < 0) {
            g = "This number is "+subNum +" Out of bounds";
        }else if (subNum < 33) {
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
            g = "This number is "+subNum +" Out of bounds";
        }

        return g;
    }

    // Grade point
    public float gradePoint(int subNum) {
        float g = 0.0f;

        if (subNum < 33) {
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
        }

        return g;
    }

}
