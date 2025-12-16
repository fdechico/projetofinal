//Fhelipe Vinicios Dechico - RA: 2623390
public final class Apartamento extends Propriedade {
    private int andar;
    private boolean varanda;
    private double valorCondominio;
    private boolean portaria;
    private int vagasEstacionamento;

    //Sobrecarga
    public Apartamento() {
        super();
        this.andar = 0;
        this.varanda = false;
        this.valorCondominio = 0.0;
        this.portaria = false;
        this.vagasEstacionamento = 0;
    }

    //Sobrecarga
    public Apartamento(int id, String endereco, double precoBase, double metrosQuadrados, int qtdQuartos, int qtdBanheiros, int disponivel, int andar, boolean varanda, double valorCondominio, boolean portaria, int vagasEstacionamento) {
        super(id, endereco, precoBase, metrosQuadrados, qtdQuartos, qtdBanheiros, disponivel);
        this.andar = andar;
        this.varanda = varanda;
        this.valorCondominio = valorCondominio;
        this.portaria = portaria;
        this.vagasEstacionamento = vagasEstacionamento;
    }

    public int getAndar() {return andar;}
    public boolean getVaranda() {return varanda;}
    public double getValorCondominio() {return valorCondominio;}
    public boolean getPortaria() {return portaria;}
    public int getVagasEstacionamento() {return vagasEstacionamento;}

    public void setAndar(int andar) throws NumeroNegativoException {
        if(andar < 0){
            throw new NumeroNegativoException();
        }
        this.andar = andar;
    }

    public void setVaranda(boolean varanda) {this.varanda = varanda;}

    public void setValorCondominio(double valorCondominio) throws NumeroNegativoException {
        if(valorCondominio < 0){
            throw new NumeroNegativoException();
        }
        this.valorCondominio = valorCondominio;
    }

    public void setPortaria(boolean portaria) {this.portaria = portaria;}

    public void setVagasEstacionamento(int vagasEstacionamento) throws NumeroNegativoException {
        if(vagasEstacionamento < 0){
            throw new NumeroNegativoException();
        }
        this.vagasEstacionamento = vagasEstacionamento;
    }

    //Sobrescrita
    public void calcPreco() {
        setPrecoBase(precoMetroQuadrado * getMetrosQuadrados() + vagasEstacionamento * 5000.00);
        if(this.varanda == true){setPrecoBase(1.15 * getPrecoBase());}
        if(this.portaria == true){setPrecoBase(1.1 * getPrecoBase());}
    }

    //Sobrescrita
    public void imprimirInformacao() {
        System.out.println("Id: " + getId() +
                            "\nEndereço: " + getEndereco() +
                            "\nMetros Quadrados: " + getMetrosQuadrados() + "m2" +
                            "\nQuartos: " + getQtdQuartos() +
                            "\nBanheiros: " + getQtdBanheiros() +
                            "\nAndar: " + andar +
                            "\nPossui Varanda: " + (varanda ? "Sim" : "Não") +
                            "\nValor do Condomínio: R$ " + valorCondominio +
                            "\nPortaria 24h: " + (portaria ? "Sim" : "Não") +
                            "\nVagas de Estacionamento: " + vagasEstacionamento +
                            "\nPreço Final: R$" + getPrecoBase() + " + valor do condominio de R$" + valorCondominio +
                            "\nDisponibilidade: " + ((getDisponivel() == 1) ?  "disponivel" : "nao esta disponivel"));
    }
}
