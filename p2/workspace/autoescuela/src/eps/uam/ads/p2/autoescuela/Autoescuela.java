/**
 * @author lucia asencio
 */
package eps.uam.ads.p2.autoescuela;

/**
 * clase autoescuela
 * @author lucia asencio
 *
 */

public class Autoescuela {
	private int codigo;
	private String direccion;
	private String encargado;
	
	/**
	 * Constructor de Autoescuela
	 * @param codigo
	 * @param direccion
	 * @param encargado
	 */
	
	public Autoescuela(int codigo, String direccion, String encargado){
		this.codigo = codigo;
		this.direccion = direccion;
		this.encargado = encargado;
	}
	
	/**
	 * funcion getter del codigo de autoescuela
	 * @return int codigo de autoescuela
	 */
	public int getCodigo(){
		return this.codigo;
	}
	
	/**
	 * funcion getter de la direccion de autoescuela
	 * @return  string con direccion de autoescuela
	 */
	public String getDireccion(){
		return this.direccion;
	}
	
	/**
	 * funcion getter del encargado de autoescuela
	 * @return string con el encargado de la autoescuela
	 */
	public String getEncargado(){
		return this.encargado;
	}
}
