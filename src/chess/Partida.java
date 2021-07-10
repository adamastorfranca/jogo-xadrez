package chess;

import boardgame.Peca;
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
	
	public PecaDeXadrez executaMovimento(JogadaPosicao posicaoInicial, JogadaPosicao posicaoFinal) {
		Posicao inicial = posicaoInicial.toPosicao();
		Posicao finall = posicaoFinal.toPosicao();
		validacaoPosicaoInicial(inicial);
		Peca obterPosicao = movePeca(inicial, finall);
		return (PecaDeXadrez) obterPosicao;
	}
	
	private Peca movePeca(Posicao inicial, Posicao finall) {
		Peca p = tabuleiro.removePeca(inicial);
		Peca pecaCapturada = tabuleiro.removePeca(finall);
		tabuleiro.colocarPeca(p, finall);
		return pecaCapturada;
	}
	
	private void validacaoPosicaoInicial(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
	}
	
	private void colocarNovaPeca (char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new JogadaPosicao(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCA));
		
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETA));
		
	}
}
