package chess;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class Partida {
	
	private Tabuleiro tabuleiro;

	public Partida() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}
	
	public PecaDeXadrez[][] getPecas(){
		PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int l = 0; l < tabuleiro.getLinhas(); l++) {
			for(int c = 0; c < tabuleiro.getColunas(); c++) {
				matriz[l][c] = (PecaDeXadrez) tabuleiro.peca(l, c);
			}
		}
		return matriz;
	}
	
	private void colocarNovaPeca (char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new JogadaPosicao(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
		
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		
	}
}
