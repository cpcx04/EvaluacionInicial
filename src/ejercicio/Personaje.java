package ejercicio;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {

	// Atributos

	private String nombre;
	private int puntosVida=100;
	private int puntosConseguidos=0;
	private int numeroItems=10;
	private String[] mochila = {"Vacio","Vacio","Vacio","Vacio","BOTIQUIN","Vacio","Vacio","Vacio","Vacio","Vacio"};
	private int puntosFuerza=1;

	// Constructores

	public Personaje() {
	}
	public Personaje(String nombre) {
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
	
	/*Método botiquin
	 * 
	 * 
	 * El metodo del botiquin se encarga de
	 * buscar en el array un elemento que contenga el nombre
	 * de BOTOQUIN, si lo encuentra aplica diez de salud
	 * , sino no aplica salud
	 * 
	 * 
	 * */
	
	public String buscarBotiquin() {
		String botiquin="BOTIQUIN";
		for (String element : mochila) {
			if(element.equalsIgnoreCase(botiquin)) {
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

	public int getPuntosFuerza() {
		return puntosFuerza;
	}

	public void setPuntosFuerza(int puntosFuerza) {
		this.puntosFuerza = puntosFuerza;
	}
}
