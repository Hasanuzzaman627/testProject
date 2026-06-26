package test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DemoApiTest extends BaseTest{
    public static APIRequest request;
    static Playwright playwright;


    @Test
    public void testPostRequest() {
        playwright = Playwright.create();
        request = playwright.request();

        //RequestOptions options = RequestOptions.create().setHeader("Authorization", "Bearer YOUR_TOKEN");
        APIResponse response = request.newContext().post("https://reqres.in/api/users", RequestOptions.create()
                .setHeader("Content-Type", "application/json")
                .setData("{\n" +
                "    \"name\": \"Hasanuzzaman\",\n" +
                "    \"job\": \"SQA leader\"\n" +
                "}"));
        assertEquals(201, response.status());
        System.out.println("Status: " + response.status());
        System.out.println("Response Body: " + response.text());

        // Validate response status
        if (response.status() != 201) {
            throw new RuntimeException("Unexpected status code: " + response.status());
        }
    }


    @Test
    public void testGetRequest() {
        playwright = Playwright.create();
        request = playwright.request();

        //RequestOptions options = RequestOptions.create().setHeader("Authorization", "Bearer YOUR_TOKEN");
        APIResponse response = request.newContext().get("https://reqres.in/api/users/2");
        assertEquals(200, response.status());
        System.out.println("Status: " + response.status());
        System.out.println("Response Body: " + response.text());

        // Validate response status
        if (response.status() != 200) {
            throw new RuntimeException("Unexpected status code: " + response.status());
        }
    }


    @Test
    public void testPutRequest() {
        playwright = Playwright.create();
        request = playwright.request();
        APIResponse response = request.newContext().put("https://jsonplaceholder.typicode.com/posts/1",
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setData("{\"title\":\"updated title\"}")
        );
        System.out.println("Request Boyd" + response.text());

        // Validate response status
        if (response.status() != 200) {
            throw new RuntimeException("Unexpected status code: " + response.status());
        }
    }

    @Test
    public void testDeleteRequest(){
        playwright = Playwright.create();
        request = playwright.request();
        APIResponse response = request.newContext().delete("https://reqres.in/api/users/2");

        System.out.println("Response Body" + response.text());
        // Validate response status
        if (response.status() != 204) {
            throw new RuntimeException("Unexpected status code: " + response.status());
        }
    }

}
