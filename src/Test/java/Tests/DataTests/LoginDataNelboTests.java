package Tests.DataTests;

import Pages.Nelbo.LoginPage;
import Tests.ObjectModels.LoginModel;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataNelboTests extends BaseTest {

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File("src\\test\\java\\resources\\data\\testdatanelbo.json");
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void loginWithJsonTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }

    private void printData(LoginModel lm) {
//        System.out.println("Account:username" + lm.getAccount().getUsername()
//                + "/password:" + lm.getAccount().getPassword());
//        System.out.println("User error:" + lm.getUserError());
//        System.out.println("Password error:" + lm.getPasswordError());
        System.out.println(lm);
    }

    private void loginActions(LoginModel lm) {

        LoginPage loginPage = new LoginPage(driver);

//       open login page
        System.out.println("Open Login page");
        driver.get(baseUrl + "/customer/account/login/referer/aHR0cHM6Ly9uZWxiby5yby8%2C/");

//         login
        loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword());
        System.out.println("Login button was pressed");

        String expectedUsernameErr = lm.getUserError();
        String expectedPassErr = lm.getPasswordError();

        System.out.println("Verify expected errors present:\n expected userError:" + expectedUsernameErr);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(loginPage.checkErr(expectedPassErr, "passErr"));
    }

    @DataProvider(name = "SQLdp")
    public Iterator<Object[]> SQLDpCollection() {
        //        get DB connection settings
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbPassword:" + dbPassword);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negative");
            while (resultSet.next()) {
                LoginModel lm = new LoginModel(getEscapedElement(resultSet, "username"),
                        getEscapedElement(resultSet, "password"),
                        getEscapedElement(resultSet, "usernameErr"),
                        getEscapedElement(resultSet, "passErr"));
                dp.add(new Object[]{lm});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dp.iterator();
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @Test(dataProvider = "SQLdp")
    public void loginWithDBTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }

}
