package rough;

import utils.ExcelReader;
import utils.DataUtils;

public class CheckingRunmode {
    public static void main(String[] args) {
        String suiteName = "BankManagerSuite";
        boolean suiteRunMode = DataUtils.isSuiteRunnable(suiteName);
        System.out.println(suiteRunMode);

        String testCaseName = "OpenAccount";
        boolean testRunMode = DataUtils.isTestRunnable(testCaseName, new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/testdata/"+suiteName+".xlsx"));
        System.out.println(testRunMode);
    }
}
