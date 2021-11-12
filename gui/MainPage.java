package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.xdevapi.JsonParser;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MainPage extends JFrame {
    /* Atributos --------------------------------------------------------- */
    private JButton botaoCadastrar;
    private JButton botaoVisualizar;
    private JLabel labelTorneios;
    private JComboBox caixaTorneios;

    /* Construtores ----------------------------------------------------- */
    public MainPage() {
        super("Torneios de E-sports");

        // inicialização dos componentes

        labelTorneios = new JLabel("Campeonato:");
        // array de textos que será passado para o ComboBox
        String[] torneios = {"League of Legends","CS.GO","Valorant","Rocket League", "Mário Kart"};
        caixaTorneios = new JComboBox<String>(torneios);
        caixaTorneios.setSize(80, 30);
        botaoCadastrar = new JButton("Cadastrar participante");
        botaoCadastrar.setSize(50, 30);
        botaoCadastrar.addActionListener(new EventoCadastrar());
        botaoVisualizar = new JButton("Visualizar equipe e participantes");
        botaoVisualizar.setSize(50, 30);
        botaoVisualizar.addActionListener(new EventoVisualizar());

        // definição dos layouts
        JPanel panel = (JPanel) getContentPane(); // obtém o painel de conteúdo desta janela
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10) );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,5,10);

        // adição dos componentes na janela
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        panel.add(labelTorneios,constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(caixaTorneios, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(botaoCadastrar, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 2
        panel.add(botaoVisualizar, constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }

    /* Métodos ------------------------------------------------------------- */

    /* Classes internas ---------------------------------------------------- */
    private class EventoCadastrar implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            if (caixaTorneios.getSelectedItem() == "League of Legends"){System.out.println("lolzim");
            CadastroLOL janelaCadastro = new CadastroLOL();
                
            } else if (caixaTorneios.getSelectedItem() == "CS.GO"){
                System.out.println("cs");
                CadastroCSGO janelaCadastro = new CadastroCSGO();
            } else if (caixaTorneios.getSelectedItem() == "Valorant"){
                System.out.println("valorant");
                CadastroValorant janelaCadastro = new CadastroValorant();
                        
            } else if (caixaTorneios.getSelectedItem() == "Rocket League") {
                System.out.println("Rocket League");
                CadastroRL janelaCadastro = new CadastroRL();

            } else {
                System.out.println("Mario Kart");
                CadastroMariokart janelaCadastro = new CadastroMariokart();
            }
        }
    }
    
    private class EventoVisualizar implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            Visualizar janelaVisualizar = new Visualizar();
        }
    }


}
