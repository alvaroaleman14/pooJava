/**
 * Clase que gestiona un banco. Un banco esta compuesto simplemente
 * por un nombre y una coleccion de numero de cuentas
 */
package prBanco;

import java.util.Arrays;

public class Banco{
	
	/**
	 * Numero maximo de cuentas por defecto
	 */
	private final static int TAM_ARRAY_CTAS = 10;
	
	/**
	 * Numero de cuenta inicialo
	 */
	private final static int PRIMER_NUM_CTA = 1001;

	
	/**
	 * Nombre del banco.
	 */
	private String nombre;
	
	/**
	 * Primera posicion libre para insertar una cuenta.
	 */
	private int ppl;
	
	/** 
	 * Siguiente numero de cuenta; 
	 */
	private int snc;

	/**
	 * Cuentas bancarias que hay en el banco.
	 */
	private Cuenta[] ctas;
	
	/**
	 * Creamos un banco a partir de su nombre. Creamos por
	 * defecto tantas cuentas como indica NCTAS.
	 * @param n String con el nombre del banco.
	 */
	public Banco(String n){
		this(n, TAM_ARRAY_CTAS);
	}
	
	/**
	 * Creamos un banco a partir de un nombre y del numero de
	 * cuentas maximo que va a gestionar.
	 * @param n String con el nombre del banco.
	 * @param nctas int con el numero maximo de cuentas inicial.
	 */
	public Banco(String n, int nc){
		nombre = n;
		ctas = new Cuenta[nc];
		snc= PRIMER_NUM_CTA;
		ppl = 0;
		// No hemos usado aun ninguna cuenta.
	}
	
	/**
	 * Creamos una nueva cuenta en el banco a partir del 
	 * titular de la cuenta y  el saldo inicial.
	 * @param titular String con el titular de la cuenta.
	 * @param saldoInicial double con el saldo inicial de la
	 * cuenta.
	 * @return int con el numero de cuenta creada.
	 */
	 
	public int abrirCuenta(String titular, double saldoInicial){
		if (ppl == ctas.length){
			// Si el array ya esta lleno hacemos una
			//  copia de este en uno mas grande y seguimos con
			//  el nuevo a partir de ahora.
			ctas = Arrays.copyOf(ctas, ctas.length*2);
		}		
		// Tanto en un caso como en otro ya podemos insertar
		//  la nueva cuenta.
		ctas[ppl] = new Cuenta(titular, snc, saldoInicial);
		ppl++;
		snc++;
		return snc - 1;
	}

	/**
	 * Creamos una nueva cuenta en el banco a partir del titular
	 * de la cuenta. Suponemos que el saldo inicial sera 0.0
	 * @param titular String con el titular de la cuenta.
	 * @return int con el numero de cuenta creada.
	 */
	public int abrirCuenta(String titular){
		return abrirCuenta(titular, 0.0);
	}
	
	/**
	 * Cerramos la cuenta bancaria indicada. Al cerrar una cuenta
	 * hay que reajustar las cuentas para que estan todas
	 * contiguas.
	 * @param nc int con el numero de cuenta a cerrar.
	 * @return double con el saldo de la cuenta que acabamos de
	 * cerrar.
	 */
	public void cerrarCuenta(int nc){
		int posCuenta = posicionCuenta(nc);
		for (int i = posCuenta; i < ppl - 1; i++) {
			ctas[i] = ctas[i + 1];
		}
		ctas[ppl - 1] = null;
		ppl--;
	}
		
	
	/**
	 * Obtenemos la posicion de la cuenta cuyo numero es el
	 * indicado.
	 * @param nc Numero de cuenta a localizar.
	 * @return int con la posicion de la cuenta. 
	 */
	private int posicionCuenta(int nc){
		int ncb = 0;
		while (ncb < ppl && nc != ctas[ncb].numCuenta()) {
			ncb++;
		}
		if (ncb == ppl) {
			throw new RuntimeException("Cuenta inexistente " + nc);
		}	
		return ncb;
	}
	
	/**
	 * Hacemos un ingreso en la cuenta indicada.
	 * @param nc int con el numero de cuenta donde hacer el
	 * ingreso.
	 * @param cantidad double con la cantidad a ingresar.
	 */
	public void ingreso(int nc, double cantidad){
		int posCuenta = posicionCuenta(nc);
		ctas[posCuenta].ingreso(cantidad);
	}
	
	/**
	 * Hacemos un debito en la cuenta indicada. 
	 * No permite que a cuenta quede en negativo.
	 * @param nc int con el numero de cuenta donde hacer el
	 * débito.
	 * @param cantidad double con la cantidad a quitar.
	 * @return la cantidad realmente extraida
	 */
	public double debito(int nc, double cantidad){
		int posCuenta = posicionCuenta(nc);
		double saldo = ctas[posCuenta].saldo();		
		if (cantidad > saldo) {
			cantidad = saldo;
		}
		ctas[posCuenta].debito(cantidad);
		return cantidad;
	}
	
	/**
	 * Obtenemos el saldo de la cuenta pasada como parametro.
	 * @param nc in con el numero de cuenta.
	 * @return double con el saldo de la cuenta.
	 */
	public double saldo(int nc){
		int posCuenta = posicionCuenta(nc);
		return ctas[posCuenta].saldo();
	}
	
	/**
	 * Hacemos una transferencia desde la cuenta origen hasta
	 * la cuenta destino.
	 * @param origen int con el numero de cuenta origen.
	 * @param destino int con el numero de cuenta destino.
	 * @param cantidad double con la cantidad a transferir.
	 * @return cantidad realmente transferida
	 */
	public double transferencia(int origen, int destino, 
			double cantidad){
		double cantReal = debito(origen, cantidad);
		ingreso(destino, cantReal);
		return cantReal;
	}
	
	 
	/**
	 * Representamos el banco mediante un String;
	 */
	public String toString(){
		String res = nombre +": [";
		for (int i = 0; i < ppl; i++){
			res = res + ctas[i] + " ";
		}
		return res + "]";		
	}

}
