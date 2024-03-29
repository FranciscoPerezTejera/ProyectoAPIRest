package company.proyectoapirest.dto;

public class PokemonDTO {

    public String name;
    public String url;

    public PokemonDTO() {
    }

    public PokemonDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pokemon [" + "Nombre : " + name + ", URL de información: " + url + ']';
    }
}
