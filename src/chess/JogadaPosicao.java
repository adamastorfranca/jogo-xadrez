package chess;

import boardgame.Position;

public class JogadaPosicao {
	
	private int linha;
	private char coluna;
	
	public JogadaPosicao(char coluna, int linha) {
		if (linha < 1 || linha > 8 || coluna < 'a' || coluna > 'h') {
			throw new ChessException("Erro na jogada: valores válidos são de a1 a h8");
		}
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}
	
	protected Position toPosicao() {
		return new Position(8 - linha, coluna - 'a');
	}
	
	protected static JogadaPosicao fromPosicao(Position posicao) {
		return new JogadaPosicao((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}

}
