package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entidades.Equipe;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.*;
import java.util.List;
import org.json.simple.*;

public class JogadoresEquipe extends JFrame{
    /* Atributos --------------------------------------------------------- */
    private JLabel labelNome;
    private JLabel labelTAG;
    private JLabel labelJogo;
    private JList listJogadores;
    private DefaultListModel<JSONObject> modelJogadores;

    private JLabel labeljog1Nome;
    private JLabel labeljog2Nome;
    private JLabel labeljog3Nome;
    private JLabel labeljog4Nome;
    private JLabel labeljog5Nome;

    private JLabel labeljog1Nick;
    private JLabel labeljog2Nick;
    private JLabel labeljog3Nick;
    private JLabel labeljog4Nick;
    private JLabel labeljog5Nick;

    private JLabel labeljog1Role;
    private JLabel labeljog2Role;
    private JLabel labeljog3Role;
    private JLabel labeljog4Role;
    private JLabel labeljog5Role;

    private JSONArray jogadoresJSON;
    private JSONObject jog1Json;
    private JSONObject jog2Json;
    private JSONObject jog3Json;
    private JSONObject jog4Json;
    private JSONObject jog5Json;

    String jog1nome;
    String jog1nick;
    String jog1role;

    String jog2nome;
    String jog2nick;
    String jog2role;

    String jog3nome;
    String jog3nick;
    String jog3role;

    String jog4nome;
    String jog4nick;
    String jog4role;

    String jog5nome;
    String jog5nick;
    String jog5role;



    /* Construtores ----------------------------------------------------- */
    public JogadoresEquipe(Equipe equipe){
        super("Jogadores da equipe"); // nome da janela

        // inicialização dos labels
        labelNome = new JLabel("Nome da Equipe: "+equipe.getNome());
        labelTAG = new JLabel("TAG da Equipe: "+equipe.getTag());
        labelJogo = new JLabel("Torneio do Jogo: "+equipe.getJogo());

        // obtém o JSONArray de jogadores (JSONObject)
        JSONArray jogadoresJSON = equipe.getJogadores();
        int n = jogadoresJSON.size();

        //Adicionar aqui filtragem de jogo
        if (equipe.getJogo().equals("CSGO") || equipe.getJogo().equals("Valorant")) {
            while (n >= 0) { // Filtragem e coleta de dados csgo+valorant
          
                if (n == 4) { // Se o número de jogadores for 5:
                    // Filtrando os dados de JSON para String
                    jog5Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog5 = (JSONObject)jog5Json.get("Jogador5");
    
                    //Coletando as Strings
                    jog5nome = (String)jog5.get("Nome");
                    jog5nick = (String)jog5.get("Nickname");
                    jog5role = (String)jog5.get("Role");
    
                } else if (n == 3) { // Se o número de jogadores for 4:
                    // Filtrando os dados de JSON para String
                    jog4Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog4 = (JSONObject)jog4Json.get("Jogador4");
    
                    //Coletando as Strings
                    jog4nome = (String)jog4.get("Nome");
                    jog4nick = (String)jog4.get("Nickname");
                    jog4role = (String)jog4.get("Role");
                } else if (n == 2) { // Se o número de jogadores for 3:
                    // Filtrando os dados de JSON para String
                    jog3Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog3 = (JSONObject)jog3Json.get("Jogador3");
    
                    //Coletando as Strings
                    jog3nome = (String)jog3.get("Nome");
                    jog3nick = (String)jog3.get("Nickname");
                    jog3role = (String)jog3.get("Role");
                } else if (n == 1) { // Se o número de jogadores for 2:
                    // Filtrando os dados de JSON para String
                    jog2Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog2 = (JSONObject)jog2Json.get("Jogador2");
    
                    //Coletando as Strings
                    jog2nome = (String)jog2.get("Nome");
                    jog2nick = (String)jog2.get("Nickname");
                    jog2role = (String)jog2.get("Role");
                } else if (n == 0) { // Se o número de jogadores for 1:
                    // Filtrando os dados de JSON para String
                    jog1Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog1 = (JSONObject)jog1Json.get("Jogador1");
    
                    //Coletando as Strings
                    jog1nome = (String)jog1.get("Nome");
                    jog1nick = (String)jog1.get("Nickname");
                    jog1role = (String)jog1.get("Role");
                }
                n--; 
            }
        } else if (equipe.getJogo().equals("League of Legends")) {
            System.out.println(jogadoresJSON);
            while (n >= 0) { // Filtragem e coleta de dados League of
          
                if (n == 4) { // Se o número de jogadores for 5:
                    // Filtrando os dados de JSON para String
                    jog5Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog5 = (JSONObject)jog5Json.get("Sup");
    
                    //Coletando as Strings
                    jog5nome = (String)jog5.get("Nome");
                    jog5nick = (String)jog5.get("Nickname");
                    jog5role = "Sup";
    
                } else if (n == 3) { // Se o número de jogadores for 4:
                    // Filtrando os dados de JSON para String
                    jog4Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog4 = (JSONObject)jog4Json.get("Adc");
    
                    //Coletando as Strings
                    jog4nome = (String)jog4.get("Nome");
                    jog4nick = (String)jog4.get("Nickname");
                    jog4role = "Adc";
                } else if (n == 2) { // Se o número de jogadores for 3:
                    // Filtrando os dados de JSON para String
                    jog3Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog3 = (JSONObject)jog3Json.get("Mid");
    
                    //Coletando as Strings
                    jog3nome = (String)jog3.get("Nome");
                    jog3nick = (String)jog3.get("Nickname");
                    jog3role = "Mid";
                } else if (n == 1) { // Se o número de jogadores for 2:
                    // Filtrando os dados de JSON para String
                    jog2Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog2 = (JSONObject)jog2Json.get("Jungle");
    
                    //Coletando as Strings
                    jog2nome = (String)jog2.get("Nome");
                    jog2nick = (String)jog2.get("Nickname");
                    jog2role = "Jungle";
                } else if (n == 0) { // Se o número de jogadores for 1:
                    // Filtrando os dados de JSON para String
                    jog1Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog1 = (JSONObject)jog1Json.get("Top");
    
                    //Coletando as Strings
                    jog1nome = (String)jog1.get("Nome");
                    jog1nick = (String)jog1.get("Nickname");
                    jog1role = "Top";
                }
                n--; 
            }
        } else if (equipe.getJogo().equals("Rocket League")) {
            System.out.println(jogadoresJSON);
            while (n >= 0) { // Filtragem e coleta de dados csgo+valorant
          
                
                if (n == 2) { // Se o número de jogadores for 3:
                    // Filtrando os dados de JSON para String
                    jog3Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog3 = (JSONObject)jog3Json.get("Jogador3");
    
                    //Coletando as Strings
                    jog3nome = (String)jog3.get("Nome");
                    jog3nick = (String)jog3.get("Nickname");
                    jog3role = (String)jog3.get("Role");
                } else if (n == 1) { // Se o número de jogadores for 2:
                    // Filtrando os dados de JSON para String
                    jog2Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog2 = (JSONObject)jog2Json.get("Jogador2");
    
                    //Coletando as Strings
                    jog2nome = (String)jog2.get("Nome");
                    jog2nick = (String)jog2.get("Nickname");
                    jog2role = (String)jog2.get("Role");
                } else if (n == 0) { // Se o número de jogadores for 1:
                    // Filtrando os dados de JSON para String
                    jog1Json = (JSONObject)jogadoresJSON.get(n);
                    JSONObject jog1 = (JSONObject)jog1Json.get("Jogador1");
    
                    //Coletando as Strings
                    jog1nome = (String)jog1.get("Nome");
                    jog1nick = (String)jog1.get("Nickname");
                    jog1role = (String)jog1.get("Role");
                }
                n--; 
            }

        }
        
        labeljog1Nome = new JLabel("Nome do Jogador: "+jog1nome);
        labeljog1Nick = new JLabel("Nick do Jogador: "+jog1nick);
        labeljog1Role = new JLabel("Role do Jogador: "+jog1role);
    
        labeljog2Nome = new JLabel("Nome do Jogador: "+jog2nome);
        labeljog2Nick = new JLabel("Nick do Jogador: "+jog2nick);
        labeljog2Role = new JLabel("Role do Jogador: "+jog2role);
    
        labeljog3Nome = new JLabel("Nome do Jogador: "+jog3nome);
        labeljog3Nick = new JLabel("Nick do Jogador: "+jog3nick);
        labeljog3Role = new JLabel("Role do Jogador: "+jog3role);
    
        labeljog4Nome = new JLabel("Nome do Jogador: "+jog4nome);
        labeljog4Nick = new JLabel("Nick do Jogador: "+jog4nick);
        labeljog4Role = new JLabel("Role do Jogador: "+jog4role);
    
        labeljog5Nome = new JLabel("Nome do Jogador: "+jog5nome);
        labeljog5Nick = new JLabel("Nick do Jogador: "+jog5nick);
        labeljog5Role = new JLabel("Role do Jogador: "+jog5role);
    

        //listJogadores = new JList(modelJogadores);
        //listJogadores.setVisibleRowCount(5);
        //listJogadores.setFixedCellWidth(200);
        //listJogadores.setFixedCellHeight(15);
        //listJogadores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // permite selecionar vários registros da lista

        // configuração do layout
        JPanel panel = (JPanel)getContentPane(); // obtem o panel da própria janela
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10) );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5,5,5,5);

        // adiciona os componentes na janela
        // ---------- Linha 0 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        panel.add(labelNome,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=0; // linha 0
        panel.add(labelTAG,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=0; // linha 0
        panel.add(labelJogo,constraints);
        // -----------------------------

        // ---------- Linha 1 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(labeljog1Nome ,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=1; // linha 1
        panel.add(labeljog1Nick ,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=1; // linha 1
        panel.add(labeljog1Role ,constraints);
        // -----------------------------

        // ---------- Linha 2 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 1
        panel.add(labeljog2Nome ,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 1
        panel.add(labeljog2Nick ,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=2; // linha 1
        panel.add(labeljog2Role ,constraints);
        // -----------------------------

        // ---------- Linha 3 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 1
        panel.add(labeljog3Nome ,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=3; // linha 1
        panel.add(labeljog3Nick ,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=3; // linha 1
        panel.add(labeljog3Role ,constraints);
        // -----------------------------

        // ---------- Linha 4 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 1
        panel.add(labeljog4Nome ,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=4; // linha 1
        panel.add(labeljog4Nick ,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=4; // linha 1
        panel.add(labeljog4Role ,constraints);
        // -----------------------------

        // ---------- Linha 5 ----------
        constraints.gridx=0; // coluna 0
        constraints.gridy=5; // linha 1
        panel.add(labeljog5Nome ,constraints);

        constraints.gridx=1; // coluna 1
        constraints.gridy=5; // linha 1
        panel.add(labeljog5Nick ,constraints);

        constraints.gridx=2; // coluna 2
        constraints.gridy=5; // linha 1
        panel.add(labeljog5Role ,constraints);
        // -----------------------------





        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); 
        setLocation(600,300);
        pack(); 
        setVisible(true);
    }

    /* Métodos -------------------------------------------------------------*/

    /* Classes internas ---------------------------------------------------- */
}
