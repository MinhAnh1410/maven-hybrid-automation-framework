package pageUIs.jquery;

public class HomePageUI {
    public static final String PAGING_LINK_BY_NUMBER = "XPath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String PAGING_LINK_ACTIVE_BY_NUMBER = "XPath=//a[@class='qgrd-pagination-page active' and text()='%s']";
    public static final String HEADER_TEXTBOX_BY_NAME = "XPath=//div[text()='%s']/parent::div//following-sibling::input";
    public static final String ROW_ACTIVED_BY_VALUE = "XPath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
    public static final String ICON_BY_COUNTRY_NAME = "XPath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[contains(@class,'qgrd-%s-row-btn')]";
    public static final String COLUMN_INDEX_BY_NAME = "XPath=//th[text()='%s']/preceding-sibling::th";
    public static final String CELL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "XPath=//tr[%s]/td[%s]/input";
    public static final String CELL_DROPDOWN_BY_COLUMN_AND_ROW_INDEX = "XPath=//tr[%s]/td[%s]/div/select";

    public static final String ALL_PAGING_LINK = "XPath=//li[@class='qgrd-pagination-page']/a";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "XPath=//div[@class='qgrd-header-text' and text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String COLUMN_INDEX = "XPath=//td[%s]";


}

//    Row = Hàng
//    Column = Cột
//    Giao giữa Row vs Column = Cell (Ô)
//    Cột = td
//    Dòng = tr
//    ---> cell = //tr[index]/td[index]

