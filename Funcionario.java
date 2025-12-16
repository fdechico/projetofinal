//Fhelipe Vinicios Dechico - RA: 2623390
public final class Funcionario extends Pessoa {
    private int id;
    private double salario;
    private String cargo;
    private double comissao;

    //Sobrecarga
    public Funcionario() {
        super();
        this.id = 0;
        this.salario = 0.0;
        this.cargo = "";
        this.comissao = 0.0;
    }

    //Sobrecarga
    public Funcionario(String nome, long cpf, String email, String telefone, int id, double salario, String cargo, double comissao) {
        super(nome, cpf, email, telefone);
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
        this.comissao = comissao;
    }

    public int getId() {return id;}
    public double getSalario() {return salario;}
    public String getCargo() {return cargo;}
    public double getComissao() {return comissao;}

    public void setId(int id) throws NumeroNegativoException{
        if(id < 0){
            throw new NumeroNegativoException();
        }
        this.id = id;
    }

    public void setSalario(double salario) throws NumeroNegativoException{
        if(salario < 0){
            throw new NumeroNegativoException();
        }
        this.salario = salario;
    }

    public void setCargo(String cargo) {this.cargo = cargo;}
    public void setComissao(double comissao) {this.comissao = comissao;}

    //Sobrescrita
    public void imprimirInformacao() {
        System.out.println("Nome: " + getNome() +
                            "\nCPF: " + getCpf() +
                            "\nEmail: " + getEmail() + 
                            "\nTelefone: " + getTelefone() +
                            "\nId: " + id + 
                            "\nSalário: R$ " + salario +
                            "\nCargo: " + cargo +
                            "\nComissão: R$ " + comissao);
    }
}
