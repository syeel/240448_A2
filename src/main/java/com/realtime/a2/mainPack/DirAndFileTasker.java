//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.mainPack;

import com.realtime.a2.determineDirectory.DirWorker;
import com.realtime.a2.determineFile.FileWorker;
import java.io.File;
import java.util.ArrayList;

public class DirAndFileTasker {
    
    private String directory, relativePath;
    private ArrayList<String> fileNames;
    
    public void tasksForDirAndFile() throws InterruptedException{
        DirWorker dir = new DirWorker();
        Thread dir1 = new Thread(dir);
        dir1.start();
        dir1.join();
        directory = dir.getPath();
        relativePath = dir.getRelativePath();
        
        final File folder = new File(directory);
        
        FileWorker ftw = new FileWorker(folder);
        Thread ftw1 = new Thread(ftw);
        ftw1.start();
        ftw1.join();
        fileNames = ftw.getFileName();
    }
    
    public String getDirectory(){
        return directory;
    }
    
    public String getRelativePath(){
        return relativePath;
    }
    
    public ArrayList<String> getFileNames(){
        return fileNames;
    }
}
