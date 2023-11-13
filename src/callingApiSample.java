/* Sample code for calling the Yelp API using http. It works!*/
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class callingApiSample {
        static String apiKey = "insert api key";
        static String location = "Toronto";
        static String term = "food"; // could be any term a user types into the search bar e.g chinese, italian, etc.

        public static void main(String[] args) throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.yelp.com/v3/businesses/search?location=" + location + "&term=" + term +"&sort_by=best_match&limit=20"))
                    .header("accept", "application/json")
                    .header("Authorization", apiKey)
                    .method("GET", HttpRequest.BodyPublishers.noBody())

                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
    }




