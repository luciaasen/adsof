/**
 * @author lucia asencio
 */
package eps.uam.ads.p2.autoescuela.persona;

/**
 * clase persona
 * @author lucia asencio
 *
 */
public abstract class Persona {
	 private int mDni;
	 private String mNombre;
	 private String mApellidos;
	 private int mTelefono;
	 
	 /**
	  * 
	  * @param dni
	  * @param nombre
	  * @param apellidos
	  * @param telefono
	  */
	 public Persona(int dni, String nombre, String apellidos, int telefono) {
	        mDni = dni;
	        mNombre = nombre;
	        mApellidos = apellidos;
	        mTelefono = telefono;
	       
	  }
	
	  /**
	   * funcion getter del dni de persona
	   * @return int dni de persona
	   */
	  public int getDni(){
	        return mDni;
	  }
	  
	  /**
	   * funcion getter del telefono de persona
	   * @return int telefono de persona
	   */
	  public int getTelefono(){
	        return mTelefono;
	  }
	  
	  /**
	   * funciom setter del telefono de una persona
	   * @param telefono
	   */
	  public void setTelefono(int telefono){
	        this.mTelefono = telefono;
	  }
	    
	  /**
	   * funcion getter de nombre y apellidos de una persona
	   * @return string con nombre y apellidos
	   */
	  public String getNombreYApellidos() {
	       String nombreYApellido = mNombre + " " + mApellidos;
	       return nombreYApellido;
	  }
	  
	  /**
	   * funcion toString para la clase persona
	   */
	  public String toString(){
	        String s = "<mDni: " + getDni() + "> \n" +
	                "	Nombre y mApellidos: " + getNombreYApellidos() + "\n"+
	                "	Telefono: " + getTelefono() + "\n";

	        return s;
	  }
	    
	 
}
