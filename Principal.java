//Fhelipe Vinicios Dechico - RA: 2623390
public class Principal{
	public static void main(String args[]){
		Leitura l = new Leitura();
		Imobiliaria imob = new Imobiliaria();
		int opt1, opt2, opt3;

		do{
			//try
			System.out.println("Gerenciar:\n1 - Imoveis\n2 - Funcionarios\n3 - Clientes\n4 - Transacoes\n0 - Sair");
			opt1 = Integer.parseInt(l.entDados("Selecione uma opcao: "));

			switch(opt1){
				case 1:
					//imoveis
					do{
						//try
						System.out.println("\nImovel:\n1 - Adicionar\n2 - Remover\n3 - Alterar\n4 - Buscar\n5 - Listar\n0 - Voltar para o menu\n-1 - Sair"); //antes das operacoes perguntar se e casa, ap ou comercial
						opt2 = Integer.parseInt(l.entDados("Selecione uma opcao: "));

						switch(opt2){
							case 1:
								//add
								Propriedade prop;
								String tipoImovel = l.entDados("O imovel e uma casa, apartamento ou um imovel comercial?");
								if(tipoImovel.equalsIgnoreCase("casa")){
									prop = new Casa();
								}
								else if(tipoImovel.equalsIgnoreCase("apartamento")||tipoImovel.equalsIgnoreCase("ap")){
									prop = new Apartamento();
								}
								else if(tipoImovel.equalsIgnoreCase("imovel comercial")||tipoImovel.equalsIgnoreCase("comercial")){
									prop = new Comercial();
								}
								else{
									System.out.println("O tipo do imovel digitado e invalido, voltando para o menu");
									break;
								}
								
								prop = imob.getGp().inserirPropriedade(prop);
								if(prop == null){System.out.println("Já existe uma propriedade com este id");} //fazer com q o id seja automatico, ou fazer um loop pra reinserir o id
								else{System.out.println("Propriedade inserida com sucesso");}

								break;
							case 2:
								prop = new Casa(); //instancia uma casa so pra pegar o id, ja que nao e possivel instanciar propriedade

								try{
									prop.setId(Integer.parseInt(l.entDados("Digite o id do imovel que deseja remover: ")));
								}
								catch(NumeroNegativoException nne){
									System.out.println("O id da prorpiedade nao pode ser negativo, retornando ao menu");
								}
								catch(NumberFormatException nfe){
									System.out.println("A entrada de de dados deve ser um NUMERO!\nO id da propriedade deve ser um numero positivo, retornando ao menu");
								}

								prop = imob.getGp().deletarPropriedade(prop);
								if(prop == null){System.out.println("Propriedade excluida");}
								else{System.out.println("A propriedade nao existe");}
								break;
							case 3:
								prop = new Casa();
								try{
									prop.setId(Integer.parseInt(l.entDados("Digite o id do imovel que deseja atualizar: ")));
								}
								catch(NumeroNegativoException nne){
									System.out.println("O id da prorpiedade nao pode ser negativo, retornando ao menu");
								}
								catch(NumberFormatException nfe){
									System.out.println("A entrada de de dados deve ser um NUMERO!\nO id da propriedade deve ser um numero positivo, retornando ao menu");
								}
								
								//prop = imob.getGp().consultaPropriedade(prop);
								prop = imob.getGp().atualizaPropriedade(prop);
								if(prop == null){System.out.println("A Propriedade nao existe");}
								else{System.out.println("A propriedade foi alterada");}

								break;
							case 4:
								prop = new Casa(); 
								try{
									prop.setId(Integer.parseInt(l.entDados("Digite o id do imovel que deseja buscar: ")));
								}
								catch(NumeroNegativoException nne){
									System.out.println("O id da prorpiedade nao pode ser negativo, retornando ao menu");
								}
								catch(NumberFormatException nfe){
									System.out.println("A entrada de de dados deve ser um NUMERO!\nO id da propriedade deve ser um numero positivo, retornando ao menu");
								}
								
								prop = imob.getGp().consultaPropriedade(prop);

								if(prop == null){System.out.println("A Propriedade nao existe");}
								else{
									System.out.println("----------------------------------------------------------");
									prop.imprimirInformacao();
									System.out.println("----------------------------------------------------------");
								}

								break;
							case 5:
								System.out.println("----------------------------------------------------------");
								for(Propriedade propriedade: imob.getGp().getbdProp()){
									propriedade.imprimirInformacao();
									System.out.println("");
								}
								System.out.println("----------------------------------------------------------");
								break;
							case 0:
								break;
							case -1:
								System.exit(0);
								break;
							default:
								System.out.println("\nValor fora do escopo, tente novamente");
						}
					}while(opt2 != 0);
					System.out.println("");

					break;
				case 2:
					//funcionarios
					do{
						System.out.println("\nFuncionario:\n1 - Adicionar\n2 - Remover\n3 - Alterar\n4 - Buscar\n5 - Listar\n0 - Voltar para o menu\n-1 - Sair");
						opt2 = Integer.parseInt(l.entDados("Selecione uma opcao: "));

						switch(opt2){
							case 1:
								//add
								Funcionario fun = new Funcionario();
								fun = imob.getGf().inserirFuncionario(fun);
								if(fun == null){System.out.println("Já existe uma funcionario com este id ou cpf");}
								else{System.out.println("Funcionario inserido com sucesso");}

								break;
							case 2:
								fun = new Funcionario();

								try{
									fun.setId(Integer.parseInt(l.entDados("Digite o id do funcionario: ")));
								}
								catch(NumeroNegativoException nne){System.out.println("O id do funcionario deve ser um inteiro positivo, voltando para o menu");}
								catch(NumberFormatException nfe){System.out.println("O id do funcionario deve ser um NUMERO inteiro positivo, voltando para o menu");}

								fun = imob.getGf().deletarFuncionario(fun);
								if(fun == null){System.out.println("Funcionario excluido");}
								else{System.out.println("O funcionario com este id nao existe");}

								break;
							case 3:
								fun = new Funcionario();

								try{
									fun.setId(Integer.parseInt(l.entDados("Digite o id do funcionario: ")));
								}
								catch(NumeroNegativoException nne){System.out.println("O id do funcionario deve ser um inteiro positivo, voltando para o menu");}
								catch(NumberFormatException nfe){System.out.println("O id do funcionario deve ser um NUMERO inteiro positivo, voltando para o menu");}

								fun = imob.getGf().atualizaFuncionario(fun);
								if(fun == null){System.out.println("O funcionario com este id nao existe");}
								else{System.out.println("O funcionario foi alterado");}
								break;
							case 4:
								fun = new Funcionario();

								try{
									fun.setId(Integer.parseInt(l.entDados("Digite o id do funcionario: ")));
								}
								catch(NumeroNegativoException nne){System.out.println("O id do funcionario deve ser um inteiro positivo, voltando para o menu");}
								catch(NumberFormatException nfe){System.out.println("O id do funcionario deve ser um NUMERO inteiro positivo, voltando para o menu");}

								fun = imob.getGf().consultaIdFuncionario(fun);
								if(fun == null){System.out.println("O funcionario com este id nao existe");}
								else{
									System.out.println("----------------------------------------------------------");
									fun.imprimirInformacao();
									System.out.println("----------------------------------------------------------");
								}
								break;
							case 5:
								System.out.println("----------------------------------------------------------");
								for(Funcionario funcionario: imob.getGf().getbdFun()){
									funcionario.imprimirInformacao();
									System.out.println("");
								}
								System.out.println("----------------------------------------------------------");
								break;
							case 0:
								break;
							case -1:
								System.exit(0);
								break;
							default:
								System.out.println("\nValor fora do escopo, tente novamente");
						}
					}while(opt2 != 0);
					System.out.println("");

					break;
				case 3:
					//clientes
					do{
						System.out.println("\nCliente:\n1 - Adicionar\n2 - Remover\n3 - Alterar\n4 - Buscar\n5 - Listar\n0 - Voltar para o menu\n-1 - Sair");
						opt2 = Integer.parseInt(l.entDados("Selecione uma opcao: "));

						switch(opt2){
							case 1:
								//adiciona cliente, tem um loop com try para o cpf ser valido, ou sai do loop retornando null 
								Cliente cli = new Cliente();
								cli = imob.getGc().inserirCliente(cli);
								if(cli == null){System.out.println("Já existe uma cliente com este cpf");}
								else{System.out.println("Cliente inserido com sucesso");}

								break;
							case 2:
								//remover cliente, se for lancada uma exception volta para o menu
								cli = new Cliente();
								try{
									cli.setCpf(Long.parseLong(l.entDados("Digite o cpf do cliente que sera deletado: ")));
									cli = imob.getGc().deletarCliente(cli);
								}
								catch(CpfDiferenteOnzeException cdo){
									System.out.println("O cpf deve ter 11 digitos positivos, voltando para o menu");
									break;
								}
								catch(NumberFormatException nfe){
									System.out.println("O cpf deve ser um numero inteiro, positivo de 11 digitos, voltando para o menu");
									break;
								}
								if(cli == null){System.out.println("Cliente excluido");}
								else{System.out.println("O cliente com este cpf nao existe");}

								break;
							case 3:
								//atualiza cliente, se for lancada uma exception volta para o menu
								cli = new Cliente();
								try{
									cli.setCpf(Long.parseLong(l.entDados("Digite o cpf do cliente que sera atualizado: ")));
									cli = imob.getGc().atualizaCliente(cli);
								}
								catch(CpfDiferenteOnzeException cdo){
									System.out.println("O cpf deve ser 11 digitos positivos, voltando para o menu");
									break;
								}
								catch(NumberFormatException nfe){
									System.out.println("O cpf deve ser um numero inteiro, positivo de 11 digitos, voltando para o menu");
									break;
								}
								if(cli == null){System.out.println("O cliente com este cpf nao existe");}
								else{System.out.println("O cliente foi alterado");}

								break;
							case 4:
								//consulta cliente, se for lancada uma exception volta para o menu
								cli = new Cliente();
								try{
									cli.setCpf(Long.parseLong(l.entDados("Digite o cpf do cliente que sera consultado: ")));
									cli = imob.getGc().consultaCliente(cli);
								}
								catch(CpfDiferenteOnzeException cdo){
									System.out.println("O cpf deve ter 11 digitos positivos, voltando para o menu");
									break;
								}
								catch(NumberFormatException nfe){
									System.out.println("O cpf deve ser um numero inteiro, positivo de 11 digitos, voltando para o menu");
									break;
								}
								if(cli == null){System.out.println("O cliente com este cpf nao existe");}
								else{
									System.out.println("----------------------------------------------------------");
									cli.imprimirInformacao();
									System.out.println("----------------------------------------------------------");
								}

								break;
							case 5:
								System.out.println("----------------------------------------------------------");
								for(Cliente cliente: imob.getGc().getBdCli()){
									cliente.imprimirInformacao();
									System.out.println("");
								}
								System.out.println("----------------------------------------------------------");
								break;
							case 0:
								break;
							case -1:
								System.exit(0);
								break;
							default:
								System.out.println("\nValor fora do escopo, tente novamente");
						}
					}while(opt2 != 0);
					System.out.println("");

					break;
				case 4:
					//transacoes
					do{
						System.out.println("\nTransacao:\n1 - Nova transacao\n2 - Remover Transacao\n3 - Consultar Transacao \n4 - Listar Transacoes\n0 - Voltar para o menu\n-1 - Sair");
						opt2 = Integer.parseInt(l.entDados("Selecione uma opcao: "));

						switch(opt2){
							case 1:
								Transacao tra = new Transacao();
								Transacao verifica = new Transacao();
								Cliente cli = new Cliente();
								Funcionario fun = new Funcionario();
								Propriedade prop = new Casa();
								int flag = 0;

								while(flag == 0){
									try{
										tra.setId(Integer.parseInt(l.entDados("Digite o id da transacao")));

										verifica = imob.getGt().consultaTransacao(tra);
										if(verifica != null){System.out.println("Ja existe uma transacao com este id, tente novamente");}
										else{flag = 1;}
									}
									catch(NumeroNegativoException nne){System.out.println("O id deve ser maior positivo");}
									catch(NumberFormatException nfe){System.out.println("O id deve ser um numero inteiro");}
								}
								
								flag = 0;

								while(flag == 0){
									try{
										cli.setCpf(Long.parseLong(l.entDados("Digite o cpf do cliente: ")));
										flag = 1;
									}
									catch(CpfDiferenteOnzeException cdo){System.out.println("O cpf deve ter 11 digitos positivos");}
									catch(NumberFormatException nfe){System.out.println("O cpf deve ser um numero inteiro, positivo de 11 digitos");}
									catch(NullPointerException npe){
										System.out.println("Tente novamente");
										continue;
									}
									
									tra.setCliente(imob.getGc().consultaCliente(cli));
									if(tra.getCliente() == null){
										System.out.println("Nao existe um cliente com este cpf, retornando ao menu");
										flag = -1;
										break;
									}
								}

								if(flag == -1){break;}
								flag = 0;

								while(flag == 0){
									try{
										fun.setId(Integer.parseInt(l.entDados("Digite o id do funcionario responsavel pela transacao: ")));
										flag = 1;
									}
									catch(NumeroNegativoException nne){System.out.println("O id do funcionario deve ser um inteiro positivo");}
									catch(NumberFormatException nfe){System.out.println("O id do funcionario deve ser um NUMERO inteiro positivo");}
									catch(NullPointerException npe){
										System.out.println("Tente novamente");
										continue;
									}

									tra.setFuncionario(imob.getGf().consultaIdFuncionario(fun));
									if(tra.getFuncionario() == null){
										System.out.println("Nao existe um funcionario com este id, voltando ao menu");
										flag = -1;
										break;
									}
								}

								if(flag == -1){break;}
								flag = 0;
								
								while(flag == 0){
									try{
										prop.setId(Integer.parseInt(l.entDados("Digite o id da propriedade: ")));
										flag = 1;
									}
									catch(NumeroNegativoException nne){
										System.out.println("O id da prorpiedade nao pode ser negativo");
									}
									catch(NumberFormatException nfe){
										System.out.println("A entrada de de dados deve ser um NUMERO!\nO id da propriedade deve ser um numero positivo");
									}
									catch(NullPointerException npe){
										System.out.println("Tente novamente");
										continue;
									}

									tra.setPropriedade(imob.getGp().consultaPropriedade(prop));
									if(tra.getPropriedade() == null){
										System.out.println("Nao existe uma propriedade com este id, retornando ao menu");
										flag = -1;
										break;
									}
								}

								if(flag == -1){break;}

								if(tra.getPropriedade().getDisponivel() == 0){
									System.out.println("A propriedade nao esta disponivel, voltando ao menu");
									break;
								}

								flag = 0;
								
								while(flag == 0){
									String tipo = l.entDados("A propriedade sera vendida ou alugada?");
									if(tipo.equalsIgnoreCase("venda") || tipo.equalsIgnoreCase("vendida")){
										tra.venderPropriedade();
										tra.setTipoTransacao(tipo);

										for(int i = 0; i < imob.getGc().getBdCli().size(); i++){
											if(tra.getCliente().getCpf() == imob.getGc().getBdCli().get(i).getCpf()){
												imob.getGc().getBdCli().set(i, tra.getCliente());
											}
										}
										for(int i = 0; i < imob.getGf().getbdFun().size(); i++){
											if(tra.getFuncionario().getId() == imob.getGf().getbdFun().get(i).getId()){
												imob.getGf().getbdFun().set(i, tra.getFuncionario());
											}
										}
										flag = 1;
									}
									else if(tipo.equalsIgnoreCase("alugada") || tipo.equalsIgnoreCase("aluguel")){
										tra.alugarPropriedade();
										tra.setTipoTransacao(tipo);

										for(int i = 0; i < imob.getGc().getBdCli().size(); i++){
											if(tra.getCliente().getCpf() == imob.getGc().getBdCli().get(i).getCpf()){
												imob.getGc().getBdCli().set(i, tra.getCliente());
											}
										}
										for(int i = 0; i < imob.getGp().getbdProp().size(); i++){
											if(tra.getPropriedade().getId() == imob.getGp().getbdProp().get(i).getId()){
												imob.getGp().getbdProp().set(i, tra.getPropriedade());
											}
										}
										flag = 1;
									}
									else{
										System.out.println("Transacao nao reconhecida, tente novamente");
									}
								}

								tra = imob.getGt().inserirTransacao(tra);

								if(tra == null){System.out.println("Ja existe uma transacao com este id");}
								else{
									System.out.println("Transacao inserida com sucesso");
								}

								break;
							case 2:
								//remover
								tra = new Transacao();
								Transacao tra2 = new Transacao();
								int iCliente = 0, iPropriedade = 0;

								try{
									tra.setId(Integer.parseInt(l.entDados("Digite o id da transacao que sera removida")));
								}
								catch(NumeroNegativoException nne){System.out.println("O id deve ser positivo");}
								catch(NumberFormatException nfe){System.out.println("O id deve ser um numero inteiro");}

								
								tra2 = tra;
								tra = imob.getGt().deletarTransacao(tra);
								if(tra == null){System.out.println("A transacao foi deletada");}
								else{System.out.println("Nao foi encontrada uma transacao com este id");}
								tra2 = null;
								break;
							case 3:
								tra = new Transacao();

								try{
									tra.setId(Integer.parseInt(l.entDados("Digite o id da Transacao que sera consultada: ")));
								}
								catch(NumeroNegativoException nne){System.out.println("O id deve ser maior positivo");}
								catch(NumberFormatException nfe){System.out.println("O id deve ser um numero inteiro");}
								
								tra = imob.getGt().consultaTransacao(tra);
								if(tra == null){System.out.println("A transacao com este id nao existe");}
								else{
									System.out.println("----------------------------------------------------------");
									tra.imprimirInformacao();
									System.out.println("----------------------------------------------------------");
								}

								break;
							case 4:
								System.out.println("----------------------------------------------------------");
								for(Transacao transacao: imob.getGt().getBdTra()){
									transacao.imprimirInformacao();
									System.out.println("");
								}
								System.out.println("----------------------------------------------------------");

								break;
							case 0:
								break;
							case -1:
								System.exit(0);
								break;
							default:
								System.out.println("\nValor fora do escopo, tente novamente");
						}

					}while(opt2 != 0);
					System.out.println("");

					break;
				case 0:
					break;
				default:
					System.out.println("Valor fora do escopo, tente novamente");
				}

			}while(opt1 != 0);
		}
}
	