import org.junit.rules.ErrorCollector;
import org.junit.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    String computerName = MainClass.computer;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lev\\IdeaProjects\\Test\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://computer-database.gatling.io/computers?p=0&n=10&s=introduced&d=desc");
        System.out.println("Open browser");
        mainPage = new MainPage(driver);
    }
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void addComputer(){
        AddPage addPage = mainPage.addNewComputer();
        System.out.println("click 'Add a new computer'");
        String heading = addPage.getHeading();
        Assert.assertEquals("Add a computer",heading);
        System.out.println("open new window and checking heading");
    }
    @Test
    public void findComputer(){
        mainPage.searchComputer(computerName);
        System.out.println("Fill the field 'Filter by computer name' and click button 'Filter by name'");
        String nameInTable = mainPage.checkTableFirst();
        System.out.println("Checking first position in table");
        try {
            Assert.assertEquals(nameInTable, computerName);
        } catch (Throwable t) {
            collector.addError(t);
        }
    }
    @After
    public void tearDown(){
        driver.quit();
        System.out.println("Closing browser");
    }
}
