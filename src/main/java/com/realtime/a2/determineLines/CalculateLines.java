//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

public class CalculateLines {

    private int[][] lineCount;
    private String[][] allFilesContent;
    
    public CalculateLines(String [][] allFilesContent){
        this.allFilesContent = allFilesContent;
        
        lineCount = new int[allFilesContent.length][4];
        //lineCount[0][0]=LOC, lineCount[0][1]=Blank
        //lineCount[0][2]=Comment, lineCount[0][3]=Actual LOC
    }
    
    public void calcLineCounts(){
        int loc, blank, comment;
        boolean checkCommentAtFront;
        String subStr = "//";
        
        for (int i=0; i<allFilesContent.length; i++){ //accessing file number i 
            loc = 0; blank = 0; comment = 0;
            for (int x=0; x<allFilesContent[i].length; x++){///accessing line number x in file number i
                // Counting LOC
                loc++;
                
                // Counting blank lines
                if(allFilesContent[i][x].trim().length() == 0 || allFilesContent[i][x] == null){
                    blank++;
                }
                
                // Counting comment lines
                checkCommentAtFront = false;
                if(allFilesContent[i][x].contains("//")){
                    String tempString = allFilesContent[i][x];
                    String beforeSubStr = tempString.substring(0, tempString.indexOf(subStr));
                    
                    // Will ignore line as comment if comment starts after a java statement
                    if(beforeSubStr.trim().length() == 0){
                        checkCommentAtFront = true;
                        comment++;
                    }
                }
            }
            lineCount[i][0] = loc;
            lineCount[i][1] = blank;
            lineCount[i][2] = comment;
        }
        
        int tLoc=0, tBlank=0, tComment=0, actual=0;
        for (int i=0; i<allFilesContent.length; i++){ //accessing file number i
            loc = 0;
            for (int x=0; x<4; x++){ ///accessing line number x in file number i
                switch (x) {
                    case 0:
                        tLoc = lineCount[i][x];
                        break;
                    case 1:
                        tBlank = lineCount[i][x];
                        break;
                    case 2:
                        tComment = lineCount[i][x];
                        break;     
                    default:
                        actual = tLoc - (tBlank + tComment);
                        lineCount[i][3] = actual;
                        break;
                }
            }
        } 
    }
    
    public int[][] getLineCounts(){
        return lineCount;
    } 
}
