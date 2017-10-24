//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineDirectory;

import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DirWorkerTest {
    
    @Test
    public void testRealPath(){
        //Real path = relative path + \JAVAFILES
        DirWorker dw = new DirWorker();
        dw.setPath();
        
        String expectedPath = Paths.get("").toAbsolutePath().toString() + "\\" + "JAVAFILES";
        String actualPath = dw.getPath();
        assertEquals(expectedPath, actualPath);
    } 
}
