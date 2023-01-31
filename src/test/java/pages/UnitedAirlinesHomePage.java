package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedAirlinesHomePage extends UnitedAirlinesBasePage {
    public UnitedAirlinesHomePage() {
        super();
    }

    @FindBy(xpath = "//a[starts-with(@id, 'headerNav')]")
    public List<WebElement> headerNavigators;

    @FindBy(xpath = "//li[contains(@id,'Tab')]")
    public List<WebElement> travelMenu;

    @FindBy(xpath = "//fieldset[@name='flightType']//label")
    public List<WebElement> tripLabel;

    @FindBy(xpath = "//fieldset[@name='flightType']//input")
    public List<WebElement> tripInput;

    @FindBy(xpath = "//input[@id='award']/.. ")
    public WebElement bookWithMilesLabel;

    @FindBy(css = "input[id='award']")
    public WebElement bookWithMilesCheckbox;

    @FindBy(xpath = "//input[@id='flexibleDates']/..")
    public WebElement flexibleDatesLabel;

    @FindBy(css = "input[id='flexibleDates']")
    public WebElement flexibleDatesCheckbox;

     @FindBy(css= "input[id='bookFlightOriginInput']")
     public WebElement fromInput;

     @FindBy(css ="input[id='bookFlightDestinationInput']")
     public WebElement toInput;

     @FindBy(css = "input[id='DepartDate']")
     public WebElement dateInput;

    @FindBy(css = "#passengerSelector>button")
    public WebElement travelersSelector;

    @FindBy(xpath = "//button[@aria-label='Substract one Adult']")
    public WebElement plusOneAdult;

    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdownButton;

    @FindBy(css = "#cabinType_item-2")
    public WebElement businessOrFirst;

    @FindBy(css = "button[class*='2fg9l']")
    public WebElement findFlightsButton;

    @FindBy(css = "div[class*='-3_5-b']>div")
    public WebElement departureDate;


}