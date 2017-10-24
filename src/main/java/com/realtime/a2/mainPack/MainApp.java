//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.mainPack;

import com.realtime.a2.generateExcel.ApachePOIWriter;
import com.realtime.a2.generateExcel.DataFormatter;
import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        
        DirAndFileTasker df_tsk = new DirAndFileTasker();
        df_tsk.tasksForDirAndFile();
        String relativePath = df_tsk.getRelativePath();
        
        DataTasker tsk = new DataTasker(df_tsk.getDirectory(), df_tsk.getFileNames());
        tsk.tasksForEachFile();
        tsk.tasksForDistictMatric();

        String[] keywords = tsk.getKeywords();
        ArrayList<String> courseInfo = tsk.getCourseInfo();
        ArrayList<String> uniqueMatric = tsk.getUniqueMatric();
        int[][] totalLineCount = tsk.getTotalLineCount();
        int[][] totalIndividualKeywordCount = tsk.getTotalIndividualKeywordCount();
        int[] totalValue = tsk.getTotalValue();
        
        DataFormatter formatter = new DataFormatter
        (keywords, courseInfo, uniqueMatric, totalLineCount, totalIndividualKeywordCount, totalValue);
        
        formatter.setCourseSection();
        formatter.setDescSection();
        formatter.setDataSection();
        formatter.generateObject();
        String[][] objectStore = formatter.getObjectStore();
        
        ApachePOIWriter writer = new ApachePOIWriter(relativePath, objectStore);
        writer.initializeExcel();
        writer.writeToExcel();   
    } 
}
