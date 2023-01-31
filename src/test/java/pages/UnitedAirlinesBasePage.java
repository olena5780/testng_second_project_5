package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import utilities.Driver;

public class UnitedAirlinesBasePage {

   public UnitedAirlinesBasePage(){
       PageFactory.initElements(Driver.getDriver(), this);

   }

}
