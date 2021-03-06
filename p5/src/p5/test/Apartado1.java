package p5.test;
import p5.*;
import p5.exc.*;

/**
 * Esta clase hace un test del funcionamiento de la clase MyAdjustableTime
 * Al implementar Observer y AdjustableTime, y extender de la implementada DefaultPropertyObersver,
 * testeando esta clase comprobamos el funcionamiento de todas las clases implementadas
 * @author lucia
 *
 */
public class Apartado1 {
	public static void main(String[] args){
		MyAdjustableTime v1 = new MyAdjustableTime(5);
		System.out.println("Value 1: " + v1);
		try{
			MyAdjustableTime v2 = new MyAdjustableTime(-5);
		}catch(p5.exc.IllegalArgumentException e){
			System.out.println("Exception caught: No se creo un MyAdjustableTime v2 con value < 0");
		}
		MyAdjustableTime v2 = new MyAdjustableTime(4);
		MyAdjustableTime v3 = new MyAdjustableTime(3);
		System.out.println("Value 2: " + v2 + " Value 3: " + v3 + "\n");
		System.out.println("Probamos getValue. v1: " + v1.getValue() + ". v2: " + v2.getValue() + ". v3: " + v3.getValue() + "\n");
		
		v1.addObserver(v2);
		System.out.println("Aniadimos v2 como observador de v1; v2: " + v2.getValue());
		v2.addObserver(v3);
		System.out.println("Aniadimos v3 como observador de v2; v3: " + v3.getValue());
		
		MyAdjustableTime v4 = new MyAdjustableTime(6);
		System.out.print("Creamos v4: " + v4.getValue());
		v4.addObserver(v2);
		System.out.println( " y aniadimos a v2 como observer; v2: " + v2.getValue());
		v1.removeObserver(v2);
		System.out.println("Quitamos v2 de observer de v1; v2: " + v2.getValue() + "\n");
		
		
		System.out.println("PropertyChanged e incrementTime son probadas con los add/removeObserver");
		System.out.println("Probamos incrementTime para comprobar que pasa si value <  0");
		try{
			v1.incrementTime(-6);
		}catch(p5.exc.IllegalArgumentException e){
			System.out.println("Exception caught: no fue posible decrementar 6 a v1, que tenia valor " + v1.getValue());
		}
	}
}
