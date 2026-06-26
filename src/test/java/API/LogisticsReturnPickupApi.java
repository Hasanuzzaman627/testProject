package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;

import static helpers.apiConfigProperty.updateConfigurationProperty;
import static test.BaseTest.apiProperty;

public class LogisticsReturnPickupApi {

    @Step("POST API For Authorization Token")
    public LogisticsReturnPickupApi authrorizationToken() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String json = """
                {
                    "service_key": "@H=H>2pVu&1695702568",
                    "username": "deliverybadda",
                    "password": "Bd@_1971"
                }
                """;
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder().url("https://pre-prod-be-auth.cartup.com/api/v1/users/signin").method("POST", body).addHeader("Content-Type", "application/json").build();
        Response response = client.newCall(request).execute();


        if (response.isSuccessful()) {
            assert response.body() != null;

            String responseBody = response.body().string();

            //System.out.println("Response Body: " + responseBody);
            //System.out.println("Response Code: " + response.code());

            String accessToken = JsonPath.read(responseBody, "$.data.accessToken");
            updateConfigurationProperty("apiconfig.properties", "authorization_token", accessToken);
        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }

    public LogisticsReturnPickupApi getIdFromReturnCode(String targetOrderReturnCode) throws IOException{

        int returnID=0;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(apiProperty("BaseURL") +"/logistics-rider/api/app/App_ReturnOrderPickup/GetAllPendingOrderReturns?page=1&size=2")
                .addHeader("Authorization", "Bearer "+ apiProperty("authorization_token"))
                .build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode root = objectMapper.readTree(responseBody);

                JsonNode collection = root.path("data").path("collection");

                for (JsonNode item : collection) {
                    if (item.path("orderReturnCode").asText().equals(targetOrderReturnCode)) {
                        returnID = item.path("id").asInt();
                        System.out.println("Found ID: " + returnID);
                        break;
                    }
                }

                updateConfigurationProperty("apiconfig.properties", "orderReturnCode", String.valueOf(returnID));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new IOException("Unexpected code " + response);
        }

        System.out.println(returnID);

        return this;

    }

    public LogisticsReturnPickupApi returnPickupConfirm() throws IOException{

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String json= String.format("""
                [
                %s
                ]
                """, apiProperty("orderReturnCode"));

        MediaType mediaType = MediaType.parse("application/json-patch+json");
        RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_ReturnOrderPickup/ConfirmInPickup")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+ apiProperty("authorization_token"))
                .build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

//            System.out.println("Response Body: " + responseBody);
//            System.out.println("Response Code: " + response.code());

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }

    public LogisticsReturnPickupApi returnPickupReceive() throws IOException{

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String json= String.format("""
                {
                  "id": %s,
                  "pickupImageUrl": [
                    "string"
                  ],
                  "latitude": 0,
                  "longitude": 0
                }
                """, apiProperty("orderReturnCode"));

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_ReturnOrderPickup/PickupSuccessWithImage")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+ apiProperty("authorization_token"))
                .build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

//            System.out.println("Response Body: " + responseBody);
//            System.out.println("Response Code: " + response.code());

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }
}
