package com.result.projsp;

import java.util.ArrayList;
import java.util.List;

public class StudentResultShow {

    private int count = 0;
    StudentResultLogic srl = new StudentResultLogic();

    //Main each subject letter. checked
    public List<String> subjectGradeL(List<Double> subjectNum) {

        List<String> mainSubGradePoi = new ArrayList<String>();
        for (Object li : subjectNum) {

            mainSubGradePoi.add(srl.letterGrade((double) li));
        }

        return mainSubGradePoi;
    }

    // Main each subject point. checked
    public List<Double> subjectGradeP(List<Double> subjectNum) {

        List<Double> mainSubGradePoi = new ArrayList<Double>();
        for (Object li : subjectNum) {
            mainSubGradePoi.add(srl.gradePoint((double) li));
        }

        return mainSubGradePoi;
    }

    double avgGPALetter;

    //All main subject Grade Point. checked
    public double mainAvgPoint(List<Double> subjectNum) {
        double avgGPALetter = 0;
        int count = 0;
        for (Object lis : subjectNum) {
            if (srl.pointGPA((double) lis)) {
                avgGPALetter = avgGPALetter + srl.gradePoint((double) lis);

            } else {
                return 0.0;
            }
            count++;
        }

        return (avgGPALetter / count);
    }

    // All main subject Grade Letter. checked
    public String mainAvgLetter(List<Double> subjectNum) {

        double avgGPALetter = 0;
        int count = 0;
        for (Object li : subjectNum) {
            if (srl.pointGPA((double) li)) {
                avgGPALetter = avgGPALetter + srl.gradePoint((double) li);

            } else {
                return "F";
            }
            count++;
        }
        return srl.letterGPA((avgGPALetter / count));
    }

    //All editional subject Grade point. checked.
    public double editionAavgPoint(List<Double> subjectNum) {
        double avgGPALetter = 0;
        int count = 0;
        for (Object li : subjectNum) {
            avgGPALetter = avgGPALetter + srl.gradePoint((double) li);

            count++;
        }

        return (avgGPALetter / count);
    }

    // All editional subject Grade Letter. checked
    public String editionAvgLetter(List<Double> subjectNum) {
        avgGPALetter = 0;
        count = 0;
        for (Object li : subjectNum) {
            avgGPALetter = avgGPALetter + srl.gradePoint((double) li);

            count++;

        }
        return srl.letterGPA(avgGPALetter / count);
    }

    // Main Group subject point checked
    public final List<Double> subjectGroup(List<Double> subjectNum) {

        int counter = 1;
        double groupSub1 = 0;
        double groupSub2 = 0;

        List<Double> mainGroupSubPoi = new ArrayList<Double>();

        for (Object i : subjectNum) {
            if (counter == 1) {
                groupSub1 = (double) i;
            } else if (counter == 2) {
                groupSub2 = (double) i;
                mainGroupSubPoi.add((groupSub1 + groupSub2) / 2);
                counter = 0;
            }

            counter++;
        }

        return mainGroupSubPoi;
    }

    //Result with editional subject. 
    //total main subject (100/main sub)* (editionalsub-2)
    public double totalResult(List<Double> subjectNum, List<Double> subGroupNum,
            List<Double> ediSubNum, List<Double> ediGroupNum) {
        int countMain = 0;
        double total = 0;

        List<Double> list3 = subjectGroup(subGroupNum);

        

        double min = mainAvgPoint(subjectNum);
        double ming = mainAvgPoint(list3);
       
        double edi2 = editionAdd(subjectNum, subGroupNum, ediSubNum, ediGroupNum);
        
        if (((min + ming) / 2) > 1 ) {

            total = ((min + ming) / 2) + edi2;
            
        } else {

            return 0;

        }

        return total;
    }
    
    public double result(List<Double> subjectNum, List<Double> subGroupNum) {
        int countMain = 0;
        double total = 0;

        List<Double> list3 = subjectGroup(subGroupNum);

        

        double min = mainAvgPoint(subjectNum);
        double ming = mainAvgPoint(list3);
       
        
        if (((min + ming) / 2) > 1 ) {

            total = ((min + ming) / 2);
            
        } else {

            return 0;

        }

        return total;
    }

    public double editionAdd(List<Double> subjectNum, List<Double> subGroupNum,
            List<Double> ediSubNum, List<Double> ediGroupNum) {

        int countMain = 0;
        double total = 0;

        List<Double> list3 = subjectGroup(subGroupNum);
        List<Double> list4 = subjectGroup(ediGroupNum);

        for (Object i : subjectNum) {
            countMain++;
        }
        for (Object i : list4) {
            countMain++;
        }

        double min = (mainAvgPoint(subjectNum) + mainAvgPoint(list3)) / 2;
        double edi = (editionAavgPoint(ediSubNum) + editionAavgPoint(list4)) / 2;

//        
        String ediAdd = ".";
        int edi2 = 0;
        if (min > 1 && edi > 2) {
            edi2 = (int) ((100 / countMain) * (edi - srl.getEditional()));
            ediAdd = ediAdd + edi2;
            total = Double.parseDouble(ediAdd);
        } else if (min > 1 && edi < 2) {
            return 0;
        }

        return total;

    }

}
