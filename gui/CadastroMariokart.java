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
import java.io.FileWriter;
import java.io.IOException;
import utils.FabricaConexao;


public class CadastroMariokart extends JFrame {

    private JLabel labelMariokart;
    private JButton botaoMariokart;


    private JLabel labelequipe;
    private JTextField txtequipe;
    private JLabel labelTag;
    private JTextField txtTag;

    private JLabel labeljog1;
    private JTextField txtjog1;
    private JLabel labeljog2;
    private JTextField txtjog2;
    private JLabel labelcpf1;
    private JLabel labelcpf2;

    private JTextField txtcpf1;
    private JTextField txtcpf2;

    private JLabel labelPersonagens;
    private JComboBox<String> caixaPersonagens1;
    private JComboBox<String> caixaPersonagens2;

    private JButton botaoSalvar;


    public CadastroMariokart() {
        super("Cadastro de Equipe");

        // -------------------------------- inicialização dos componentes ----------------------------------------
        labelMariokart = new JLabel("Campeonato de Mario Kart UNIJORGE");
        botaoMariokart = new JButton("Informações");
        botaoMariokart.addActionListener(new Eventoinfomariokart());

        labelequipe = new JLabel("Nome da equipe:");
        labelTag = new JLabel("TAG da equipe:");
        labeljog1 = new JLabel("Nome Jogador 1:");
        labeljog2 = new JLabel("Nome Jogador 2:");
        
        labelcpf1 = new JLabel("CPF J1:");
        try{
          MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
          txtcpf1 = new JFormattedTextField(mascaraCpf);
      }catch(ParseException e){
          e.printStackTrace();
      }
        labelcpf2 = new JLabel("CPF J2:");
        try{
          MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
          txtcpf2 = new JFormattedTextField(mascaraCpf);
      }catch(ParseException e){
          e.printStackTrace();
      }

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

        String[] roles = {"Mário","Princesa Peach","Luigi","Princesa Daisy","Toad","Toadette","Yoshi", "Birdo", "Bowser"};
        caixaPersonagens1 = new JComboBox<String>(roles);
        caixaPersonagens2 = new JComboBox<String>(roles);
        labelPersonagens = new JLabel("Personagem:");

        botaoSalvar = new JButton("Salvar equipe");
        botaoSalvar.addActionListener(new EventoSalvar());

        // --------------------------------------- definição dos layouts ----------------------------------------
        JLabel background = new JLabel(new ImageIcon("img/mario.jpg"));
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
        panel.add(labelMariokart,constraints);
        constraints.gridx=1; // coluna 1
        constraints.gridy=0; // linha 0
        panel.add(botaoMariokart, constraints);

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
        constraints.gridx=4; // coluna 4
        constraints.gridy=1; // linha 1
        panel.add(labelPersonagens, constraints);
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
        panel.add(labelcpf1, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=2; // linha 2
        panel.add(txtcpf1, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=2; // linha 2
        panel.add(caixaPersonagens1, constraints);
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
        panel.add(labelcpf2, constraints);
        constraints.gridx=3; // coluna 3
        constraints.gridy=3; // linha 3
        panel.add(txtcpf2, constraints);
        constraints.gridx=4; // coluna 4
        constraints.gridy=3; // linha 3
        panel.add(caixaPersonagens2, constraints);
        // --------------------------------------------------------
        // ---------------- Background ----------------

        background.add(panel, BorderLayout.PAGE_END);
        background.repaint();

        // ---------------- Componentes da linha 4 ----------------
        constraints.gridx=0; // coluna 0
        constraints.gridy=4; // linha 4
        constraints.gridwidth=5; // ocupa 5 colunas
        panel.add(botaoSalvar, constraints);

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(250,50);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
    /* Classes internas ---------------------------------------------------- */
    @SuppressWarnings("unused") // Suprime os Warnings Java
    private class Eventoinfomariokart implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            infomariokart janelainfomariokart = new infomariokart();
        }
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

        // VALIDAÇÃO DO CAMPO CPF1
        String cpf1 = txtcpf1.getText(); // obter o cpf completo digitado
        cpf1 = cpf1.replace(".", "");
        cpf1 = cpf1.replace("-", "");
        cpf1 = cpf1.replace(" ", "");
        if(cpf1.length() < 11){
            JOptionPane.showMessageDialog(this, "O campo 'cpf' deve ter 11 números!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // VALIDAÇÃO DO CAMPO CPF2
        String cpf2 = txtcpf2.getText(); // obter o cpf completo digitado
        cpf2 = cpf2.replace(".", "");
        cpf2 = cpf2.replace("-", "");
        cpf2 = cpf2.replace(" ", "");
        if(cpf2.length() < 11){
            JOptionPane.showMessageDialog(this, "O campo 'cpf' deve ter 11 números!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        return true;
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
                Jogador1.put("CPF", txtcpf1.getText());
                Jogador1.put("Personagem", caixaPersonagens1.getSelectedItem());
                
                JSONObject Jog1Object = new JSONObject(); 
                Jog1Object.put("Jogador1", Jogador1);
                // -------------------------------------------------
                
                //Jogador 2
                JSONObject Jogador2 = new JSONObject();
                Jogador2.put("Nome", txtjog2.getText());
                Jogador2.put("CPF", txtcpf2.getText());
                Jogador2.put("Personagem", caixaPersonagens2.getSelectedItem());
                
                JSONObject Jog2Object = new JSONObject(); 
                Jog2Object.put("Jogador2", Jogador2);

                // -------------------------------------------------
                
                //Adicionando os Jogadores ao Array de Jogadores
                JSONArray JogadoresLista = new JSONArray();
                JogadoresLista.add(Jog1Object);
                JogadoresLista.add(Jog2Object);

                // -------------------------------------------------

                // Criando o JSON definitivo    
                JSONObject MariokartJSON = new JSONObject();
                MariokartJSON.put("Nome da Equipe", txtequipe.getText());
                MariokartJSON.put("TAG", txtTag.getText());
                MariokartJSON.put("Jogadores", JogadoresLista);
                MariokartJSON.put("Jogo", "Mario Kart");
                
                //Write JSON file
                try (FileWriter file = new FileWriter("EquipeMariokart.json")) {
                    //We can write any JSONArray or JSONObject instance to the file
                    file.write(MariokartJSON.toJSONString()); 
                    file.flush();
        
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                /* Salva o objeto json no banco de dados ------------- */
                Connection conexao = FabricaConexao.getInstance(); // obtém a instancia do banco de dados
                try{
                PreparedStatement ps = conexao.prepareStatement("INSERT INTO dados_jogo(dados_jogo) VALUES('" +MariokartJSON.toJSONString()+ "')");
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

