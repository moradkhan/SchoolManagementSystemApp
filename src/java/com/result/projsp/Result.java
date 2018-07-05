
package com.result.projsp;

import java.util.ArrayList;
import java.util.List;


public interface Result {
    
    
    List<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
    
    List<Integer> mainSub = new ArrayList<Integer>();
    List<Integer> edtionSub = new ArrayList<Integer>();
    
    List<Integer> mainGroupSub = new ArrayList<Integer>();
    List<Integer> edtioGroupSub = new ArrayList<Integer>();
    
    
    List<String> mainSubGradeLet = new ArrayList<>();
    List<Integer> mainSubGradePoi = new ArrayList<>();
    
    List<String> edtioSubGradeLet = new ArrayList<>();
    List<Integer> edtioSubGradePoi = new ArrayList<>();
    
    
    List<String> mainGroupSubLet = new ArrayList<>();
    List<Integer> mainGroupSubPoi = new ArrayList<>();
    
    List<String> edtioGroupSubLet = new ArrayList<>();
    List<Integer> edtioGroupSubPoi = new ArrayList<>();
    
    
    String mainSubLetter = "";
    Float mainSubPoint = 0f;
    String editionSubLetter= "";
    Float editionSubPoint = 0f;
    
    String allSubResultLetter = "";
    Float allSubResultPint = 0f;
    
    List<ArrayList<Object>> allSubResult ( List<Integer> mainSub, List<Integer> editionSub,
            List<Integer> mainGroupSub, List<Integer> editioGroupSub);
    
    List<ArrayList<Object>> allSubResult ( List<Integer> sub, List<Integer> groupSub );
    
    List<ArrayList<Object>> allEditionSubResult ( List<Integer> sub, List<Integer> groupSub );
    
    List<ArrayList<Object>> editionSubResult ( List<Integer> sub );
    
    List<ArrayList<Object>> subResult ( List<Integer> sub );
    
    
    
    String[] allSubResult2 (List<Integer> mainSub, List<Integer> editionSub,
            List<Integer> mainGroupSub, List<Integer> editioGroupSub);
    
    String[] allSubResult2 ( List<Integer> sub, List<Integer> groupSub );
    
    String[] allEditionSubResult2 ( List<Integer> sub, List<Integer> groupSub );
    
    String[] editionSubResult2 ( List<Integer> sub );
    
    String[] subResult2 ( List<Integer> sub );
    
    
}
