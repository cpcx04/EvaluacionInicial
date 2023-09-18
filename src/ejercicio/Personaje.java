package ejercicio;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {

	// Atributos

	private String nombre;
	private int puntosVida;
	private int puntosConseguidos;
	private String[] mochila;
	private int numeroItems;

	// Constructores
	public Personaje(String nombre, int puntosVida, int puntosConseguidos, String[] mochila, int numeroItems) {
		super();
		this.nombre = nombre;
		this.puntosVida = 100;
		this.puntosConseguidos = 0;
		this.mochila = mochila;
		this.numeroItems = 0;
	}

	public Personaje() {
		this.puntosVida = 100;
	}

	public Personaje(String nombre) {
		this.puntosVida = 100;
		this.puntosConseguidos = 0;
		this.nombre = nombre;
	}

	// GettersAndSetters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getPuntosConseguidos() {
		return puntosConseguidos;
	}

	public void setPuntosConseguidos(int puntosConseguidos) {
		this.puntosConseguidos = puntosConseguidos;
	}

	public String[] getMochila() {
		return mochila;
	}

	public int getNumeroItems() {
		return numeroItems;
	}

	// EqualsAndHashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mochila);
		result = prime * result + Objects.hash(nombre, numeroItems, puntosConseguidos, puntosVida);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Arrays.equals(mochila, other.mochila) && Objects.equals(nombre, other.nombre)
				&& numeroItems == other.numeroItems && puntosConseguidos == other.puntosConseguidos
				&& puntosVida == other.puntosVida;
	}

	// toString

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntosConseguidos=" + puntosConseguidos
				+ ", mochila=" + Arrays.toString(mochila) + ", numeroItems=" + numeroItems + "]";
	}

	// Metodos

	/*
	 * Metodo para agregar Elemento Le pasamos un elemento que comprobará que el
	 * array tiene menos de diez elementos y en el caso de que sea así añadirá el
	 * elemento al array.
	 */
	public int agregarElemento(String elemento) {
		if (mochila.length >= 10) {
			MensajeMochilaLlena();
		} else {
			mochila[numeroItems] = elemento;
		}
		numeroItems++;

		return numeroItems;
	}

	public void MensajeMochilaLlena() {
		System.out.println("YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA");
	}

	/*
	 * Metodo para recibir golpe
	 * (Comprobar que funcione)
	 */

	public int recibirGolpe(int golpe) {
		puntosVida = puntosVida - golpe;

		if (puntosVida <= 0) {
			noTienesVida();
		}
		return puntosVida;

	}

	public void noTienesVida() {
		System.out.println("Estas eliminado");
	}
	
	/*Método botiquin*/
	
	public String buscarBotiquin() {
		String botiquin="BOTIQUIN";
		for (int i = 0; i < mochila.length;) {
			if(mochila[i].equalsIgnoreCase(botiquin)) {
				if(puntosVida==100) {
					return "Vida al máximo";
				}else {
					puntosVida=puntosVida+10;
					return "Ahora tiene" + puntosVida;
				}		
			}else{
				return "No se encuentra botiquin";
			}
		}
		return "Dispone de" + puntosVida;
	}
}
