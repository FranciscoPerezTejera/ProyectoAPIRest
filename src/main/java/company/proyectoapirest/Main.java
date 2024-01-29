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
        
        
        APIRestScreen nuevaAPIRestScreen;
        RestClient cliente = new RestClient();

        String pokemons = cliente.getPokemonsLimit("151");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(pokemons, JsonObject.class);
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");

        List<PokemonDTO> pokemones = Arrays.asList(gson.fromJson(resultsArray, PokemonDTO[].class));
        List <String> nombresPokemon = new ArrayList<>();
       // List <PokemonDTO> listaDenombre = p

        for (PokemonDTO pokemon : pokemones) {
          //  nombresPokemon.add(pokemon.getName());
        }
        
        for (String string : nombresPokemon) {
            System.out.println(string);
        }
        
        nuevaAPIRestScreen = new APIRestScreen(pokemones);
    }
}
