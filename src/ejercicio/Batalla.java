package ejercicio;

public class Batalla {

	// Métodos
	public static void batallas(Personaje p1, Personaje p2) {
		Personaje ganador;
		while (p1.getPuntosVida() >= 0 || p2.getPuntosVida() >= 0) {
			int golpe = (int) (Math.floor(Math.random() * (3 - 1 + 1) + 1));
			golpe = golpe * p2.getPuntosFuerza();
			p1.recibirGolpe(golpe);
			int golpe2 = (int) (Math.floor(Math.random() * (3 - 1 + 1) + 1));
			golpe2 = golpe2 * p1.getPuntosFuerza();
			p2.recibirGolpe(golpe2);
			if (p1.getPuntosVida() >= 30 || p2.getPuntosFuerza() >= 30 && p1.getPuntosVida() >= 0
					|| p2.getPuntosFuerza() >= 0) {
				p1.buscarBotiquin();
				p2.buscarBotiquin();
			} else if (p1.getPuntosFuerza() > p2.getPuntosFuerza() || p1.getPuntosFuerza() < p2.getPuntosFuerza()) {
				golpe = golpe + 1;
			}
			if (p1.getPuntosVida() == 0) {
				ganador = p2;
				int i = ganador.getPuntosFuerza();
				i = i + 1;
				ganador.setPuntosFuerza(i);
				if(ganador.getPuntosFuerza()==10) 
					System.out.println("Limite de Fuerza alcanzando, fin de la batalla");
			} else if (p2.getPuntosVida() == 0) {
				ganador = p1;
				int i = ganador.getPuntosFuerza();
				i = i + 1;
				if(ganador.getPuntosFuerza()==10) 
					System.out.println("Limite de Fuerza alcanzando, fin de la batalla");
			}
		}
	}


}
