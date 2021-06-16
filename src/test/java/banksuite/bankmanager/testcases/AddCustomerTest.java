package banksuite.bankmanager.testcases;

import org.jsoup.helper.DataUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;
import utils.DataProviders;
import utils.DataUtils;
import utils.ExcelReader;

import java.util.Hashtable;

public class AddCustomerTest {

    @Test(dataProviderClass = DataProviders.class,dataProvider="customerDP")
    public void addCustomerTest(Hashtable<String, String> data) {

        ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);

        DataUtils.checkExecution("BankManagerSuite","AddCustomerTest", data.get("Runmode"), excel);

//        //Testing if suite if runnable
//        System.out.println("Suite" + DataUtils.isSuiteRunnable("BankManagerSuite"));
//        //Testing if testcase is runnable
//        System.out.println("testCase" + DataUtils.isTestRunnable("AddCustomerTest"));
//        System.out.println("Run mode for data:" + data.get("Runmode"));
    }
}

