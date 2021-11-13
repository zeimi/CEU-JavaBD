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

public class CadastroMariokart extends JFrame {


    private static final Component labelpersonagens = null;

        private JButton botaokar;
        private JButton botaosala1;
        private JButton botaosala2;
        private JButton botaosala3;
        private JButton botaosala4;

        private JLabel labeltxt;
        private JTextField txtNome;
        private JTextField txtcpf1;
        private JTextField txtcpf2;
        private JTextField txtcpf3;

        private JLabel labeljog1;
        private JTextField txtjog1;
        private JLabel labeljog2;
        private JTextField txtjog2;
        private JLabel labeljog3;
        private JTextField txtjog3;
        private JLabel labeljog4;
        private JTextField txtjog4;
        private JButton botaoSalvar;
        private JLabel panel;
        private JLabel labelRoles;
        private JComboBox<String> personagens1 ;
        private JComboBox<String> personagens2 ;
        private JComboBox<String> personagens3 ;
        private JComboBox<String> personagens4 ;
        private JComboBox<String> personagens5 ;
        private JComboBox <String> personagens6 ;
        private JComboBox<String> personagens7 ;
        private JComboBox<String> personagens8 ;
        
      

    public CadastroMariokart() {
        
        super("Cadastro de Equipe");

        JLabel CadastroMariokart = new JLabel("JOGADOR 1");

        // inicialização dos cadastros J1
        labeljog1 = new JLabel("Nome do jogador 1:");
        txtNome = new JTextField(50);

           // Escolher o persongaem do jogador
           labelpersonagens= new JLabel(" Escolha o seu personagem:");
            String[] personagens = {"Mário","Princesa Peach","Luigi","Princesa Daisy","Toad","Toadette","Yoshi", "Birdo"};
            personagens1 = new JComboBox<String> (personagens);
            personagens2 = new JComboBox<String> (personagens);
            personagens3 = new JComboBox<String> (personagens);
            personagens4 = new JComboBox<String> (personagens);
            personagens5 = new JComboBox<String> (personagens);
            personagens6 = new JComboBox<String> (personagens);
            personagens7 = new JComboBox<String> (personagens);
            personagens8 = new JComboBox<String> (personagens);
           
            personagens1.setsize(78, 30); 

            
        
         // xxxxxxxxx declarando a localização xxxxxxxxx
            JPanel panel = (JPanel) getContentPane(); // obtém o painel de conteúdo desta janela
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new EmptyBorder(10,10,10,10) );

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.weightx=1;
            constraints.weighty=1;
            constraints.fill=GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(10,5,5,10);

         
          // Ajeitando as localizações 
          constraints.gridx=0; // coluna 0
          constraints.gridy=1; // linha 1
          panel.add(labeljog1,constraints);
          constraints.gridx=1; // coluna 1
          constraints.gridy=1; // linha 1
          panel.add(txtjog1, constraints);
          constraints.gridx=2; // coluna 2
          constraints.gridy=1; // linha 1
          panel.add(txtcpf1, constraints);
          constraints.gridx=3; // coluna 3
          constraints.gridy=1; // linha 1
          panel.add (personagens , constraints);
          

         GridBagConstraints constraints = new GridBagConstraints();
         constraints.gridx=3; // coluna 3
         constraints.gridy=4; // linha 4
         constraints.gridwidth=5; // ocupa 4 colunas
         panel.add(botaoSalvar, constraints);

         // configuração da janela
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setResizable(true); // impede o redimensionamento da janela
           setLocation(600, 300);
           pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
           setVisible(true);
    }


    private boolean validacaoSalvar(){
        // VALIDAÇÃO DO CAMPO NOME
        if(txtNome.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'nome' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false;
         }
        
        
        // VALIDAÇÃO DO CAMPO CPF
       String cpf = txtcpf1.getText(); // obter o cpf completo digitado
       cpf = cpf.replace(".", "");
       cpf = cpf.replace("-", "");
       cpf = cpf.replace(" ", "");

        if(cpf.length() < 11){
        JOptionPane.showMessageDialog(this, "O campo 'cpf' deve ter 11 números!", "Erro de validação",JOptionPane.WARNING_MESSAGE); 
        return false;
    }
    return true;
    }

}