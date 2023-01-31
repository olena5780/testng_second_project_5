package scripts;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedAirlinesHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;
import utilities.WindowHandler;

public class UnitedAirlinesTest extends UnitedAirlinesBase {
    /**
Test Case 1: Validate "Main menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see “Main menu” navigation items
|BOOK
|MY TRIPS
|TRAVEL INFO
|MILEAGEPLUS® PROGRAM|
|DEALS
|HELP

     */

    @BeforeMethod
    public void setPage(){
        unitedAirlinesHomePage = new UnitedAirlinesHomePage();

    }

    /**
     * Test Case 1: Validate "Main menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see “Main menu” navigation items
     * |BOOK                	          	  |
     * |MY TRIPS            	          	  |
     * |TRAVEL INFO         	  |
     * |MILEAGEPLUS® PROGRAM|
     * |DEALS               	          	  |
     * |HELP
     */

    @Test(priority = 1, description = "Validate \"Main menu\" navigation items")
    public void validateMainMenu(){
        String[] mainMenu = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < unitedAirlinesHomePage.headerNavigators.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.headerNavigators.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesHomePage.headerNavigators.get(i).isEnabled());
            Assert.assertEquals(unitedAirlinesHomePage.headerNavigators.get(i).getText(), mainMenu[i]);

        }
    }
    /**
     * Test Case 2: Validate "Book travel menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see "Book travel menu" navigation items
     * |Book             |
     * |Flight Status|
     * |Check-in       |
     * |My trips        |
     */

    @Test(priority = 2, description = "Validate \"Book travel menu\" navigation items")
    public void validateBookTravelMenu(){
        String[] bookTravelNames = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < bookTravelNames.length; i++) {
            Assert.assertTrue(unitedAirlinesHomePage.travelMenu.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesHomePage.travelMenu.get(i).isEnabled());
            Assert.assertEquals(unitedAirlinesHomePage.travelMenu.get(i).getText(), bookTravelNames[i]);


        }
        //System.out.println(unitedAirlinesHomePage.travelMenu.size()); //8

    }
    /**
     * Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     * And validate "One-way" radio button is displayed, is enabled but is not selected
     * When user clicks on "One-way" radio button
     * Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
     */
    @Test(priority = 3, description = "Validate  \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRadioButtons(){
        for (int i = 0; i < unitedAirlinesHomePage.tripLabel.size(); i++) {
            Assert.assertTrue(unitedAirlinesHomePage.tripLabel.get(i).isDisplayed()); // validate "Roundtrip" and "One-way" radio button is displayed, is enabled
            Assert.assertTrue(unitedAirlinesHomePage.tripLabel.get(i).isEnabled());
        }
        Assert.assertTrue(unitedAirlinesHomePage.tripInput.get(0).isSelected()); // validating "Roundtrip" radio button is selected
        Assert.assertFalse(unitedAirlinesHomePage.tripInput.get(1).isSelected());//validating "One-way" radio button is not selected

        unitedAirlinesHomePage.tripInput.get(1).click(); //clicking on "One-way" radio button
        Assert.assertTrue(unitedAirlinesHomePage.tripInput.get(1).isSelected());// validating "One-way" radio button is  selected
        Assert.assertFalse(unitedAirlinesHomePage.tripInput.get(0).isSelected());// validating "Roundtrip" radio button is not selected
    }


    /**
     * Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
     * And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
     * When user clicks both checkboxes
     * Then validate both checkboxes are selected
     * When user clicks on both selected checkboxes again
     * Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes")

    public void validateCheckBoxes(){
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesLabel.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesLabel.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckbox.isSelected());

        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesLabel.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesLabel.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckbox.isSelected());

        unitedAirlinesHomePage.bookWithMilesLabel.click();
        unitedAirlinesHomePage.flexibleDatesLabel.click();

        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckbox.isSelected());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckbox.isSelected());

        unitedAirlinesHomePage.bookWithMilesLabel.click();
        unitedAirlinesHomePage.flexibleDatesLabel.click();

        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckbox.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckbox.isSelected());

    }

    /**
     * Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
     * Given user is on "https://www.united.com/en/us"
     * When user selects "One-way" ticket radio button
     * And user enters "Chicago, IL, US (ORD)" to from input box
     * And user enters "Miami, FL, US (MIA)" to to input box
     * And user selects "Feb 28" to the dates input box
     * And user selects "2 Adults" from travelers selector
     * And user selects "Business or First" from cabin dropdown
     * And user clicks on "Find Flights" button
     * Then validate departure equals to "DEPART ON: February 28"
     */

    @Test(priority = 5, description = "Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void validateOneWayTicketChicagoToMiami(){
        unitedAirlinesHomePage.tripInput.get(1).click();
        unitedAirlinesHomePage.fromInput.clear();
        unitedAirlinesHomePage.fromInput.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesHomePage.fromInput.click();
        unitedAirlinesHomePage.toInput.clear();
        unitedAirlinesHomePage.toInput.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesHomePage.toInput.click();
        unitedAirlinesHomePage.dateInput.clear();
        unitedAirlinesHomePage.dateInput.sendKeys("Feb 28");
        unitedAirlinesHomePage.dateInput.click();
        unitedAirlinesHomePage.travelersSelector.click();
        unitedAirlinesHomePage.plusOneAdult.click();
        unitedAirlinesHomePage.cabinTypeDropdownButton.click();
        unitedAirlinesHomePage.businessOrFirst.click();
        unitedAirlinesHomePage.cabinTypeDropdownButton.click();


        unitedAirlinesHomePage.findFlightsButton.click();
        Waiter.pause(3);
        WindowHandler.switchToChildWindow();
        Waiter.pause(3);
        Assert.assertEquals(unitedAirlinesHomePage.departureDate.getText(), "DEPART ON: February 28");

    }



}