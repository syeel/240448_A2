//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineCourseMatric;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseWorker implements Runnable{
    
    private final ArrayList<String> fNames;
    private final String dir;
    private ArrayList<String> courseInfo = new ArrayList<>();
    
    public CourseWorker (String directory, ArrayList<String> fileNames){
        this.dir = directory;
        this.fNames = fileNames;
    }
    
    @Override
    public void run() {
        readCourseInfo(dir, fNames);
    }
    
    public void readCourseInfo(String directory, ArrayList<String> fileNames){
        
        int dot, hash;
        String fileSeperator = System.getProperty("file.separator");
        String filePath, extention, info;
        
        for (int i=0; i<1; i++){
            dot = fileNames.get(i).lastIndexOf(".");
            extention = fileNames.get(i).substring(dot + 1);
            
            if ("java".equals(extention)){
                filePath = directory + fileSeperator +fileNames.get(i);
            
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String sCurrentLine;
                    for (int x=0; x<4; x++){
                        if(((sCurrentLine = br.readLine()) != null)){
                            if(sCurrentLine.trim().length() > 0){
                                hash = sCurrentLine.lastIndexOf("#");
                                info = sCurrentLine.substring(hash + 1);
                                courseInfo.add(info);
                            } 
                        }
                    }
                }catch (IOException e) {
                    System.out.println("Error, file cannot be read.");
                } 
            }       
        }
    }
    
    public ArrayList<String> getCourseInfo(){
        return courseInfo;
    } 
}
