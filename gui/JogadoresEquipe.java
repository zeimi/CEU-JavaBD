package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entidades.Equipe;

import java.awt.*;
import java.util.List;
import org.json.simple.JSONObject;

public class JogadoresEquipe extends JFrame{
    /* Atributos --------------------------------------------------------- */
    private JLabel labelNome;
    private JLabel labelTAG;
    private JLabel labelJogo;
    private JList listJogadores;
    private DefaultListModel<JSONObject> modelJogadores;

    /* Construtores ----------------------------------------------------- */
    public JogadoresEquipe(Equipe equipe){
        super("Jogadores da equipe"); // nome da janela

        // inicialização dos labels
        labelNome = new JLabel("Nome da Equipe: "+equipe.getNome());
        labelTAG = new JLabel("TAG da Equipe: "+equipe.getTag());
        labelJogo = new JLabel("Torneio do Jogo: "+equipe.getJogo());

        
        modelJogadores = new DefaultListModel<JSONObject>();

        // obtém o JSONArray de jogadores (JSONObject)
        List<JSONObject> jogadores = equipe.getJogadores();
        // Numero de jogadores dentro do array
        int n = jogadores.size(); 

        for(int i=0; i < n; i++){ // loop para colocar x jogadores no model
            // obtem cada um dos jogadores
            JSONObject jogador = jogadores.get(i);
            // adiciona jogadores no model
            modelJogadores.addElement(jogador);
        }

        listJogadores = new JList(modelJogadores);
        listJogadores.setVisibleRowCount(5);
        listJogadores.setFixedCellWidth(200);
        listJogadores.setFixedCellHeight(15);
        listJogadores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // permite selecionar vários registros da lista

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
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        panel.add(labelNome,constraints);
        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(labelTAG,constraints);
        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(labelJogo,constraints);
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        panel.add( new JScrollPane(listJogadores) ,constraints);

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
