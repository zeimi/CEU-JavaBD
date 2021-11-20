package entidades;

import java.util.ArrayList;
import java.util.List;

public class EquipeCSGO {
    // atributos -------------------------------
    String Equipe, EquipeTag;
    List<String> Jogadores;
    
    // construtor ------------------------------
    public EquipeCSGO(){
        Jogadores = new ArrayList<String>();
    }
    
    // getters e Setters -------------------------------
    public String getNome() {
        return Equipe;
    }
    public void setNome(String Equipe) {
        this.Equipe = Equipe;
    }
    public String getTaG() {
        return EquipeTag;
    }
    public void setTag(String EquipeTag) {
        this.EquipeTag = EquipeTag;
    }
    public List<String> getJogadores() {
        return Jogadores;
    }
    public void setJogadores(List<String> Jogadores) {
        this.Jogadores = Jogadores;
    }
    // métodos -------------------------------
    public void print(){
        System.out.println("*********************************");
        System.out.println("Nome da Equipe: "+Equipe);
        System.out.println("TAG da Equipe: "+EquipeTag);
        System.out.println("Jogadores ----------------");
        for(int i=0; i<Jogadores.size(); i++){
            System.out.println("-> "+Jogadores.get(i));
        }
        System.out.println("*********************************");
    }
}
