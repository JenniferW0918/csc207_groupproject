package data_access;
import use_case.search_name.SearchNameDataAccessInterface;
import use_case.search_name.SearchNameInputData;

import okhttp3.*;
import org.json.JSONException;
import java.io.IOException;

public class SearchNameDataAccessObject implements SearchNameDataAccessInterface {
    private static final String API_URL = "https://api.yelp.com/v3/businesses/search?location=%s&term=%s&sort_by=best_match&limit=%s";
    private static final String API_TOKEN = "Bearer aUjsL_a7uXnzTktFn8_flSRQgzMzvR29s2XvkdSTTM32IUfmaoh0piPhSUJblFvZb_jQ-_x1Z6wMPfLpf3QJs3PUzv6079NtFUC3-b6RybopBoio22mCrHPiccYWZXYx";

    // private static final String API_TOKEN = "Bearer " + System.getenv("YOUR_ENV_VARIABLE_FOR_TOKEN");

    private static final String MATCH_LIMIT = "5";



    public void getSearchName(SearchNameInputData searchNameInputData) throws JSONException, IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format(API_URL, searchNameInputData.location, searchNameInputData.term, MATCH_LIMIT))
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", API_TOKEN)
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }
}


