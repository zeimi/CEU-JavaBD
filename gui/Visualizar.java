package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.xdevapi.JsonParser;

import entidades.Equipe;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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

    /* Construtores ----------------------------------------------------- */
    public Visualizar() {
        super("Listagem das Equipes");

        // inicialização dos componentes
        listaEquipes = new ArrayList<Equipe>(); // inicializa a lista de alunos
        modelEquipes = new EquipeTableModel(listaEquipes); // inicializa o tablemodel com a lista
        buscarDados();

        tableEquipes = new JTable(modelEquipes); // inicializa o JTable
        tableEquipes.setPreferredScrollableViewportSize(new Dimension(500, 200)); // definie a largura da tabela
        tableEquipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // restringe a seleção de um único registro
                                                                           // na tabela
        btnShowJogadores = new JButton("Mostrar jogadores da equipe");

        // definição dos layouts
        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento de 5px entre os componentes
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // uma borda para afastar os compoentes da janela
        panel.add(new JScrollPane(tableEquipes), BorderLayout.CENTER);
        panel.add(btnShowJogadores, BorderLayout.SOUTH);
        add(panel); // coloco o painel dentro da janela

        // configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // impede o redimensionamento da janela
        setLocation(600, 300);
        pack(); // define o tamanho da janela (menor possível para caber o conteúdo)
        setVisible(true);
    }

    /* Métodos ------------------------------------------------------------- */
    public void buscarDados() {
        listaEquipes.clear(); // limpa/zera todos os dados do ArrayList

        // buca as informações de cada aluno no Banco de dados
        try {
            // obter uma conexão com o banco de dados
            Connection conexao = FabricaConexao.getInstance();
            // prepara a consulta sql
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM dados_csgo;");
            ResultSet rs = ps.executeQuery();

            // percorrer a lista de resultados (ResultSet)
            while (rs.next()) {
                // cria um novo objeto aluno
                Equipe equipe = new Equipe();
                // captura o JSon como texto puro
                String jsonEquipeString = rs.getString("dados_csgo");
                // cria o conversor(parser) Json
                JSONParser parser = new JSONParser();
                // converte(parse) o campo aluno para um objeto json
                JSONObject jsonEquipe = (JSONObject) parser.parse(jsonEquipeString);

                // obtém cada um dos valores do JSON
                String nome = (String) jsonEquipe.get("Nome da Equipe");
                String tag = (String) jsonEquipe.get("TAG");
                JSONArray jogadores = (JSONArray) jsonEquipe.get("Jogadores");

                // coloca os valores obtidos dentro do objeto aluno
                equipe.setNome(nome);
                equipe.setTag(tag);
                equipe.setJogadores(jogadores);

                // coloca cada novo aluno dentro da lista
                listaEquipes.add(equipe);
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
            // busca novamento os dados dos alunos no banco
            buscarDados();
            // informo ao tableModel que os dados foram atualizados
            modelEquipes.fireTableDataChanged();
        }
    }
}
