import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AddPageTest {
    private WebDriver driver;
    private AddPage addPage;
    private MainPage mainPage;
    String intData = MainClass.introduceData;
    String disData = MainClass.discontinueData;
    String computerName = MainClass.computer;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lev\\IdeaProjects\\Test\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://computer-database.gatling.io/computers/new");
        System.out.println("Open browser");
        addPage = new AddPage(driver);
        mainPage = new MainPage(driver);
    }
    @Test
    public void addNewComputer(){
        addPage.computerName(computerName);
        System.out.println("Fill the field 'Computer name'");
        addPage.introduceData(intData);
        System.out.println("Fill the field 'Introduced'");
        addPage.discontinueData(disData);
        System.out.println("Fill the field 'Discontinued'");
        addPage.choseCompany();
        System.out.println("Choosing company in droplist 'Company'");
        addPage.createComputer();
        System.out.println("Click 'Create this computer'");
        mainPage.checkAddedComputer();
        String text = MainPage.testText;
        Assert.assertEquals("Done ! Computer "+ computerName +" has been created",text);
        System.out.println("Checking alert massage 'Computer was create'");
    }
    @Test
    public void cancelAdding(){
        addPage.cancel();
        System.out.println("Click 'Cancel'");
    }
    @After
    public void tearDown(){
        driver.quit();
        System.out.println("Closing browser");
    }
}
