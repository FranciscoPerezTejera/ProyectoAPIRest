package company.proyectoapirest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import company.proyectoapirest.dto.PokemonDTO;
import company.proyectoapirest.dto.RestClient;
import company.proyectoapirest.interfaz.APIRestScreen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RestClient cliente = new RestClient();
        String resultado = "";

        resultado = cliente.getPokemonsLimit("151");

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");

        List<PokemonDTO> listaDePokemons = Arrays.asList(gson.fromJson(resultsArray, PokemonDTO[].class));

        List<String> lista = new ArrayList<String>();

        for (PokemonDTO pokemon : listaDePokemons) {
            lista.add(pokemon.getName());
        }

        APIRestScreen nuevaAPIRestScreen = new APIRestScreen(lista);
    }
}
