import java.util.ArrayList;
//Fhelipe Vinicios Dechico - RA: 2623390
public final class GerPropriedade{
	private Leitura l = new Leitura();
	private Propriedade prop;
	private ArrayList<Propriedade> bdProp = new ArrayList<Propriedade>();

	public ArrayList<Propriedade> getbdProp(){
		return bdProp;
	}

	public Propriedade consultaPropriedade(Propriedade prop){
		for(Propriedade propriedade: bdProp){
			if(prop.getId() == propriedade.getId()){
				return propriedade;
			}
		}
		return null;
	}

	public Propriedade inserirPropriedade(Propriedade prop){
		if(consultaPropriedade(prop) == null){
			int flag = 0;

			while(flag == 0){
				try{
					prop.setId(Integer.parseInt(l.entDados("Digite o id para o imovel: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("O id da prorpiedade nao pode ser negativo, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrada de de dados deve ser um NUMERO!\nO id da propriedade deve ser um numero positivo, , tente novamente");
				}
			}
			
			prop.setEndereco(l.entDados("Digite o Endereco: "));
			flag = 0;

			while(flag == 0){
				try{
					prop.setMetrosQuadrados(Double.parseDouble(l.entDados("Digite a area em metros quadrados do imovel: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("A area do imovel nao pode ser negativa e nem nula, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrada de dados deve ser um NUMERO\nA area do imovel deve ser um numero positivo, tente novamente");
				}
			}

			flag = 0;

			while(flag == 0){
				try{
					prop.setQtdQuartos(Integer.parseInt(l.entDados("Digite a quantidade de quartos do imovel: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("A quantidade de quartos nao pode ser negativa, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de quartos deve ser um numero positivo, tente novamente");
				}
			}

			flag = 0;

			while(flag == 0){
				try{
					prop.setQtdBanheiros(Integer.parseInt(l.entDados("Digite a quantidade de banheiros do imovel: ")));
					flag = 1;
				}
				catch(NumeroNegativoException nne){
					System.out.println("A quantidade de banheiros nao pode ser negativa, tente novamente");
				}
				catch(NumberFormatException nfe){
					System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de banheiros deve ser um numero positivo, tente novamente");
				}
			}

			flag = 0;

			if(prop instanceof Casa){
				Casa casa = (Casa) prop;

				while(flag == 0){
					try{
						casa.setQtdAndares(Integer.parseInt(l.entDados("Digite a quantidade de andares: ")));
						flag = 1;
					}
					catch(NumeroNegativoException nne){
						System.out.println("A quantidade de andares do imovel nao pode ser negativa ou nula, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA qunatidade de andares deve ser um numero positivo, tente novamente");
					}
				}
				
				casa.setTipoArquitetura(l.entDados("Qual o estilo arquitetonico?"));
                casa.setJardim(Boolean.parseBoolean(l.entDados("A casa tem jardim? <true/false>")));
                casa.setPiscina(Boolean.parseBoolean(l.entDados("A casa tem piscina? <true/false>")));
			}
			else if(prop instanceof Apartamento){
				Apartamento ap = (Apartamento) prop;

				while(flag == 0){
					try{
						ap.setAndar(Integer.parseInt(l.entDados("Qual o andar do apartamento?")));
						flag = 1;
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nO andar deve ser um numero positivo");
					}
					catch(NumeroNegativoException nne){
						System.out.println("O andar do ap nao pode ser negativo");
					}
				}

				ap.setVaranda(Boolean.parseBoolean(l.entDados("O apartamento tem varanda? <true/false>")));
				flag = 0;

				while(flag == 0){
					try{
						ap.setValorCondominio(Double.parseDouble(l.entDados("Digite o valor do condominio: ")));
						flag = 1;
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nO valor do condominio deve ser um numero positivo");
					}
					catch(NumeroNegativoException nne){
						System.out.println("O valor do condominio nao pode ser negativo");
					}
				}

                ap.setPortaria(Boolean.parseBoolean(l.entDados("O apartamento tem portaria? <true/false>")));

                flag = 0;

                while(flag == 0){
					try{
						ap.setVagasEstacionamento(Integer.parseInt(l.entDados("Insira a quantidade de vagas de estacionamento: ")));
						flag = 1;
					}
					catch(NumeroNegativoException nne){
						System.out.println("A quantidade de vagas nao pode ser negativa, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de vagas deve ser um numero positivo, tente novamente");
					}
				}
                
			}
			else if(prop instanceof Comercial){
				Comercial com = (Comercial) prop;
				com.setTipoComercio(l.entDados("Qual o tipo do comercio? "));
                com.setDescricao(l.entDados("Insira uma descricao sobre o comercio: "));

                while(flag == 0){
					try{
						com.setCameras(Integer.parseInt(l.entDados("Insira a quantidade de cameras: ")));
						flag = 1;
					}
					catch(NumeroNegativoException nne){
						System.out.println("A quantidade de cameras nao pode ser negativa, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de vagas deve ser um numero positivo, tente novamente");
					}
				}
			}
			else{
				System.out.println("Instancia de propriedade proibida, retornando null");
				return null;
			}

			prop.calcPreco();
			bdProp.add(prop);
			return prop;
		}
		return null;
	}

	public Propriedade deletarPropriedade(Propriedade prop){
		Propriedade propDel = consultaPropriedade(prop);
		if(propDel != null){
			bdProp.remove(propDel);
			return null;
		}
		return prop;
	}

	public Propriedade atualizaPropriedade(Propriedade prop){
		for(int i = 0; i < bdProp.size(); i++){
			if(prop.getId() == bdProp.get(i).getId()){
            	prop = bdProp.get(i);

            	try{
	            	prop.setMetrosQuadrados(Double.parseDouble(l.entDados("Insira a nova area: ")));
	            }
	            catch(NumberFormatException nfe){
	            	System.out.println("A entrada de dados deve ser um NUMERO\nA area do imovel deve ser um numero positivo");
	            }
	            catch(NumeroNegativoException nne){
	            	System.out.println("A area do imovel nao pode ser negativa e nem nula");
	            }
                
                try{
                	prop.setQtdQuartos(Integer.parseInt(l.entDados("Insira a nova quantidade de quartos: ")));
            	}
            	catch(NumberFormatException nfe){
            		System.out.println("A quantidade de quartos nao pode ser negativa");
            	}
            	catch(NumeroNegativoException nne){
            		System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de quartos deve ser um numero positivo");
            	}

            	try{
            		prop.setQtdBanheiros(Integer.parseInt(l.entDados("Insira a nova quantidade de banheiros: ")));
            	}
            	catch(NumberFormatException nfe){
            		System.out.println("A quantidade de banheiros nao pode ser negativa");
            	}
            	catch(NumeroNegativoException nne){
            		System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de banheiros deve ser um numero positivo");
            	}

                if(prop instanceof Casa){
                	Casa casa = (Casa) prop;

                	try{
                		casa.setQtdAndares(Integer.parseInt(l.entDados("Insira a nova quantidade de andares: ")));
		            }
					catch(NumeroNegativoException nne){
						System.out.println("A quantidade de andares do imovel nao pode ser negativa ou nula");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA qunatidade de andares deve ser um numero positivo");
					}

                	casa.setJardim(Boolean.parseBoolean(l.entDados("A casa tem jardim? <true/false>")));
                	casa.setPiscina(Boolean.parseBoolean(l.entDados("A casa tem piscina? <true/false>")));
                }

                else if(prop instanceof Apartamento){
                	Apartamento ap = (Apartamento) prop;

                	try{
                		ap.setValorCondominio(Double.parseDouble(l.entDados("Insira o novo valor do condominio: ")));
	            	}
	            	catch(NumberFormatException nfe){
						System.out.println("O valor do condominio nao pode ser negativo");
					}
					catch(NumeroNegativoException nne){
						System.out.println("A entrada de dados deve ser um NUMERO\nO valor do condominio deve ser um numero positivo");
					}

                	ap.setPortaria(Boolean.parseBoolean(l.entDados("O apartamento tem portaria? <true/false>")));

                	try{
                		ap.setVagasEstacionamento(Integer.parseInt(l.entDados("Insira a nova quantidade de vagas de estacionamento: ")));
	            	}
	            	catch(NumeroNegativoException nne){
						System.out.println("A quantidade de vagas nao pode ser negativa, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de vagas deve ser um numero positivo, tente novamente");
					}
                }

                else if(prop instanceof Comercial){
                	Comercial com = (Comercial) prop;

                	com.setTipoComercio(l.entDados("Qual o novo tipo do comercio? "));
                	com.setDescricao(l.entDados("Insira uma descricao sobre o novo comercio: "));

                	try{
                		com.setCameras(Integer.parseInt(l.entDados("Insira a nova quantidade de cameras: ")));
	            	}
	            	catch(NumeroNegativoException nne){
						System.out.println("A quantidade de cameras nao pode ser negativa, tente novamente");
					}
					catch(NumberFormatException nfe){
						System.out.println("A entrada de dados deve ser um NUMERO\nA quantidade de vagas deve ser um numero positivo, tente novamente");
					}
                }

                else{
                	System.out.println("Instancia de propriedade proibida, retornando null");
					return null;
                }

                prop.calcPreco();
                bdProp.set(i, prop);  
                return bdProp.get(i);
			}
		}
		return null;
	}
}