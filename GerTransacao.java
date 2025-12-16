import java.util.ArrayList;
//Fhelipe Vinicios Dechico - RA: 2623390
public final class GerTransacao{
	private Leitura l = new Leitura();
	private Transacao tra;
	private ArrayList<Transacao> bdTra = new ArrayList<Transacao>();

	public ArrayList<Transacao> getBdTra(){
		return bdTra;
	}

	public Transacao consultaTransacao(Transacao tra){
		for(Transacao transacao: bdTra){
			if(tra.getId() == transacao.getId()){
				return transacao;
			}
		}
		return null;
	}

	public Transacao inserirTransacao(Transacao tra){
		if(consultaTransacao(tra) == null){
			bdTra.add(tra);
			return tra;
		}
		return null;
	}

	public Transacao deletarTransacao(Transacao tra){
		Transacao traDel = consultaTransacao(tra);
		if(traDel != null){
			bdTra.remove(traDel);
			return null;
		}
		return tra;
	}
}