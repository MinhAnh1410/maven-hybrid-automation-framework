package pageObjects.jquery;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String number) {
        waitElementClickable(driver, HomePageUI.PAGING_LINK_BY_NUMBER, number);
        clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER, number);
        sleepInSecond(5);
    }

    public boolean isPageActivedByNumber(String number) {
        waitElementVisible(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, number);
        return isElementDisplay(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, number);
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToEnter) {
        waitElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
        sendkeyToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_NAME, valueToEnter, headerName);
    }

    public boolean isRowActiveByValue(String female, String country, String male, String total) {
        waitElementVisible(driver, HomePageUI.ROW_ACTIVED_BY_VALUE, female,country,male,total);
        return isElementDisplay(driver, HomePageUI.ROW_ACTIVED_BY_VALUE, female,country,male,total);
    }

    public void clickToIconByCountryName(String countryName, String iconName) {
        waitElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconName);
        clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconName);
    }

    public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToEnter) {
        // dựa vào columnName để lấy được index cuả cột
        waitElementClickable(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName);
        String columnIndex = String.valueOf(getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1);

        waitElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex, columnIndex);
        sendkeyToElement(driver,HomePageUI.CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, valueToEnter, rowIndex, columnIndex);
    }

    public void selectToDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSelect) {
        waitElementClickable(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName);
        String columnIndex = String.valueOf(getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1);

        waitElementClickable(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, rowIndex, columnIndex);
        selectItemInDropdown(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, valueToSelect, rowIndex, columnIndex);

    }

    public List<String> getAllValueByColumnName(String columnName) {
        List<WebElement> allPaging = getListElement(driver, HomePageUI.ALL_PAGING_LINK);

        List<String> allPageValue = new ArrayList<String>();

        String columnIndex = String.valueOf(getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1);

        for (WebElement page : allPaging){
            page.click();

            List<WebElement> columnAllValue = getListElement(driver, HomePageUI.COLUMN_INDEX, columnIndex);
            for (WebElement value : columnAllValue) {
                allPageValue.add(value.getText());
            }
        }

        for (String value : allPageValue) {
            System.out.println(value);
        }

        return allPageValue;
    }
}
