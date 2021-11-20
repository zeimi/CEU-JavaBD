package entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    // atributos -------------------------------
    String nome, tag;
    List<String> jogadores;
    
    // construtor ------------------------------
    public Equipe(){
        jogadores = new ArrayList<String>();
    }
    
    // getters e Setters -------------------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public List<String> getJogadores() {
        return jogadores;
    }
    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }
    // métodos -------------------------------
    public void print(){
        System.out.println("*********************************");
        System.out.println("Nome: "+nome);
        System.out.println("Cpf: "+tag);
        System.out.println("Jogadores -------------");
        for(int i=0; i<jogadores.size(); i++){
            System.out.println("-> "+jogadores.get(i));
        }
        System.out.println("*********************************");
    }
}
