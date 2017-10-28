//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineDirectory;

public class DirWorker implements Runnable{
    
    private String relativePath, realPath;
    
    @Override
    public void run() {
        setPath();
    }
    
    public void setPath(){
        String fileSeperator = System.getProperty("file.separator");
        relativePath = System.getProperty("user.dir");

        realPath = relativePath + fileSeperator + "JAVAFILES"; 
    }
    
    public String getPath(){
        return realPath;
    }
    
    public String getRelativePath(){
        return relativePath;
    }
}