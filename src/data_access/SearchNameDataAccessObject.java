package data_access;
import entity.Business;
import entity.SearchNameResult;
import org.json.JSONObject;
import org.json.JSONArray;

import use_case.search_name.SearchNameDataAccessInterface;
import use_case.search_name.SearchNameInputData;
import okhttp3.*;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;

public class SearchNameDataAccessObject implements SearchNameDataAccessInterface {
    private static final String API_URL = "https://api.yelp.com/v3/businesses/search?location=%s&term=%s&sort_by=best_match&limit=%s";
    private static final String API_TOKEN = "Bearer aUjsL_a7uXnzTktFn8_flSRQgzMzvR29s2XvkdSTTM32IUfmaoh0piPhSUJblFvZb_jQ-_x1Z6wMPfLpf3QJs3PUzv6079NtFUC3-b6RybopBoio22mCrHPiccYWZXYx";

    // private static final String API_TOKEN = "Bearer " + System.getenv("YOUR_ENV_VARIABLE_FOR_TOKEN");

    private static final String MATCH_LIMIT = "10";


    public SearchNameDataAccessObject() {
    }

    /**
     * Calls API and returns SearchNameResult */
    public SearchNameResult getSearchName(SearchNameInputData searchNameInputData) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format(API_URL, searchNameInputData.getLocation(), searchNameInputData.getTerm(), MATCH_LIMIT))
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", API_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return turnToSearchNameResult(searchNameInputData.getLocation(), searchNameInputData.getTerm(), response.body().string());
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Turns output from API into SearchNameResult
     */
    private SearchNameResult turnToSearchNameResult(String location, String term, String apiOutput) {
        JSONObject jsonObject = new JSONObject(apiOutput);
        JSONArray businessesJson = jsonObject.getJSONArray("businesses");

        ArrayList<Business> businesses = new ArrayList<>();
        for (int i = 0; i < businessesJson.length(); i++) {
            JSONObject businessJson = businessesJson.getJSONObject(i);
            String name = businessJson.getString("name");  // Getting name
            boolean is_closed = businessJson.getBoolean("is_closed");  // Getting is_closed

            //Getting address
            JSONObject locationJSON = businessJson.getJSONObject("location");
            JSONArray displayAddress = locationJSON.getJSONArray("display_address");
            StringBuilder addressBuilder = new StringBuilder();
            for (int j = 0; j < displayAddress.length(); j++) {
                addressBuilder.append(displayAddress.getString(j));
                if (j < displayAddress.length() - 1) {
                    addressBuilder.append(", ");
                }
            }
            String address = addressBuilder.toString();


            Business business = new Business(name, address, is_closed);
            businesses.add(business);
        }
        return new SearchNameResult(term, location, businesses);
    }
}

