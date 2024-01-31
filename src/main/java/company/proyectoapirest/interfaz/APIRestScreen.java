package company.proyectoapirest.interfaz;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import company.proyectoapirest.dto.ItemDTO;
import company.proyectoapirest.dto.MoveDTO;
import company.proyectoapirest.dto.PokemonDTO;
import company.proyectoapirest.dto.RestClient;
import company.proyectoapirest.dto.RootDTO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tituloCartaTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaTextoCarta = new javax.swing.JTextArea();
        operacionPostEnviarButton = new javax.swing.JButton();
        borrarContenidoButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        respuestaDelPost = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

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

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("POST DE UNA CARTA A PLACEHOLDER");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Título de la carta:");

        tituloCartaTextField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Cuerpo de la carta:");

        areaTextoCarta.setColumns(20);
        areaTextoCarta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        areaTextoCarta.setRows(5);
        jScrollPane4.setViewportView(areaTextoCarta);

        operacionPostEnviarButton.setText("ENVIAR POST");
        operacionPostEnviarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionPostEnviarButtonActionPerformed(evt);
            }
        });

        borrarContenidoButton.setText("BORRAR");
        borrarContenidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarContenidoButtonActionPerformed(evt);
            }
        });

        respuestaDelPost.setColumns(20);
        respuestaDelPost.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        respuestaDelPost.setRows(5);
        jScrollPane5.setViewportView(respuestaDelPost);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Respuesta del POST:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(operacionPostEnviarButton)
                                .addGap(18, 18, 18)
                                .addComponent(borrarContenidoButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tituloCartaTextField)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5))))
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tituloCartaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrarContenidoButton)
                    .addComponent(operacionPostEnviarButton))
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void operacionPostEnviarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionPostEnviarButtonActionPerformed

        if (tituloCartaTextField.getText().isEmpty() && areaTextoCarta.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "LOS CAMPOS NO PUEDEN ESTAR VACIOS",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } else {

            Gson gson = new Gson();
            JSONObject objeto = new JSONObject();
            CloseableHttpClient cliente = null;
            HttpPost httpPost = null;

            objeto.accumulate("title", tituloCartaTextField.getText());
            objeto.accumulate("body", areaTextoCarta.getText());
            objeto.accumulate("userId", 4);

            String jsonPost = gson.toJson(objeto);

            try {
                cliente = HttpClients.createDefault();
                httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");
                httpPost.setHeader("Content-Type", "application/json");

                StringEntity requestEntity = new StringEntity(jsonPost);

                httpPost.setEntity(requestEntity);
            } catch (Exception e) {

            }
            try {
                CloseableHttpResponse response = cliente.execute(httpPost);

                HttpEntity responseEntity = response.getEntity();

                if (responseEntity != null) {

                    String respuesta = EntityUtils.toString(responseEntity);
                    respuestaDelPost.setText(respuesta);

                } else {
                    JOptionPane.showMessageDialog(this, "FALLO EN LA RESPUESTA");
                }
                
                cliente.close();
                
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_operacionPostEnviarButtonActionPerformed

    private void borrarContenidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarContenidoButtonActionPerformed

        tituloCartaTextField.setText("");
        areaTextoCarta.setText("");
        respuestaDelPost.setText("");

    }//GEN-LAST:event_borrarContenidoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeTextoDos;
    private javax.swing.JTextArea areaDeTextoTres;
    private javax.swing.JTextArea areaDeTextoUno;
    private javax.swing.JTextArea areaTextoCarta;
    private javax.swing.JButton borrarContenidoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> nombrePokemonsComboBox;
    private javax.swing.JComboBox<String> nombreRecursoComboBox;
    private javax.swing.JButton operacionPostEnviarButton;
    private javax.swing.JComboBox<String> queryParamsComboBox;
    private javax.swing.JTextArea respuestaDelPost;
    private javax.swing.JTextField tituloCartaTextField;
    // End of variables declaration//GEN-END:variables
}
