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

public class MatricWorker implements Runnable{
    
    private final ArrayList<String> fNames;
    private final String dir;
    private ArrayList<String> matricNum = new ArrayList<>();
    
    public MatricWorker (String directory, ArrayList<String> fileNames){
        this.dir = directory;
        this.fNames = fileNames;
    }
    
    @Override
    public void run() {
        readMatricInfo(dir, fNames);
    }
    
    public void readMatricInfo(String directory, ArrayList<String> fileNames){
        
        int dot, hash;
        String filePath, extention, matric;
        
        for (int i=0; i<fileNames.size(); i++){
            dot = fileNames.get(i).lastIndexOf(".");
            extention = fileNames.get(i).substring(dot + 1);
            
            if ("java".equals(extention)){
                filePath = directory + "\\" +fileNames.get(i);
            
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String sCurrentLine;
                    for (int x=0; x<5; x++){
                        if(((sCurrentLine = br.readLine()) != null)){
                            if(sCurrentLine.trim().length() > 0){
                                hash = sCurrentLine.lastIndexOf("#");
                                matric = sCurrentLine.substring(hash + 1);
                                
                                if (x == 4){
                                   matricNum.add(matric); 
                                }
                                
                            } 
                        }
                    }
                }catch (IOException e) {
                    System.out.println("Error, file cannot be read.");
                } 
            }       
        }
    }
    
    public ArrayList<String> getMatricNum(){
        return matricNum;
    }  
}
