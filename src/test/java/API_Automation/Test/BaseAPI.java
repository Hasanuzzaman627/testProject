package API_Automation.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Map;

public class BaseAPI {
    protected APIRequestContext context;
    protected Playwright playwright;

    public BaseAPI(Playwright playwright, String baseURL, Map<String, String> headers) {
        this.playwright = playwright;
        this.context = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(baseURL)
                        .setExtraHTTPHeaders(headers)
        );
    }

    public APIResponse get(String endpoint) {
        return context.get(endpoint);
    }

    public APIResponse post(String endpoint, Object body) {
        return context.post(endpoint, RequestOptions.create().setData(body));
    }

    public APIResponse put(String endpoint, Object body) {
        return context.put(endpoint, RequestOptions.create().setData(body));
    }

    public APIResponse delete(String endpoint) {
        return context.delete(endpoint);
    }

    public APIResponse patch(String endpoint, Object body) {
        return context.patch(endpoint, RequestOptions.create().setData(body));
    }

    public void dispose() {
        if (context != null) context.dispose();
    }
}
