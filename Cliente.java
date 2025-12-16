import java.util.ArrayList;
//Fhelipe Vinicios Dechico - RA: 2623390
public final class Cliente extends Pessoa {
    private int idade;
    private String profissao;
    private GerPropriedade gpCli = new GerPropriedade();

    //Sobrecarga
    public Cliente() {
        super();
        this.idade = 0;
        this.profissao = "";
        gpCli = new GerPropriedade();
    }

    //Sobrecarga
    public Cliente(String nome, long cpf, String email, String telefone, int idade, String profissao) {
        super(nome, cpf, email, telefone);
        this.idade = idade;
        this.profissao = profissao;
    }

    public int getIdade() {return idade;}
    public String getProfissao() {return profissao;}
    public GerPropriedade getgpCli() {return gpCli;}

    public void setIdade(int idade) throws IdadeMaiorException, NumeroNegativoException{
        if(idade > 80){
            throw new IdadeMaiorException();
        }
        if(idade < 0){
            throw new NumeroNegativoException();
        }
        this.idade = idade;
    }
    public void setProfissao(String profissao) {this.profissao = profissao;}
    public void setPropriedades(GerPropriedade gpCli) {this.gpCli = gpCli;}

    //Sobrescrita
    public void imprimirInformacao() {
        System.out.println("Nome: " + getNome() +
                            "\nCPF: " + getCpf() +
                            "\nEmail: " + getEmail() + 
                            "\nTelefone: " + getTelefone() +
                            "\nIdade: " + idade + 
                            "\nProfissao: " + profissao);
        if(!gpCli.getbdProp().isEmpty()){
            System.out.println("\nPropriedades:\n");
            for(Propriedade propriedade: gpCli.getbdProp()){
                System.out.println("==========================================================");
                propriedade.imprimirInformacao();
                 System.out.println("");
            }
            System.out.println("==========================================================");
        }
    }  
}