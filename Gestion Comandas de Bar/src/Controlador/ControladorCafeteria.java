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

import Modelo.Bebida;
import Modelo.Empleado;
import Vista.InterfazApp;

public class ControladorCafeteria implements ActionListener, MouseListener{
	
	InterfazApp vista = new InterfazApp();
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	ArrayList<Bebida> cafes = new ArrayList<Bebida>();
	ArrayList<Bebida> refrescos = new ArrayList<Bebida>();
	ArrayList<Bebida> batidos = new ArrayList<Bebida>();
	ArrayList<Bebida> bebidasCalientesOFrias = new ArrayList<Bebida>();
	Timer fechaYHora;
	Empleado empleadoActual;
	
	public ControladorCafeteria(InterfazApp vista) {
		this.vista = vista;
		this.vista.btnInicioSesion.addActionListener(this);
		this.vista.btn_GuardarCambios.addActionListener(this);
		this.vista.comboBox_Menu.addActionListener(this);
		this.vista.comboBox_TipoCafe.addActionListener(this);
		this.vista.comboBox_TipoBatido.addActionListener(this);
		this.vista.comboBox_TipoRefresco.addActionListener(this);
		this.vista.comboBox_TipoBebidaCalienteoFria.addActionListener(this);
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
		this.vista.lbl_InformacionComida1.addMouseListener(this);
		
		rellenarListaEmpleados(empleados);
		
		rellenarCafes(cafes);
		rellenarRefrescos(refrescos);
		rellenarBatidos(batidos);
		rellenarBebidasCalientesOFrias(bebidasCalientesOFrias);
		
		rellenarComboBoxBebidas(cafes, refrescos, batidos, bebidasCalientesOFrias);
		
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
		
		if(e.getSource()==vista.comboBox_Menu) {
			if(vista.comboBox_Menu.getSelectedItem().equals("Comidas")) {
				vista.panel_Comidas.setVisible(true);
				vista.panel_Bebidas.setVisible(false);
			}else if(vista.comboBox_Menu.getSelectedItem().equals("Bebidas")) {
				vista.panel_Comidas.setVisible(false);
				vista.panel_Bebidas.setVisible(true);
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoCafe) {
			mostrarInformacionCafeSeleccionado();
		}
		
		if(e.getSource()==vista.comboBox_TipoBatido) {
			mostrarInformacionBatidoSeleccionado();
		}
		
		if(e.getSource()==vista.comboBox_TipoRefresco) {
			mostrarInformacionRefrescoSeleccionado();
		}
		
		if(e.getSource()==vista.comboBox_TipoBebidaCalienteoFria) {
			mostrarInformacionBebidaCalienteOFriaSeleccionada();
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
		boolean cambiosGuardados=false;
		
		//VALIDACION CONTRASEÑA
		if(!vista.textField_Contraseña.getText().equals(empleadoActual.getContraseña())) {
			if(vista.textField_Contraseña.getText().length()<8) {
				vista.textArea_MensajeInformacionCambiosRealizados.setText("La contraseña es incorrecta. Introduzca otra".toUpperCase());
				vista.textArea_MensajeInformacionCambiosRealizados.setForeground(new Color (255, 0, 0));
				vista.textArea_MensajeInformacionCambiosRealizados.setVisible(true);
				vista.textField_Contraseña.setText("");
			}else {
				empleadoActual.setContraseña(vista.textField_Contraseña.getText());
				cambiosGuardados=true;
			}
		}//FIN IF CONTRASEÑA
		
		//VALIDAR TELEFONO
		String telefono = vista.textField_Telefono.getText();
		
		if(!esTelefonoValido(telefono)) {
			vista.textArea_MensajeInformacionCambiosRealizados.setText("El teléfono debe tener 9 dígitos sin espacios ni caracteres especiales".toUpperCase());
			vista.textArea_MensajeInformacionCambiosRealizados.setForeground(new Color (255, 0, 0));
			vista.textArea_MensajeInformacionCambiosRealizados.setVisible(true);
			vista.textField_Telefono.setText("");
		}else {
			if(!vista.textField_Telefono.getText().equals(empleadoActual.getTelefono())) {
				empleadoActual.setTelefono(vista.textField_Telefono.getText());
				cambiosGuardados=true;
			}
		}
		
		//GUARDAR DIRECCION
		if(!vista.textField_Direccion.getText().equals(empleadoActual.getDireccion())) {
			empleadoActual.setDireccion(vista.textField_Direccion.getText());
			cambiosGuardados=true;
		}
		
		if(cambiosGuardados) {
			vista.textArea_MensajeInformacionCambiosRealizados.setText("Se han guardado los cambios correctamente".toUpperCase());
			vista.textArea_MensajeInformacionCambiosRealizados.setForeground(new Color (0,136,0));
			vista.textArea_MensajeInformacionCambiosRealizados.setVisible(true);
		}
		
	}//FIN GUARDAR CAMBIOS
	
	private boolean esTelefonoValido(String telefono) {
		if(telefono.length() != 9) {
			return false;
		}
		for(int i=0; i<telefono.length(); i++) {
			char c= telefono.charAt(i);
			if(c < '0' || c>'9') {
				return false;
			}
		}
		return true;
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
		
		vista.panel_Comidas.setVisible(true);
		vista.panel_Bebidas.setVisible(false);
		
		rellenarComboBoxMenu();
	}
	
	private void rellenarComboBoxMenu() {
		if(!comprobarItemEnComboBoxMenu("Comidas")) {
			vista.comboBox_Menu.addItem("Comidas");
		}
		if(!comprobarItemEnComboBoxMenu("Bebidas")) {
			vista.comboBox_Menu.addItem("Bebidas");
		}
		vista.comboBox_Menu.setSelectedItem("Comidas");
	}
	
	private boolean comprobarItemEnComboBoxMenu(String item) {
		for(int i=0; i<vista.comboBox_Menu.getItemCount(); i++) {
			if(vista.comboBox_Menu.getItemAt(i).equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	private void rellenarCafes(ArrayList<Bebida> cafes) {
		cafes.add(new Bebida(new ImageIcon("src/img/cafe.png"), 0.00, "Cafés"));
		cafes.add(new Bebida(new ImageIcon("src/img/cafe con leche.png"), 1.30, "Café con leche"));
		cafes.add(new Bebida(new ImageIcon("src/img/capuccino.png"), 1.80, "Capuccino"));
		cafes.add(new Bebida(new ImageIcon("src/img/cafe americano.png"), 1.40, "Café Americano"));
		cafes.add(new Bebida(new ImageIcon("src/img/cafe bombon.png"), 1.90, "Café Bombón"));
		cafes.add(new Bebida(new ImageIcon("src/img/cafe cortado.png"), 1.25, "Café Cortado"));
	}
	
	private void rellenarRefrescos(ArrayList<Bebida> refrescos) {
		refrescos.add(new Bebida(new ImageIcon("src/img/refresco.png"), 0.00, "Refrescos"));
		refrescos.add(new Bebida(new ImageIcon("src/img/agua.png"), 1.00, "Agua"));
		refrescos.add(new Bebida(new ImageIcon("src/img/aquarius.png"), 1.75, "Aquarius Limón"));
		refrescos.add(new Bebida(new ImageIcon("src/img/fanta de naranja.png"), 1.75, "Fanta Naranja"));
		refrescos.add(new Bebida(new ImageIcon("src/img/nestea.png"), 1.60, "Nestea"));
		refrescos.add(new Bebida(new ImageIcon("src/img/coca cola.png"), 1.90, "Coca-Cola"));
	}
	
	private void rellenarBatidos(ArrayList<Bebida> batidos) {
		batidos.add(new Bebida(new ImageIcon("src/img/batido.png"), 0.00, "Batidos"));
		batidos.add(new Bebida(new ImageIcon("src/img/batido de chocolate.png"), 3.00, "Batido Chocolate"));
		batidos.add(new Bebida(new ImageIcon("src/img/batido de fresa.png"), 3.00, "Batido Fresa"));
		batidos.add(new Bebida(new ImageIcon("src/img/batido de chocolate.png"), 3.50, "Batido Oreo"));
		batidos.add(new Bebida(new ImageIcon("src/img/batido de vainilla.png"), 3.00, "Batido Vainilla"));
		batidos.add(new Bebida(new ImageIcon("src/img/batido de mango.png"), 3.25, "Batido Mango"));
	}
	
	private void rellenarBebidasCalientesOFrias(ArrayList<Bebida> bebidasCalientesOFrias) {
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/bebida caliente.png"), 0.00, "Bebidas Mixtas"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/chocolate caliente.png"), 3.00, "Chocolate caliente"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/te de menta.png"), 1.60, "Té de menta"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/te de frutos rojos.png"), 2.20, "Té de frutos rojos"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/horchata.png"), 2.00, "Horchata"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/limonada.png"), 2.10, "Limonada"));
		bebidasCalientesOFrias.add(new Bebida(new ImageIcon("src/img/infusion de canela y manzana.png"), 2.75, "Infusión"));
	}
	
	private void rellenarComboBoxBebidas(ArrayList<Bebida> cafes, ArrayList<Bebida> refrescos, ArrayList<Bebida> batidos, ArrayList<Bebida> bebidasCalientesOFrias) {
		//COMBOBOX CAFES
		for(int i=0; i<cafes.size(); i++) {
			this.vista.comboBox_TipoCafe.addItem(cafes.get(i).getNombre());
		}
		
		//COMBOBOX BATIDOS
		for(int i=0; i<batidos.size(); i++) {
			this.vista.comboBox_TipoBatido.addItem(batidos.get(i).getNombre());
		}
		
		//COMBOBOX REFRESCOS
		for(int i=0; i<refrescos.size(); i++) {
			this.vista.comboBox_TipoRefresco.addItem(refrescos.get(i).getNombre());
		}
		
		//COMBOBOX BEBIDAS CALIENTES O FRIAS
		for(int i=0; i<bebidasCalientesOFrias.size(); i++) {
			this.vista.comboBox_TipoBebidaCalienteoFria.addItem(bebidasCalientesOFrias.get(i).getNombre());
		}
	}
	
	private void mostrarInformacionCafeSeleccionado() {
		String tipoCafe = (String) vista.comboBox_TipoCafe.getSelectedItem();
		
		switch(tipoCafe) {
			case "Café con leche":
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(1).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(1).getPrecio()));
				vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
				vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
				break;
			case "Capuccino":
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(2).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(2).getPrecio()));
				vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
				vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
				break;
			case "Café Americano":
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(3).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(3).getPrecio()));
				vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
				vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
				break;
			case "Café Bombón":
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(4).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(4).getPrecio()));
				vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
				vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
				break;
			case "Café Cortado":
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(5).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(5).getPrecio()));
				vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
				vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
				break;
			default:
				vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(0).getImagenBebida().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
				vista.lbl_PrecioCafe.setText("");
				vista.lbl_IconoEuro1.setIcon(null);
				vista.lbl_InformacionBebida1.setIcon(null);
				break;
		}
	}//MOSTRAR INFORMACION CAFE SELECCIONADO
	
	private void mostrarInformacionBatidoSeleccionado() {
		String tipoBatido = (String) vista.comboBox_TipoBatido.getSelectedItem();
		
		switch(tipoBatido) {
			case "Batido Chocolate":
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(1).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(1).getPrecio()));
				vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
				vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
				break;
			case "Batido Fresa":
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(2).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(2).getPrecio()));
				vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
				vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
				break;
			case "Batido Oreo":
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(3).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(3).getPrecio()));
				vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
				vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
				break;
			case "Batido Vainilla":
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(4).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(4).getPrecio()));
				vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
				vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
				break;
			case "Batido Mango":
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(5).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(5).getPrecio()));
				vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
				vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
				break;
			default:
				vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(0).getImagenBebida().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
				vista.lbl_PrecioBatido.setText("");
				vista.lbl_IconoEuro2.setIcon(null);
				vista.lbl_InformacionBebida2.setIcon(null);
				break;
		}
	}//MOSTRAR INFORMACION BATIDO SELECCIONADO
	
	private void mostrarInformacionRefrescoSeleccionado() {
		String tipoRefresco = (String) vista.comboBox_TipoRefresco.getSelectedItem();
		
		switch(tipoRefresco) {
			case "Agua":
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(1).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(1).getPrecio()));
				vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
				vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
				break;
			case "Aquarius Limón":
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(2).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(2).getPrecio()));
				vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
				vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
				break;
			case "Fanta Naranja":
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(3).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(3).getPrecio()));
				vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
				vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
				break;
			case "Nestea":
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(4).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(4).getPrecio()));
				vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
				vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
				break;
			case "Coca-Cola":
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(5).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(5).getPrecio()));
				vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
				vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
				break;
			default:
				vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(0).getImagenBebida().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
				vista.lbl_PrecioRefresco.setText("");
				vista.lbl_IconoEuro3.setIcon(null);
				vista.lbl_InformacionBebida3.setIcon(null);
				break;
		}
	}//MOSTRAR INFORMACION REFRESCO SELECCIONADO
	
	private void mostrarInformacionBebidaCalienteOFriaSeleccionada() {
		String tipoBebidaCalienteOFria = (String) vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem();
		
		switch(tipoBebidaCalienteOFria) {
			case "Chocolate caliente":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(1).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(1).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			case "Té de menta":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(2).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(2).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			case "Té de frutos rojos":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(3).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(3).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			case "Horchata":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(4).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(4).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			case "Limonada":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(5).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(5).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			case "Infusión":
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(6).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(6).getPrecio()));
				vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
				vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
				break;
			default:
				vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(0).getImagenBebida().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
				vista.lbl_PrecioBebidaVariada.setText("");
				vista.lbl_IconoEuro4.setIcon(null);
				vista.lbl_InformacionBebida4.setIcon(null);
				break;
		}
	}//MOSTRAR INFORMACION BEBIDA SELECCIONADA
	
	private void gestionarSeleccionBebidasPorDefecto() {
		vista.comboBox_TipoCafe.setSelectedIndex(0);
		vista.comboBox_TipoBatido.setSelectedIndex(0);
		vista.comboBox_TipoRefresco.setSelectedIndex(0);
		vista.comboBox_TipoBebidaCalienteoFria.setSelectedIndex(0);
	}
	
	private void gestionarMesaOTaburete(String nombreComanda) {
		vista.panel_GestionComandas.setVisible(true);
		vista.panel_PantallaPrincipal.setVisible(false);
		iniciarGestionComandas();
		vista.lbl_Mesa_o_Taburete.setText(nombreComanda);
	}
	
	private void iniciarPanelInformacionProductos() {
		vista.lbl_ImgFondoInfoProductos.setIcon(ajustarTamañoImg("src/img/fondoInformacionProducto.png", vista.lbl_ImgFondoInfoProductos.getWidth(), vista.lbl_ImgFondoInfoProductos.getHeight()));
	}

	private ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
	}//FIN AJUSTAR TAMAÑO IMG
	
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
				vista.textArea_MensajeInformacionCambiosRealizados.setText("No has guardado los cambios".toUpperCase());
				vista.textArea_MensajeInformacionCambiosRealizados.setForeground(new Color(255, 0, 0));
				vista.textArea_MensajeInformacionCambiosRealizados.setVisible(true);
			}else {
				vista.panel_DetallesEmpleado.setVisible(false);
				vista.panel_PantallaPrincipal.setVisible(true);
				vista.textArea_MensajeInformacionCambiosRealizados.setVisible(false);
			}
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Detalles) {
			vista.panel_DetallesEmpleado.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarAppDetallesEmpleado();
			mostrarDetallesEmpleado();
		}
		
		if(e.getClickCount()==1) {
			if (e.getSource()==vista.lbl_Mesa1) {
				gestionarMesaOTaburete("MESA 1");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa2) {
				gestionarMesaOTaburete("MESA 2");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa3) {
				gestionarMesaOTaburete("MESA 3");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa4) {
				gestionarMesaOTaburete("MESA 4");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa5) {
				gestionarMesaOTaburete("MESA 5");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete1) {
				gestionarMesaOTaburete("TABURETE 1");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete2) {
				gestionarMesaOTaburete("TABURETE 2");
				gestionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete3) {
				gestionarMesaOTaburete("TABURETE 3");
				gestionarSeleccionBebidasPorDefecto();
			}
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_SalirComandas) {
			vista.panel_PantallaPrincipal.setVisible(true);
			vista.panel_GestionComandas.setVisible(false);
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_InformacionComida1) {
			vista.panel_GestionComandas.setVisible(false);
			vista.panel_InformacionProducto.setVisible(true);
			iniciarPanelInformacionProductos();
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
