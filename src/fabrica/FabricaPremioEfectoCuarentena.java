package fabrica;

import entidad.enemigo.Enemigo;
import entidad.premio.EfectoCuarentena;
import entidad.premio.Premio;
import juego.Juego;

public class FabricaPremioEfectoCuarentena implements FabricaPremio{

	@Override
	public Premio crearPremio(Juego j,Enemigo e) {
		return new EfectoCuarentena(500,0,j, e);
	}

}
