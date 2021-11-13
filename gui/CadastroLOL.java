package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
//import org.json.simple.JSONObject;


//import org.json.simple.JSONArray;
//import gui.MainPage.EventoResposta;

public class CadastroLOL extends JFrame {

    private JLabel labellol;
    private JButton botaolol;

    private JLabel labelequipe;
    private JTextField txtequipe;
    private JLabel labelTag;
    private JTextField txtTag;

    private JLabel labeltop;
    private JTextField txtjog1;
    private JLabel labeljg;
    private JTextField txtjog2;
    private JLabel labelmid;
    private JTextField txtjog3;
    private JLabel labeladc;
    private JTextField txtjog4;
    private JLabel labelsup;
    private JTextField txtjog5;

    private JLabel labelnick1;
    private JLabel labelnick2;
    private JLabel labelnick3;
    private JLabel labelnick4;
    private JLabel labelnick5;

    private JTextField txtnick1;
    private JTextField txtnick2;
    private JTextField txtnick3;
    private JTextField txtnick4;
    private JTextField txtnick5;

    private JButton botaoSalvar;


    public CadastroLOL() {
        super("Cadastro de Equipe");

        // -------------------------------- inicialização dos componentes ----------------------------------------
        labellol = new JLabel("Campeonato de League of legends UNIJORGE");
        botaolol = new JButton("Informações");
        botaolol.addActionListener(new Eventoinfolol());

        labelequipe = new JLabel("Nome da equipe:");
        labelTag = new JLabel("TAG da equipe:");
        labeltop = new JLabel("Top:");
        labeljg = new JLabel("Jungle:");
        labelmid = new JLabel("Mid:");
        labeladc = new JLabel("Adc:");
        labelsup = new JLabel("Sup:");
        
        labelnick1 = new JLabel("Nickname do J1:");
        labelnick2 = new JLabel("Nickname do J2:");
        labelnick3 = new JLabel("Nickname do J3:");
        labelnick4 = new JLabel("Nickname do J4:");
        labelnick5 = new JLabel("Nickname do J5:");

        txtequipe = new JTextField(10);
        //Mascara TAG (4 letras)
        try{
            MaskFormatter mascaratag = new MaskFormatter("UUUU");
            txtTag = new JFormattedTextField(mascaratag);
        }catch(ParseException e){
            e.printStackTrace();
        }
        txtjog1 = new JTextField(25);
        txtjog2 = new JTextField(25);
        txtjog3 = new JTextField(25);
        txtjog4 = new JTextField(25);
        txtjog5 = new JTextField(25);
        
        txtnick1 = new JTextField(10);
        txtnick2 = new JTextField(10);
        txtnick3 = new JTextField(10);
        txtnick4 = new JTextField(10);
        txtnick5 = new JTextField(10);

        botaoSalvar = new JButton("Salvar equipe");
        botaoSalvar.addActionListener(new EventoSalvar());


        // --------------------------------------- definição dos layouts ----------------------------------------
        JLabel background = new JLabel(new ImageIcon("img/league.png"));
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


        // ------------------- adição dos componentes na janela -------------------

        // ---------------- Componentes da linha 0 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        panel.add(labellol,constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=0; // linha 0
        panel.add(botaolol, constraints);

        // ---------------- Componentes da linha 1 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=1; // linha 1
        panel.add(labelequipe,constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=1; // linha 1
        panel.add(txtequipe, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=1; // linha 1
        panel.add(labelTag, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=1; // linha 1
        panel.add(txtTag, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 2 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=2; // linha 2
        panel.add(labeltop, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 2
        panel.add(txtjog1, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=2; // linha 2
        panel.add(labelnick1, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=2; // linha 2
        panel.add(txtnick1, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 3 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        panel.add(labeljg, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=3; // linha 3
        panel.add(txtjog2, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=3; // linha 3
        panel.add(labelnick2, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=3; // linha 3
        panel.add(txtnick2, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 4 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        panel.add(labelmid, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=4; // linha 4
        panel.add(txtjog3, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=4; // linha 4
        panel.add(labelnick3, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=4; // linha 4
        panel.add(txtnick3, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 5 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=5; // linha 5
        panel.add(labeladc, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=5; // linha 5
        panel.add(txtjog4, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=5; // linha 5
        panel.add(labelnick4, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=5; // linha 5
        panel.add(txtnick4, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 6 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=6; // linha 6
        panel.add(labelsup, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=6; // linha 6
        panel.add(txtjog5, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=6; // linha 6
        panel.add(labelnick5, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=6; // linha 6
        panel.add(txtnick5, constraints);

        // ---------------- Background ----------------

        background.add(panel, BorderLayout.PAGE_END);
        background.repaint();

        // ---------------- Componentes da linha 7 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=7; // linha 7
        constraints.gridwidth=5; // ocupa 5 colunas
        panel.add(botaoSalvar, constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(250,50);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }

    /* Métodos -------------------------------------------------------------*/
    private boolean validacaoSalvar(){
        // Validação do campo Nome da Equipe
        if(txtequipe.getText().length() < 3){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome da Equipe' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo TAG da Equipe
        String campoTag = txtTag.getText();
        campoTag = campoTag.replaceAll(" ", "");
        if(campoTag.length() < 3){
            JOptionPane.showMessageDialog(this, "O campo 'TAG' deve ter 4 letras", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do jogador 1
        if(txtjog1.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome do jogador 1' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do jogador 2
        if(txtjog2.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome do jogador 2' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do jogador 3
        if(txtjog3.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome do jogador 3' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        } 

        // Validação do campo nome do jogador 4
        if(txtjog4.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome do jogador 4' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do jogador 5
        if(txtjog5.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nome do jogador 5' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }
        // Validação do campo nome do nick 1
        if(txtnick1.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nick do jogador 1' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do nick 2
        if(txtnick2.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nick do jogador 2' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do nick 3
        if(txtnick3.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nick do jogador 3' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        } 

        // Validação do campo nome do nick 4
        if(txtnick4.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nick do jogador 4' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Validação do campo nome do nick 5
        if(txtnick5.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'Nick do jogador 5' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }
        return true;
    }

    /* Classes internas ---------------------------------------------------- */
    private class Eventoinfolol implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            infolol janelainfolol = new infolol();
        }
    }

    private class EventoSalvar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // o código que será executado quando o btn salvar for pressionado    
            boolean validacao = validacaoSalvar();

            if(validacao == true){ // verificando se a validação ocorreu com sucesso
                // salvar aluno no banco de dados
                System.out.println("JOGADOR SALVO");
            }

        }
    }
}