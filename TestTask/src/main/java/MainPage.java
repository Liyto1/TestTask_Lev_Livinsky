import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    public static String testText;
    public static String name;

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By addNewButton = By.xpath("//a[@id='add']");
    private By filterButton = By.xpath("//input[@id='searchsubmit']");
    private By searchField = By.xpath("//input[@id='searchbox']");
    private By alertMessage= By.xpath("//div[@class='alert-message warning']");
    private By firstNameInTable = By.xpath("//td[1]");

    public AddPage addNewComputer(){
        driver.findElement(addNewButton).click();
        return new AddPage(driver);
    }
    public MainPage searchComputer(String computer){
        driver.findElement(searchField).sendKeys(computer);
        driver.findElement(filterButton).click();
        return this;
    }
    public String checkAddedComputer(){
        testText = driver.findElement(alertMessage).getText();
        return testText;
    }
    public String checkTableFirst(){
        name = driver.findElement(firstNameInTable).getText();
        return name;
    }
}
