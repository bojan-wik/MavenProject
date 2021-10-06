package mavencourse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * W klasie 'x_TestngXMLparametrizing' i spiętym z nim 'x_TestngXMLparametrizing.xml' definiowałem parametry na poziomie globalnym (test suite, test folder).
 * Jeżeli chciałbym zdefiniować parametr lokalnie - na poziomie test case, nie da się tego zrobić w ten sam sposób w pliku XML.
 * Mogę to zrobić za pomocą DataProviderAnnotation. Ma to zastosowanie np. kiedy muszę uruchomić jakiś pojedynczy test case dla wielu różnych danych
 * np. kiedy chcę przetestować logowanie na stronie dla 3 różnych kont typu admin, user, uploader itd. Wtedy uruchamiam tylko raz ten jeden test case
 * z takim zestawem danych (3 konta jednocześnie) zamiast uruchamiać 3 razy ten sam test case, każdorazowo z innymi danymi (1 konto na raz).
 */
public class y_DataProviderAnnotation {

    @DataProvider
    public Object[][] getDataSet() {
        /**
         * Chcę stworzyć następujący zestaw danych, który będę potem przekazywał do test case:
         *      1st data set (admin, username & password)
         *      2nd data set (user, username & password)
         *      3rd data set (uploader, username & password)
         *
         * W tym celu tworzę multidimensional array:
         * - 1szy argument (liczba wierszy) to liczba zestawów danych (3)
         * - 2gi argument (liczba kolumn) to liczba przekazywanych valuesów w każdym zestawie danych (2)
         */
        Object[][] dataSetArray = new Object[3][2];
        //1st data set (admin, username & password)
        dataSetArray[0][0] = "admin username";
        dataSetArray[0][1] = "admin password";
        //2nd data set (user, username & password)
        dataSetArray[1][0] = "user username";
        dataSetArray[1][1] = "user password";
        //3rd data set (uploader, username & password)
        dataSetArray[2][0] = "uploader username";
        dataSetArray[2][1] = "uploader password";
        return dataSetArray;
    }

    /**
     * Tworzę standardowo test case, ale dodatkowo podaję (dataProvider = "getDataSet"),
     * gdzie odnoszę się do wcześniej stworzonej metody z adnotacją @DataProvider, która zwraca mi utworzony zestaw danych,
     * który chcę przekazać do tego test case. Potem w argumentach test casu przekazuję wartości (2) każdego zestawu danych
     */
    @Test(dataProvider = "getDataSet")
    public void dataProviderTestCase1(String username, String password) {
        System.out.println("dataProviderTestCase1");
        System.out.printf("%s : %s\n", username, password).println();
    }
    /**
     * Te parametry (dla test casów) są definiowane tylko w obrębie samych test casów - z pominięciem pliku XML
     */
}
