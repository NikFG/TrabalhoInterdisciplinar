package model;

/**
 *
 * @author Nikollas
 */
public class Quarto {

    private int idQuarto;
    private int Capacidade;
    private int Andar;
    private String Localizacao;
    private int ArCondicionado;
    private String Tipo;
    private double ValorDiaria;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Quarto(int idQuarto, int Capacidade, int Andar, String Localizacao, int ArCondicionado, String Tipo, double ValorDiaria) {
        this.idQuarto = idQuarto;
        this.Capacidade = Capacidade;
        this.Andar = Andar;
        this.Localizacao = Localizacao;
        this.ArCondicionado = ArCondicionado;
        this.Tipo = Tipo;
        this.ValorDiaria = ValorDiaria;
    }
    
    public Quarto() {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public int getIdQuarto() {
        return idQuarto;
    }
    
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    
    public int getCapacidade() {
        return Capacidade;
    }
    
    public void setCapacidade(int Capacidade) {
        this.Capacidade = Capacidade;
    }
    
    public int getAndar() {
        return Andar;
    }
    
    public void setAndar(int Andar) {
        this.Andar = Andar;
    }
    
    public String getLocalizacao() {
        return Localizacao;
    }
    
    public void setLocalizacao(String Localizacao) {
        this.Localizacao = Localizacao;
    }
    
    public int getArCondicionado() {
        return ArCondicionado;
    }
    
    public void setArCondicionado(int ArCondicionado) {
        this.ArCondicionado = ArCondicionado;
    }
    
    public String getTipo() {
        return Tipo;
    }
    
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    public double getValorDiaria() {
        return ValorDiaria;
    }
    
    public void setValorDiaria(double ValorDiaria) {
        this.ValorDiaria = ValorDiaria;
    }
//</editor-fold>

}
