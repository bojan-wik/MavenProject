package mavencourse;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Aby móc korzystać z adnotacji Listeners muszę najpierw zaimplementować interface 'ITestListener'.
 * Żeby dowiedzieć się, jakie metody mogę zaimplementować z interfejsu muszę najechać na 'ITestListener' -> ... -> Edit source
 */

public class z_Listeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // 'make screenshot' code
        System.out.println("test failed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test passed");
    }

    /**
     * Aby kod zdefiniowany w implementowanych metodach faktycznie był uruchamiany muszę przekazać wiedzę o klasie implementującej interfejs ('z_Listeners')
     * plikowi testng.xml ('z_Listeners.xml') - dodaję tam odpowiednie informacje w tagu <Listeners>
     */
}
