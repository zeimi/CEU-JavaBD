package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import org.json.simple.JSONObject;


import org.json.simple.JSONArray;
//import gui.MainPage.EventoResposta;

public class CadastroLOL extends JFrame {

    private JLabel labeltxt;
    private JTextField txtNome;
    private JLabel labeltxt1;
    private JTextField txtJog1;
    private JLabel labeltxt2;
    private JTextField txtJog2;
    private JLabel labeltxt3;
    private JTextField txtJog3;
    private JLabel labeltxt4;
    private JTextField txtJog4;
    private JLabel labeltxt5;
    private JTextField txtJog5;
    private JButton botaoSalvar;


    public CadastroLOL() {
        super("Cadastro de Equipe");

        // inicialização dos componentes
        labeltxt = new JLabel("Nome do Time:");
        txtNome = new JTextField(25);
        labeltxt1 = new JLabel("Jogador do Topo:");
        txtJog1 = new JTextField(25);
        labeltxt2 = new JLabel("Jogador da Selva:");
        txtJog2 = new JTextField(25);
        labeltxt3 = new JLabel("Jogador do Meio:");
        txtJog3 = new JTextField(25);
        labeltxt4 = new JLabel("Jogador Atirador:");
        txtJog4 = new JTextField(25);
        labeltxt5 = new JLabel("Jogador Suporte:");
        txtJog5 = new JTextField(25);
        botaoSalvar = new JButton("Salvar Time");
        botaoSalvar.setSize(50, 30);

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
        panel.add(labeltxt,constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=0; // linha 0
        panel.add(txtNome, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(labeltxt1, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=1; // linha 1
        panel.add(txtJog1, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(labeltxt2, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 2
        panel.add(txtJog2, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        panel.add(labeltxt3, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=3; // linha 3
        panel.add(txtJog3, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        panel.add(labeltxt4, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=4; // linha 4
        panel.add(txtJog4, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=5; // linha 5
        panel.add(labeltxt5, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=5; // linha 5
        panel.add(txtJog5, constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=6; // linha 6
        constraints.gridwidth=2; // ocupa 2 colunas
        panel.add(botaoSalvar, constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(600,300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}
