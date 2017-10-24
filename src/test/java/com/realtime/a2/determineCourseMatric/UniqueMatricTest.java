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
import org.junit.Test;

public class UniqueMatricTest {
    
    @Test
    public void testCorrectUniqueMatricNum(){
        ArrayList<String> matricNum = new ArrayList(Arrays.asList("898989", "123456", "898989", "898989", "123456"));
        UniqueMatric um = new UniqueMatric(matricNum);
        um.findUniqueMatric();
        
        ArrayList<String> expectedUniqueMatric = new ArrayList(Arrays.asList("898989", "123456"));
        ArrayList<String> actualUniqueMatric = um.getUniqueMatric();
        assertEquals(expectedUniqueMatric, actualUniqueMatric);
    }    
}
