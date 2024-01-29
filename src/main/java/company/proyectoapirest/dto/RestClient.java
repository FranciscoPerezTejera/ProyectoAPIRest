package company.proyectoapirest.dto;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
    private final String URL_API = "https://pokeapi.co/api/v2/";

    public String getPokemons() {
        return sendGetRequest("pokemon");
    }

    public String getPokemonsByIDWithQueryParams(String id) {
        return sendGetRequestWithQueryParams("pokemon/", id);
    }

    public String getPokemonsLimit(String limit) {
        return sendGetRequestPokemonsLimit("pokemon/", limit);
    }
    private String sendGetRequestWithQueryParams(String endpoint, String id) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL_API + endpoint + id);
            request.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = httpClient.execute(request);
            return extractResponseContent(response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String sendGetRequestPokemonsLimit(String endpoint, String limit) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL_API + endpoint + "?limit=" + limit);
            request.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = httpClient.execute(request);
            return extractResponseContent(response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String sendGetRequest(String endpoint) {

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL_API + endpoint);
            request.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = httpClient.execute(request);
            return extractResponseContent(response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String extractResponseContent(CloseableHttpResponse response) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}