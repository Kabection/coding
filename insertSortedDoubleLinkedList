/** 
   * Insere um objeto associado a chave na cabeca da lista, ou seja, a antiga cabeca passa
	 * a ser o segundo elemento no encadeamento.
	 */
	@Override
	public boolean inserir(int chave, Object info) {
		NoDEnc Atual = this.getCabeca();
		// lista vazia
		if (this.getCabeca() == null){
			this.cabeca = new NoDEnc(chave, info, null, this.getCabeca());
			this.cauda = this.getCabeca();
			this.tamanho++;
			return true;
		}
		// inserção na cabeça
		if (Atual.getChave() > chave){
			NoDEnc novoNo = new NoDEnc(chave, info, null, Atual);
			Atual.setAnterior(novoNo);
			this.cabeca = novoNo;
			this.tamanho++;
			return true;
		}
		// inserção na cauda
		if (this.cauda.getChave() < chave){
			NoDEnc novaCauda = new NoDEnc(chave,info,this.cauda,null);
			this.cauda.setProximo(novaCauda);
			this.cauda = novaCauda;
			this.tamanho++;
			return true;
		}
		// inserção no meio
		while (Atual != null){
			if (Atual.getChave() == chave)
				return false;
			if (Atual.getChave() > chave){
				NoDEnc novoNo = new NoDEnc(chave,info,Atual.getAnterior(),Atual);
				Atual.getAnterior().setProximo(novoNo);
				Atual.setAnterior(novoNo);
				this.tamanho++;
				return true;
			}else{
				Atual = Atual.getProximo();
			}
		}
		return false;
	}
