package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import entidades.Equipe;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.FabricaConexao;

public class Visualizar extends JFrame {
    /* Atributos --------------------------------------------------------- */
    private JTable tableEquipes;
    private EquipeTableModel modelEquipes;
    private ArrayList<Equipe> listaEquipes;
    private JButton btnShowJogadores;
    private JogadoresEquipe jogadoresEquipe = null;

    public String jogoDeterminado;

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
        btnShowJogadores.addActionListener(new EventoShowDisciplinas());

        // definição dos layouts
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // uma borda para afastar os compoentes da janela
        panel.add(new JScrollPane(tableEquipes), BorderLayout.CENTER);
        panel.add(btnShowJogadores, BorderLayout.SOUTH);
        add(panel); // coloco o painel dentro da janela

        // configuração da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(600, 300);
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
                    System.out.println("Equipe Adicionada\n");
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

    // evento a ser chamado pela janela de cadastro, quando o cadastro for finalizado com sucesso
    public class EventoResposta{
        public void atualizarDados(){
            // busca novamento os dados das equipes no banco
            buscarDados();
            // informo ao tableModel que os dados foram atualizados
            modelEquipes.fireTableDataChanged();
        }
    }

    private class EventoShowDisciplinas implements ActionListener {
        public void actionPerformed(ActionEvent e) { // o método invocado quando o btn cadastrar for pressionado
            if(tableEquipes.getSelectedRow() != -1){ // verifica se o usuário selecionou um aluno na tabela
                // captura o nº da linha selecionada no JTable
                int linhaSelecionada = tableEquipes.getSelectedRow();
                // captura o aluno pela linha selecionada
                Equipe equipeSelecionada = modelEquipes.getEquipe(linhaSelecionada);
                
                if(jogadoresEquipe != null){ // tratar a possibilidade de ser a primeira abertura de janela
                    jogadoresEquipe.dispose(); // fecha a janela atual
                }
                jogadoresEquipe = new JogadoresEquipe(equipeSelecionada); // cria uma nova janela
            }else{ // caso não tenha selecionado nenhum aluno
                JOptionPane.showMessageDialog(null, "Você precisa selecionar uma Equipe!","Exibição", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
} // :3
