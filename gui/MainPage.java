package gui;

import javax.lang.model.util.ElementScanner14;
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
    public int jogo;

    /* Construtores ----------------------------------------------------- */
    public MainPage() {
        super("Torneios de E-sports");

        // inicialização dos componentes

        labelTorneios = new JLabel("Campeonato:");
        // array de textos que será passado para o ComboBox
        String[] signos = {"League of Legends","CS.GO","Valorant","FIFA 2021"};
        caixaTorneios = new JComboBox<String>(signos);
        caixaTorneios.setSize(80, 30);
        botaoCadastrar = new JButton("Cadastrar Participante");
        botaoCadastrar.setSize(50, 30);
        botaoCadastrar.addActionListener(new EventoCadastrar());
        botaoVisualizar = new JButton("Vizualizar Equipe e Participantes");
        botaoVisualizar.setSize(50, 30);

        // definição dos layouts
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(50, 30, 50, 30)); // uma borda para afastar os compoentes da janela
        panel.add(labelTorneios, BorderLayout.NORTH);
        panel.add(caixaTorneios, BorderLayout.SOUTH);
        panel.add(botaoCadastrar, BorderLayout.WEST);
        panel.add(botaoVisualizar, BorderLayout.EAST);
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
    private class EventoCadastrar implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            if (caixaTorneios.getSelectedItem() == "League of Legends"){System.out.println("lolzim");

            }   else if (caixaTorneios.getSelectedItem() == "CS.GO"){System.out.println("cs");

                }   else if (caixaTorneios.getSelectedItem() == "Valorant"){System.out.println("valorant");

                    }else {System.out.println("fifa");}
            Cadastro janelaCadastro = new Cadastro();
        }
    }

}
