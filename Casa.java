//Fhelipe Vinicios Dechico - RA: 2623390
public final class Casa extends Propriedade {
    private int qtdAndares;
    private boolean jardim;
    private boolean piscina;
    private String tipoArquitetura;

    //Sobrecarga
    public Casa(){
        super();
        this.qtdAndares = qtdAndares;
        this.jardim = jardim;
        this.piscina = piscina;
        this.tipoArquitetura = tipoArquitetura;
    }

    //Sobrecarga
    public Casa(int id, String endereco, double precoBase, double metrosQuadrados, int qtdQuartos, int qtdBanheiros, int disponivel, int qtdAndares, boolean jardim, boolean piscina, String tipoArquitetura) {
        super(id, endereco, precoBase, metrosQuadrados, qtdQuartos, qtdBanheiros, disponivel);
        this.qtdAndares = qtdAndares;
        this.jardim = jardim;
        this.piscina = piscina;
        this.tipoArquitetura = tipoArquitetura;
    }

    public int getQtdAndares() {return qtdAndares;}
    public boolean getJardim() {return jardim;}
    public boolean getPiscina() {return piscina;}
    public String getTipoArquitetura() {return tipoArquitetura;}

    public void setQtdAndares(int qtdAndares) throws NumeroNegativoException {
        if(qtdAndares <= 0){
            throw new NumeroNegativoException();
        }
        this.qtdAndares = qtdAndares;
    }
    public void setJardim(boolean jardim) {this.jardim = jardim;}
    public void setPiscina(boolean piscina) {this.piscina = piscina;}
    public void setTipoArquitetura(String tipoArquitetura) {this.tipoArquitetura = tipoArquitetura;}

    //Sobrescrita
    public void calcPreco() {
        setPrecoBase(precoMetroQuadrado * getMetrosQuadrados());
        if(this.piscina == true){setPrecoBase(1.2 * getPrecoBase());}
        if(this.jardim == true){setPrecoBase(1.1 * getPrecoBase());}
    }

    //Sobrescrita
    public void imprimirInformacao(){
        System.out.println("Id: " + getId() +
                            "\nEndereço: " + getEndereco() +
                            "\nMetros Quadrados: " + getMetrosQuadrados() + "m2" +
                            "\nQuartos: " + getQtdQuartos() +
                            "\nBanheiros: " + getQtdBanheiros() +
                            "\nQuantidade de Andares: " + qtdAndares +
                            "\nPossui Jardim: " + (jardim ? "Sim" : "Não") +
                            "\nPossui Piscina: " + (piscina ? "Sim" : "Não") +
                            "\nTipo de Arquitetura: " + tipoArquitetura +
                            "\nPreço Final: R$" + getPrecoBase() +
                            "\nDisponibilidade: " + ((getDisponivel() == 1) ?  "disponivel" : "nao esta disponivel"));
    }
}
