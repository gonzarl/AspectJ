import entidad.enemigo.*;
import juego.*;

public aspect Control {
	
	after(): 
		call(* *. .crearPremio(Juego, Enemigo)) {
			System.out.println("Se creo una mejora.");
	}
	
	after(): 
		call(* *. .mejorarHechizos()) {
			System.out.println("Se obtuvo una mejora de disparos.");
	}
	
	after(): 
		call(* *. .pausar()) {
			System.out.println("Se obtuvo una mejora de pausa.");
	}
	
	after(): 
		call(* *. .enemigoAbatido()) {
			System.out.println("Se acabo con un enemigo.");
	}
	
	after(): 
		call(* *. .crearHorda(int, int)) {
			System.out.println("Se creo una nueva horda de enemigos.");
	}
	

}
