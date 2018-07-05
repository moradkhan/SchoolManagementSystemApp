package com.result.projsp.calculation;

import static java.nio.file.Files.list;
import java.sql.Array;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;

public class SSCMarksheetCalculation1 {

    private ArrayList<ArrayList<Object>> allResult = new ArrayList<ArrayList<Object>>();

    private List mainSubject = new ArrayList<Integer>();//value intial
    private List editionalSubject = new ArrayList<Integer>();//value intial
    private List mainGroupSubject = new ArrayList<Integer>();
    private List editionalGroupSubject = new ArrayList<Integer>();

    private List mainSubjectP = new ArrayList<Integer>();
    private List mainSubjectL = new ArrayList<String>();

    private List editionalSubjectP = new ArrayList<Integer>();
    private List editionalSubjectL = new ArrayList<String>();

    private List mainGroupSubjectP = new ArrayList<Integer>();
    private List mainGroupSubjectL = new ArrayList<Integer>();
    private List editionalGroupSubjectP = new ArrayList<Integer>();
    private List editionalGroupSubjectL = new ArrayList<Integer>();

    int count = 0;
    int groupSub1 = 0;
    int groupSub2 = 0;

    public void resultValue(List<ArrayList<String>> list) {
        Integer j;
        //ArrayList
        for (ArrayList li : list) {

            for (Object i : li) {
                if (count < 1) {
                    try {
                        j = Integer.parseInt((String) i);
                        mainSubject.add(j);
                    } catch (Exception e) {
                    }
                } else if (count < 2) {
                    try {
                        j = Integer.parseInt((String) i);
                        editionalSubject.add(j);
                    } catch (Exception e) {
                    }
                }

            }
            count++;

        }
        count = 0;
    }

    public List<ArrayList<Object>> allResult() {

        List<Object> li = new ArrayList<Object>();

        allResult.add(mGradeL());
        allResult.add(mGradeP());
        allResult.add(eGradeL());
        allResult.add(eGradeP());
        allResult.add(mainGroupSubject());
        allResult.add(editionalGroupSubject());
        li.add(avgGPAPointM());
        li.add(avgGPALetterM());
        li.add(avgGPAPointE());
        li.add(avgGPALetterE());
        li.add(totalResult());
        li.add(editionalAdd());
        allResult.add((ArrayList<Object>) li);
        //      

        return allResult;
    }

    //Main each subject letter.
    public ArrayList mGradeL() {

        for (Object li : this.mainSubject) {
            
            mainSubjectL.add(letterGrade((int) li));
        }

        return (ArrayList) mainSubjectL;
    }

    // Main each subject point.
    public ArrayList mGradeP() {
        for (Object li : this.mainSubject) {
            mainSubjectP.add(gradePoint((int) li));
        }

        return (ArrayList) mainSubjectP;
    }

    // Editional each subject letter.
    public ArrayList eGradeL() {
        for (Object li : this.editionalSubject) {
            editionalSubjectL.add(letterGrade((int) li));
        }

        return (ArrayList) editionalSubjectL;
    }

    //Editional each subject point.
    public ArrayList eGradeP() {
        for (Object li : this.editionalSubject) {
            editionalSubjectP.add(gradePoint((int) li));
        }

        return (ArrayList) editionalSubjectP;
    }

    double avgGPALetter;

    //All main subject Grade Point.
    public double avgGPAPointM() {
        avgGPALetter = 0;
        count = 0;
        for (Object li : this.mainSubject) {
            if ((int) li >= 33) {
                avgGPALetter = avgGPALetter + gradePoint((int) li);

                count++;
            } else {
                return 0.0;

            }
        }
        return (avgGPALetter / count);
    }

    // All main subject Grade Letter. 
    public String avgGPALetterM() {
        avgGPALetter = 0;
        count = 0;
        for (Object li : this.mainSubject) {
            if ((int) li >= 33) {
                avgGPALetter = avgGPALetter + gradePoint((int) li);

                count++;
            } else {
                return "F";

            }
        }
        return letterGPA((int) Math.abs(avgGPALetter / count));
    }

    //All editional subject Grade point. 
    public int avgGPAPointE() {
        avgGPALetter = 0;
        count = 0;
            for (Object li : this.editionalSubject) {
                avgGPALetter = avgGPALetter + gradePoint((int) li);

                count++;

            }
        
        return (int) Math.abs(avgGPALetter / count);
    }

    // All editional subject Grade Letter. 
    public String avgGPALetterE() {
        avgGPALetter = 0;
        count = 0;
        for (Object li : this.editionalSubject) {
            avgGPALetter = avgGPALetter + gradePoint((int) li);

            count++;

        }
        return letterGPA((int) Math.abs(avgGPALetter / count));
    }

    // Main Group subject  
    public ArrayList mainGroupSubject() {
        count = 1;
        for (Object i : mainSubject) {
            if (count == 1) {
                groupSub1 = (int) i;
            } else if (count == 2) {
                groupSub2 = (int) i;
            }
            if (count == 2) {
                mainGroupSubjectP.add(gradePoint(Math.abs((groupSub1 + groupSub2) / 2)));
                count = 0;
            }
            count++;
        }
        return (ArrayList) mainGroupSubjectP;
    }

    //Editional Group Subject. 
    public ArrayList editionalGroupSubject() {
        count = 1;
        for (Object i : editionalSubject) {
            if (count == 1) {
                groupSub1 = (int) i;
            } else if (count == 2) {
                groupSub2 = (int) i;
            }
            if (count == 2) {
                editionalGroupSubjectP.add(gradePoint(Math.abs((groupSub1 + groupSub2) / 2)));
                count = 0;
            }
            count++;
        }

        return (ArrayList) editionalGroupSubjectP;
    }

    //Result with editional subject. 
    //total main subject (100/main sub)* (editionalsub-2)
    public double totalResult() {
        int countMain = 1;
        for (Object i : mainSubjectP) {
            countMain++;
        }
        double r = avgGPAPointM() + ((.100 / countMain) * (editionalAdd()));
        if(r<1){
            return 0.0;
        }
        
        return r;
    }
    
    //editional add.
    public double editionalAdd() {
        int countMain = 1;
        for (Object i : mainSubjectP) {
            countMain++;
        }

        return (avgGPAPointE() - 2);
    }

    // All Letter Grade point Calculation.
    public String letterGPA(int allSubP) {
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

    // Each Letter Grade point Calculation.
    public String letterGrade(int subNum) {
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
    public float gradePoint(int subNum) {
        float g = 0.0f;

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

}
