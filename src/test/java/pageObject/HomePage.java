package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search-autocomplete-input']")
    WebElement searchBox;

    public @FindBy(xpath = "//div[@class='cds-Search-actionButtons']/button")
    WebElement searchButton;



//    public void clickSearchBox() {
//        searchBox.click();
//    }

    public void clickSearchBox() {
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(12))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(searchBox));
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", searchBox);
        try {
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                    .until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(searchBox));
            searchBox.click();
        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBox);
        }
    }

    public void sendKeysToSearchBox(String query) {
        searchBox.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
