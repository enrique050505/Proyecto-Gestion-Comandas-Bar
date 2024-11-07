package Controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Modelo.Empleado;
import Vista.InterfazApp;

public class ControladorCafeteria implements ActionListener, MouseListener{
	
	InterfazApp vista = new InterfazApp();
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	Timer fechaYHora;
	Empleado empleadoActual;
	
	public ControladorCafeteria(InterfazApp vista) {
		this.vista = vista;
		this.vista.btnInicioSesion.addActionListener(this);
		this.vista.btn_GuardarCambios.addActionListener(this);
		this.vista.lbl_Detalles.addMouseListener(this);
		this.vista.lbl_CerrarSesion.addMouseListener(this);
		this.vista.lbl_Salir.addMouseListener(this);
		this.vista.lbl_SalirComandas.addMouseListener(this);
		this.vista.lbl_Mesa1.addMouseListener(this);
		this.vista.lbl_Mesa2.addMouseListener(this);
		this.vista.lbl_Mesa3.addMouseListener(this);
		this.vista.lbl_Mesa4.addMouseListener(this);
		this.vista.lbl_Mesa5.addMouseListener(this);
		this.vista.lbl_Taburete1.addMouseListener(this);
		this.vista.lbl_Taburete2.addMouseListener(this);
		this.vista.lbl_Taburete3.addMouseListener(this);
		rellenarListaEmpleados(empleados);
		
		fechaYHora = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.actualizarFechaYHora();
			}
			
		});
		fechaYHora.start();
		
	}//FIN CONSTRUCTOR CONTROLADOR

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vista.btnInicioSesion) {
			autenticarEmpleado(empleados);
			iniciarAppPrincipal();
		}
		
		if(e.getSource()==vista.btn_GuardarCambios) {
			guardarCambiosEmpleado();
		}

	}	
	
	public void autenticarEmpleado(ArrayList<Empleado> empleados) {
		boolean usuarioCorrecto = false;
		
		if(!vista.textFieldUsuario.getText().isEmpty() && !vista.passwordField_Contraseña.getText().isEmpty()) {
			for(Empleado empleado:empleados) {
				if(empleado.getNombre().equals(vista.textFieldUsuario.getText()) && empleado.getContraseña().equals(vista.passwordField_Contraseña.getText())) {
					empleadoActual=empleado;
					usuarioCorrecto=true;
					mostrarEmpleadoPantallaPrincipal(empleado);
				}
			}
			if(usuarioCorrecto) {
				vista.panel_InicioSesion.setVisible(false);
				vista.panel_PantallaPrincipal.setVisible(true);
			}else {
				vista.lblEmpleadoIncorrecto.setVisible(true);
				vista.lblEmpleadoIncorrecto.setText("USUARIO NO PERMITIDO");
			}
		}else if(vista.textFieldUsuario.getText().isEmpty() && !vista.passwordField_Contraseña.getText().isEmpty()) {
			vista.lblEmpleadoIncorrecto.setVisible(true);
			vista.lblEmpleadoIncorrecto.setText("INTRODUZCA SU NOMBRE DE USUARIO");
		}else if(vista.passwordField_Contraseña.getText().isEmpty() && !vista.textFieldUsuario.getText().isEmpty()) {
			vista.lblEmpleadoIncorrecto.setVisible(true);
			vista.lblEmpleadoIncorrecto.setText("INTRODUZCA SU CONTRASEÑA");
		}else if (vista.textFieldUsuario.getText().isEmpty() && vista.passwordField_Contraseña.getText().isEmpty()) {
			vista.lblEmpleadoIncorrecto.setVisible(true);
			vista.lblEmpleadoIncorrecto.setText("NO HAS INTRODUCIDO NADA");
		}
	}
	
	public void iniciarAppPrincipal() {
		vista.lbl_CerrarSesion.setIcon(ajustarTamañoImg("src/img/CerrarSesion.png", vista.lbl_CerrarSesion.getWidth(), vista.lbl_CerrarSesion.getHeight()));
		vista.lbl_ImgPrincipalApp.setIcon(ajustarTamañoImg("src/img/fondoPrincipalApp.png", vista.lbl_ImgPrincipalApp.getWidth(), vista.lbl_ImgPrincipalApp.getHeight()));
		vista.lbl_Mesa1.setIcon(ajustarTamañoImg("src/img/mesa.png", vista.lbl_Mesa1.getWidth(), vista.lbl_Mesa1.getHeight()));
		vista.lbl_Mesa2.setIcon(ajustarTamañoImg("src/img/mesa.png", vista.lbl_Mesa2.getWidth(), vista.lbl_Mesa2.getHeight()));
		vista.lbl_Mesa3.setIcon(ajustarTamañoImg("src/img/mesa.png", vista.lbl_Mesa3.getWidth(), vista.lbl_Mesa3.getHeight()));
		vista.lbl_Mesa4.setIcon(ajustarTamañoImg("src/img/mesa.png", vista.lbl_Mesa4.getWidth(), vista.lbl_Mesa4.getHeight()));
		vista.lbl_Mesa5.setIcon(ajustarTamañoImg("src/img/mesa.png", vista.lbl_Mesa5.getWidth(), vista.lbl_Mesa5.getHeight()));
		vista.lbl_Taburete1.setIcon(ajustarTamañoImg("src/img/taburete.png", vista.lbl_Taburete1.getWidth(), vista.lbl_Taburete1.getHeight()));
		vista.lbl_Taburete2.setIcon(ajustarTamañoImg("src/img/taburete.png", vista.lbl_Taburete2.getWidth(), vista.lbl_Taburete2.getHeight()));
		vista.lbl_Taburete3.setIcon(ajustarTamañoImg("src/img/taburete.png", vista.lbl_Taburete3.getWidth(), vista.lbl_Taburete3.getHeight()));
		vista.lbl_Barra.setIcon(ajustarTamañoImg("src/img/barra.png", vista.lbl_Barra.getWidth(), vista.lbl_Barra.getHeight()));
		vista.lbl_Detalles.setIcon(ajustarTamañoImg("src/img/detalles.png", vista.lbl_Detalles.getWidth(), vista.lbl_Detalles.getHeight()));
	}
	
	private void mostrarEmpleadoPantallaPrincipal(Empleado empleado) {
		vista.lbl_ImgEmpleado.setIcon(ajustarTamañoImg(empleado.getImagenEmpleado().getDescription(), vista.lbl_ImgEmpleado.getWidth(), vista.lbl_ImgEmpleado.getHeight()));
		vista.lbl_NombreEmpleado.setText(empleado.getNombre());
	}
	
	private ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
	}//FIN AJUSTAR TAMAÑO IMG
	
	private void rellenarListaEmpleados(ArrayList<Empleado> empleados) {
		empleados.add(new Empleado(new ImageIcon("src/img/usuario1.png"), "Mario", "01234567", "C/Las Rozas, 20", "686869342" , "García Lorca", "08/09/2022"));
		empleados.add(new Empleado(new ImageIcon("src/img/usuario2.png"), "Adrian", "12345678", "C/Triana, 64", "656678984", "Jiménez Muñoz", "03/10/2023"));
		empleados.add(new Empleado(new ImageIcon("src/img/usuario4.png"), "Nuria", "12121212", "C/Mayor, 23", "643687948", "López Fernández", "23/05/2023"));
		empleados.add(new Empleado(new ImageIcon("src/img/usuario3.png"), "Andrea", "23456789", "C/Ancha, 56", "623123374", "Torres Martín", "06/02/2024"));
	}//FIN RELLENAR LISTA EMPLEADOS
	
	private void iniciarAppDetallesEmpleado() {
		vista.lbl_ImgDetallesEmpleado.setIcon(ajustarTamañoImg("src/img/fondoDetallesEmpleado.png", vista.lbl_ImgDetallesEmpleado.getWidth(), vista.lbl_ImgDetallesEmpleado.getHeight()));
		vista.lbl_Salir.setIcon(ajustarTamañoImg("src/img/volverAtras.png", vista.lbl_Salir.getWidth(), vista.lbl_Salir.getHeight()));
	}
	
	private void mostrarDetallesEmpleado() {
		vista.lbl_FotoEmpleado.setIcon(ajustarTamañoImg(empleadoActual.getImagenEmpleado().getDescription(), vista.lbl_FotoEmpleado.getWidth(), vista.lbl_FotoEmpleado.getHeight()));
		vista.lbl_InformacionNombre.setText(empleadoActual.getNombre());
		vista.lbl_InformacionApellidos.setText(empleadoActual.getApellidos());
		vista.lbl_InformacionFechaIngreso.setText(empleadoActual.getFechaIngreso());
		vista.textField_Direccion.setText(empleadoActual.getDireccion());
		vista.textField_Contraseña.setText(empleadoActual.getContraseña());
		vista.textField_Telefono.setText(empleadoActual.getTelefono());
	}
	
	private void guardarCambiosEmpleado() {
		if(!vista.textField_Direccion.getText().equals(empleadoActual.getDireccion()) || !vista.textField_Contraseña.getText().equals(empleadoActual.getContraseña()) || !vista.textField_Telefono.getText().equals(empleadoActual.getTelefono())) {
			
			if(vista.textField_Contraseña.getText().length()<8) {
				vista.textArea_MensajeInformacion.setText("La contraseña es demasiado corta".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(255,0,0));
				vista.textArea_MensajeInformacion.setVisible(true);
				vista.textField_Contraseña.setText("");
			}else if(vista.textField_Telefono.getText().length()<9){
				vista.textArea_MensajeInformacion.setText("El teléfono es incorrecto. Intentalo otra vez".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(255,0,0));
				vista.textArea_MensajeInformacion.setVisible(true);
				vista.textField_Telefono.setText("");
			}else if(vista.textField_Telefono.getText().length()>9 && vista.textField_Telefono.getText().contains("abcdefghijklmnopqrstuvwxyz+-*/")) {
				vista.textArea_MensajeInformacion.setText("El teléfono es incorrecto. Intentalo otra vez".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(255,0,0));
				vista.textArea_MensajeInformacion.setVisible(true);
				vista.textField_Telefono.setText("");
			}else if(vista.textField_Telefono.getText().length()==9 && vista.textField_Telefono.getText().contains("abcdefghijklmnopqrstuvwxyz+-*/")) {
				vista.textArea_MensajeInformacion.setText("El teléfono es incorrecto. Intentalo otra vez".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(255,0,0));
				vista.textArea_MensajeInformacion.setVisible(true);
				vista.textField_Telefono.setText("");
			}else if(vista.textField_Telefono.getText().length()==9 && !vista.textField_Telefono.getText().contains("abcdefghijklmnopqrstuvwxyz+-*/")){
				empleadoActual.setContraseña(vista.textField_Contraseña.getText());
				empleadoActual.setTelefono(vista.textField_Telefono.getText());
				empleadoActual.setDireccion(vista.textField_Direccion.getText());
				
				vista.textArea_MensajeInformacion.setText("Los cambios se han realizado correctamente".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(0, 136, 0));
				vista.textArea_MensajeInformacion.setVisible(true);
			}
		
		}//FIN IF PRINCIPAL
		
	}
	
	private void iniciarGestionComandas() {
		vista.lbl_SalirComandas.setIcon(ajustarTamañoImg("src/img/volverAtras.png", vista.lbl_SalirComandas.getWidth(), vista.lbl_SalirComandas.getHeight()));
		vista.lbl_InformacionComida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida1.getWidth(), vista.lbl_InformacionComida1.getHeight()));
		vista.lbl_InformacionComida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida2.getWidth(), vista.lbl_InformacionComida2.getHeight()));
		vista.lbl_InformacionComida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida3.getWidth(), vista.lbl_InformacionComida3.getHeight()));
		vista.lbl_InformacionComida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida4.getWidth(), vista.lbl_InformacionComida4.getHeight()));
		vista.lbl_InformacionComida5.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida5.getWidth(), vista.lbl_InformacionComida5.getHeight()));
		vista.lbl_InformacionComida6.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida6.getWidth(), vista.lbl_InformacionComida6.getHeight()));
		vista.lbl_Comida1.setIcon(ajustarTamañoImg("src/img/croissant.jpg", vista.lbl_Comida1.getWidth(), vista.lbl_Comida1.getHeight()));
		vista.lbl_Comida2.setIcon(ajustarTamañoImg("src/img/napolitana.jpg", vista.lbl_Comida2.getWidth(), vista.lbl_Comida2.getHeight()));
		vista.lbl_Comida3.setIcon(ajustarTamañoImg("src/img/brazo de gitano.png", vista.lbl_Comida3.getWidth(), vista.lbl_Comida3.getHeight()));
		vista.lbl_Comida4.setIcon(ajustarTamañoImg("src/img/milhojas de crema.jpg", vista.lbl_Comida4.getWidth(), vista.lbl_Comida4.getHeight()));
		vista.lbl_Comida5.setIcon(ajustarTamañoImg("src/img/tarta de queso.jpg", vista.lbl_Comida5.getWidth(), vista.lbl_Comida5.getHeight()));
		vista.lbl_Comida6.setIcon(ajustarTamañoImg("src/img/bizcocho.jpg", vista.lbl_Comida6.getWidth(), vista.lbl_Comida6.getHeight()));
		rellenarComboBox();
	}
	
	private void rellenarComboBox() {
		vista.comboBox_Menu.removeAllItems();
		
		vista.comboBox_Menu.addItem("Comida");
		vista.comboBox_Menu.addItem("Bebida");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_CerrarSesion) {
			vista.panel_InicioSesion.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			vista.passwordField_Contraseña.setText("");
			vista.textFieldUsuario.setText("");
			vista.lblEmpleadoIncorrecto.setText("");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Salir) {
			boolean cambiosNoGuardados = !vista.textField_Direccion.getText().equals(empleadoActual.getDireccion()) || !vista.textField_Contraseña.getText().equals(empleadoActual.getContraseña()) || !vista.textField_Telefono.getText().equals(empleadoActual.getTelefono());
			
			if(cambiosNoGuardados) {
				vista.textArea_MensajeInformacion.setText("No has guardado los cambios".toUpperCase());
				vista.textArea_MensajeInformacion.setForeground(new Color(255, 0, 0));
				vista.textArea_MensajeInformacion.setVisible(true);
			}else {
				vista.panel_DetallesEmpleado.setVisible(false);
				vista.panel_PantallaPrincipal.setVisible(true);
				vista.textArea_MensajeInformacion.setVisible(false);
			}
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Detalles) {
			vista.panel_DetallesEmpleado.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarAppDetallesEmpleado();
			mostrarDetallesEmpleado();
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Mesa1) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("MESA 1");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Mesa2) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("MESA 2");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Mesa3) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("MESA 3");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Mesa4) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("MESA 4");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Mesa5) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("MESA 5");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Taburete1) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("TABURETE 1");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Taburete2) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("TABURETE 2");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Taburete3) {
			vista.panel_GestionComandas.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText("TABURETE 3");
		}
		
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_SalirComandas) {
			vista.panel_PantallaPrincipal.setVisible(true);
			vista.panel_GestionComandas.setVisible(false);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}//FIN CLASS
