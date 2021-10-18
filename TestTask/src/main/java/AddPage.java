import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPage {
    WebDriver driver;
    public AddPage(WebDriver driver) {
        this.driver = driver;
    }
    private By computerNameField = By.xpath("//input[@id='name']");
    private By introducedField = By.xpath("//input[@id='introduced']");
    private By discontinuedField = By.xpath("//input[@id='discontinued']");
    private By companyDropDown = By.xpath("//select[@id='company']");
    private By chosenCompany = By.xpath("//select[@id='company']/option[@value='1']");//Apple
    private By createComputerButton = By.xpath("//input[@value='Create this computer']");
    private By cancelButton = By.xpath("//a[text()='Cancel']");
    private By heading = By.xpath("//h1[text()='Add a computer']");

    public String getHeading(){
        return driver.findElement(heading).getText();
    }
    public AddPage computerName(String computer){
        driver.findElement(computerNameField).sendKeys(computer);
        return this;
    }
    public AddPage introduceData(String intData){
        driver.findElement(introducedField).sendKeys(intData);
        return this;
    }
    public AddPage discontinueData(String disData){
        driver.findElement(discontinuedField).sendKeys(disData);
        return this;
    }
    public AddPage choseCompany(){
        driver.findElement(companyDropDown).click();
        driver.findElement(chosenCompany).click();
        return this;
    }
    public MainPage createComputer(){
        driver.findElement(createComputerButton).click();
        return new MainPage(driver);
    }
    public MainPage cancel(){
        driver.findElement(cancelButton).click();
        return new MainPage(driver);
    }

}
