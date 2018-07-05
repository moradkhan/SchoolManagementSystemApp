package com.result.projsp;

import java.util.ArrayList;
import java.util.List;

public class StudentResult {

    public StudentResult() {
    }

    private List<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();

    private List<Integer> mainSub = new ArrayList<Integer>();
    private List<Integer> edtionSub = new ArrayList<Integer>();

    private List<Integer> groupMainSub = new ArrayList<Integer>();
    private List<Integer> groupEditionSub = new ArrayList<Integer>();

   

    public List<ArrayList<Object>> allSubResult(List<String> mainSub, List<String> mainGroupSub ,
            List<String> editionSub, List<String> editioGroupSub ) {

        Integer j=0;
        //ArrayList
        for (String li : mainSub) {
             try {
                j = Integer.parseInt(li);
                this.mainSub.add(j);
            } catch (Exception e) {
            }
        }
        
        for (String li : editionSub) {
             try {
                j = Integer.parseInt(li);
                this.edtionSub.add(j);
            } catch (Exception e) {
            }
        }
       
        for (String li : mainGroupSub) {
             try {
                j = Integer.parseInt(li);
                this.groupMainSub.add(j);
            } catch (Exception e) {
            }
        }
        
        for (String li : editioGroupSub) {
             try {
                j = Integer.parseInt(li);
                this.groupEditionSub.add(j);
            } catch (Exception e) {
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public List<ArrayList<Object>> allSubResult(List<String> mainSub, List<String> groupSub) {
//       
//        Integer j=0;
//        //ArrayList
//        for (String li : mainSub) {
//             try {
//                j = Integer.parseInt(li);
//                this.mainSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//        
//        for (String li : groupSub) {
//             try {
//                j = Integer.parseInt(li);
//                this.mainGroupSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//       
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public List<ArrayList<Object>> allEditionSubResult(List<String> editionSub, List<String> groupSub) {
//        
//        Integer j=0;
//        //ArrayList
//        for (String li : editionSub) {
//             try {
//                j = Integer.parseInt(li);
//                this.edtionSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//        
//        for (String li : groupSub) {
//             try {
//                j = Integer.parseInt(li);
//                this.edtioGroupSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public List<ArrayList<Object>> editionSubResult(List<String> editionSub) {
//        
//        Integer j=0;
//        //ArrayList
//        for (String li : editionSub) {
//             try {
//                j = Integer.parseInt(li);
//                this.edtionSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//        
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public List<ArrayList<Object>> subResult(List<String> sub) {
//        Integer j;
//        for (String li : sub) {
//             try {
//                j = Integer.parseInt(li);
//                this.mainSub.add(j);
//            } catch (Exception e) {
//            }
//        }
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String[] allSubResult2(List<Integer> mainSub, List<Integer> editionSub, List<Integer> mainGroupSub, List<Integer> editioGroupSub) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String[] allSubResult2(List<Integer> sub, List<Integer> groupSub) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String[] allEditionSubResult2(List<Integer> sub, List<Integer> groupSub) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String[] editionSubResult2(List<Integer> sub) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String[] subResult2(List<Integer> sub) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    

   
    
    
    
    
}
