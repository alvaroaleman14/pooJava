package prCilindro;
/**
 * Clase que gestiona la geometr�a de un cilindro
 * @author Fco. Duran, Fco. Gutierrez, E. Pimentel, A. Rossi
 */
public class Cilindro{
	
	/**
	 * Circulo que forma la base del cilindro.
	 */
	private Circulo base;
	
	/**
	 * Altura del cilindro.
	 */
	private double altura;
	
	/**
	 * Creamos un cilindro de altura y base por defecto.
	 */
	public Cilindro(){
		base = new Circulo();
		altura = 0.0;
	}
	
	/**
	 * Creamos un cilindro indicando el circulo de su base
	 * y la altura que tiene.
	 * @param b Circulo que ser� la base.
	 * @param a Altura del cilindro.
	 */
	public Cilindro(Circulo b, double a){
		base = b;
		altura = a;
	}
	
	/**
	 * Obtenemos la base del cilindro.
	 * @return Base del cilindro.
	 */
	public Circulo base(){
		return base;
	}
	
	/**
	 * Obtenemos la altura del cilindro.
	 * @return Altura del cilindro.
	 */
	public double altura(){
		return altura;
	}
	
	/**
	 * Cambiamos la base (c�rculo) del cilindro.
	 * @param b Circulo que ser� la nueva base del cilindro.
	 */
	public void base(Circulo b){
		base = b;
	}
	
	/**
	 * Cambiamos la altura del cilindro.
	 * @param a Nueva altura del cilindro.
	 */
	public void altura(double a){
		altura = a;
	}
	
	/**
	 * Trasladamos el cilindro a una nueva posici�n dando
	 * sus coordenadas.
	 * @param a Desplazamiento de la coordenada X.
	 * @param b Desplazamiento de la coordenada Y.
	 */
	public void trasladar(double a, double b){
		this.base().trasladar(a,b);
	}
	
	/**
	 * Representamos el cilindro mediante un String.
	 */
	public String toString(){
		return ("Cilindro(" + this.base() + ", " + altura+")");
	}
}