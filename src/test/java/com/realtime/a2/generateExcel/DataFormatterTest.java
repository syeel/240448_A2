/* 
 * Semester: A171
 * Course: STIW3054
 * Group: A
 * Task: Assignment 1
 * Matric Num: 240448
 * Name: Lim Siang Yee
 *
 */

package com.realtime.a2.generateExcel;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class DataFormatterTest {
    
    DataFormatter df;
    String[] keywords = {"abstract ", "assert", "boolean ", "break", 
        "byte ", "case", "catch", "char ", "class ", "const", "continue", "default", 
        "do", "double ", "else", "enum", "extends ", "false", "final ", "finally", 
        "float ", "for", "goto", "if", "implements", "import ", "instanceof", "int ", 
        "interface ", "long ", "native", "new ", "null", "package ", "private ", "protected ", 
        "public ", "return", "short ", "static ", "strictfp", "super ", "switch", "synchronized", 
        "this", "throw ", "throws ", "transient", "true", "try", "void ", "volatile", "while"};
    
    ArrayList<String> courseInfo = new ArrayList(Arrays.asList("A171", "STIW3054", "A", "Assignment1"));
    ArrayList<String> uniqueMatric = new ArrayList(Arrays.asList("898989", "123456"));
    int[][] totalLineCount = {{24,4,6,14}, {30,6,7,17}};
    int[][] totalKeywordsCount = {
        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}, 
        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}
    };
    int[] totalValue = {23, 27};
    
    @Before
    public void createObject(){
        df = new DataFormatter(keywords, courseInfo, uniqueMatric, totalLineCount, totalKeywordsCount, totalValue);
    }
    
    @Test
    public void testCourseSection(){
        df.setCourseSection();
        String expectedCourseInfo[][] = {
            {"Semester", "A171"},
            {"Course", "STIW3054"},
            {"Group", "A"},
            {"Task", "Assignment1"}
        };
        String actualCourseInfo[][] = df.getCourseInfo();
        assertArrayEquals(expectedCourseInfo, actualCourseInfo);
    }
    
    @Test
    public void testDescSection(){
        df.setDescSection();
        String[] expectedDesc = new String[keywords.length + 6];
        expectedDesc[0] = "Matric";
        expectedDesc[1] = "LOC";
        expectedDesc[2] = "Blank";
        expectedDesc[3] = "Comment";
        expectedDesc[4] = "Actual LOC";

        for (int i=5; i<(expectedDesc.length - 1); i++) {
            expectedDesc[i] = keywords[(i - 5)];
        }
        expectedDesc[58] = "Total";
        
        String[][] expectedDesc2 = {{}, {"", "", "", "", "", "java keyword"}, expectedDesc};
        String[][] actualDesc = df.getDescription();
        assertArrayEquals(expectedDesc2, actualDesc);
    }
    
    @Test
    public void testDataSection(){
        df.setDataSection();
        String[][] expectedData = new String[uniqueMatric.size()][keywords.length + 6];

        for (int i = 0; i < expectedData.length; i++) {
            expectedData[i][0] = uniqueMatric.get(i);
            expectedData[i][1] = Integer.toString(totalLineCount[i][0]); //LOC
            expectedData[i][2] = Integer.toString(totalLineCount[i][1]); //Blank
            expectedData[i][3] = Integer.toString(totalLineCount[i][2]); //Comment
            expectedData[i][4] = Integer.toString(totalLineCount[i][3]); //Actual LOC
            expectedData[i][58] = Integer.toString(totalValue[i]);
            
            for (int x=0; x<keywords.length; x++){
                expectedData[i][x+5] = Integer.toString(totalKeywordsCount[i][x]);
            }
        }
        String[][] actualData = df.getData();
        assertArrayEquals(expectedData, actualData);
    }
    
    @Test
    public void testExcelObject(){
        // Repeated codes to initialize course, description & data because JUnit doesnt support dependencies
        df.setCourseSection();
        df.setDescSection();
        df.setDataSection();
        df.generateObject();

        String course[][] = {
            {"Semester", "A171"},
            {"Course", "STIW3054"},
            {"Group", "A"},
            {"Task", "Assignment1"}
        };
        
        String[] desc = new String[keywords.length + 6];
        desc[0] = "Matric";
        desc[1] = "LOC";
        desc[2] = "Blank";
        desc[3] = "Comment";
        desc[4] = "Actual LOC";
        for (int i=5; i<(desc.length - 1); i++) {
            desc[i] = keywords[(i - 5)];
        }
        desc[58] = "Total";
        String[][] description = {{}, {"", "", "", "", "", "java keyword"}, desc};
        
        String[][] data = new String[uniqueMatric.size()][keywords.length + 6];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = uniqueMatric.get(i);
            data[i][1] = Integer.toString(totalLineCount[i][0]); //LOC
            data[i][2] = Integer.toString(totalLineCount[i][1]); //Blank
            data[i][3] = Integer.toString(totalLineCount[i][2]); //Comment
            data[i][4] = Integer.toString(totalLineCount[i][3]); //Actual LOC
            data[i][58] = Integer.toString(totalValue[i]);
            for (int x=0; x<keywords.length; x++){
                data[i][x+5] = Integer.toString(totalKeywordsCount[i][x]);
            }
        }
        
        String[][] expectedObject = new String[course.length + description.length + data.length][];
        int i = 0;
        
        for (; i < course.length; i++) {
            expectedObject[i] = new String[course[i].length];
            for (int x = 0; x < course[i].length; x++) {
                expectedObject[i][x] = course[i][x];
            }
        }

        for (int x = 0; x < description.length; x++) {
            expectedObject[i] = description[x];
            i++;
        }

        for (int x = 0; x < data.length; x++) {
            expectedObject[i] = data[x];
            i++;
        }
        String[][] actualObject = df.getObjectStore();
        assertArrayEquals(expectedObject, actualObject);
    }    
}
