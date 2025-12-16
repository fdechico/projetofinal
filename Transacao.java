//Fhelipe Vinicios Dechico - RA: 2623390
public final class Transacao {
    private int id;
    private Cliente cliente;
    private Funcionario funcionario;
    private Propriedade propriedade;
    private String tipoTransacao;

    //Sobrecarga
    public Transacao() {
        id = 0;
        cliente = new Cliente();
        funcionario = new Funcionario();
        propriedade = new Casa();
        tipoTransacao = "";
    }

    //Sobrecarga
    public Transacao(int id, Cliente cliente, Funcionario funcionario, Propriedade propriedade, String tipoTransacao) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.propriedade = propriedade;
        this.tipoTransacao = tipoTransacao;
    }

    public int getId(){return id;}
    public Cliente getCliente() {return cliente;}
    public Funcionario getFuncionario() {return funcionario;}
    public Propriedade getPropriedade() {return propriedade;}
    public String getTipoTransacao(){return tipoTransacao;}

    public void setId(int id) throws NumeroNegativoException{
        if(id < 0){
            throw new NumeroNegativoException();
        }
        this.id = id;
    }
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public void setFuncionario(Funcionario funcionario) {this.funcionario = funcionario;}
    public void setPropriedade(Propriedade propriedade) {this.propriedade = propriedade;}
    public void setTipoTransacao(String tipoTransacao){this.tipoTransacao = tipoTransacao;}

    public void imprimirInformacao() {
        System.out.println("Id da transacao: " + id +
                            "\nId da propriedade: " + propriedade.getId() +
                            "\nEndereco: " + propriedade.getEndereco() +
                            "\nNome do cliente: " + cliente.getNome() +
                            "\nCpf do cliente: " + cliente.getCpf() +
                            "\nNome do funcionario: " + funcionario.getNome() +
                            "\nId do funcionario: " + funcionario.getId() +
                            "\nTipo da transacao: " + tipoTransacao);
    }

    public void venderPropriedade(){
        funcionario.setComissao(0.06 * propriedade.getPrecoBase());
        propriedade.setDisponivel(0);
        cliente.getgpCli().getbdProp().add(propriedade); 
    }

    public void alugarPropriedade(){
        propriedade.setPrecoBase(0.005 * propriedade.getPrecoBase());
        propriedade.setDisponivel(0);
        cliente.getgpCli().getbdProp().add(propriedade);
    }
}
