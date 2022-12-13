package Tests.LegacyTests;

import org.testng.annotations.Test;

public class ClassActivityTest {
    @Test(groups = {"print"})
    public void displayTest2() {
        display("Method test 2");
    }

    @Test(groups = {"print"}, enabled = false)
    public void displayTest1() {
        display("Method test 1");
    }

    private void display(String parameter) {
        System.out.println(parameter);
    }
}