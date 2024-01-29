package company.proyectoapirest.dto;

import java.util.ArrayList;

public class PokemonDTO {

    public ArrayList<Ability> abilities;
    public int base_experience;
    public ArrayList<Form> forms;
    public ArrayList<Stat> stats;
    public ArrayList<Type> types;
    public int weight;

    public PokemonDTO() {
    }

    public PokemonDTO(ArrayList<Ability> abilities, int base_experience, ArrayList<Form> forms, ArrayList<Stat> stats, ArrayList<Type> types, int weight) {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.forms = forms;
        this.stats = stats;
        this.types = types;
        this.weight = weight;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public ArrayList<Form> getForms() {
        return forms;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public int getWeight() {
        return weight;
    }
}

class Ability {
    public Ability ability;
}

class Ability2 {
    public String name;
}

class Form {
    public String name;
}

class Stat {
    public int base_stat;
    public int effort;
    public Stat stat;
}

class Stat2 {
    public String name;
}

class Type {
    public int slot;
    public Type type;
}

class Type2 {
    public String name;
}
