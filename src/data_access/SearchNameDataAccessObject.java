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

/**
 * The SearchNameDataAccessObject class implements the SearchNameDataAccessInterface.
 * It interacts with the Yelp API to GET search results based on a term and location.
 */
public class SearchNameDataAccessObject implements SearchNameDataAccessInterface {
    private static final String API_URL = "https://api.yelp.com/v3/businesses/search?location=%s&term=%s&sort_by=best_match&limit=%s";
    private static final String API_KEY = "Bearer keTwmtAAS9gP-0qws2D6VTsf1uvahxacDd0G4swCBN5aCRapU9iPKHLzHQ6Jm1Cu2HEbY_Pd9oL4JH80fal6RAjY2xeU_lQkQtBlqV3Vh6fWwBx1are9dLVHU1FyZXYx";
    private static final String MATCH_LIMIT = "5";

    /**
     * This constructor creates a SearchNameDataAccessObject.
     */
    public SearchNameDataAccessObject() {
    }

    /**
     * This method calls the Yelp API twice and turns its  result into  SearchNameResult
     * @ param searchNameInputData the input data for the search name use case
     * @ return SearchNameResult the result of the search name use case
     */
    public SearchNameResult getSearchName(SearchNameInputData searchNameInputData) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format(API_URL, searchNameInputData.getLocation(), searchNameInputData.getTerm(), MATCH_LIMIT))
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization",API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return turnToSearchNameResult(searchNameInputData.getLocation(), searchNameInputData.getTerm(), response.body().string());
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }


    private SearchNameResult turnToSearchNameResult(String location, String term, String apiOutput) {
        JSONObject jsonObject = new JSONObject(apiOutput);
        JSONArray businessesJson = jsonObject.getJSONArray("businesses");

        ArrayList<Business> businesses = new ArrayList<>();
        for (int i = 0; i < businessesJson.length(); i++) {
            JSONObject businessJson = businessesJson.getJSONObject(i);
            String id = businessJson.getString("id"); // Getting id
            String name = businessJson.getString("name");  // Getting name
            boolean is_closed = businessJson.getBoolean("is_closed");  // Getting is_closed
            String url = businessJson.getString("url"); //Getting url
            String reviews = getMoreDetails(id); // Getting reviews, calling API again

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


            Business business = new Business(id, name, address, is_closed, url, reviews);
            businesses.add(business);
        }
        return new SearchNameResult(term, location, businesses);
    }

    /**
 * This method calls the Yelp API to get more details about a business, specifically the reviews.
 * The response from the Yelp API parsed and returned as a string.
 *
 * @param id The id of the business
 * @return A string containing the reviews of the business.
 * @throws RuntimeException if there is an error getting the reviews from the Yelp API.
 */
    public String getMoreDetails(String id) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format("https://api.yelp.com/v3/businesses/%s/reviews?limit=%s&sort_by=yelp_sort", id, 2))
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", API_KEY)
                .build();


        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray reviewsArray = jsonObject.getJSONArray("reviews");

            StringBuilder reviewsBuilder = new StringBuilder();

            // Iterate through each review
            for (int i = 0; i < reviewsArray.length(); i++) {
                JSONObject review = reviewsArray.getJSONObject(i);

                String name = review.getJSONObject("user").getString("name");
                int rating = review.getInt("rating");
                String text = review.getString("text");

                reviewsBuilder.append("Name: ").append(name).append("\n");
                reviewsBuilder.append("Rating: ").append(rating).append("\n");
                reviewsBuilder.append("Text: ").append(text).append("\n\n");
            }

            return reviewsBuilder.toString();

        } catch (IOException | JSONException e) {
            throw new RuntimeException("Error getting reviews");
        }
    }
}



