//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240448
//Name: #Lim Siang Yee

package com.realtime.a2.generateExcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ApachePOIWriter {
    
    private final String FILENAME = "Evaluation_Results.xlsx";
    private String[][] objectStore;
    private String path;
    
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    
    public ApachePOIWriter(String path, String[][] objectStore){
        this.objectStore = objectStore;
        this.path = path;
        
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Results");
    }
    
    public void initializeExcel(){
        int rowNum = 0;
        System.out.println("Creating " +FILENAME +" at " +path);

        for (Object[] datatype : objectStore) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    }
    
    public void writeToExcel(){
        try {
            FileOutputStream outputStream = new FileOutputStream(FILENAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully write to " +FILENAME);
    } 
}
