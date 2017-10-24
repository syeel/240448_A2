//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class TotalForEachMatricTest {
    
    TotalForEachMatric tfm;
    ArrayList<String> matricNum = new ArrayList(Arrays.asList("898989", "123456"));
    ArrayList<String> uniqueMatric = new ArrayList(Arrays.asList("898989", "123456")); 
    int[][] lineCount = {{24,4,6,14}, {30,6,7,17}};
    int[][] keywordsCount = {
        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}, 
        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}
    };
    String[] keywords = {"abstract ", "assert", "boolean ", "break", 
        "byte ", "case", "catch", "char ", "class ", "const", "continue", "default", 
        "do", "double ", "else", "enum", "extends ", "false", "final ", "finally", 
        "float ", "for", "goto", "if", "implements", "import ", "instanceof", "int ", 
        "interface ", "long ", "native", "new ", "null", "package ", "private ", "protected ", 
        "public ", "return", "short ", "static ", "strictfp", "super ", "switch", "synchronized", 
        "this", "throw ", "throws ", "transient", "true", "try", "void ", "volatile", "while"};
    
    @Before
    public void createObject(){
        tfm = new TotalForEachMatric(matricNum, uniqueMatric, lineCount, keywords, keywordsCount);
    }
    
    @Test
    public void testIndividualKeywordsSum(){
        tfm.countIndividualKeywordsSum();
        
        int[][] actualKeywordsCount = tfm.getTotalIndividualKeywordCount();
        int[][] expectedKeywordsCount = {
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}, 
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}
        };
        assertArrayEquals(expectedKeywordsCount, actualKeywordsCount);  
    }
    
    @Test
    public void testTotalKeywordsUsed(){
        tfm.countIndividualKeywordsSum();
        tfm.countTotalKeywordsUsed();
        int[] actualTotalKeywordsUsed = tfm.getSumOfAllKeywords();
        int[] expectedTotalKeywordsUsed = {9, 10};
        
        assertArrayEquals(expectedTotalKeywordsUsed, actualTotalKeywordsUsed);  
    }
    
    @Test
    public void testLinesSum(){
        tfm.countLinesSum();
        int[][] actualLinesCount = tfm.getTotalLineCount();
        int[][] expectedLinesCount = {{24,4,6,14}, {30,6,7,17}};
        assertArrayEquals(expectedLinesCount, actualLinesCount);
    }
    
    @Test
    public void testTotalValue(){
        // Repeated methods call because order of execution is not guarantee in JUnit
        tfm.countIndividualKeywordsSum();
        tfm.countTotalKeywordsUsed();
        tfm.countLinesSum();
        tfm.countTotalValue();
        int[] actualTotalValue = tfm.getTotalValue();
        int[] expectedTotalValue = {23, 27};
        assertArrayEquals(expectedTotalValue, actualTotalValue);
    }
}