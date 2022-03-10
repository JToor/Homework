package com.junglesocks.config;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public Object[][] getRowsDataInMaps(String FileName, String Sheet, Method method) {
        Object[][] ob = null;
        try {
            List<Map<String, String>> sheetDataInMaps = getSheetDataInMaps(FileName, Sheet);
            ob = new Object[sheetDataInMaps.size()][1];
            for(int j =0; j<sheetDataInMaps.size(); j++) {
                ob[j][0] = sheetDataInMaps.get(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    public List<Map<String, String>> getSheetDataInMaps(String filePath, String sheetName) {
        FileInputStream file = null;
        Workbook workbook = null;
        Sheet sheet = null;
        List<Map<String, String>> mapsList = new ArrayList<Map<String,String>>();
        try {
            file = new FileInputStream(new File(filePath));
            workbook = new HSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);


            Map<String, String> map = null;
            int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                map = new LinkedHashMap<>();

                for (int j = 0; j < colcount; j++) {
                    String header = new DataFormatter().formatCellValue(sheet.getRow(0).getCell(j));
                    String value = new DataFormatter().formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(header, value);
                }
                mapsList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapsList;

    }
}
