package gui;
//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.text.ParseException;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.*;
//import org.json.simple.JSONObject;



//import org.json.simple.JSONArray;
//import gui.MainPage.EventoResposta;

public class Visualizar extends JFrame {

    private JButton botaonaotemnada;
    private JButton botaoaquiainda;
    private JLabel labelfuturo;


    public Visualizar() {
        super("Visualizar Equipes");

        // inicialização dos componentes
        labelfuturo = new JLabel("                           Futuramente a pagina de participantes");
        botaonaotemnada = new JButton("Aguarde");
        botaonaotemnada.setSize(50, 30);
        botaoaquiainda = new JButton("Em breve 😥");
        botaoaquiainda.setSize(50, 30);

        // definição dos layouts
        JLabel background = new JLabel(new ImageIcon("img/desculpa.gif"));
	    add(background);
	    background.setLayout(new BorderLayout());

        JInternalFrame panel = new JInternalFrame(); // obtém o painel de conteúdo desta janela
        panel.setVisible(true);
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
        panel.add(labelfuturo,constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(botaonaotemnada, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 2
        panel.add(botaoaquiainda, constraints);

        // ---------------- Background ----------------

        background.add(panel, BorderLayout.PAGE_END);
        background.repaint();

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(470,200);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}
