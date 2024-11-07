package Modelo;


import javax.swing.ImageIcon;

public class Empleado {
	
	private ImageIcon imagenEmpleado;
	private String nombre, contraseña, direccion, telefono, apellidos, fechaIngreso;
	
	public Empleado(ImageIcon imagenEmpleado, String nombre, String contraseña, String direccion, String telefono, String apellidos, String fechaIngreso) {
		this.imagenEmpleado = imagenEmpleado;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.telefono = telefono;
		this.apellidos = apellidos;
		this.fechaIngreso = fechaIngreso;
	}

	public ImageIcon getImagenEmpleado() {
		return imagenEmpleado;
	}

	public void setImagenEmpleado(ImageIcon imagenEmpleado) {
		this.imagenEmpleado = imagenEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Empleado [imagenEmpleado=" + imagenEmpleado + ", nombre=" + nombre + ", contraseña=" + contraseña
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", apellidos=" + apellidos + ", fechaIngreso="
				+ fechaIngreso + "]";
	}

}
