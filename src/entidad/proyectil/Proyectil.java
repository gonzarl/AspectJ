package entidad.proyectil;

import entidad.Entidad;
import movimiento.Movimiento;
import visitor.Visitor;

public abstract class Proyectil extends Entidad{
	protected int direccion,velocidad,cap_penetracion,tiempo_pausa;
	protected Movimiento movimiento;	
	
	/**
	 * Establece la direccion
	 * @param direccion int
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Establece la velocidad
	 * @param velocidad int
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * Establece
	 * @param cap_penetracion int
	 */
	public void setCapPenetracion(int cap_penetracion) {
		this.cap_penetracion = cap_penetracion;
	}
	
	/**
	 * Establece el movimiento
	 * @param movimiento Movimiento
	 */
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public void setPausa(int tiempo) {
		tiempo_pausa=tiempo;
	}
	
	/**
	 * Consulta la direccion
	 * @return direccion
	 */
	public int getDireccion() {
		return direccion;
	}
	
	/**
	 * Consulta la velocidad
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Consulta la capacidad de penetracion
	 * @return capacidad
	 */
	public int getCapPenetracion() {
		return cap_penetracion;
	}
	
	/**
	 * Consulta el movimiento
	 * @return movimiento
	 */
	public Movimiento getMovimiento() {
		return movimiento;
	}
	
	public int getPausa() {
		return tiempo_pausa;
	}
}
