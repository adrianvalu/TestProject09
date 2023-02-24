package Tests;

import ObjectModels.LoginModel;
import ObjectModels.RegistrationModel;
import org.testng.annotations.Test;

public class DataTests extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "jsonDp", description = "verify register negative scenarios")
    public void registerWithJsonNegativeTest(RegistrationModel rm) {
        printDataRegistration(rm);
        registerActions(rm);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "SQLdp", description = "verify login negative scenarios")
    public void loginWithDBNegativeTest(LoginModel lm) {
        printDataLogin(lm);
        loginActions(lm);
    }
}
