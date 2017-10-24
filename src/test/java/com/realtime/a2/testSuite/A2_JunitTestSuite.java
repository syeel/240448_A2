/* 
 * Semester: A171
 * Course: STIW3054
 * Group: A
 * Task: Assignment 1
 * Matric Num: 240448
 * Name: Lim Siang Yee
 *
 */

package com.realtime.a2.testSuite;

import com.realtime.a2.determineCourseMatric.*;
import com.realtime.a2.determineDirectory.*;
import com.realtime.a2.determineFile.*;
import com.realtime.a2.determineLines.*;
import com.realtime.a2.generateExcel.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   DirWorkerTest.class, FileWorkerTest.class, CourseWorkerTest.class, MatricWorkerTest.class, 
   UniqueMatricTest.class, ReadFilesTest.class, CalculateKeywordsTest.class, CalculateLinesTest.class,
   TotalForEachMatricTest.class, DataFormatterTest.class
})

public class A2_JunitTestSuite {
}