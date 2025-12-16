import java.util.ArrayList;
//Fhelipe Vinicios Dechico - RA: 2623390
public final class GerFuncionario{
	private Leitura l = new Leitura();
	private Funcionario fun;
	private ArrayList<Funcionario> bdFun = new ArrayList<Funcionario>();

	public ArrayList<Funcionario> getbdFun(){
		return bdFun;
	}

	public Funcionario consultaIdFuncionario(Funcionario fun){
		for(Funcionario funcionario: bdFun){
			if(fun.getId() == funcionario.getId()){
				return funcionario;
			}
		}
		return null;
	}

	public Funcionario consultaFuncionario(Funcionario fun){
		for(Funcionario funcionario: bdFun){
			if(fun.getCpf() == funcionario.getCpf() && fun.getId() == funcionario.getId()){
				return funcionario;
			}
		}
		return null;
	}

	public Funcionario inserirFuncionario(Funcionario fun){
		if(consultaFuncionario(fun) == null){
			int flag = 0;

			fun.setNome(l.entDados("Digite o nome do funcionario: "));
			while(flag == 0){
				try{
					fun.setCpf(Long.parseLong(l.entDados("Digite o cpf do funcionario: ")));
					flag = 1;
				}
				catch(CpfDiferenteOnzeException ndo){
					System.out.println("Insira um novo cpf com 11 digitos positivos");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrade de dados deve ser um numero!");
					System.out.println("O cpf deve ter um numero inteiro, positivo de 11 digitos");
				}
			}

			fun.setEmail(l.entDados("Digite o email do funcionario: "));

			flag = 0;

			while(flag == 0){
				try{
					fun.setTelefone(l.entDados("Digite o telefone do funcionario: "));
					flag = 1;
				}
				catch(NaoeDigitoException nede){
					System.out.println("O telefone deve ser apenas numeros");
				}
			}

			flag = 0;

			while(flag == 0){
				try{
					fun.setId(Integer.parseInt(l.entDados("Digite o id do funcionario: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("O id do funcionario deve ser um inteiro positivo, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrade de dados deve ser um numero!");
					System.out.println("O id do funcionario deve ser um NUMERO inteiro positivo, tente novamente");
				}
			}
			
			fun.setCargo(l.entDados("Digite o cargo do funcionario: "));
			flag = 0;

			while(flag == 0){
				try{
					fun.setSalario(Double.parseDouble(l.entDados("Digite o salario do funcionario: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("O salario do funcionario deve ser um numero real positivo, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrade de dados deve ser um numero!");
					System.out.println("O salario do funcionario deve ser um NUMERO real positivo, tente novamente");
				}
			}
			
			bdFun.add(fun);
			return fun;
		}
		return null;
	}

	public Funcionario deletarFuncionario(Funcionario fun){
		Funcionario funDel = consultaIdFuncionario(fun);
		if(funDel != null){
			bdFun.remove(funDel);
			return null;
		}
		return fun;
	}

	public Funcionario atualizaFuncionario(Funcionario fun){
		for(int i = 0; i < bdFun.size(); i++){
			if(fun.getId() == bdFun.get(i).getId()){
				int flag = 0;
            	fun = bdFun.get(i);
                fun.setNome(l.entDados("Insira o novo nome do Funcionario: "));
                fun.setEmail(l.entDados("Insira o novo email: "));
                fun.setCargo(l.entDados("Insira o novo cargo: "));

                while(flag == 0){
					try{
						fun.setSalario(Double.parseDouble(l.entDados("Digite o salario do funcionario: ")));
						flag = 1;
					}
					catch(NumeroNegativoException nne){
						System.out.println("O salario do funcionario deve ser um numero real positivo, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrade de dados deve ser um numero!");
						System.out.println("O salario do funcionario deve ser um NUMERO real positivo, tente novamente");
					}
				}

				try{
					fun.setTelefone(l.entDados("Insira o novo telefone: "));
				}
				catch(NaoeDigitoException nede){
					System.out.println("O telefone deve ser apenas numeros");
				}

                bdFun.set(i, fun);  
                return bdFun.get(i);
			}
		}
		
		return null;
	}
}