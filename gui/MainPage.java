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
    private JButton btnShowDisciplinas;
    private JLabel labelTorneios;
    private JComboBox caixaTorneios;

    /* Construtores ----------------------------------------------------- */
    public MainPage() {
        super("Torneios de E-sports");

        // inicialização dos componentes
        btnShowDisciplinas = new JButton("Mostrar disciplinas do aluno");

        labelTorneios = new JLabel("Campeonato:");
        // array de textos que será passado para o ComboBox
        String[] signos = {"League of Legends","Counter-Strike: Global Offensive","Valorant","FIFA 2021","Clash Royale","Overwatch",
                           "Among us","DOTA 2","Skyrim","DOOM Eternal","Pokemon","Legends of Runeterra"};
        caixaTorneios = new JComboBox<String>(signos);
        botaoCadastrar = new JButton("Cadastrar Participante");
        botaoVisualizar = new JButton("Vizualizar Equipe e Participantes");

        // definição dos layouts
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(50, 30, 50, 30)); // uma borda para afastar os compoentes da janela
        panel.add(caixaTorneios, BorderLayout.NORTH);
        panel.add(botaoCadastrar, BorderLayout.CENTER);
        panel.add(botaoVisualizar, BorderLayout.SOUTH);
        add(panel); // coloco o painel dentro da janela

        // configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }

    /* Métodos ------------------------------------------------------------- */

    /* Classes internas ---------------------------------------------------- */

}
