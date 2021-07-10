package chess;

import boardgame.Piece;
import boardgame.Position;
import boardgame.Board;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class Partida {
	
	private Board tabuleiro;

	public Partida() {
		tabuleiro = new Board(8, 8);
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
	
	//performChessMove
	public PecaDeXadrez executaMovimento(JogadaPosicao posicaoInicial, JogadaPosicao posicaoFinal) {
		Position inicial = posicaoInicial.toPosicao();
		Position finall = posicaoFinal.toPosicao();
		validacaoPosicaoInicial(inicial);
		validacaoPosicaoFinal(inicial, finall);
		Piece obterPosicao = movePeca(inicial, finall);
		return (PecaDeXadrez) obterPosicao;
	}
	
	//makeMove
	private Piece movePeca(Position inicial, Position finall) {
		Piece p = tabuleiro.removePeca(inicial);
		Piece pecaCapturada = tabuleiro.removePeca(finall);
		tabuleiro.colocarPeca(p, finall);
		return pecaCapturada;
	}
	
	//validateSourcePosition
	private void validacaoPosicaoInicial(Position posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new ChessException("Nao existe peca na posicao de origem");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new ChessException("Nao existe movimentos possiveis para esta peca");
		}
	}
	
	//validateTargetPosition
	private void validacaoPosicaoFinal(Position inicial, Position finall) {
		if (!tabuleiro.peca(inicial).movimentoPossivel(finall)) {
			throw new ChessException("A peca escolhida nao pode se mover para posicao de destino");
		}
	}
	
	//validateNewPiece
	private void colocarNovaPeca (char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new JogadaPosicao(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCA));
		colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCA));
		
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETA));
		colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETA));
		colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETA));
		
	}
}
