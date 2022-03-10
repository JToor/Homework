package com.junglesocks.config;

import java.io.File;
import java.lang.reflect.Method;

import com.junglesocks.tests.BaseTest;
import org.testng.annotations.DataProvider;

public class DataProviderHelper extends BaseTest {

    protected String classPathRoot = new File(System.getProperty("user.dir")).getAbsolutePath();
    private final ExcelReader excelReader= new ExcelReader();

    @DataProvider(name = "testData", parallel = false)
    public Object[][] testData(Method m) {
        final String FILE_NAME = classPathRoot + File.separator + "testData" + File.separator + "TestData.xls";
        final String FILE_SHEET = "JungleSocks";
        return excelReader.getRowsDataInMaps(FILE_NAME, FILE_SHEET,m);
    }
}
