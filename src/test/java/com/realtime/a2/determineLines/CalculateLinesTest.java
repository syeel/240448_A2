//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculateLinesTest {
    
    String[][] allFilesContent;
    
    @Before
    public void readAllFiles(){
        String directory = Paths.get("").toAbsolutePath().toString() + "\\" + "JAVAFILES";
        ArrayList<String> correctFileNames = new ArrayList(Arrays.asList("MyThread1.java", "MyThread2.java"));
        ReadFiles rf = new ReadFiles(directory, correctFileNames);
        rf.readFileContent();
        allFilesContent = rf.getFilesContent(); 
    }
    
    @Test
    public void testCorrectLineCounts(){
        CalculateLines cl = new CalculateLines(allFilesContent);
        cl.calcLineCounts();
        int[][] expectedLineCounts = {{24,4,6,14}, {30,6,7,17}};
        //[0][0]=LOC, [0][1]=Blank, [0][2]=Comment, [0][3]=Actual LOC
        int[][] actualLineCounts = cl.getLineCounts();
        assertArrayEquals(expectedLineCounts, actualLineCounts);  
    } 
}
