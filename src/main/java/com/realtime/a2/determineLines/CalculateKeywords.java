//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.determineLines;

public class CalculateKeywords {
    
    private String[][] allFilesContent;
    private int[][] keywordsCount;
    public final String KEYWORDS[] = {"abstract ", "assert", "boolean ", "break", 
        "byte ", "case", "catch", "char ", "class ", "const", "continue", "default", 
        "do", "double ", "else", "enum", "extends ", "false", "final ", "finally", 
        "float ", "for", "goto", "if", "implements", "import ", "instanceof", "int ", 
        "interface ", "long ", "native", "new ", "null", "package ", "private ", "protected ", 
        "public ", "return", "short ", "static ", "strictfp", "super ", "switch", "synchronized", 
        "this", "throw ", "throws ", "transient", "true", "try", "void ", "volatile", "while"}; //53 keywords
    
    public CalculateKeywords(String[][] allFilesContent){
        this.allFilesContent = allFilesContent;
        this.keywordsCount = new int[allFilesContent.length][KEYWORDS.length];
    }
    
    public void countKeywords(){
        String tempString="", key="";
        for (int i = 0; i < allFilesContent.length; i++) { //Num of files
            for (int x = 0; x < allFilesContent[i].length; x++) { // Num of rows in file i
                tempString = allFilesContent[i][x];
                
                for (int k = 0; k < KEYWORDS.length; k++) {
                    key = KEYWORDS[k];
                    
                    if (tempString.contains(key)) {
                        keywordsCount[i][k]++;
                    }
                }
            }
        }
    }
    
    public int[][] getKeywordsCount(){
        return keywordsCount;
    }
    
    public String[] getKeywords(){
        return KEYWORDS;
    }
}
