package gui;
import javax.imageio.ImageIO;
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

public class Visualizar extends JFrame {

    private JButton botaoSalvar;


    public Visualizar() {
        super("Visualizar Equipe");

        // inicialização dos componentes
        botaoSalvar = new JButton("Salvar Time");
        botaoSalvar.setSize(200, 300);

        // definição dos layouts
        JPanel panel = (JPanel) getContentPane(); // obtém o painel de conteúdo desta janela
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10) );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,5,10);

        constraints.gridx=0; // coluna 0
        constraints.gridy=6; // linha 6
        constraints.gridwidth=2; // ocupa 2 colunas
        panel.add(botaoSalvar, constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600,300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}
