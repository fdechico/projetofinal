//Fhelipe Vinicios Dechico - RA: 2623390
public final class Comercial extends Propriedade {
    private String tipoComercio;
    private String descricao;
    private int cameras;

    //Sobrecarga
    public Comercial() {
        super();
        this.tipoComercio = "";
        this.descricao = "";
        this.cameras = 0;
    }

    //Sobrecarga
    public Comercial(int id,String endereco, double precoBase, double metrosQuadrados, int qtdQuartos, int qtdBanheiros, int disponivel, String tipoComercio, String descricao, int cameras) {
        super(id, endereco, precoBase, metrosQuadrados, qtdQuartos, qtdBanheiros, disponivel);
        this.tipoComercio = tipoComercio;
        this.descricao = descricao;
        this.cameras = cameras;
    }

    public String getTipoComercio(){return tipoComercio;}
    public String getDescricao(){return descricao;}
    public int getCameras(){return cameras;}

    public void setTipoComercio(String tipoComercio) {this.tipoComercio = tipoComercio;}
    public void setDescricao(String descricao){this.descricao = descricao;}
    public void setCameras(int cameras) throws NumeroNegativoException{
        if(cameras < 0){
            throw new NumeroNegativoException();
        }
        this.cameras = cameras;
    }

    //Sobrescrita
    public void calcPreco() {
        setPrecoBase(precoMetroQuadrado * getMetrosQuadrados());
        if(cameras > 0){setPrecoBase(getPrecoBase() * 1.15 + 300 * cameras);}
    }

    //Sobrescrita
    public void imprimirInformacao() {
        System.out.println("Id: " + getId() +
                            "\nEndereço: " + getEndereco() +
                            "\nMetros Quadrados: " + getMetrosQuadrados() + "m2" +
                            "\nQuartos: " + getQtdQuartos() +
                            "\nBanheiros: " + getQtdBanheiros() +
                            "\nTipo de Comércio: " + tipoComercio +
                            "\nDescrição: " + descricao +
                            "\nPossui Câmeras de Segurança: " + cameras +
                            "\nPreço Final: R$" + getPrecoBase() +
                            "\nDisponibilidade: " + ((getDisponivel() == 1) ?  "disponivel" : "nao esta disponivel"));
    }
}
