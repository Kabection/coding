public class ListaDEncOrdRec extends ListaEncAbs implements ListaEncOrdRec{

  private int tamanho;
	protected NoDEnc cauda;
	
	protected NoDEnc getCabeca() {
		return (NoDEnc) this.cabeca;
	}
	
	protected void setCabeca(NoDEnc No){
		this.cabeca = No;
	}

	@Override
	public int tamanho() {
		return this.tamanho;
	}
	
	@Override
	public boolean alterar(int chave, Object info) {
		NoDEnc No = this.obter(chave);
		if (No != null){
			No.setInfo(info);
			return true;
		}
		return false;
	}
	
	@Override
	public NoDEnc obter(int chave){
		return obter(chave, this.getCabeca());
	}
	
	private NoDEnc obter(int chave, NoDEnc No){
		if (No == null){
			return null;
		}else if (No.getChave() == chave){
			return No;
		}else{
			return obter(chave, No.getProximo());
		}
	}
	
	@Override
	public boolean inserir(int chave, Object info) {
		NoDEnc NoInserido = new NoDEnc(chave, info, null, null);
		if (this.getCabeca() == null){
			this.setCabeca(this.cauda = NoInserido);
			tamanho++;
			return true;
		}
		NoDEnc Maior = procuraMaior(chave, this.getCabeca());
		if (Maior == null){
			this.cauda.setProximo(NoInserido);
			NoInserido.setAnterior(this.cauda);
			this.cauda = NoInserido;
			tamanho++;
			return true;
		}else if (Maior == this.getCabeca()){
			NoInserido.setProximo(this.getCabeca());
			this.getCabeca().setAnterior(NoInserido);
			this.setCabeca(NoInserido);
			tamanho++;
			return true;
		}else{
			NoInserido.setAnterior(Maior.getAnterior());
			NoInserido.setProximo(Maior);
			Maior.getAnterior().setProximo(NoInserido);
			Maior.setAnterior(NoInserido);
			tamanho++;
			return true;
		}
	}

	private NoDEnc procuraMaior(int chave, NoDEnc No){
		if (No == null){
			return null;
		}else if (No.getChave() > chave){
			return No;
		}else{
			return procuraMaior(chave, No.getProximo());
		}
	}
	
	@Override
	public boolean remover(int chave){
		NoDEnc NoRemovido = this.obter(chave);
		if (NoRemovido == null){
			throw new IllegalStateException("Chave não encontrada");			
		}
		if (this.tamanho() == 1){
				this.setCabeca(this.cauda = null);
				tamanho--;
				return true;
		}else if (NoRemovido == this.getCabeca()){
				this.setCabeca(NoRemovido.getProximo());
				this.getCabeca().setAnterior(null);
				tamanho--;
				return true;
		}else if (NoRemovido == this.cauda){
				this.cauda = this.cauda.getAnterior();
				this.cauda.setProximo(null);
				tamanho--;
				return true;
		}else{
				NoRemovido.getAnterior().setProximo(NoRemovido.getProximo());
				NoRemovido.getProximo().setAnterior(NoRemovido.getAnterior());
				tamanho--;
				return true;
		}
	}
}
