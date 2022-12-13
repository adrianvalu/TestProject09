package Tests.LegacyTests;

import com.siit.course.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class MyFirstTestNGTest {
    Calculator c;
    int count;

    @BeforeClass
    public void setUp() {
        c = new Calculator();
        System.out.println("SetUp on before class");
    }

    @BeforeTest
    public void setUpTest() {
        count = 0;
        System.out.println("SetUp on before test");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("SetUp on before method");
    }

    @Test(description = "This is first test", groups = {"Smoke", "Regression"})
    public void test1() {
        System.out.println("I am Test1");
    }

    @Test(enabled = true, groups = "Regression")
    public void test2() {
        System.out.println("I am Test2");
    }

    private void test3() {
        System.out.println("I am Test3");
    }

    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][]{
                {5, 2, 3, "+", 0},
                {10, -2, -5, "*", 0},
                {10, 20, 2, "/", 0},
                {1.4142, 2, 0, "SQRT", 0.0001}
        };
    }


    @Test(dataProvider = "calculatorDataProvider")
    public void verifyCalculatorTest(double expRes, double d1, double d2, String op, double delta) {
        System.out.println("Compute calculator assert with delta:" + delta + " for: " + d1 + " " + op + " " + d2 + "=" + expRes);
        Assert.assertEquals(expRes, c.compute(d1, d2, op), delta);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divisionExceptionTest() {
        c.compute(5, 0, "/");
    }

    @Test(invocationCount = 10)
    public void testMe() {
        count++;
        System.out.println("Current value for count:" + count);
    }

    @Test(groups = {"Smoke", "Regression"})
    public void login() {
        System.out.println("Login with user");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"aLogout"},
            alwaysRun = true, groups = {"Smoke", "Regression"})
    public void closeTabAtEnd() {
        System.out.println("close at end");
    }

    @Test(priority = 1, dependsOnMethods = {"login"}, groups = {"Smoke", "Regression"})
    public void aLogout() {
        System.out.println("log out");
    }

    @Test
    public void getParamsFromCmd() {
        String browser = System.getProperty("browser");
        System.out.println("Run tests with browser:" + browser);
        Assert.assertNotNull(browser);
        String env = System.getProperty("env");
        System.out.println("Run tests on env:" + env);
        Assert.assertNotNull(env);
    }

}