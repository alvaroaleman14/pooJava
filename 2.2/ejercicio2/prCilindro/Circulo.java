package prCilindro;

/**
 * Clase que gestiona la geometria de un ccrculo.
 * @author Fco. Duran, Fco. Gutierrez, E. Pimentel, A. Rossi
 */
public class Circulo{
	
	/**
	 * Radio del circulo.
	 */
	private double radio;
	

	/**
	 * Punto que representa el centro del circulo.
	 */
	private Punto centro;
	
	/**
	 * Creamos un circulo de radio 0 en el origen de
	 * coordenadas
	 *
	 */
	public Circulo(){
		radio = 0.0;
		centro = new Punto();
	}
	
	/**
	 * Creamos un circulo indicando su centro (Punto) y su
	 * radio
	 * @param p Centro del circulo.
	 * @param r Radio del circulo.
	 */
	public Circulo(Punto p, double r){
		radio = r;
		centro = p;
	}
	
	/**
	 * Obtenemos el centro del circulo (Punto).
	 * @return Punto central del circulo.
	 */
	public Punto centro(){
		return centro;
	}
	
	/**
	 * Obtenemos el radio del circulo.
	 * @return Radio del circulo.
	 */
	public double radio(){
		return radio;
	}
	
	/**
	 * Cambiamos el centro del circulo.
	 * @param p Nuevo punto que sustituir al centro del 
	 * circulo.
	 */
	public void centro(Punto p){
		centro = p;
	}
	
	/**
	 * Cambiamos el radio del circulo.
	 * @param r Nuevo radio del circulo.
	 */
	public void radio(double r){
		radio = r;
	}
	
	/**
	 * Trasladamos el circulo a una nueva posicion.
	 * @param a Desplazamiento de la coordenada X.
	 * @param b Desplazamiento de la coordenada Y.
	 */
	public void trasladar(double a, double b){
		this.centro().trasladar(a,b);
	}
	
	/**
	 * Representamos el circulo mediante un String.
	 */
	public String toString(){
		return ("Circulo(" + centro + ", " + radio + ")");
	}
}