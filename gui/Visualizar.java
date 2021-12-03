package gui;
import entidades.Equipe;
import utils.FabricaConexao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Visualizar extends JFrame {
    /* Atributos --------------------------------------------------------- */
    private JTable tableEquipes;
    private EquipeTableModel modelEquipes;
    private ArrayList<Equipe> listaEquipes;
    private JButton btnShowJogadores;
    private JogadoresEquipe jogadoresEquipe = null;
    private String jogoDeterminado;

    /* Construtores ----------------------------------------------------- */
    public Visualizar(JComboBox<String> caixaTorneios) {
        super("Listagem das Equipes");
        jogoDeterminado = caixaTorneios.getSelectedItem().toString();
        System.out.println("Jogo Escolhido: " + jogoDeterminado);

        // inicialização dos componentes
        listaEquipes = new ArrayList<Equipe>(); // inicializa a lista de equipes
        modelEquipes = new EquipeTableModel(listaEquipes); // inicializa o tablemodel com a lista
        buscarDados();

        tableEquipes = new JTable(modelEquipes); // inicializa o JTable
        tableEquipes.setPreferredScrollableViewportSize(new Dimension(500, 200)); // definie a largura da tabela
        tableEquipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // restringe a seleção de um único registro
                                                                           // na tabela
        btnShowJogadores = new JButton("Mostrar jogadores da equipe");
        btnShowJogadores.addActionListener(new EventoShowJogadores());

        // definição dos layouts
        JScrollPane scroll = new JScrollPane(tableEquipes);
        // definição dos layouts
        JLabel background = new JLabel(new ImageIcon("img/visu.jpg"));
	    add(background);
	    background.setLayout(new BorderLayout());

        JInternalFrame panel = new JInternalFrame(); // obtém o painel de conteúdo desta janela
        panel.setVisible(true);
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(5,5,5,5) );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx=1;
        constraints.weighty=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,5,5,10);;

        // adição dos componentes na janela
        constraints.gridx=0; // coluna 0
        constraints.gridy=0; // linha 0
        constraints.gridwidth=2; // ocupa 5 colunas
        panel.add(scroll,constraints);

        constraints.gridx=0; // coluna 0
        constraints.gridy=3; // linha 1
        constraints.gridwidth=2; // ocupa 5 colunas
        panel.add(btnShowJogadores, constraints);

        // ---------------- Background ----------------

        background.add(panel, BorderLayout.PAGE_END);
        background.repaint();

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(435, 50);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }

    /* Métodos ------------------------------------------------------------- */
    public void buscarDados() {
        listaEquipes.clear(); // limpa/zera todos os dados do ArrayList
        // buca as informações de cada equipe no Banco de dados
        try {
            // obter uma conexão com o banco de dados
            Connection conexao = FabricaConexao.getInstance();
            // prepara a consulta sql
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM dados_jogo;");
            ResultSet rs = ps.executeQuery();

            // percorrer a lista de resultados (ResultSet)
            while (rs.next()) {
                // cria um novo objeto equipe
                Equipe equipe = new Equipe();
                // captura o JSon como texto puro
                String jsonEquipeString = rs.getString("dados_jogo");
                // cria o conversor(parser) Json
                JSONParser parser = new JSONParser();
                // converte(parse) o campo equipe para um objeto json
                JSONObject jsonEquipe = (JSONObject) parser.parse(jsonEquipeString);

                // obtém cada um dos valores do JSON
                String jogoEscolhido = (String) jsonEquipe.get("Jogo"); // Implementar aqui sistema de filtro
                System.out.println("Jogo da Equipe: "+jogoEscolhido);
                if (jogoEscolhido.equals(jogoDeterminado)) {
                    String nome = (String) jsonEquipe.get("Nome da Equipe");
                    String tag = (String) jsonEquipe.get("TAG");
                    JSONArray jogadores = (JSONArray) jsonEquipe.get("Jogadores");
                    String jogo = (String) jsonEquipe.get("Jogo");

                    // coloca os valores obtidos dentro do objeto equipe
                    equipe.setNome(nome);
                    equipe.setTag(tag);
                    equipe.setJogadores(jogadores);
                    equipe.setJogo(jogo);

                    // coloca cada nova equipe dentro da lista
                    listaEquipes.add(equipe); 
                } else {
                    String nome = (String) jsonEquipe.get("Nome da Equipe");
                    System.out.println("Equipe: \""+nome+"\" não pertence ao jogo\n");
                }
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL", "Listagem dos dados", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro no parser do JSON", "Listagem dos dados",
                    JOptionPane.ERROR_MESSAGE);
        }

    }


    private class EventoShowJogadores implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            if(tableEquipes.getSelectedRow() != -1){ // verifica se o usuário selecionou uma equipe na tabela
                // captura o nº da linha selecionada no JTable
                int linhaSelecionada = tableEquipes.getSelectedRow();
                // captura a equipe pela linha selecionada
                Equipe equipeSelecionada = modelEquipes.getEquipe(linhaSelecionada);
                
                if(jogadoresEquipe != null){ // tratar a possibilidade de ser a primeira abertura de janela
                    jogadoresEquipe.dispose(); // fecha a janela atual
                }
                jogadoresEquipe = new JogadoresEquipe(equipeSelecionada); // cria uma nova janela
            }else{ // caso não tenha selecionado nenhuma equipe
                JOptionPane.showMessageDialog(null, "Você precisa selecionar uma Equipe!","Exibição", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
} // :3
