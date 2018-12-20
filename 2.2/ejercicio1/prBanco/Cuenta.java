

/**
 * Clase que gestiona una cuenta bancaria. Esta viene dada por su
 * titular, su nnmero y el saldo disponible.
 * @author Antonio J. Rossi
 */
package prBanco;

public class Cuenta{
	
	/**
	 * Titular de la cuenta
	 */
	private String titular;
	
	/**
	 * Numero de cuenta.
	 */
	private int numCuenta;
	
	/**
	 * Saldo de la cuenta.
	 */
	private double saldo;
		
	/**
	 * Construimos una cuenta bancaria a partir del titular,
	 * del numero de cuenta y del saldo inicial.
	 * @param t String con el titular de la cuenta.
	 * @param n int con el numero de cuenta.
	 * @param s int con el saldo inicial de la cuenta.
	 */
	public Cuenta(String t, int n, double s){
		titular = t;
		numCuenta = n;
		saldo = s;
	}
	
	
	/**
	 * Construimos una cuenta bancaria a partir del titular y del
	 * numero de cuenta. El saldo inicial es 0.0.
	 * @param t String con el titular de la cuenta.
	 * @param n int con el número de cuenta.
	 */
	public Cuenta(String t, int n){
		this(t, n, 0);
	}
	
	/**
	 * Hacemos un ingreso en la cuenta por la cantidad indicada.
	 * @param cantidad double con la cantidad a ingresar en la 
	 * cuenta.
	 * 
	 * La cantidad no puede ser menor que 0. Si es menor que 0 se lanza una excepcion	  
	 */
	public void ingreso(double cantidad){
		saldo = saldo + cantidad;
	}
	
	/**
	 * Hacemos un débito en la cuenta por la cantidad indicada.
	 * @param cantidad double con la cantidad a quitar de la
	 * cuenta.
	 * 
	 */
	public void debito(double cantidad){
		saldo = saldo - cantidad;
	}
	
	/**
	 * Obtenemos el titular de la cuenta
	 * @return String con el titular de la cuenta.
	 */
	public String titular(){
		return titular;
	}
	
	/**
	 * Obtenemos el numero de cuenta.
	 * @return int con el numero de cuenta.
	 */
	public int numCuenta(){
		return numCuenta;
	}
	
	/**
	 * Obtenemos el saldo actual de la cuenta.
	 * @return double con el saldo actual de la cuenta.
	 */
	public double saldo(){
		return saldo;
	}
	
	/**
	 * Representamos la cuenta bancaria mediante un String.
	 */
	public String toString(){
		return ("[(" + titular + "/" + numCuenta + ")" +  
				" -> " + saldo + "]");
	}
	

}