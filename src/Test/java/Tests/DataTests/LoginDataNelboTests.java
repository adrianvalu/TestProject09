package Tests.DataTests;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import Pages.Nelbo.RegistrationPage;
import Tests.ObjectModels.LoginModel;
import Tests.ObjectModels.RegistrationModel;
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

        File f = new File("src\\test\\java\\resources\\data\\testdatanelbo3.json");
        RegistrationModel[] lms = objectMapper.readValue(f, RegistrationModel[].class);

        for (RegistrationModel rm : lms)
            dp.add(new Object[]{rm});

        return dp.iterator();
    }



    private void printData(LoginModel lm) {
        System.out.println(lm);
    }
    private void printData2(RegistrationModel rm) {
        System.out.println(rm);
    }

    private void loginActions(LoginModel lm) {

        driver.get(baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getControlereText(), "Controlere");
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginPageText(), "Conectare client");
//         login
        loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword());

        String expectedUsernameErr = lm.getUserError();
        String expectedPassErr = lm.getPasswordError();

        //System.out.println("Verify expected errors present:\n expected userError:" + expectedUsernameErr);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameErr, "userErr"));

        //System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(loginPage.checkErr(expectedPassErr, "passErr"));
    }

    private void registerActions(RegistrationModel rm) {
        driver.get(baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getControlereText(), "Controlere");
        mp.hoverButtonInteract();
        mp.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertEquals(registrationPage.getRegistrationPageText(), "Creați Cont client nou");

//         login
        registrationPage.register(rm.getAccountRegister().getFirstName(), rm.getAccountRegister().getLastName(), rm.getAccountRegister().getUsername(), rm.getAccountRegister().getPassword(), rm.getAccountRegister().getConfirmPassword());

        String expectedFirstNameErr = rm.getFirstNameError();
        String expectedLastNameErr = rm.getLastNameError();
        String expectedUsernameErr = rm.getUserError();
        String expectedPassErr = rm.getPasswordError();
        String expectedConfirmPassErr = rm.getConfirmPasswordError();

        Assert.assertTrue(registrationPage.checkErr(expectedFirstNameErr, "firstNameErr"));
        Assert.assertTrue(registrationPage.checkErr(expectedLastNameErr, "lastNameErr"));

        //System.out.println("Verify expected errors present:\n expected userError:" + expectedUsernameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedUsernameErr, "userErr"));

        //System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(registrationPage.checkErr(expectedPassErr, "passErr"));
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

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @Test(dataProvider = "jsonDp")
    public void registerWithJsonTest(RegistrationModel rm) {
        printData2(rm);
        registerActions(rm);
    }
    @Test(dataProvider = "SQLdp")
    public void loginWithDBTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }

}
