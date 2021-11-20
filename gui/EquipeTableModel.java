package gui;

import entidades.Equipe;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EquipeTableModel extends AbstractTableModel{

   
    /* Atributos ----------------------------------------------------------- */
    String[] colunas = {"Nome","Tag"}; // nomes das colunas
    private ArrayList<Equipe> listaEquipes; // onde ficam os dados do model
    /* Contrutor ----------------------------------------------------------- */
    public EquipeTableModel(ArrayList<Equipe> a){
        // quando este model é inicalizado, devemos passar
        // para o construtor a lista de alunos que o alimentará.
        listaEquipes = a;
    }

    /* Métodos ------------------------------------------------------------- */
    public Equipe getAluno(int linha){
        // retorna um registro específico da lista de alunos
        return listaEquipes.get(linha);
    }

    /* Métodos sobrecarregados - p/ fazer o model funcionar --------------- */
    @Override
    public int getRowCount() { 
        return listaEquipes.size();
    }

    // especifica a quantidade de colunas
    @Override
    public int getColumnCount() {
        // a qtd de colunas será o tamnho do array colunas
        return colunas.length;
    }

    // especifica onde estão os nomes das colunas
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    

    // preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // obtem o registro do aluno da linha especificada
        Equipe linha = listaEquipes.get(rowIndex);

        if(columnIndex == 0){ // coluna NOME
            return linha.getNome();
        }else if(columnIndex == 1){ // coluna CPF
            return linha.getTag();
        }
        
        return null; // se houver algum erro de índice
    }
}
