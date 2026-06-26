package API;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;

import static helpers.apiConfigProperty.updateConfigurationProperty;
import static test.BaseTest.apiProperty;

public class logisticsDeliveryManApi {

    @Step("POST API For Authorization Token")
    public logisticsDeliveryManApi authrorizationToken() throws IOException {

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

    @Step("GET API For Scan For Validate Order Package")
    public logisticsDeliveryManApi scanForValidateOrderPackage(String packageCode) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_CustomerDelivery/ScanForValidateOrderPackage?packageCode=" + packageCode).addHeader("Authorization", "Bearer " + apiProperty("authorization_token")).build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            //System.out.println("Response Body: " + responseBody);
            //System.out.println("Response Code: " + response.code());

            int packageId = JsonPath.read(responseBody, "$.data.id");
            int deliveryRiderId = JsonPath.read(responseBody, "$.data.deliveryRiderId");

            updateConfigurationProperty("apiconfig.properties", "packageId", String.valueOf(packageId));
            updateConfigurationProperty("apiconfig.properties", "deliveryRiderId", String.valueOf(deliveryRiderId));

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }

    @Step("PUT API For Receive Delivery Man")
    public logisticsDeliveryManApi receiveDeliveryMan() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String json = String.format("""
                {
                    "riderId": %s,
                    "packageIds": [
                        %s
                    ],
                    "remarks": "string"
                }
                """, apiProperty("deliveryRiderId"), apiProperty("packageId"));


        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder().url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_CustomerDelivery/ReceiveDeliveryMan").method("PUT", body).addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + apiProperty("authorization_token")).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            //System.out.println("Response Body: " + responseBody);
            //System.out.println("Response Code: " + response.code());

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }

    @Step("PUT API For Request On The Way Confirm By Delivery Man")
    public logisticsDeliveryManApi requestOnTheWayConfirmByDeliveryMan() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String json = String.format("""
                {
                    "packageIds": [
                        %s
                    ]
                }
                """, apiProperty("packageId"));

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder().url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_CustomerDelivery/OnTheWayConfirmByDeliverMan").method("PUT", body).addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + apiProperty("authorization_token")).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            //System.out.println("Response Body: " + responseBody);
            //System.out.println("Response Code: " + response.code());

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }

    @Step("PUT API For Deliver Package")
    public logisticsDeliveryManApi deliverPackage() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String json = String.format("""
                {
                    "packageId": %s,
                    "otp": "1234",
                    "imageUrl": "string",
                    "remarks": "string",
                    "latitude": 0,
                    "longitude": 0
                }
                """, apiProperty("packageId"));

        MediaType mediaType = MediaType.parse("application/json-patch+json");
        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder().url(apiProperty("BaseURL") + "/logistics-rider/api/app/App_CustomerDelivery/DeliverPackage").method("PUT", body).addHeader("Content-Type", "application/json-patch+json").addHeader("Authorization", "Bearer " + apiProperty("authorization_token")).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            //System.out.println("Response Body: " + responseBody);
            //System.out.println("Response Code: " + response.code());

        } else {
            throw new IOException("Unexpected code " + response);
        }

        return this;
    }
}
