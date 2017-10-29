//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.generateExcel;

import java.util.ArrayList;

public class DataFormatter {
    
    String[] keywords;
    ArrayList<String> courseInfo; 
    ArrayList<String> uniqueMatric; 
    int[][] totalLineCount;
    int[][] totalIndividualKeywordCount;
    int[] totalValue;
    
    String[][] course;
    String[][] description;
    String[][] data;
    String[][] objectStore;
    
    public DataFormatter(String[] keywords, ArrayList<String> courseInfo, ArrayList<String> uniqueMatric, 
                      int[][] totalLineCount, int[][] totalIndividualKeywordCount, int[] totalValue){
        
        this.keywords = keywords;
        this.courseInfo = courseInfo;
        this.uniqueMatric = uniqueMatric;
        this.totalLineCount = totalLineCount;
        this.totalIndividualKeywordCount = totalIndividualKeywordCount;
        this.totalValue = totalValue;
        
        course = new String[4][2];
        description = new String[3][];
        data = new String[uniqueMatric.size()][];
    }
    
    public void setCourseSection(){
        // Preping data for row 1-4 in excel
        String[][] tempCourse = {
            {"Semester", courseInfo.get(0)},
            {"Course", courseInfo.get(1)},
            {"Group", courseInfo.get(2)},
            {"Task", courseInfo.get(3)}
        };
        course = tempCourse;
    }
    
    public void setDescSection(){
        String[] fixedFields = new String[keywords.length + 6];
        fixedFields[0] = "Matric";
        fixedFields[1] = "LOC";
        fixedFields[2] = "Blank";
        fixedFields[3] = "Comment";
        fixedFields[4] = "Actual LOC";

        for (int i=5; i<(fixedFields.length - 1); i++) {
            fixedFields[i] = keywords[(i - 5)];
        }
        fixedFields[58] = "Total";
        
        // Preping data for row 5-7 in excel
        String[][] tempDesc = {{}, {"", "", "", "", "", "java keyword"}, fixedFields};

        description = tempDesc;
    }
    
    public void setDataSection(){
        String[][] tempData = new String[uniqueMatric.size()][keywords.length + 6];
        
        // Preping data for row 8 - ... in excel
        for (int i = 0; i < tempData.length; i++) {
            tempData[i][0] = uniqueMatric.get(i);
            tempData[i][1] = Integer.toString(totalLineCount[i][0]); //LOC
            tempData[i][2] = Integer.toString(totalLineCount[i][1]); //Blank
            tempData[i][3] = Integer.toString(totalLineCount[i][2]); //Comment
            tempData[i][4] = Integer.toString(totalLineCount[i][3]); //Actual LOC
            tempData[i][58] = Integer.toString(totalValue[i]);
            
            for (int x=0; x<keywords.length; x++){
                tempData[i][x+5] = Integer.toString(totalIndividualKeywordCount[i][x]);
            }
        }
        data = tempData;
    }
    
    public void generateObject() {
        String[][] tempObject = new String[course.length + description.length + data.length][];
        int i = 0;
        
        for (; i < course.length; i++) {
            tempObject[i] = new String[course[i].length];
            for (int x = 0; x < course[i].length; x++) {
                tempObject[i][x] = course[i][x];
            }
        }

        for (int x = 0; x < description.length; x++) {
            tempObject[i] = description[x];
            i++;
        }

        for (int x = 0; x < data.length; x++) {
            tempObject[i] = data[x];
            i++;
        }
        objectStore = tempObject;
    }
    
    public String[][] getCourseInfo(){
        return course;
    }
    
    public String[][] getDescription(){
        return description;
    }
    
    public String[][] getData(){
        return data;
    }
    
    public String[][] getObjectStore(){
        return objectStore;
    }
}
