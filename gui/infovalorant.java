package gui;
//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.text.ParseException;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.*;
//import org.json.simple.JSONObject;



//import org.json.simple.JSONArray;
//import gui.MainPage.EventoResposta;

public class infovalorant extends JFrame {

    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JLabel info4;
    private JLabel info5;


    public infovalorant() {
        super("Informações do campeonato");

        // inicialização dos componentes
        info1 = new JLabel("Campeonato de Valorant UNIJORGE");
        info2 = new JLabel("Data:   xx/xx/xx");
        info3 = new JLabel("Hora:   xx:xx AM");
        info4 = new JLabel("Premio: Um pastel e um caldo de cana");
        info5 = new JLabel("Organização by Peripécias");

        // definição dos layouts
        JPanel panel = (JPanel) getContentPane(); // obtém o painel de conteúdo desta janela
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10) );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,5,10);

        // ------------------- adição dos componentes na janela -------------------

        // ---------------- Componentes da linha 0 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        panel.add(info1,constraints);

        // ---------------- Componentes da linha 1 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(info2,constraints);

        // ---------------- Componentes da linha 2 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(info3,constraints);

        // ---------------- Componentes da linha 3 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        panel.add(info4,constraints);

        // ---------------- Componentes da linha 4 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        panel.add(info5,constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600,300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}
