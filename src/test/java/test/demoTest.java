package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.demoPage;

import java.io.IOException;

public class demoTest extends BaseTest {
    private demoPage demoPage;


    @DataProvider(name = "airportCode")
    public Object[][] dataproviderFunction(){
        return new Object[][]{
                {"DAC","CXB"},{"CGP","DAC"}
        };
    }

    @Test(dataProvider ="airportCode")
    public void searchFlight(String from,String to) throws IOException, InterruptedException {
        demoPage = new demoPage(page);
        demoPage
             /*   .maximizeWindow() */ // Maximize window here if desired
                .navigateTo(property("base_url"))
                .selectAirport( "airport input from",from)
                .selectAirport("airport input to",to)
                .clickOnSearchButton();
        Thread.sleep(5000);

    }
}
