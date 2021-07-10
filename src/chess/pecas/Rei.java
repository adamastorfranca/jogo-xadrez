package chess.pecas;

import boardgame.Board;
import chess.Cor;
import chess.PecaDeXadrez;

public class Rei extends PecaDeXadrez{

	public Rei(Board tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "K"; // King
	}

	//possibleMoves
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return matriz;
	}
}
