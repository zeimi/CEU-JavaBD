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

        private JComboBox<String>kar;
        private JLabel labeltxt;
        private JTextField txtNome;
        private JTextField txtcpf;
        private JLabel labeljog;
        private JTextField txtjog;
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
        private JLabel myLabel, myLabel2;
        private AbstractButton Sala1;
        private javax.swing.JRadioButton Sala2;
        //private RadioButtonHandler handler;
        private JRadioButton java, csharp,
        sim, nao;
       
        private JTextArea textArea;

        private Component JLabelcpf;

        private String cpf;

        
      
        /*public class RadioButton extends JFrame {
          private JLabel myLabel, myLabel2;
         // private RadioButtonHandler handler;
          private JRadioButton sala1, sala2,
          sim, nao;
          }
    public CadastroMariokart() {
        
        super("Cadastro de Equipe");

        JLabel CadastroMariokart = new JLabel("JOGADOR");

        // inicialização dos cadastros J1
        labeljog = new JLabel("Nome do jogador:");
        txtNome = new JTextField(50);

          // VALIDAÇÃO DO CAMPO CPF
          String cpf = txtcpf.getText(); // obter o cpf completo digitado
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

            // Botão sala para jogar 



           // Escolher o nível de dificuldade 
  

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
          panel.add(labeljog,constraints);
          constraints.gridx=1; // coluna 1
          constraints.gridy=1; // linha 1
          panel.add(txtjog, constraints);
          constraints.gridx=0; // coluna 0
          constraints.gridy=2; // linha 2
          panel.add(JLabelcpf, constraints);
          constraints.gridx=1; // coluna 1
          constraints.gridy=2; // linha 2
          panel.add(txtcpf, constraints);
          constraints.gridx=2; // coluna 2
          constraints.gridy=3; // linha 3
          panel.add (personagens1 , constraints);
          // SALAS
          constraints.gridx=0; // coluna 2
          constraints.gridy=2; // linha 3
          panel.add (kar, constraints);
          
           // configuração da janela
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setResizable(true); // impede o redimensionamento da janela
           setLocation(800, 500);
           pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
           setVisible(true);
    }
            //public class RadioButton extends JFrame {
              /*
            private JRadioButton , csharp,
             sim, nao;
            private JLabel myLabel, myLabel2;
           private ButtonGroup grupo1, grupo2;
            private RadioButtonHandler handler;
            }
            // Configuração do botão
            public void RadioButton(){
              //super("Radio Buttons ");
              setLayout( new FlowLayout() );
              handler = new RadioButtonHandler();
              
              myLabel = new JLabel("Deseja jogar em qual sala?");
              myLabel2 = new JLabel("\nVocê tem certeza disso?");
              Sala1 = JRadioButton("sala1", false);
              Sala2= new JRadioButton("sala2", false);
              sim = new JRadioButton("Sim", false);
              nao = new JRadioButton("Não", false);
              
              add(myLabel);
              add(Sala1);
              add(Sala2);
              add(myLabel2);
              add(sim);
              add(nao);
              
              Sala1 = new ButtonGroup();
              Sala1.add(Sala1);
              Sala1.add(Sala2);
              
               = new ButtonGroup();
              Sala2.add(sim);
              Sala2.add(nao);
              
              Sala1.addItemListener(handler);
             Sala2.addItemListener(handler);
              sim.addItemListener(handler);
              nao.addItemListener(handler);
             }
             
             private ButtonGroup JRadioButton(String string, boolean b) {
              return null;
            }
            private class RadioButtonHandler implements ItemListener{
            
              @Override
              public void itemStateChanged(ItemEvent event) {
               if(java.isSelected() && sim.isSelected())
                JOptionPane.showMessageDialog(null,"OK");
               if(csharp.isSelected() && sim.isSelected())
                JOptionPane.showMessageDialog(null,"Retorne para escolher outra sala");
              }*/
              
    

        private boolean validacaoSalvar(){
        // VALIDAÇÃO DO CAMPO NOME
        if(txtNome.getText().length() == 0){ // se o campo 'nome' está vazio
            JOptionPane.showInternalConfirmDialog (JLabelcpf, "O campo 'nome' deve estar preenchido!", "Erro de validação",JOptionPane.WARNING_MESSAGE);
            return false;
          }
        

        if(cpf.length() < 11){
        JOptionPane.showInputDialog(this, "O campo 'cpf' deve ter 11 números!"); 
        return false;
      }
    }
  }
}
}*/
