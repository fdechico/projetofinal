//Fhelipe Vinicios Dechico - RA: 2623390
public abstract class Propriedade implements CalculaPreco{
    private int id;
    private String endereco;
    private double precoBase;
    private double metrosQuadrados;
    private int qtdQuartos;
    private int qtdBanheiros;
    private int disponivel;

    public Propriedade() {
        id = 0;
        endereco = "";
        precoBase = 0.0;
        metrosQuadrados = 0.0;
        qtdQuartos = 0;
        qtdBanheiros = 0;
        disponivel = 1;
    }

    //Sobrecarga
    public Propriedade(int id, String endereco, double precoBase, double metrosQuadrados, int qtdQuartos, int qtdBanheiros, int disponivel) {
        this.id = id;
        this.endereco = endereco;
        this.precoBase = precoBase;
        this.metrosQuadrados = metrosQuadrados;
        this.qtdQuartos = qtdQuartos;
        this.qtdBanheiros = qtdBanheiros;
        this.disponivel = disponivel;
    }

    //Sobrecarga
    public int getId(){return id;}
    public String getEndereco() {return endereco;}
    public double getPrecoBase() {return precoBase;}
    public double getMetrosQuadrados() {return metrosQuadrados;}
    public int getQtdQuartos() {return qtdQuartos;}
    public int getQtdBanheiros() {return qtdBanheiros;}
    public int getDisponivel(){return disponivel;}


    public void setId(int id) throws NumeroNegativoException{
        if(id < 0){
            throw new NumeroNegativoException();
        }
        this.id = id;
    }

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public void setPrecoBase(double precoBase){this.precoBase = precoBase;}

    public void setMetrosQuadrados(double metrosQuadrados) throws NumeroNegativoException {
        if(metrosQuadrados <= 0){
            throw new NumeroNegativoException();
        }
        this.metrosQuadrados = metrosQuadrados;
    }

    public void setQtdQuartos(int qtdQuartos) throws NumeroNegativoException {
        if(qtdQuartos < 0){
            throw new NumeroNegativoException();
        }
        this.qtdQuartos = qtdQuartos;
    }

    public void setQtdBanheiros(int qtdBanheiros)  throws NumeroNegativoException{
        if(qtdBanheiros < 0){
            throw new NumeroNegativoException();
        }
        this.qtdBanheiros = qtdBanheiros;
    }

    public void setDisponivel(int disponivel){this.disponivel = disponivel;}

    //Sobrescrita
    public abstract void imprimirInformacao();
    //Sobrescrita
    public abstract void calcPreco();
}
