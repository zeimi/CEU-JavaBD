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

import entidades.Equipe;

import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import utils.FabricaConexao;

public class CadastroCSGO extends JFrame {

    private JLabel labelcs;
    private JButton botaocs;


    private JLabel labelequipe;
    private JTextField txtequipe;
    private JLabel labelTag;
    private JTextField txtTag;

    private JLabel labeljog1;
    private JLabel labeljog2;
    private JLabel labeljog3;
    private JLabel labeljog4;
    private JLabel labeljog5;

    private JTextField txtjog1;
    private JTextField txtjog2;
    private JTextField txtjog3;
    private JTextField txtjog4;
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

    private JComboBox<String> caixaRoles1;
    private JComboBox<String> caixaRoles2;
    private JComboBox<String> caixaRoles3;
    private JComboBox<String> caixaRoles4;
    private JComboBox<String> caixaRoles5;

    private JButton botaoSalvar;

    private String Jogo;


    public CadastroCSGO() {
        super("Cadastro de Equipe");

        // -------------------------------- inicialização dos componentes ----------------------------------------
        labelcs = new JLabel("Campeonato de Counter Strike UNIJORGE");
        botaocs = new JButton("Informações");
        botaocs.addActionListener(new Eventoinfocsgo());

        labelequipe = new JLabel("Nome da equipe:");
        labelTag = new JLabel("TAG da equipe:");
        labeljog1 = new JLabel("Nome Jogador 1:");
        labeljog2 = new JLabel("Nome Jogador 2:");
        labeljog3 = new JLabel("Nome Jogador 3:");
        labeljog4 = new JLabel("Nome Jogador 4:");
        labeljog5 = new JLabel("Nome Jogador 5:");
        
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

        String[] roles = {"EntryFragger", "Awper", "Rifler", "Support", "In-Game Leader"};
        caixaRoles1 = new JComboBox<String>(roles);
        caixaRoles2 = new JComboBox<String>(roles);
        caixaRoles3 = new JComboBox<String>(roles);
        caixaRoles4 = new JComboBox<String>(roles);
        caixaRoles5 = new JComboBox<String>(roles);

        botaoSalvar = new JButton("Salvar equipe");
        botaoSalvar.addActionListener(new EventoSalvar());

        // --------------------------------------- definição dos layouts ----------------------------------------
        JLabel background = new JLabel(new ImageIcon("img/csgo.png"));
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
        panel.add(labelcs,constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=0; // linha 0
        panel.add(botaocs, constraints);

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
        panel.add(labeljog1, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=2; // linha 2
        panel.add(txtjog1, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=2; // linha 2
        panel.add(labelnick1, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=2; // linha 2
        panel.add(txtnick1, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=2; // linha 2
        constraints.gridx=4; // coluna 4
        constraints.gridy=2; // linha 2
        panel.add(caixaRoles1, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 3 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 3
        panel.add(labeljog2, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=3; // linha 3
        panel.add(txtjog2, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=3; // linha 3
        panel.add(labelnick2, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=3; // linha 3
        panel.add(txtnick2, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=3; // linha 3
        constraints.gridx=4; // coluna 4
        constraints.gridy=3; // linha 3
        panel.add(caixaRoles2, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 4 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        panel.add(labeljog3, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=4; // linha 4
        panel.add(txtjog3, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=4; // linha 4
        panel.add(labelnick3, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=4; // linha 4
        panel.add(txtnick3, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=4; // linha 4
        constraints.gridx=4; // coluna 4
        constraints.gridy=4; // linha 4
        panel.add(caixaRoles3, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 5 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=5; // linha 5
        panel.add(labeljog4, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=5; // linha 5
        panel.add(txtjog4, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=5; // linha 5
        panel.add(labelnick4, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=5; // linha 5
        panel.add(txtnick4, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=5; // linha 5
        constraints.gridx=4; // coluna 4
        constraints.gridy=5; // linha 5
        panel.add(caixaRoles4, constraints);
        // --------------------------------------------------------

        // ---------------- Componentes da linha 6 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=6; // linha 6
        panel.add(labeljog5, constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=6; // linha 6
        panel.add(txtjog5, constraints);
        constraints.gridx=2; // coluna 2
        constraints.gridy=6; // linha 6
        panel.add(labelnick5, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=6; // linha 6
        panel.add(txtnick5, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=6; // linha 6
        constraints.gridx=4; // coluna 4
        constraints.gridy=6; // linha 6
        panel.add(caixaRoles5, constraints);

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
        setSize(400,400);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo);
        setVisible(true);
    }

    // Métodos -------------------------------------------------------------
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
    // Classes internas ---------------------------------------------------- 
    private class Eventoinfocsgo implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            infocsgo janelainfocsgo = new infocsgo();
            janelainfocsgo.getHeight();
        }
    }

    @SuppressWarnings("unchecked") // Suprime os Warnings Java (que são muitos)
    private class EventoSalvar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // o código que será executado quando o btn salvar for pressionado    
            boolean validacao = validacaoSalvar();

            if(validacao == true){ // verificando se a validação ocorreu com sucesso
                // salvar aluno no banco de dados
                System.out.println("JOGADOR SALVO");
                // ----------------- Criando o JSON para o banco de dados --------------------
                //Jogador 1
                JSONObject Jogador1 = new JSONObject();
                Jogador1.put("Nome", txtjog1.getText());
                Jogador1.put("Nickname", txtnick1.getText());
                Jogador1.put("Role", caixaRoles1.getSelectedItem());
                
                JSONObject Jog1Object = new JSONObject(); 
                Jog1Object.put("Jogador1", Jogador1);
                // -------------------------------------------------
                
                //Jogador 2
                JSONObject Jogador2 = new JSONObject();
                Jogador2.put("Nome", txtjog2.getText());
                Jogador2.put("Nickname", txtnick2.getText());
                Jogador2.put("Role", caixaRoles2.getSelectedItem());
                
                JSONObject Jog2Object = new JSONObject(); 
                Jog2Object.put("Jogador2", Jogador2);
                // -------------------------------------------------

                //Jogador 3
                JSONObject Jogador3 = new JSONObject();
                Jogador3.put("Nome", txtjog3.getText());
                Jogador3.put("Nickname", txtnick3.getText());
                Jogador3.put("Role", caixaRoles3.getSelectedItem());
                
                JSONObject Jog3Object = new JSONObject(); 
                Jog3Object.put("Jogador3", Jogador3);
                // -------------------------------------------------

                //Jogador 4
                JSONObject Jogador4 = new JSONObject();
                Jogador4.put("Nome", txtjog4.getText());
                Jogador4.put("Nickname", txtnick4.getText());
                Jogador4.put("Role", caixaRoles4.getSelectedItem());
                
                JSONObject Jog4Object = new JSONObject(); 
                Jog4Object.put("Jogador4", Jogador4);
                // -------------------------------------------------

                //Jogador 5
                JSONObject Jogador5 = new JSONObject();
                Jogador5.put("Nome", txtjog5.getText());
                Jogador5.put("Nickname", txtnick5.getText());
                Jogador5.put("Role", caixaRoles5.getSelectedItem());
                
                JSONObject Jog5Object = new JSONObject(); 
                Jog5Object.put("Jogador5", Jogador5);
                // -------------------------------------------------
                
                //Adicionando os Jogadores ao Array de Jogadores
                JSONArray JogadoresLista = new JSONArray();
                JogadoresLista.add(Jog1Object);
                JogadoresLista.add(Jog2Object);
                JogadoresLista.add(Jog3Object);
                JogadoresLista.add(Jog4Object);
                JogadoresLista.add(Jog5Object);

                // -------------------------------------------------

                // Criando o JSON definitivo    
                JSONObject CSGOJSON = new JSONObject();
                CSGOJSON.put("Nome da Equipe", txtequipe.getText());
                CSGOJSON.put("TAG", txtTag.getText());
                CSGOJSON.put("Jogadores", JogadoresLista);
                CSGOJSON.put("Jogo", Equipe.Jogo.CSGO.toString());
                
                //Write JSON file
                try (FileWriter file = new FileWriter("EquipeCSGO.json")) {
                    //We can write any JSONArray or JSONObject instance to the file
                    file.write(CSGOJSON.toJSONString()); 
                    file.flush();
        
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                /* Salva o objeto json no banco de dados ------------- */
                Connection conexao = FabricaConexao.getInstance(); // obtém a instancia do banco de dados
                try{
                PreparedStatement ps = conexao.prepareStatement("INSERT INTO dados_jogo(dados_jogo) VALUES('" +CSGOJSON.toJSONString()+ "')");
                ps.execute(); // executar o sql no banco de dados
                JOptionPane.showMessageDialog(null, "Equipe cadastrada com sucesso!", "Inserção no Banco",JOptionPane.INFORMATION_MESSAGE);
                dispose(); // fechar esta janela de Cadastro
                }catch(SQLException exc){
                exc.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar equipe no banco!", "Inserção no Banco",JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
                
     }
 }


