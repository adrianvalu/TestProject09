import com.siit.course.Circle;
import com.siit.course.Person;
import com.siit.course.Rectangle;
import com.siit.course.Square;
import org.junit.*;

public class Course07Test {

    @BeforeClass
    public static void beforeAll(){
        System.out.println("This will run only once before all tests in the class!!");
    }

    @Before
    public void beforeTest() {
        System.out.println("THis will run before every test !!!");
    }

    @Test
    public void computeRectangleAreaTest() {
        Rectangle r = new Rectangle(2, 3);
        System.out.println("Checking now that the rectangle has the correct area!!");
        Assert.assertEquals("Area is not computed correctly", 6, r.computeArea());
        r.setHeight(0);
        Assert.assertEquals("Area is not computed correctly !!", 0, r.computeArea());
    }

    @Test
    public void computeSquareAreaTest() {
        Square s = new Square(5);
        System.out.println("Checking now the square to have the correct area");
        Assert.assertEquals("Area of square is incorrect !", 25, s.computeArea());
    }

    @Test
    public void checkIfPersonIsHungryTest(){
        Person p = new Person(35, 'M', "Alex", 171, 71, true);
        Assert.assertTrue("Person is not hungry when it should be!", p.isHungry());
        p.eat();
        Assert.assertFalse("Person is still hungry even if it ate!!!", p.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCircleAreaTest() {
        Circle c = new Circle(6);
        // the purpose of the test is to check that the exception is thrown legally
        c.setRadius(-6);
    }

    @After
    public void afterTest(){
        System.out.println("This will execute at the end of every test !!");
    }

    @AfterClass
    public static void afterTestsPerClass() {
        System.out.println("This will run at the end of all the tests in the class !!!");
    }

}
