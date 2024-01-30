package company.proyectoapirest.dto;

public class ItemDTO {

    public String name;
    public String url;

    public ItemDTO() {
    }

    public ItemDTO(String name, String url) {
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
        return "Objeto [" + "Nombre: " + name + ", URL de información: " + url + ']';
    }
}
