package assertVerify;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class HardAssert {
    private String employeeAddress = null;

    @Test
    public void TC_01() {
        String fullName = "Automation Testing";

        // mong đợi điều kiện trả veef là đúng
        Assert.assertTrue(fullName.startsWith("Auto"));
        Assert.assertTrue(fullName.endsWith("ing"));

        // mong đợi điều kiện trả veef là sai
        Assert.assertFalse(fullName.endsWith("Auto"));
        Assert.assertFalse(fullName.startsWith("ing"));

        //mong đợi 2 điều kiện = nhau
        assertEquals(fullName, "Automation Testing");
        Assert.assertNotEquals(fullName, "Automation Testing");
        Assert.assertNull(employeeAddress);

    }
}
