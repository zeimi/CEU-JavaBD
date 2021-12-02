package entidades;
import org.json.simple.JSONArray;

public class Equipe {
    // atributos -------------------------------
    String nome, tag, jogo;
    JSONArray jogadores;
    
    // construtor ------------------------------
    public Equipe(){
        jogadores = new JSONArray();
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
    public String getJogo() {
        return jogo;
    }
    public void setJogo(String jogo) {
        this.jogo = jogo;
    }
    public JSONArray getJogadores() {
        return jogadores;
    }
    public void setJogadores(JSONArray jogadores) {
        this.jogadores = jogadores;
    }
}
