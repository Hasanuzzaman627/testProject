package API_Automation.Test;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserAPI extends BaseAPI {

    public UserAPI(Playwright playwright) {
        super(playwright, "https://pre-prod-api.cartup.com", Map.of(
                "Content-Type", "application/json",
                "authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzbF9jdXN0b21lciIsInN1YiI6InNsX2N1c3RvbWVyX2FwcGxpY2F0aW9uX3NlcnZpY2UiLCJuYmYiOjE3NDc5MDk2MDYsImlkIjoyNzQ3LCJmaXJzdE5hbWUiOiJIYXNhbiIsImxhc3ROYW1lIjoiVXp6YW1hbiIsInBob25lIjoiMDE2Mjc1NTc1NjMiLCJlbWFpbCI6IiIsImV4cCI6MTc1MDUwMTYwNiwiaXNFbWFpbFZlcmlmaWVkIjpmYWxzZSwiaXNQaG9uZVZlcmlmaWVkIjp0cnVlLCJzdGF0dXNJZCI6MSwiY3JlYXRlZEF0IjoiMjAyNC0xMC0yOCAxNToyNzoxMC42MTg0MDcgKzAwMDAgVVRDIiwidXBkYXRlZEF0IjoiMjAyNS0wNC0yMCAxMToxNDo1NS45NTA4MzggKzAwMDAgVVRDIiwiaWF0IjoxNzQ3OTA5NjA2LCJwcm9maWxlSW1hZ2UiOiJoYXNhbi1hZjUyNWEyMS03Y2ZhLTQ2ZmMtOTJhOS04YWM0Y2M0OGUzMmMuanBlZyIsImF0blZlcnNpb24iOjR9.GELVSubd3RGoF7fRPUTQg0m8zojwG2VmxgwDCwssqGQ",
                "sxsrf", "V2xoc1MySkhWa2xSYmtKcVlsWmFObE5YY0habFJUVTJWVlJTVGxKSFkzcFViRkp1VFZWNFJGTnVjR2hXTWxJeFUxZHdkbUZWT1ZWVlZGSk9aVzFvZEZkdE1WcE5NWEJZVjIweFRsSkZOWE5YV0hCWFlUQTFjVlZVU2s1V1JXdzBWRmR3YW1WR2EzbFViWGhhVmpCYWMxZFdaRmRoUlRWVlVXMXdZVkl4V25CVU1GSnFUa1V4UlZWVVFrOWxiVTB3Vkd0U1ZrNUdjRlZSYlRGYVpXMTBORlJ0Y0dwT1ZURndVMWhPU21KcmNHOVpiVEZUWkcxS1ZGTlVXazVSZWxGNFZHMXdXazFyTlVWV1ZFcFFWa1V3ZWxSVlVrSmxWVFZaVFVRd1BRPT0="
        ));
    }

    public APIResponse getUser() {
        return get("/aes/api/v1/products/search?keyword=scooter&sorting=0&rowsPerPage=30&currentPage=1");
    }

    public <T> T parseResponse(APIResponse response, Class<T> responseType) throws Exception {
        String body = response.text();
        return new ObjectMapper().readValue(body, responseType);
    }
}
