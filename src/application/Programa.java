package application;

import chess.Partida;

public class Programa {
	
	public static void main(String[] args) {
		
		Partida partida = new Partida();
		Visualizacao.exibirNoTabuleiro(partida.getPecas());
		
	}

}
