package application;

import java.util.Scanner;

import chess.JogadaPosicao;
import chess.Partida;
import chess.PecaDeXadrez;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while (true) {
			Visualizacao.exibirNoTabuleiro(partida.getPecas());
			
			System.out.println();
			System.out.print("Posição da peça: ");
			JogadaPosicao origem = Visualizacao.receberPosicao(sc);
			
			System.out.println();
			System.out.print("Posição da jogada: ");
			JogadaPosicao jogada = Visualizacao.receberPosicao(sc);
			
			PecaDeXadrez capturada = partida.executaMovimento(origem, jogada);
			
		}
	}
}
