//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DirWorker implements Runnable{
    
    private String relativePath, realPath;
    
    @Override
    public void run() {
        setPath();
    }
    
    public void setPath(){
        Path currentRelativePath = Paths.get("");
        relativePath = currentRelativePath.toAbsolutePath().toString();
        realPath = relativePath + "\\" + "JAVAFILES"; 
    }
    
    public String getPath(){
        return realPath;
    }
    
    public String getRelativePath(){
        return relativePath;
    }
}