//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.mainPack;

import java.util.ArrayList;
import com.realtime.a2.determineLines.CalculateKeywords;
import com.realtime.a2.determineLines.CalculateLines;
import com.realtime.a2.determineLines.ReadFiles;
import com.realtime.a2.determineLines.TotalForEachMatric;
import com.realtime.a2.determineCourseMatric.CourseWorker;
import com.realtime.a2.determineCourseMatric.MatricWorker;
import com.realtime.a2.determineCourseMatric.UniqueMatric;

public class DataTasker {
    
    private final ArrayList<String> fileNames;
    private final String directory;
    private ArrayList<String> courseInfo;
    private ArrayList<String> matricNum;
    private ArrayList<String> uniqueMatric;
    private String[][] allFilesContent;
    private int[][] lineCount;
    private int[][] keywordsCount;
    private String[] keywords;
    
    private int[][] totalLineCount; 
    private int[][] totalIndividualKeywordCount;
    private int[] totalValue;
    
    public DataTasker(String directory, ArrayList<String> fileNames){
        this.directory = directory;
        this.fileNames = fileNames;
    }
    
    public void tasksForEachFile() throws InterruptedException{
        //Semester, Course, Group, Task        
        CourseWorker cw = new CourseWorker(directory, fileNames);
        Thread cw1 = new Thread(cw);
        cw1.start();
        cw1.join();
        courseInfo = cw.getCourseInfo();

        MatricWorker mw = new MatricWorker(directory, fileNames);
        Thread mw1 = new Thread(mw);
        mw1.start();
        mw1.join();
        matricNum = mw.getMatricNum();

        ReadFiles rf = new ReadFiles(directory, fileNames);
        rf.readFileContent();
        allFilesContent = rf.getFilesContent();
 
        CalculateLines cl = new CalculateLines(allFilesContent);
        cl.calcLineCounts();
        lineCount = cl.getLineCounts();
        
        CalculateKeywords ck = new CalculateKeywords(allFilesContent);
        ck.countKeywords();
        keywordsCount = ck.getKeywordsCount();
        keywords = ck.getKeywords();
    }
    
    public void tasksForDistictMatric(){
        
        UniqueMatric um = new UniqueMatric(matricNum);
        um.findUniqueMatric();
        uniqueMatric = um.getUniqueMatric();
        
        TotalForEachMatric totMat = new TotalForEachMatric(matricNum, uniqueMatric, lineCount, keywords, keywordsCount);
        totMat.countIndividualKeywordsSum();
        totMat.countLinesSum();
        totMat.countTotalValue();
        totalLineCount = totMat.getTotalLineCount();
        totalIndividualKeywordCount = totMat.getTotalIndividualKeywordCount();
        totalValue = totMat.getTotalValue();
        
        // ===================  CHECKERS  =================== //
    
        //----- For course information
        /*for (int x=0; x<courseInfo.size(); x++) {
            System.out.println(courseInfo.get(x));
        }*/
    
        //----- For matric numbers
        /*for (int x=0; x<matricNum.size(); x++) {
            System.out.println(matricNum.get(x));
        }*/
    
        //----- For LOC, Blanks, Comments, ActualLOC
        /*for (int i=0; i<fileNames.size(); i++){
            for (int x=0; x<4; x++){
                System.out.print(lineCount[i][x] +" ");
            }
            System.out.println();
        }*/
    
        //----- For total value for each unique matric
        /*for (int x=0; x<uniqueMatric.size(); x++) {
            System.out.println(totalValue[x]);
        }*/
        
        //----- For total individual keyword count
        /*for (int a=0; a<2; a++){
            for (int x=0; x<53; x++){
                System.out.print(totalIndividualKeywordCount[a][x] +" ");
            }
            System.out.println();
        }*/
    }
    
    public String[] getKeywords(){
        return keywords;
    }
    public ArrayList<String> getCourseInfo(){
        return courseInfo;
    }
    
    public ArrayList<String> getUniqueMatric(){
        return uniqueMatric;
    }
    
    public int[][] getTotalLineCount(){
        return totalLineCount;
    }
    
    public int[][] getTotalIndividualKeywordCount(){
        return totalIndividualKeywordCount;
    }

    public int[] getTotalValue(){
        return totalValue;
    }     
}
