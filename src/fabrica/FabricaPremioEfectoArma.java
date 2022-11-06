package fabrica;


import entidad.enemigo.Enemigo;
import entidad.premio.EfectoArma;
import entidad.premio.Premio;
import juego.Juego;

public class FabricaPremioEfectoArma implements FabricaPremio{

	@Override
	public Premio crearPremio(Juego j, Enemigo e) {
		return new EfectoArma(500,0,j, e);
	}

}
