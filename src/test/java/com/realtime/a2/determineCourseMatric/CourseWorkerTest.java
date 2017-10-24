/* 
 * Semester: A171
 * Course: STIW3054
 * Group: A
 * Task: Assignment 1
 * Matric Num: 240448
 * Name: Lim Siang Yee
 *
 */

package com.realtime.a2.determineCourseMatric;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CourseWorkerTest {
    
    String directory;
    ArrayList<String> correctFileNames;
    
    @Before
    public void setupDirAndFiles(){
        directory = Paths.get("").toAbsolutePath().toString() + "\\" + "JAVAFILES";
        correctFileNames = new ArrayList(Arrays.asList("MyThread1.java", "MyThread2.java"));
    }
    
    @Test
    public void testCorrectCourseInfo(){
        CourseWorker cw = new CourseWorker(directory, correctFileNames);
        cw.readCourseInfo(directory, correctFileNames);
        
        ArrayList<String> expectedCourseInfo = new ArrayList(Arrays.asList("A171", "STIW3054", "A", "Assignment1"));
        ArrayList<String> actualCourseInfo = cw.getCourseInfo();
        assertEquals(expectedCourseInfo, actualCourseInfo);
    }  
}
