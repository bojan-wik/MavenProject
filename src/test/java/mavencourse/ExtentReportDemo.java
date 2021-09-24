package mavencourse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    /**
     * Deklaruję zmienną typu ExtentReports. Deklaruję ją na poziomie klasy, żeby była dostępna dla każdej metody
     * m.in. dla testcasów, bo inaczej nie byłbym w stanie ich podpiąć i wygenerować dla nich raportów.
     */
    ExtentReports extentReports;

    @BeforeTest
    public void extentReportConfig() {
        /**
         * Dynamicznie tworzę ścieżkę do pliku .html w którym będzie zapisywany raport z testów.
         * Metoda getProperty("user.dir") zwraca mi ścieżkę absolutną (C:\Users\bojanoww\IdeaProjects\MavenProject)
         */
        String reportFilePath = System.getProperty("user.dir") + "\\reports\\index.html";
        /**
         * Tworzę obiekt klasy ExtentSparkReporter, który będzie przechowywał m.in. konfigurację raportów.
         * Jako argument podaję mu ścieżkę na dysku lokalnym, gdzie mają być zapisywane raporty.
         */
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFilePath);
        /**
         * Metoda config() daje sporo możliwości customizowania raportów. Tutaj zmieniam nazwę raportu
         * i title strony.
         */
        extentSparkReporter.config().setReportName("My custom report name");
        extentSparkReporter.config().setDocumentTitle("My custom document title");
        /**
         * Pod zadeklarowaną wcześniej zmienną tworzę obiekt klasy ExtentReports, która jest główną klasą odpowiedzialną za tworzenie raportów.
         * Podpinam pod nią wcześniej utworzony obiekt klasy ExtentSparkReporter.
         */
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Wiktor");
    }

    @Test
    public void extentReportTestCase1() {
        /**
         * Aby dany test case był brany pod uwagę w raporcie muszę go podpiąć pod obiekt klasy ExtentReports.
         * Podpinam za pomocą metody createTest(). Od teraz ten test case jest jakby 'monitorowany'
         * Tworzę obiekt klasy ExtentTest i w nim przechowuję wywołanie metody createTest()
         */
        ExtentTest extentTest = extentReports.createTest("extentReportTestCase1");
        /**
         * Tworzę jakiś prosty test case w Selenium
         */
        System.setProperty("webdriver.chrome.driver" ,"C:\\Tools\\Webdrivers\\Chrome\\92\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle);
        driver.quit();
        /**
         * Generalnie na ten moment raport nie będzie zawierał info o testach, które są na fail, bo skrypt się wcześniej wywala i raport nie zdąży się wygenerować.
         * Będzie to możliwe dopiero w momencie, kiedy zostaną podepnięte TestNG Listeners - dalsza część kursu.
         * Na ten moment mogę tylko sztucznie sfailować test za pomocą metody fail().
         */
        //extentTest.fail("Test failed");
        extentTest.addScreenCaptureFromBase64String("extentReportTestCase1");
        /**
         * Na koniec kończę 'monitorowanie' danego test casu za pomocą metody flush()
         */
        extentReports.flush();
    }
}
