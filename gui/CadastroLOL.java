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


    public CadastroLOL() {
        super("Cadastro de Equipe");

        // inicialização dos componentes
        labeltxt = new JLabel("Nome:");
        txtNome = new JTextField(50);

        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(50, 30, 50, 30)); // uma borda para afastar os compoentes da janela
        panel.add(labeltxt, BorderLayout.NORTH);
        panel.add(txtNome, BorderLayout.CENTER);
        add(panel);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}
