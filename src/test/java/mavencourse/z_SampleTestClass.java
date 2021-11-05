package mavencourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class z_SampleTestClass {

    @Test
    public void sampleTestMethodSuccess() {
        System.out.println("\nrunning sampleTestMethodSuccess()");
        Assert.assertTrue(true);
    }

    @Test
    public void sampleTestMethodFailure() {
        System.out.println("\nrunning sampleTestMethodFailure()");
        Assert.assertTrue(false);
    }
}
