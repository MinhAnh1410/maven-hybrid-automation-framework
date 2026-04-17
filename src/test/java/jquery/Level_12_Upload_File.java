package jquery;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneration;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.UploadPO;

public class Level_12_Upload_File extends BaseTest {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();

    @Parameters ({"Browser","Url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneration.getPage(UploadPO.class, driver);
    }

    //@Test
    public void Upload_01_Single(){
        // load file lên
        uploadPage.uploadMultipleFiles(driver,foxFileName);
        uploadPage.uploadMultipleFiles(driver,stitchFileName);
        uploadPage.uploadMultipleFiles(driver,tinkFileName);

        // verify load file lên thành công
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(foxFileName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(stitchFileName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(tinkFileName));

        // click start button upload
        uploadPage.clickStartButton();

        // verify upload file thành công
        //uploadPage.isFileUploadSuccess(foxFileName);
        uploadPage.isFileUploadSuccess(stitchFileName);
        uploadPage.isFileUploadSuccess(tinkFileName);

    }

    //@Test
    public void Upload_02_Multiple(){
        // load file lên
        uploadPage.uploadMultipleFiles(driver,foxFileName, stitchFileName, tinkFileName);

        // verify load file lên thành công
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(foxFileName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(stitchFileName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(tinkFileName));

        // click start button upload
        uploadPage.clickStartButton();

        // verify upload file thành công
        //uploadPage.isFileUploadSuccess(foxFileName);
        uploadPage.isFileUploadSuccess(stitchFileName);
        uploadPage.isFileUploadSuccess(tinkFileName);

    }

    @Test
    public void Upload_03_File_Type(){
        // load file lên
        uploadPage.uploadMultipleFiles(driver,doc2mbFileName);

        // verify load file lên thành công
        Assert.assertTrue(uploadPage.isFileTypeNotAllowed(doc2mbFileName));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private UploadPO uploadPage;
    private String foxFileName = "Fox_and_Rabbit.png";
    private String stitchFileName = "Stitch.jpg";
    private String tinkFileName = "Tinkerbell.jpg";
    private String doc2mbFileName = "2mb.doc";
}
