import java.util.ArrayList;
//Fhelipe Vinicios Dechico - RA: 2623390
public final class Imobiliaria {
    private GerTransacao gt = new GerTransacao();
    private GerCliente gc = new GerCliente();
    private GerFuncionario gf = new GerFuncionario();
    private GerPropriedade gp = new GerPropriedade();

    public Imobiliaria() {
        gt = new GerTransacao();
        gc = new GerCliente();
        gf = new GerFuncionario();
        gp = new GerPropriedade();
    }

    public GerTransacao getGt() {return gt;}
    public GerCliente getGc() {return gc;}
    public GerFuncionario getGf() {return gf;}
    public GerPropriedade getGp(){return gp;}

    public void setTransacoes(GerTransacao gt) {this.gt = gt;}
    public void setGc(GerCliente gc) {this.gc = gc;}
    public void setGf(GerFuncionario gf) {this.gf = gf;}
    public void setGp(GerPropriedade gp){this.gp = gp;}
}
