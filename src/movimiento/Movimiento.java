package movimiento;


import entidad.Entidad;

public abstract class Movimiento {
	protected int direccion;
	protected int velocidad;
	protected Entidad entidad;
	
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
	 * Establece la entidad
	 * @param entidad Entidad
	 */
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
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
	 * Consulta la entidad
	 * @return entidad
	 */
	public Entidad getEntidad() {
		return entidad;
	}
	
	/**
	 * Metodo para mover
	 */
	public abstract void mover();
	
	public void moverArriba() {};
}
