package banksuite.bankmanager.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;
import utils.DataProviders;
import utils.DataUtils;
import utils.ExcelReader;

import java.util.Hashtable;

public class OpenAccountTest {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
    public void openAccountTest(Hashtable<String, String> data) {

    }


}

