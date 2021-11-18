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


    private static Component labelpersonagens = null;

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
        private JComboBox<String> personagens1 ;
        private JComboBox<String> personagens2 ;
        private JComboBox<String> personagens3 ;
        private JComboBox<String> personagens4 ;
        private JComboBox<String> personagens5 ;
        private JComboBox <String> personagens6 ;
        private JComboBox<String> personagens7 ;
        private JComboBox<String> personagens8 ;

        private JButton button;

        private JTextArea textArea;

        private Component JLabelcpf1;
        
      

    public CadastroMariokart() {
        
        super("Cadastro de Equipe");

        JLabel CadastroMariokart = new JLabel("JOGADOR 1");

        // inicialização dos cadastros J1
        labeljog1 = new JLabel("Nome do jogador 1:");
        txtNome = new JTextField(50);

          // VALIDAÇÃO DO CAMPO CPF
          String cpf = txtcpf1.getText(); // obter o cpf completo digitado
          cpf = cpf.replace(".", "");
          cpf = cpf.replace("-", "");
          cpf = cpf.replace(" ", "");

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

         /* xxxxxxx Sala para jogos em grupo c/ diferentes pessoas xxxxxxxxx */
            // Sala 1
            botaosala1 = new JButton("SALA 1");
            botaosala1.setSize(50, 30);
            botaosala1.addActionListener(new Eventosala1());
            // Sala 2
            botaosala2 = new JButton("SALA 2");
            botaosala2.setSize(50, 30);
            botaosala2.addActionListener(new Eventosala1());
            // Sala 3
            botaosala3 = new JButton("SALA 4");
            botaosala3.setSize(50, 30);
            botaosala3.addActionListener(new Eventosala1());
            // Sala 4
            botaosala4 = new JButton("SALA 4");
            botaosala4.setSize(50, 30);
            botaosala4.addActionListener(new Eventosala1());

            
        
         // xxxxxxxxx declarando a localização xxxxxxx
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
          constraints.gridx=0; // coluna 0
          constraints.gridy=2; // linha 2
          panel.add(JLabelcpf1, constraints);
          constraints.gridx=1; // coluna 1
          constraints.gridy=2; // linha 2
          panel.add(txtcpf1, constraints);
          constraints.gridx=2; // coluna 2
          constraints.gridy=3; // linha 3
          panel.add (personagens1 , constraints);

           // configuração da janela
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setResizable(true); // impede o redimensionamento da janela
           setLocation(800, 500);
           pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
           setVisible(true);
    }
             // eventosala2
             public void Eventosala1() {
             button = new JButton("OK");
             Window frame = new JFrame("SALA 1");
             textArea = new JTextArea(5, 40);
             button.addActionListener((ActionListener) this);
             textArea.setLineWrap(true);
             Object constraints;

             frame.setLayout(new BorderLayout());
             frame.add(textArea, BorderLayout.NORTH);
             frame.add(button, BorderLayout.SOUTH);
             frame.pack();
 
             ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
            }
           
            
             private class Eventosala1 implements ActionListener {
             private String cpf;


            public void actionPerformed(ActionEvent e) { // o método invocado quando o btn sala 1 for pressionado
            JComboBox<String> eventosala1;
            if (eventosala1.getSelectedItem() == "Sala1"){System.out.println("Personagens");
          }
        }
           // eventosala2
            public void eventosala2() {
            button = new JButton("OK");
            Window frame = new JFrame("SALA 2");
            textArea = new JTextArea(5, 40);
            button.addActionListener((ActionListener) this);
            textArea.setLineWrap(true);
            Object constraints;

            frame.setLayout(new BorderLayout());
            frame.add(textArea, BorderLayout.NORTH);
            frame.add(button, BorderLayout.SOUTH);
            frame.pack();

            ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setVisible(true);
           }
           private class eventosala2 implements ActionListener {
            private String cpf;


           public void actionPerformed(ActionEvent e) { // o método invocado quando o btn sala 1 for pressionado
           JComboBox<String> eventosala2;
           if (eventosala2.getSelectedItem() == "Sala2"){System.out.println("Personagens");
          }
        }


        private boolean validacaoSalvar(){
        // VALIDAÇÃO DO CAMPO NOME
        if(txtNome.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showInternalConfirmDialog (JLabelcpf1, "O campo 'nome' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if(cpf.length() < 11){
        JOptionPane.showInputDialog(this, "O campo 'cpf' deve ter 11 números!"); 
        return false;
    }
    return true;
    }
  }
}

