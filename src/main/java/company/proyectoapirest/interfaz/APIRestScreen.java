package company.proyectoapirest.interfaz;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import company.proyectoapirest.dto.ItemDTO;
import company.proyectoapirest.dto.MoveDTO;
import company.proyectoapirest.dto.PokemonDTO;
import company.proyectoapirest.dto.RestClient;
import company.proyectoapirest.dto.RootDTO;
import java.util.Arrays;
import java.util.List;

public class APIRestScreen extends javax.swing.JFrame {

    List<String> nombresDePokemon;

    public APIRestScreen(List<String> nombrePokemons) {
        initComponents();
        this.nombresDePokemon = nombrePokemons;

        for (String nombre : nombresDePokemon) {
            nombrePokemonsComboBox.addItem(nombre);
        }

        nombreRecursoComboBox.addActionListener((e) -> {

            RestClient cliente = new RestClient();
            String resultado = "";

            areaDeTextoUno.setText("");

            if (nombreRecursoComboBox.getSelectedItem().toString().equalsIgnoreCase("selecciona uno")) {
                areaDeTextoUno.setText("Selecciona uno de los recursos en el desplegable de arriba.");

            } else if (nombreRecursoComboBox.getSelectedItem().toString().equalsIgnoreCase("pokemons")) {

                resultado = cliente.getPokemonsLimit("1302");

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
                JsonArray resultsArray = jsonObject.getAsJsonArray("results");

                List<PokemonDTO> listaDePokemons = Arrays.asList(gson.fromJson(resultsArray, PokemonDTO[].class));

                int i = 1;

                for (PokemonDTO pokemones : listaDePokemons) {
                    areaDeTextoUno.append(i++ + ".- " + pokemones.toString() + "\n");
                }

            } else if (nombreRecursoComboBox.getSelectedItem().toString().equalsIgnoreCase("MOVIMIENTOS")) {

                resultado = cliente.getMovesLimit("937");

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
                JsonArray resultsArray = jsonObject.getAsJsonArray("results");

                List<MoveDTO> movimientos = Arrays.asList(gson.fromJson(resultsArray, MoveDTO[].class));

                int i = 1;

                for (MoveDTO moves : movimientos) {
                    areaDeTextoUno.append(i++ + " " + moves.toString() + "\n");
                }

            } else if (nombreRecursoComboBox.getSelectedItem().toString().equalsIgnoreCase("items")) {

                resultado = cliente.getItemsLimit("2110");

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
                JsonArray resultsArray = jsonObject.getAsJsonArray("results");

                List<ItemDTO> objetos = Arrays.asList(gson.fromJson(resultsArray, ItemDTO[].class));

                int i = 1;

                for (ItemDTO objeto : objetos) {
                    areaDeTextoUno.append(i++ + " " + objeto.toString() + "\n");
                }
            }
        });

        nombrePokemonsComboBox.addActionListener((e) -> {

            areaDeTextoDos.setText("");

            RestClient cliente = new RestClient();
            String nombreSeleccionado = nombrePokemonsComboBox.getSelectedItem().toString();

            String resultado = cliente.getPokemonsByNameWithQueryParams(nombreSeleccionado);

            Gson gson = new Gson();

            RootDTO root = gson.fromJson(resultado, RootDTO.class);
            areaDeTextoDos.setText(root.toString());

        });

        queryParamsComboBox.addActionListener((e) -> {

            RestClient cliente = new RestClient();
            String resultado = "";
            Gson gson = null;
            PokemonDTO pokemon = null;

            areaDeTextoTres.setText("");

            if (queryParamsComboBox.getSelectedItem().toString().equalsIgnoreCase("50 pokemons saltandome los 50 primeros")) {

                gson = new Gson();

                resultado = cliente.getPokemonsByNameWithQueryParams("?offset=40&limit=50");

                JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
                JsonArray resultsArray = jsonObject.getAsJsonArray("results");

                List<PokemonDTO> listaDePokemons = Arrays.asList(gson.fromJson(resultsArray, PokemonDTO[].class));
                int i = 1;

                for (PokemonDTO pokemones : listaDePokemons) {
                    areaDeTextoTres.append(i++ + ".- " + pokemones.toString() + "\n");
                }
            } else if (queryParamsComboBox.getSelectedItem().toString().equalsIgnoreCase("100 primeros items limitado")) {

                gson = new Gson();

                resultado = cliente.getItemsLimit("100");
                
                System.out.println(resultado);

                JsonObject jsonObject = gson.fromJson(resultado, JsonObject.class);
                JsonArray resultsArray = jsonObject.getAsJsonArray("results");

                List<ItemDTO> objetos = Arrays.asList(gson.fromJson(resultsArray, ItemDTO[].class));

                int i = 1;

                for (ItemDTO item : objetos) {
                    areaDeTextoTres.append(i++ + " " + item.toString() + "\n");
                }

            } else if (queryParamsComboBox.getSelectedItem().toString().equalsIgnoreCase("Selecciona una query")) {

                areaDeTextoTres.setText("Selecciona uno de los recursos en el desplegable de arriba.");

            }
        });

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreRecursoComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDeTextoUno = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombrePokemonsComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDeTextoDos = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        queryParamsComboBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDeTextoTres = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRUEBA DE GET MASIVO DE 3 RECURSOS API POKEMON");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Elige uno de los recursos: ");

        nombreRecursoComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombreRecursoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Uno", "POKEMONS", "MOVIMIENTOS", "ITEMS" }));
        nombreRecursoComboBox.setToolTipText("");

        areaDeTextoUno.setEditable(false);
        areaDeTextoUno.setColumns(20);
        areaDeTextoUno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        areaDeTextoUno.setLineWrap(true);
        areaDeTextoUno.setRows(5);
        jScrollPane1.setViewportView(areaDeTextoUno);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(nombreRecursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreRecursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("GET MASIVO 3 RECURSOS", jPanel3);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GET CON ID API POKEMON");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Elige un pokémon: ");

        nombrePokemonsComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nombrePokemonsComboBox.setToolTipText("");

        areaDeTextoDos.setEditable(false);
        areaDeTextoDos.setColumns(20);
        areaDeTextoDos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        areaDeTextoDos.setLineWrap(true);
        areaDeTextoDos.setRows(5);
        jScrollPane2.setViewportView(areaDeTextoDos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombrePokemonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombrePokemonsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("GET MASIVO POR ATRIBUTO POKEAPI", jPanel1);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GET CON FILTRADO QUERYPARAMS");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Elige una query: ");

        queryParamsComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        queryParamsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una query", "50 pokemons saltandome los 50 primeros", "100 primeros items limitado" }));
        queryParamsComboBox.setToolTipText("");

        areaDeTextoTres.setEditable(false);
        areaDeTextoTres.setColumns(20);
        areaDeTextoTres.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        areaDeTextoTres.setRows(5);
        jScrollPane3.setViewportView(areaDeTextoTres);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(queryParamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(queryParamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("GET CON FILTRADO QUERYPARAMS", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("POST API REST", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeTextoDos;
    private javax.swing.JTextArea areaDeTextoTres;
    private javax.swing.JTextArea areaDeTextoUno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> nombrePokemonsComboBox;
    private javax.swing.JComboBox<String> nombreRecursoComboBox;
    private javax.swing.JComboBox<String> queryParamsComboBox;
    // End of variables declaration//GEN-END:variables
}
