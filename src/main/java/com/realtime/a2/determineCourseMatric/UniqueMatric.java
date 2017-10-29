//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineCourseMatric;

import java.util.ArrayList;

public class UniqueMatric {
    
    private ArrayList<String> uniqueMatric;
    private ArrayList<String> matricNum;
    
    public UniqueMatric(ArrayList<String> matricNum){
        this.matricNum = matricNum;
        uniqueMatric = new ArrayList<>(); 
    }
    
    public void findUniqueMatric(){   
        matricNum.stream().filter((s) -> (!uniqueMatric.contains(s))).forEach((s) -> {
            uniqueMatric.add(s);
        });
    }
    
    public ArrayList<String> getUniqueMatric(){
        return uniqueMatric;
    }
}
