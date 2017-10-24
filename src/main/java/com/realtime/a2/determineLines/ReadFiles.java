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
import java.util.ArrayList;

public class ReadFiles {
    
    private final ArrayList<String> fNames;
    private final String dir;
    private ArrayList<String> fileData = new ArrayList<>();
    private String[][] allFilesContent;
    
    public ReadFiles (String directory, ArrayList<String> fileNames){
        this.dir = directory;
        this.fNames = fileNames;
        this.allFilesContent = new String[fNames.size()][];
    }

    public void readFileContent(){    
        int dot, javaFileCount=0;
        String filePath, extention;

        for (int i=0; i<fNames.size(); i++){
            fileData.clear();
            dot = fNames.get(i).lastIndexOf(".");
            extention = fNames.get(i).substring(dot + 1);
            
            if ("java".equals(extention)){
                
                filePath = dir + "\\" +fNames.get(i);
            
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        fileData.add(sCurrentLine);
                    }

                    allFilesContent[javaFileCount] = new String[fileData.size()];
                    for (int x = 0; x < fileData.size(); x++){
                        allFilesContent[javaFileCount][x] = fileData.get(x);
                    }             
                    
                }catch (IOException e) {
                    System.out.println("Error, file cannot be read.");
                }
                javaFileCount++;
            }       
        }
        //----- Remove Comment to check for files' content
        /*for (int i=0; i<allFilesContent.length; i++){
            System.out.println();
            System.out.println("Accessing file: " +(i+1));
            for (int x=0; x<allFilesContent[i].length; x++){
                System.out.println(allFilesContent[i][x]);
            }  
        }*/     
    }
    
    public String[][] getFilesContent(){
        return allFilesContent;
    }
}
