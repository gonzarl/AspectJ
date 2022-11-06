package entidad.premio;

import entidad.Entidad;
public abstract class Premio extends Entidad{
	protected int tiempo_pausa;
	public abstract void activar(); 
	
	
	public void setPausa(int tiempo) {
		tiempo_pausa=tiempo;
	}
	
	public int getPausa() {
		return tiempo_pausa;
	}
}
