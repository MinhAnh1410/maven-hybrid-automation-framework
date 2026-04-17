package pageUIs.jquery;

public class UploadPageUI {
    public static final String FILE_NAME_LOADED = "Xpath=//p[@class='name' and text()='%s']";
    public static final String FILE_NAME_UPLOADED = "Xpath=//p[@class='name']/a[text()='%s']";
    public static final String FILE_TYPE_NOT_ALLOWED_MSG = "Xpath=//p[@class='name' and text()='%s']/following-sibling::strong[text()='File type not allowed']";
    public static final String START_UPLOAD_BUTTON = "Xpath=//span[text()='Start upload']";
    public static final String START_BUTTON = "CSS=table button.start";

}
