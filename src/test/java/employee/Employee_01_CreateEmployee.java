package employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Employee_01_CreateEmployee {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();
    }

    @Test
    public void Employee_01_NewEmployee(){
        driver.get();

    }

    @Test
    public void Employee_02_NewEmployee(){

    }

    @Test
    public void Employee_03_NewEmployee(){

    }

    @Test
    public void Employee_04_NewEmployee(){

    }
}
