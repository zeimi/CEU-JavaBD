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
    private Component txtCpf;


    public CadastroMariokart() {
        super("Cadastro de Equipe");

        label CadastroMariokart = new JLabel("JOGADOR 1:")

        // inicialização dos cadastros J1
        labeltxt = new JLabel("Nome:");
        txtNome = new JTextField(50);
        private boolean validacaoSalvar(){
            // VALIDAÇÃO DO CAMPO NOME
            if(txtNome.getText().length() == 0){ // se o campo 'nome' está vazio
                JOptionPane.showMessageDialog(this, "O campo 'nome' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
                return false; 
            }
            
            // VALIDAÇÃO DO CAMPO CPF
        String cpf = txtCpf.getText(); // obter o cpf completo digitado
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(" ", "");
        if(cpf.length() < 11){
            JOptionPane.showMessageDialog(this, "O campo 'cpf' deve ter 11 números!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false; }

           // Escolher o persongaem do jogador
           labelpersonagens= new JLabel(" Escolha o seu personagem:");
            String[] personagens = {"Mário","Princesa Peach","Luigi","Princesa Daisy","Toad","Toadette","Yoshi", "Birdo"};
            caixapersonagens = new JComboBox<String>(personagens);
            caixapersonagensSize(80, 30); }
            
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(50, 30, 50, 30)); // uma borda para afastar os compoentes da janela
        panel.add(labeltxt, BorderLayout.NORTH);
        panel.add(txtNome, BorderLayout.CENTER);
        panel.add(txtCpf, BorderLayout.CENTER);
        panel.add(labelpersonagens, BorderLayout.SOUTH);

        add(panel);
    

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }
}