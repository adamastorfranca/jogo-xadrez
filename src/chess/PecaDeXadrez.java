package chess;

import boardgame.Piece;
import boardgame.Position;
import boardgame.Board;

public abstract class PecaDeXadrez extends Piece{
	
	private Cor cor;

	public PecaDeXadrez(Board tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	//isThereOpponentPiece OK
	protected boolean existePecaOponente(Position posicao) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
}
