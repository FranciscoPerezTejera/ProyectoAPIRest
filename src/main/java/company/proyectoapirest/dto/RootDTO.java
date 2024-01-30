package company.proyectoapirest.dto;

import java.util.ArrayList;

public class RootDTO {

    public ArrayList<Ability> abilities;
    public int base_experience;
    public ArrayList<Form> forms;
    public ArrayList<Stat> stats;
    public ArrayList<Type> types;
    public int weight;

    public RootDTO() {
    }

    public RootDTO(ArrayList<Ability> abilities, int base_experience, ArrayList<Form> forms, ArrayList<Stat> stats, ArrayList<Type> types, int weight) {
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

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<Form> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Stat> stats) {
        this.stats = stats;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Datos del Pokémon "
                + "\n  Habilidades: " + abilities
                + "\n  Experiencia base: " + base_experience
                + "\n  Pokemon: " + forms
                + "\n  Estadísticas: " + stats
                + "\n  Tipos: " + types
                + "\n  Peso: " + weight;
    }
}

class Ability {

    public Ability2 ability;
    public boolean is_hidden;
    public int slot;

    @Override
    public String toString() {
        return "Nombre: " + ability;
                
    }
}

class Ability2 {

    public String name;

    @Override
    public String toString() {
        return name;
    }
    
    
}

class Form {

    public String name;

    @Override
    public String toString() {
        return name;
    }
    
    
}

class Stat {

    public int base_stat;
    public int effort;
    public Stat2 stat;

    @Override
    public String toString() {
        return "\n      estadistica base: " + base_stat + ", nombre: " + stat + "\n";
    }
    
    
}

class Stat2 {

    public String name;

    @Override
    public String toString() {
        return name;
    }
    
    
}

class Type {

    public int slot;
    public Type2 type;

    @Override
    public String toString() {
        return "Tipo: " + type;
    }
    
    
}

class Type2 {

    public String name;

    @Override
    public String toString() {
        return name;
    }
    
    
}
