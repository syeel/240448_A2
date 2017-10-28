//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineCourseMatric;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MatricWorkerTest {
    
    String directory;
    ArrayList<String> correctFileNames;
    
    @Before
    public void setupDirAndFiles(){
        directory = System.getProperty("user.dir") + System.getProperty("file.separator") + "JAVAFILES";
        correctFileNames = new ArrayList(Arrays.asList("MyThread1.java", "MyThread2.java"));
    }
    
    @Test
    public void testCorrectMatricNum(){
        MatricWorker mw = new MatricWorker(directory, correctFileNames);
        mw.readMatricInfo(directory, correctFileNames);
        
        ArrayList<String> expectedMatricNum = new ArrayList(Arrays.asList("898989", "123456"));
        ArrayList<String> actualMatricNum = mw.getMatricNum();
        assertEquals(expectedMatricNum, actualMatricNum);
    }  
}
