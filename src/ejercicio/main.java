package ejercicio;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombre;
		nombre="Amador";
		Personaje p1=new Personaje(nombre);
		nombre="Recio";
		Personaje p2=new Personaje (nombre);
	
		Batalla.batallas(p1, p2);
	}

}
