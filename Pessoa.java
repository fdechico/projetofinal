//Fhelipe Vinicios Dechico - RA: 2623390
public abstract class Pessoa {
    private String nome;
    private long cpf;
    private String email;
    private String telefone;

    //Sobrecarga
    public Pessoa() {
        this.nome = "";
        this.cpf = 0;
        this.email = "";
        this.telefone = "";
    }

    //Sobrecarga
    public Pessoa(String nome, long cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {return nome;}
    public long getCpf() {return cpf;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(long cpf) throws CpfDiferenteOnzeException{
        if(cpf < 10000000000L || cpf > 99999999999L ){
            throw new CpfDiferenteOnzeException();
        }

        this.cpf = cpf;
    }
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String telefone) throws NaoeDigitoException {
        for(char c: telefone.toCharArray()){
            if(Character.isDigit(c) != true){
                throw new NaoeDigitoException();
            }
        }
        
        this.telefone = telefone;
    }

    //Sobrescrita
    public abstract void imprimirInformacao();
}