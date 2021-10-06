package mavencourse;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class x_TestngXMLparametrizing {

    /**
     * Utworzony w pliku 'x_TestngXMLparametrizing.xml' parametr przekazuję za pomocą adnotacji @Parameters({}),
     * działa tylko na test case bezpośrednio pod nim - czyli dla każdego test case, który ma otrzymać ten parametr
     * muszę przed nim postawić adnotację @Parameters({}).
     * Potem jeszcze definiuję ten parametr, jako argument funkcji (String urlName)
     */
    @Parameters({"URL"})
    @Test
    public void parametrizedTestCase1(String URL) {
        System.out.printf("parametrizedTestCase1, parameter: %s", URL).println();
    }

    @Parameters({"URL", "username"})
    @Test
    public void parametrizedTestCase2(String URL, String username) {
        System.out.printf("parametrizedTestCase2, parameter1: %s", URL).println();
        System.out.printf("parametrizedTestCase2, parameter2: %s", username).println();
    }
}
