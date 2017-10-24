//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

import java.util.ArrayList;

public class TotalForEachMatric {
    
    private ArrayList<String> matricNum; 
    private ArrayList<String> uniqueMatric; 
    private int[][] lineCount; 
    private int[][] keywordsCount;
    private String[] keywords;
    private int[][] totalLineCount; 
    private int[][] totalIndividualKeywordCount;
    private int[] sumOfAllKeywords;
    private int[] totalValue;

    public TotalForEachMatric(ArrayList<String> matricNum, ArrayList<String> uniqueMatric, int[][] lineCount, String[] keywords, int[][] keywordsCount) {
        this.matricNum = matricNum;
        this.uniqueMatric = uniqueMatric;
        this.lineCount = lineCount;
        this.keywordsCount = keywordsCount;
        this.keywords = keywords;
    }
    
    public void countIndividualKeywordsSum(){
        totalIndividualKeywordCount = new int[uniqueMatric.size()][keywords.length];

        for (int i = 0; i < uniqueMatric.size(); i++) { //unique matric
            for (int x = 0; x < keywordsCount.length; x++) { //num of files
                for (int n = 0; n < keywordsCount[x].length; n++) { //num of keywords
                    if (uniqueMatric.get(i).equals(matricNum.get(x))) {
                        totalIndividualKeywordCount[i][n] += keywordsCount[x][n];
                    }
                }
            }
        }
    }
    
    public void countTotalKeywordsUsed(){
        sumOfAllKeywords = new int[uniqueMatric.size()];
        
        for (int i = 0; i < totalIndividualKeywordCount.length; i++) {
            for (int b = 0; b < totalIndividualKeywordCount[i].length; b++) {
                sumOfAllKeywords[i] += totalIndividualKeywordCount[i][b];
            }
        }
    }
    
    public void countLinesSum(){
        totalLineCount = new int[uniqueMatric.size()][4];

        for (int i = 0; i < uniqueMatric.size(); i++) { //unique matric
            for (int x = 0; x < keywordsCount.length; x++) { //num of files
                if (uniqueMatric.get(i).equals(matricNum.get(x))) {
                    totalLineCount[i][0] += lineCount[x][0]; //LOC
                    totalLineCount[i][1] += lineCount[x][1]; //Blank
                    totalLineCount[i][2] += lineCount[x][2]; //Comment
                    totalLineCount[i][3] += lineCount[x][3]; //Actual LOC
                }
            }
        }
    }
    
    public void countTotalValue(){
        countTotalKeywordsUsed();
        totalValue = new int[uniqueMatric.size()];
        
        totalValue = new int[uniqueMatric.size()];
        for (int i = 0; i < uniqueMatric.size(); i++) {
            totalValue[i] = totalValue[i] + (totalLineCount[i][3] + sumOfAllKeywords[i]);
        }
    }
    
    public int[][] getTotalLineCount(){
        return totalLineCount;
    }
    
    public int[][] getTotalIndividualKeywordCount(){
        return totalIndividualKeywordCount;
    }
    
    public int[] getSumOfAllKeywords(){
        return sumOfAllKeywords;
    }
    
    public int[] getTotalValue(){
        return totalValue;
    }   
}
