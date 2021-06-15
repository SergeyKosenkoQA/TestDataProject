package banksuite.customer.testcases;

import org.testng.annotations.Test;
import utils.DataProviders;

import java.util.Hashtable;

public class AddCustomerTest {

    @Test(dataProviderClass= DataProviders.class,dataProvider="customerDP")
    public void addCustomerTest(Hashtable<String, String> data) {
    }
}

