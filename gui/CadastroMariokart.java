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
        private JLabel labeltxt;
        private JTextField txtNome;
        private JTextField txtCpf1;
        private Component txtcpf1;
        private Component txtCpf2;
        private Component txtcpf2;
        private Component txtCpf3;
        private Component txtcpf3;
        private Component txtCpf4;
        private Component txtcpf4;
        private Component txtCpf5;
        private Component txtcpf5;
        private Component txtCpf6;
        private Component txtcpf6;
        private Component txtCpf7;
        private Component txtcpf7;
        private Component txtCpf8;
        private Component txtcpf8;

        private JLabel labeljog1;
        private JTextField txtjog1;
        private JLabel labeljog2;
        private JTextField txtjog2;
        private JLabel labeljog3;
        private JTextField txtjog3;
        private JLabel labeljog4;
        private JTextField txtjog4;
        private JLabel labeljog5;
        private JTextField txtjog5;
        private JLabel labeljog6;
        private JTextField txtjog6;
        private JLabel labeljog7;
        private JTextField txtjog7;
        private JLabel labeljog8;
        private JTextField txtjog8;
        private JButton botaoSalvar;
        private JLabel panel;
        private JLabel labelRoles;
        private JRadioButton personagens;
      

    public CadastroMariokart() {
        
        super("Cadastro de Equipe");

        JLabel CadastroMariokart = new JLabel("JOGADOR 1");

        // inicialização dos cadastros J1
        labeljog1 = new JLabel("Nome do jogador 1:");
        txtNome = new JTextField(50);

           // Escolher o persongaem do jogador
           //labelpersonagens= new JLabel(" Escolha o seu personagem:");
            String[] personagens = {"Mário","Princesa Peach","Luigi","Princesa Daisy","Toad","Toadette","Yoshi", "Birdo"};
            //caixapersonagens = new JRadioButton(personagens);
            //caixapersonagens.setsize(80, 30); 
        
            
          JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
          //panel.setLayout(new GridBagLayout());
          panel.setBorder(new EmptyBorder(50, 30, 50, 30)); // uma borda para afastar os compoentes da janela
          panel.add(labelpersonagens, BorderLayout.SOUTH);
          add(panel);
                
       // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
         pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
        
        GridBagConstraints constraints = new GridBagConstraints();
         constraints.gridx=0; // coluna 0
         constraints.gridy=6; // linha 4
         constraints.gridwidth=5; // ocupa 4 colunas
         panel.add(botaoSalvar, constraints);
    }


    private boolean validacaoSalvar(){
        // VALIDAÇÃO DO CAMPO NOME
        if(txtNome.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showMessageDialog(this, "O campo 'nome' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false;
         }
        
        
        // VALIDAÇÃO DO CAMPO CPF
       String cpf = txtCpf1.getText(); // obter o cpf completo digitado
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