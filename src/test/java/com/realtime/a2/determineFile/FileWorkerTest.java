//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FileWorkerTest {
    
    String directory;
    File folder;
   
    @Before
    public void setupDirAndFile(){
        directory = System.getProperty("user.dir") + System.getProperty("file.separator") + "JAVAFILES";
        folder = new File(directory);
    }
    
    @Test
    public void testCorrectFileNames(){
        FileWorker fw = new FileWorker(folder);
        fw.setFileName(folder);
        
        ArrayList<String> expectedFileNames = new ArrayList(Arrays.asList("MyThread1.java", "MyThread2.java"));
        ArrayList<String> actualFileNames = fw.getFileName();
        assertEquals(expectedFileNames, actualFileNames);
    } 
}
