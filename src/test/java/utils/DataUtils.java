package utils;

import org.testng.annotations.DataProvider;

import java.util.Hashtable;

public class DataUtils {

    public static boolean isSuiteRunnable(String suiteName, ExcelReader excel) {
       int rows = excel.getRowCount(Constants.SUITE_SHEET);
       for(int rowNum=2; rowNum<=rows; rowNum++) {
          String data = excel.getCellData(Constants.SUITE_SHEET,Constants.SUITENAME_COL,rowNum);
          if(data.equalsIgnoreCase(suiteName)) {
              String runMode = excel.getCellData(Constants.SUITE_SHEET,Constants.RUNMODE_COL,rowNum);
              return runMode.equalsIgnoreCase(Constants.RUNMODE_YES);
          }
       }
        return false;
    }
    public static boolean isTestRunnable(String testCaseName, ExcelReader excel) {
        int rows = excel.getRowCount(Constants.TESTCASE_SHEET);
        for(int rowNum=2; rowNum<=rows; rowNum++) {
            String data = excel.getCellData(Constants.TESTCASE_SHEET,Constants.TESTCASE_COL,rowNum);
            if(data.equalsIgnoreCase(testCaseName)) {
                String runMode = excel.getCellData(Constants.TESTCASE_SHEET,Constants.RUNMODE_COL,rowNum);
                return runMode.equalsIgnoreCase(Constants.RUNMODE_YES);
            }
        }
        return false;

    }

    // Common data provider for tests
    @DataProvider
    public static Object[][] getData(String testCase, ExcelReader excel) {

        int rows = excel.getRowCount(Constants.DATA_SHEET);
        System.out.println("Total rows are: " + rows);

        String testName = testCase;
        //Find Test Case start row
        int testCaseRowNum = 1;

        for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
            String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
            if (testCaseName.equalsIgnoreCase(testName)) break;


        }
        System.out.println("Test case starts from row num: " + testCaseRowNum);

        //Checking total rows in test case
        int dataStartRowNum = testCaseRowNum + 2;

        int testRows = 0;
        //While data is not empty, check next line
        while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
            testRows++;
        }
        System.out.println("Total rows of data " + testRows);

        //Checking total clos in test case
        int colStartColNum = testCaseRowNum + 1;
        int testCols = 0;
        while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {
            testCols++;
        }
        System.out.println("Total cols are: " + testCols);


        // Printing data

        Object[][] data = new Object[testRows][1];

        int i=0;
        for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

            Hashtable<String,String> table = new Hashtable<String,String>();

            for (int cNum = 0; cNum < testCols; cNum++) {

                //System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
                String testData = excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
                String colName = excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);

                table.put(colName, testData);

            }

            data[i][0] = table;
            i++;

        }

        return data;
    }
}
