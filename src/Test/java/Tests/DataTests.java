package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import ObjectModels.LoginModel;
import ObjectModels.RegistrationModel;
import Utils.ExtentTestManager;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataTests extends BaseTest {

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here is starting deserialization of json into RegistrationModel object
        ObjectMapper objectMapper = new ObjectMapper();

        File f = new File("src\\test\\java\\resources\\data\\testdatanelbo.json");
        RegistrationModel[] lms = objectMapper.readValue(f, RegistrationModel[].class);

        for (RegistrationModel rm : lms)
            dp.add(new Object[]{rm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp", description = "verify register negative scenarios")
    public void registerWithJsonNegativeTest(RegistrationModel rm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify register negative scenarios");
        printDataRegistration(rm);
        registerActions(rm);
    }

    private void printDataRegistration(RegistrationModel rm) {
        System.out.println(rm);
    }

    private void registerActions(RegistrationModel rm) {
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.hoverButtonInteract();
        mp.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertEquals(registrationPage.getRegistrationPageText(), "Creați Cont client nou");

        registrationPage.register(rm.getAccountRegister().getFirstName(), rm.getAccountRegister().getLastName(), rm.getAccountRegister().getUsername(), rm.getAccountRegister().getPassword(), rm.getAccountRegister().getConfirmPassword());

        String expectedFirstNameErr = rm.getFirstNameError();
        String expectedLastNameErr = rm.getLastNameError();
        String expectedUsernameErr = rm.getUserError();
        String expectedPassErr = rm.getPasswordError();
        String expectedConfirmPassErr = rm.getConfirmPasswordError();

        System.out.println("Verify expected errors present:\nExpected firstnameError:" + expectedFirstNameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedFirstNameErr, "firstNameErr"));

        System.out.println("Expected lastnameError:" + expectedLastNameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedLastNameErr, "lastNameErr"));

        System.out.println("Expected usernameError:" + expectedUsernameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected passwordError:" + expectedPassErr);
        Assert.assertTrue(registrationPage.checkErr(expectedPassErr, "passErr"));

        System.out.println("Expected confirmedPasswordError:" + expectedConfirmPassErr);
        Assert.assertTrue(registrationPage.checkErr(expectedConfirmPassErr, "confirmPassErr"));
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

    @Test(dataProvider = "SQLdp", description = "verify login negative scenarios")
    public void loginWithDBNegativeTest(LoginModel lm, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify login negative scenarios");
        printDataLogin(lm);
        loginActions(lm);
    }

    private void printDataLogin(LoginModel lm) {
        System.out.println(lm);
    }

    private void loginActions(LoginModel lm) {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginPageText(), "Conectare client");
//         login
        loginPage.loginDataInput(lm.getAccount().getUsername(), lm.getAccount().getPassword());

        String expectedUsernameErr = lm.getUserError();
        String expectedPassErr = lm.getPasswordError();

        System.out.println("Verify expected errors present:\nExpected usernameError:" + expectedUsernameErr);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(loginPage.checkErr(expectedPassErr, "passErr"));
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }
}
