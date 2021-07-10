package boardgame;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar tabuleiro: necess�rio que tenha pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("Posi��o n�o existe");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posi��o n�o existe");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new TabuleiroException("J� existe uma pe�a na posi��o: " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posi��o n�o existe");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca auxiliar = peca(posicao);
		auxiliar.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return auxiliar;
	}
	
	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Posi��o n�o existe");
		}
		return peca(posicao) != null;
	}
		
}
