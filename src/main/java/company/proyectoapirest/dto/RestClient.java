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
    
    public String getMove() {
        return sendGetRequest("move");
    }
    
    public String getItem() {
        return sendGetRequest("item");
    }

    public String getPokemonsByNameWithQueryParams(String name) {
        return sendGetRequestWithQueryParams("pokemon/", name);
    }
    
        public String getItemsWithQueryParams(String queryOne, String queryTwo) {
        return sendGetRequestWithQueryParams("pokemon", queryOne + queryTwo);
    }
    
    public String getMovesLimit(String limit) {
        return sendGetRequestPokemonsLimit("move", limit);
    }
    
    public String getItemsLimit(String limit) {
        return sendGetRequestPokemonsLimit("item", limit);
    }
    
    public String getPokemonsLimit(String limit) {
        return sendGetRequestPokemonsLimit("pokemon", limit);
    }
    
    
    private String sendGetRequestWithQueryParams(String endpoint, String query) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL_API + endpoint + query);
            request.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = httpClient.execute(request);
            return extractResponseContent(response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        private String sendGetRequestWithTwoQueryParams(String endpoint, String querOne, String queryTwo) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL_API + endpoint + "?limit=" + querOne + "&sort_by=" + queryTwo);
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