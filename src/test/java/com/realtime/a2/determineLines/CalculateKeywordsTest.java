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

public class CalculateKeywordsTest {
    
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
    public void testCorrectIndividualKeywordCount(){
        CalculateKeywords ck = new CalculateKeywords(allFilesContent);
        ck.countKeywords();
        
        int[][] expectedKeywordsCount = {
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}, 
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,1,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,2,0,0}
        };
        int[][] actualKeywordsCount = ck.getKeywordsCount();
        
        assertArrayEquals(expectedKeywordsCount, actualKeywordsCount);   
    }  
}
