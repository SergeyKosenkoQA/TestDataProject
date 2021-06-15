package banksuite.bankmanager.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;
import utils.DataProviders;
import utils.DataUtils;
import utils.ExcelReader;

import java.util.Hashtable;

public class AddCustomerTest {

    @Test(dataProviderClass= DataProviders.class,dataProvider="customerDP")
    public void addCustomerTest(Hashtable<String, String> data) {
    }
}

