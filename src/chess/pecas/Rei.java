package chess.pecas;

import boardgame.Tabuleiro;
import chess.Cor;
import chess.PecaDeXadrez;

public class Rei extends PecaDeXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "K"; // King
	}
}
