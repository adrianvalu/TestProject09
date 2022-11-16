import com.siit.course.Calculator;
import org.junit.*;

public class CalculatorTest {

    Calculator c = new Calculator();

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void beforeTest() {

    }

    @Test
    public void additionTest() {
//        Assert.assertEquals("2+3 should be 5 !", 5, c.compute(2,3,"+"));
        Assert.assertEquals(5, c.compute(2,3,"+"), 0);
        Assert.assertEquals(5, c.compute(5, 0, "+"), 0);
        Assert.assertEquals(100, c.compute(200, -100, "+"), 0);

    }

    @Test
    public void substractionTest(){
        Assert.assertEquals(0, c.compute(5, 5, "-"), 0);
        Assert.assertEquals(100, c.compute(200, 100, "-"), 0);
        Assert.assertEquals(10, c.compute(5, -5, "-"),0);
    }

    @Test
    public void multiplicationTest() {
        Assert.assertEquals(625, c.compute(25, 25, "*"), 0);
        Assert.assertEquals(15.5, c.compute(2.5, 6.2,"*"), 0);
        Assert.assertEquals(0, c.compute(0, 8, "*"), 0);
        Assert.assertEquals(-6, c.compute(2, -3, "*"), 0);
        Assert.assertEquals(10, c.compute(-2, -5, "*"), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionExceptionTest(){
        c.compute(5, 0 , "/");
    }

    @Test
    public void divisionTest() {
        Assert.assertEquals(10, c.compute(20,2,"/"),0);
        Assert.assertEquals(1.66, c.compute(5,3,"/"), 0.01);
        Assert.assertEquals(25, c.compute(5, 0.2, "/"), 0);
        Assert.assertEquals(0, c.compute(0, 100, "/"),0);
        Assert.assertEquals(0.6, c.compute(3, 5, "/"),0);
    }

    @Test
    public void sqrtTest(){
        Assert.assertEquals(25, c.compute(625, 0, "SQRT"),0);
        Assert.assertEquals(1.4142, c.compute(2, 0, "SQRT"), 0.0001);
        Assert.assertTrue(Double.isNaN(c.compute(-625, 0, "SQRT")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionOperatorTest() {
        c.compute(0,0,"abc123");
    }

    @After
    public void afterTest(){

    }

    @AfterClass
    public static void afterClass(){

    }

}