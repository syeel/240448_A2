//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class ReadFilesTest {
    
    String directory;
    ArrayList<String> correctFileNames;
    
    @Before
    public void setupDirAndFiles(){
        directory = Paths.get("").toAbsolutePath().toString() + "\\" + "JAVAFILES";
        correctFileNames = new ArrayList(Arrays.asList("MyThread1.java", "MyThread2.java"));
    }
    
    @Test
    public void testFilesContent(){
        int dot, javaFileCount=0;
        String filePath, extention;
        ArrayList<String> fileData = new ArrayList<>();
        String[][] expectedFilesContent = new String[correctFileNames.size()][];;
        String[][] actualFilesContent = null;
        
        ReadFiles rf = new ReadFiles(directory, correctFileNames);
        rf.readFileContent();
        actualFilesContent = rf.getFilesContent();

        for (int i=0; i<correctFileNames.size(); i++){
            fileData.clear();
            dot = correctFileNames.get(i).lastIndexOf(".");
            extention = correctFileNames.get(i).substring(dot + 1);
            
            if ("java".equals(extention)){
                
                filePath = directory + "\\" +correctFileNames.get(i);
            
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        fileData.add(sCurrentLine);
                    }

                    expectedFilesContent[javaFileCount] = new String[fileData.size()];
                    for (int x = 0; x < fileData.size(); x++){
                        expectedFilesContent[javaFileCount][x] = fileData.get(x);
                    }             
                    
                }catch (IOException e) {
                    System.out.println("Error, file cannot be read.");
                }
                javaFileCount++;
            }       
        }
        assertArrayEquals(expectedFilesContent, actualFilesContent);
    }  
}
