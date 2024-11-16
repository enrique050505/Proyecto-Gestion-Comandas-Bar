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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Modelo.Comanda;
import Modelo.Empleado;
import Modelo.Ingrediente;
import Modelo.Lugar;
import Modelo.Producto;
import Vista.InterfazApp;

public class ControladorCafeteria implements ActionListener, MouseListener{
	
	InterfazApp vista = new InterfazApp();
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	ArrayList<Producto> comidas = new ArrayList<Producto>();
	ArrayList<Producto> cafes = new ArrayList<Producto>();
	ArrayList<Producto> refrescos = new ArrayList<Producto>();
	ArrayList<Producto> batidos = new ArrayList<Producto>();
	ArrayList<Producto> bebidasCalientesOFrias = new ArrayList<Producto>();
	ArrayList<Lugar> lugares = new ArrayList<>();
	HashMap<String, JButton> botonesRetirarBebidas = new HashMap<>();
	
	Timer fechaYHora;
	Empleado empleadoActual;
	Comanda comandaActual;
	DefaultListModel<String> comanda = new DefaultListModel<>();
	
	public ControladorCafeteria(InterfazApp vista) {
		this.vista = vista;
		this.vista.btnInicioSesion.addActionListener(this);
		this.vista.btn_GuardarCambios.addActionListener(this);
		
		//COMBOBOX
		this.vista.comboBox_Menu.addActionListener(this);
		this.vista.comboBox_TipoCafe.addActionListener(this);
		this.vista.comboBox_TipoBatido.addActionListener(this);
		this.vista.comboBox_TipoRefresco.addActionListener(this);
		this.vista.comboBox_TipoBebidaCalienteoFria.addActionListener(this);
		
		//BOTONES AÑADIR PRODUCTOS
		this.vista.btnAñadirComida1.addActionListener(this);
		this.vista.btnAñadirComida2.addActionListener(this);
		this.vista.btnAñadirComida3.addActionListener(this);
		this.vista.btnAñadirComida4.addActionListener(this);
		this.vista.btnAñadirComida5.addActionListener(this);
		this.vista.btnAñadirComida6.addActionListener(this);
		this.vista.btnAñadirBebida1.addActionListener(this);
		this.vista.btnAñadirBebida2.addActionListener(this);
		this.vista.btnAñadirBebida3.addActionListener(this);
		this.vista.btnAñadirBebida4.addActionListener(this);
		
		//BOTONES RETIRAR PRODUCTOS
		this.vista.btnEliminarComida1.addActionListener(this);
		this.vista.btnEliminarComida2.addActionListener(this);
		this.vista.btnEliminarComida3.addActionListener(this);
		this.vista.btnEliminarComida4.addActionListener(this);
		this.vista.btnEliminarComida5.addActionListener(this);
		this.vista.btnEliminarComida6.addActionListener(this);
		this.vista.btnRetirarBebida1.addActionListener(this);
		this.vista.btnRetirarBebida2.addActionListener(this);
		this.vista.btnRetirarBebida3.addActionListener(this);
		this.vista.btnRetirarBebida4.addActionListener(this);
		
		//CHECK BOX
		this.vista.checkBox_MostrarTablaIngredientes.addActionListener(this);
		
		//MOUSE LISTENERS
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
		this.vista.lbl_InformacionComida2.addMouseListener(this);
		this.vista.lbl_InformacionComida3.addMouseListener(this);
		this.vista.lbl_InformacionComida4.addMouseListener(this);
		this.vista.lbl_InformacionComida5.addMouseListener(this);
		this.vista.lbl_InformacionComida6.addMouseListener(this);
		this.vista.lbl_InformacionBebida1.addMouseListener(this);
		this.vista.lbl_InformacionBebida2.addMouseListener(this);
		this.vista.lbl_InformacionBebida3.addMouseListener(this);
		this.vista.lbl_InformacionBebida4.addMouseListener(this);
		this.vista.lbl_SalirInformacionProductos.addMouseListener(this);
		
		this.vista.list_ListaPedidos.setModel(comanda);
		
		rellenarListaEmpleados(empleados);
		rellenarComidas(comidas);
		rellenarCafes(cafes);
		rellenarRefrescos(refrescos);
		rellenarBatidos(batidos);
		rellenarBebidasCalientesOFrias(bebidasCalientesOFrias);
		
		rellenarComboBoxBebidas(cafes, refrescos, batidos, bebidasCalientesOFrias);
		
		inicializarLugares();
		inicializarBotonesRetirarBebidas();
		
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
			
			if(vista.comboBox_TipoCafe.getSelectedIndex()==0) {
				vista.btnAñadirBebida1.setEnabled(false);
				vista.btnRetirarBebida1.setEnabled(false);
			}else {
				vista.btnAñadirBebida1.setEnabled(true);
				String cafeSeleccionado = vista.comboBox_TipoCafe.getSelectedItem().toString();
				vista.btnRetirarBebida1.setEnabled(comprobarBebidaComanda(cafeSeleccionado));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoBatido) {
			mostrarInformacionBatidoSeleccionado();
			
			if(vista.comboBox_TipoBatido.getSelectedIndex()==0) {
				vista.btnAñadirBebida2.setEnabled(false);
				vista.btnRetirarBebida2.setEnabled(false);
			}else {
				vista.btnAñadirBebida2.setEnabled(true);
				String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
				vista.btnRetirarBebida2.setEnabled(comprobarBebidaComanda(batidoSeleccionado));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoRefresco) {
			mostrarInformacionRefrescoSeleccionado();
			
			if(vista.comboBox_TipoRefresco.getSelectedIndex()==0) {
				vista.btnAñadirBebida3.setEnabled(false);
				vista.btnRetirarBebida3.setEnabled(false);
			}else {
				vista.btnAñadirBebida3.setEnabled(true);
				String refrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedItem().toString();
				vista.btnRetirarBebida3.setEnabled(comprobarBebidaComanda(refrescoSeleccionado));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoBebidaCalienteoFria) {
			mostrarInformacionBebidaCalienteOFriaSeleccionada();
			
			if(vista.comboBox_TipoBebidaCalienteoFria.getSelectedIndex()==0) {
				vista.btnAñadirBebida4.setEnabled(false);
				vista.btnRetirarBebida4.setEnabled(false);
			}else {
				vista.btnAñadirBebida4.setEnabled(true);
				String bebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
				vista.btnRetirarBebida4.setEnabled(comprobarBebidaComanda(bebidaSeleccionada));
			}
		}
		
		//BOTONES AÑADIR COMIDAS
		if(e.getSource()==vista.btnAñadirComida1) {
			añadirComidasAComanda(comidas.get(0).getNombre());
		}else if(e.getSource()==vista.btnAñadirComida2) {
			añadirComidasAComanda(comidas.get(1).getNombre());
		}else if(e.getSource()==vista.btnAñadirComida3) {
			añadirComidasAComanda(comidas.get(2).getNombre());
		}else if(e.getSource()==vista.btnAñadirComida4) {
			añadirComidasAComanda(comidas.get(3).getNombre());
		}else if(e.getSource()==vista.btnAñadirComida5) {
			añadirComidasAComanda(comidas.get(4).getNombre());
		}else if(e.getSource()==vista.btnAñadirComida6) {
			añadirComidasAComanda(comidas.get(5).getNombre());
		}
		
		//BOTONES RETIRAR COMIDAS
		if(e.getSource()==vista.btnEliminarComida1) {
			eliminarComidaDeComanda(comidas.get(0).getNombre());
		}else if(e.getSource()==vista.btnEliminarComida2) {
			eliminarComidaDeComanda(comidas.get(1).getNombre());
		}else if(e.getSource()==vista.btnEliminarComida3) {
			eliminarComidaDeComanda(comidas.get(2).getNombre());
		}else if(e.getSource()==vista.btnEliminarComida4) {
			eliminarComidaDeComanda(comidas.get(3).getNombre());
		}else if(e.getSource()==vista.btnEliminarComida5) {
			eliminarComidaDeComanda(comidas.get(4).getNombre());
		}else if(e.getSource()==vista.btnEliminarComida6) {
			eliminarComidaDeComanda(comidas.get(5).getNombre());
		}
		

		//BOTONES AÑADIR BEBIDAS
		if(e.getSource()==vista.btnAñadirBebida1) {
			int indiceCafeSeleccionado = vista.comboBox_TipoCafe.getSelectedIndex();
			
			if(indiceCafeSeleccionado > 0) {
				Producto cafeSeleccionado = cafes.get(indiceCafeSeleccionado);
				añadirBebidasAComanda(cafeSeleccionado.getNombre());
				vista.btnRetirarBebida1.setEnabled(comprobarBebidaComanda(cafeSeleccionado.getNombre()));
			}else {
				vista.btnRetirarBebida1.setEnabled(false);
			}
		}
		
		if(e.getSource()==vista.btnAñadirBebida2) {
			int indiceBatidoSeleccionado = vista.comboBox_TipoBatido.getSelectedIndex();
			
			if(indiceBatidoSeleccionado > 0) {
				Producto batidoSeleccionado = batidos.get(indiceBatidoSeleccionado);
				añadirBebidasAComanda(batidoSeleccionado.getNombre());
				vista.btnRetirarBebida2.setEnabled(comprobarBebidaComanda(batidoSeleccionado.getNombre()));
			}else {
				vista.btnRetirarBebida2.setEnabled(false);
			}
		}
		
		if(e.getSource()==vista.btnAñadirBebida3) {
			int indiceRefrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedIndex();
			
			if(indiceRefrescoSeleccionado > 0) {
				Producto refrescoSeleccionado = refrescos.get(indiceRefrescoSeleccionado);
				añadirBebidasAComanda(refrescoSeleccionado.getNombre());
				vista.btnRetirarBebida3.setEnabled(comprobarBebidaComanda(refrescoSeleccionado.getNombre()));
			}else {
				vista.btnRetirarBebida3.setEnabled(false);
			}
		}
		
		if(e.getSource()==vista.btnAñadirBebida4) {
			int indiceBebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedIndex();
			
			if(indiceBebidaSeleccionada > 0) {
				Producto bebidaSeleccionada = bebidasCalientesOFrias.get(indiceBebidaSeleccionada);
				añadirBebidasAComanda(bebidaSeleccionada.getNombre());
				vista.btnRetirarBebida4.setEnabled(comprobarBebidaComanda(bebidaSeleccionada.getNombre()));
			}else {
				vista.btnRetirarBebida4.setEnabled(false);
			}
		}
		
		//BOTONES RETIRAR BEBIDAS
		if(e.getSource()==vista.btnRetirarBebida1) {
			String cafeSeleccionado = vista.comboBox_TipoCafe.getSelectedItem().toString();
			
			retirarBebidas(cafes, cafeSeleccionado);
			vista.btnRetirarBebida1.setEnabled(comprobarBebidaComanda(cafeSeleccionado));
		}
		
		if(e.getSource()==vista.btnRetirarBebida2) {
			String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
			
			retirarBebidas(batidos, batidoSeleccionado);
			vista.btnRetirarBebida2.setEnabled(comprobarBebidaComanda(batidoSeleccionado));
		}
		
		if(e.getSource()==vista.btnRetirarBebida3) {
			String refrescoSeleccionado= vista.comboBox_TipoRefresco.getSelectedItem().toString();
			
			retirarBebidas(refrescos, refrescoSeleccionado);
			vista.btnRetirarBebida3.setEnabled(comprobarBebidaComanda(refrescoSeleccionado));
		}
		
		if(e.getSource()==vista.btnRetirarBebida4) {
			String bebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
			
			retirarBebidas(bebidasCalientesOFrias, bebidaSeleccionada);
			vista.btnRetirarBebida4.setEnabled(comprobarBebidaComanda(bebidaSeleccionada));
		}

		if(e.getSource()==vista.checkBox_MostrarTablaIngredientes) {
			boolean mostrarTabla = vista.checkBox_MostrarTablaIngredientes.isSelected();
			vista.lbl_Ingredientes.setVisible(mostrarTabla);
			vista.tabla_Ingredientes.setVisible(mostrarTabla);
			vista.checkBox_MostrarTablaIngredientes.setSelected(mostrarTabla);
			vista.tabla_Ingredientes.getTableHeader().setVisible(mostrarTabla);
			vista.scrollPane_Ingredientes.setVisible(mostrarTabla);
		}
	}//FIN ACTION PERFORMED	
	
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
		}else if(vista.textFieldUsuario.getText().isEmpty() && vista.passwordField_Contraseña.getText().isEmpty()) {
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
		vista.lbl_ImgDetallesEmpleado.setIcon(ajustarTamañoImg("src/img/fondoDetalles.png", vista.lbl_ImgDetallesEmpleado.getWidth(), vista.lbl_ImgDetallesEmpleado.getHeight()));
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
		boolean telefonoValido=true;
		
		if(telefono.length() != 9) {
			telefonoValido=false;
		}
		for(int i=0; i<telefono.length(); i++) {
			char c= telefono.charAt(i);
			if(c < '0' || c>'9') {
				telefonoValido=false;
			}
		}
		return telefonoValido;
	}
	
	private void iniciarGestionComandas() {
		vista.lbl_SalirComandas.setIcon(ajustarTamañoImg("src/img/volverAtras.png", vista.lbl_SalirComandas.getWidth(), vista.lbl_SalirComandas.getHeight()));
		vista.lbl_InformacionComida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida1.getWidth(), vista.lbl_InformacionComida1.getHeight()));
		vista.lbl_InformacionComida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida2.getWidth(), vista.lbl_InformacionComida2.getHeight()));
		vista.lbl_InformacionComida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida3.getWidth(), vista.lbl_InformacionComida3.getHeight()));
		vista.lbl_InformacionComida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida4.getWidth(), vista.lbl_InformacionComida4.getHeight()));
		vista.lbl_InformacionComida5.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida5.getWidth(), vista.lbl_InformacionComida5.getHeight()));
		vista.lbl_InformacionComida6.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionComida6.getWidth(), vista.lbl_InformacionComida6.getHeight()));
		vista.lbl_PedirComanda.setIcon(ajustarTamañoImg("src/img/pedir comanda.png", vista.lbl_PedirComanda.getWidth(), vista.lbl_PedirComanda.getHeight()));
		vista.lbl_PagarComanda.setIcon(ajustarTamañoImg("src/img/pagar.png", vista.lbl_PagarComanda.getWidth(), vista.lbl_PagarComanda.getHeight()));
		
		mostrarComidas();
		
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
		boolean itemExistente = false;
		
		for(int i=0; i<vista.comboBox_Menu.getItemCount(); i++) {
			if(vista.comboBox_Menu.getItemAt(i).equals(item)) {
				itemExistente=true;
			}
		}
		return itemExistente;
	}
	
	private void rellenarComidas(ArrayList<Producto> comidas) {
		comidas.add(new Producto(new ImageIcon("src/img/bizcocho.png"), 3.50, "Bizcocho", rellenarIngredientesComidas(0), 5, 20));
		comidas.add(new Producto(new ImageIcon("src/img/napolitana.png"), 1.80, "Napolitana", rellenarIngredientesComidas(1), 6, 25));
		comidas.add(new Producto(new ImageIcon("src/img/croissant.png"), 1.50, "Croissant", rellenarIngredientesComidas(2), 7, 25));
		comidas.add(new Producto(new ImageIcon("src/img/brazo de gitano.png"), 3.25, "Brazo de gitano", rellenarIngredientesComidas(3), 5, 18.5));
		comidas.add(new Producto(new ImageIcon("src/img/milhojas de crema.png"), 2.50, "Milhojas de crema", rellenarIngredientesComidas(4), 6, 25));
		comidas.add(new Producto(new ImageIcon("src/img/tarta de queso.png"), 3.50, "Tarta de queso", rellenarIngredientesComidas(5), 6.5, 28));
	}//RELLENAR ARRAYLIST COMIDAS
	
	private ArrayList<Ingrediente> rellenarIngredientesComidas(int numeroComida){
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		
		switch(numeroComida) {
			case 0:
				ingredientes.add(new Ingrediente("Harina de trigo", 500, "g", 364, 1820));
				ingredientes.add(new Ingrediente("Azúcar", 200, "g", 387, 774));
				ingredientes.add(new Ingrediente("Huevos", 4, "unidades", 155, 310));
				ingredientes.add(new Ingrediente("Mantequilla", 100, "g", 717, 717));
				ingredientes.add(new Ingrediente("Leche", 100, "ml", 42, 42));
				break;
			case 1:
				ingredientes.add(new Ingrediente("Harina de trigo", 400, "g", 364, 1456));
				ingredientes.add(new Ingrediente("Mantequilla", 150, "g", 717, 1075.5));
				ingredientes.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
				ingredientes.add(new Ingrediente("Chocolate", 50, "g", 546, 273));
				break;
			case 2:
				ingredientes.add(new Ingrediente("Harina de trigo", 300, "g", 364, 1092));
				ingredientes.add(new Ingrediente("Mantequilla", 150, "g", 717, 1075.5));
				ingredientes.add(new Ingrediente("Leche entera", 100, "ml", 61, 61));
				ingredientes.add(new Ingrediente("Azúcar", 50, "g", 387, 193.5));
				ingredientes.add(new Ingrediente("Levadura", 10, "g", 360, 36));
				break;
			case 3:
				ingredientes.add(new Ingrediente("Harina de trigo", 450, "g", 364, 1638));
				ingredientes.add(new Ingrediente("Huevos", 6, "unidades", 155, 465));
				ingredientes.add(new Ingrediente("Azúcar", 200, "g", 387, 774));
				ingredientes.add(new Ingrediente("Nata para montar", 200, "ml", 345, 690));
				break;
			case 4:
				ingredientes.add(new Ingrediente("Hojaldre", 400, "g", 550, 2200));
				ingredientes.add(new Ingrediente("Crema pastelera", 250, "g", 325, 812.5));
				ingredientes.add(new Ingrediente("Azúcar glas", 50, "g", 387, 193.5));
				break;
			case 5:
				ingredientes.add(new Ingrediente("Queso cremoso", 600, "g", 350, 2100));
				ingredientes.add(new Ingrediente("Gallestas digestivas", 150, "g", 500, 750));
				ingredientes.add(new Ingrediente("Mantequilla", 100, "ml", 717, 717));
				ingredientes.add(new Ingrediente("Azúcar", 150, "g", 387, 580.5));
				ingredientes.add(new Ingrediente("Huevos", 3, "unidades", 155, 232.5));
				ingredientes.add(new Ingrediente("Nata para montar", 100, "ml", 345, 345));
				break;
			default:
				System.out.println("No existe la comida");
				break;	
		}
		return ingredientes;
	}
	
	private void mostrarComidas() {
		for(int i=0; i<comidas.size(); i++) {
			switch(i) {
				case 0:
					vista.lbl_Comida1.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida1.getWidth(), vista.lbl_Comida1.getHeight()));
					vista.lbl_NombreComida1.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida1.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida1.getWidth(), vista.lbl_SimboloEuroComida1.getHeight()));
					break;
				case 1:
					vista.lbl_Comida2.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida2.getWidth(), vista.lbl_Comida2.getHeight()));
					vista.lbl_NombreComida2.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida2.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida2.getWidth(), vista.lbl_SimboloEuroComida2.getHeight()));
					break;
				case 2:
					vista.lbl_Comida3.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida3.getWidth(), vista.lbl_Comida3.getHeight()));
					vista.lbl_NombreComida3.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida3.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida3.getWidth(), vista.lbl_SimboloEuroComida3.getHeight()));
					break;
				case 3:
					vista.lbl_Comida4.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida4.getWidth(), vista.lbl_Comida4.getHeight()));
					vista.lbl_NombreComida4.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida4.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida4.getWidth(), vista.lbl_SimboloEuroComida2.getHeight()));
					break;
				case 4:
					vista.lbl_Comida5.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida5.getWidth(), vista.lbl_Comida5.getHeight()));
					vista.lbl_NombreComida5.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida5.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida5.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida5.getWidth(), vista.lbl_SimboloEuroComida5.getHeight()));
					break;
				case 5:
					vista.lbl_Comida6.setIcon(ajustarTamañoImg(comidas.get(i).getImagenProducto().getDescription(), vista.lbl_Comida6.getWidth(), vista.lbl_Comida6.getHeight()));
					vista.lbl_NombreComida6.setText(comidas.get(i).getNombre());
					vista.lbl_PrecioComida6.setText(String.valueOf(comidas.get(i).getPrecio()));
					vista.lbl_SimboloEuroComida6.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_SimboloEuroComida6.getWidth(), vista.lbl_SimboloEuroComida6.getHeight()));
					break;
				default:
					break;
			}
		}
	}
	
	private void rellenarCafes(ArrayList<Producto> cafes) {
		cafes.add(new Producto(new ImageIcon("src/img/cafe.png"), 0.00, "Cafés", null, 0, 0));
		cafes.add(new Producto(new ImageIcon("src/img/cafe con leche.png"), 1.30, "Café con leche", rellenarIngredientesCafes(0), 3.3, 3.2));
		cafes.add(new Producto(new ImageIcon("src/img/capuccino.png"), 1.80, "Capuccino", rellenarIngredientesCafes(1), 5, 4.4));
		cafes.add(new Producto(new ImageIcon("src/img/cafe americano.png"), 1.40, "Café Americano", rellenarIngredientesCafes(2), 0.2, 0.1));
		cafes.add(new Producto(new ImageIcon("src/img/cafe bombon.png"), 1.90, "Café Bombón", rellenarIngredientesCafes(3), 2.6, 3.4));
		cafes.add(new Producto(new ImageIcon("src/img/cafe cortado.png"), 1.25, "Café Cortado", rellenarIngredientesCafes(4), 1.2, 1.1));
	}
	
	private ArrayList<Ingrediente> rellenarIngredientesCafes(int numeroCafe){
		ArrayList<Ingrediente> ingredientesCafes = new ArrayList<>();
		
		switch(numeroCafe) {
		case 0:
			ingredientesCafes.add(new Ingrediente("Café", 1, "ml", 2, 2));
			ingredientesCafes.add(new Ingrediente("Leche", 100, "ml", 61, 61));
			break;
		case 1:
			ingredientesCafes.add(new Ingrediente("Café Espresso", 30, "ml", 2, 2));
			ingredientesCafes.add(new Ingrediente("Leche Vaporizada", 100, "ml", 61, 61));
			ingredientesCafes.add(new Ingrediente("Espuma de Leche", 50, "ml", 31, 31));
			break;
		case 2:
			ingredientesCafes.add(new Ingrediente("Café Espresso", 30, "ml", 2, 2));
			ingredientesCafes.add(new Ingrediente("Agua", 150, "ml", 0, 0));
			break;
		case 3:
			ingredientesCafes.add(new Ingrediente("Café Espresso", 30, "ml", 2, 2));
			ingredientesCafes.add(new Ingrediente("Leche Condensada", 50, "ml", 129, 64.5));
			break;
		case 4:
			ingredientesCafes.add(new Ingrediente("Café Espresso", 30, "ml", 2, 2));
			ingredientesCafes.add(new Ingrediente("Leche", 30, "ml", 18, 18));
			break;
		default:
			System.out.println("No existe el cafe");
			break;	
		}
		
		return ingredientesCafes;
	}//RELLENAR INGREDIENTES CAFES
	
	private void rellenarRefrescos(ArrayList<Producto> refrescos) {
		refrescos.add(new Producto(new ImageIcon("src/img/refresco.png"), 0.00, "Refrescos", null, 0, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/agua.png"), 1.00, "Agua", rellenarIngredientesRefrescos(0), 0, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/aquarius.png"), 1.75, "Aquarius Limón", rellenarIngredientesRefrescos(1), 0.2, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/fanta de naranja.png"), 1.75, "Fanta Naranja", rellenarIngredientesRefrescos(2), 0, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/nestea.png"), 1.60, "Nestea", rellenarIngredientesRefrescos(3), 0.1, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/coca cola.png"), 1.90, "Coca-Cola", rellenarIngredientesRefrescos(4), 0, 0));
	}
	
	private ArrayList<Ingrediente> rellenarIngredientesRefrescos(int numeroRefresco){
		ArrayList<Ingrediente> ingredientesRefrescos = new ArrayList<>();
		
		switch(numeroRefresco) {
		case 0:
			ingredientesRefrescos.add(new Ingrediente("Agua", 1000, "ml", 0, 0));
			break;
		case 1:
			ingredientesRefrescos.add(new Ingrediente("Agua", 800, "ml", 0, 0));
			ingredientesRefrescos.add(new Ingrediente("Azúcar", 150, "g", 387, 580));
			ingredientesRefrescos.add(new Ingrediente("Aromatizantes artificales", 50, "g", 0, 0));
			break;
		case 2:
			ingredientesRefrescos.add(new Ingrediente("Agua", 700, "ml", 0, 0));
			ingredientesRefrescos.add(new Ingrediente("Azúcar", 170, "g", 387, 658));
			ingredientesRefrescos.add(new Ingrediente("Saborizante de Naranja", 30, "ml", 0, 0));
			break;
		case 3:
			ingredientesRefrescos.add(new Ingrediente("Agua", 800, "ml", 0, 0));
			ingredientesRefrescos.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
			ingredientesRefrescos.add(new Ingrediente("Té helado concentrado", 50, "g", 0, 0));
			break;
		case 4:
			ingredientesRefrescos.add(new Ingrediente("Agua", 600, "ml", 0, 0));
			ingredientesRefrescos.add(new Ingrediente("Azúcar", 200, "g", 387, 774));
			ingredientesRefrescos.add(new Ingrediente("Aromatizantes", 50, "g", 0, 0));
			break;
		default:
			System.out.println("No existe el refresco");
			break;	
		}
		
		return ingredientesRefrescos;
	}//RELLENAR INGREDIENTES REFRESCOS
	
	private void rellenarBatidos(ArrayList<Producto> batidos) {
		batidos.add(new Producto(new ImageIcon("src/img/batido.png"), 0.00, "Batidos", null, 0, 0));
		batidos.add(new Producto(new ImageIcon("src/img/batido de chocolate.png"), 3.00, "Batido Chocolate", rellenarIngredientesBatidos(0), 8, 10));
		batidos.add(new Producto(new ImageIcon("src/img/batido de fresa.png"), 3.00, "Batido Fresa", rellenarIngredientesBatidos(1), 7, 8));
		batidos.add(new Producto(new ImageIcon("src/img/batido de oreo.png"), 3.50, "Batido Oreo", rellenarIngredientesBatidos(2), 8, 12));
		batidos.add(new Producto(new ImageIcon("src/img/batido de vainilla.png"), 3.00, "Batido Vainilla", rellenarIngredientesBatidos(3), 7, 8));
		batidos.add(new Producto(new ImageIcon("src/img/batido de mango.png"), 3.25, "Batido Mango", rellenarIngredientesBatidos(4), 6, 8));
	}
	
	private ArrayList<Ingrediente> rellenarIngredientesBatidos(int numeroBatido){
		ArrayList<Ingrediente> ingredientesBatidos = new ArrayList<>();
		
		switch(numeroBatido) {
		case 0:
			ingredientesBatidos.add(new Ingrediente("Leche", 250, "ml", 42, 105));
			ingredientesBatidos.add(new Ingrediente("Cacao", 50, "g", 315, 187.5));
			ingredientesBatidos.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
			break;
		case 1:
			ingredientesBatidos.add(new Ingrediente("Leche", 250, "ml", 42, 105));
			ingredientesBatidos.add(new Ingrediente("Azúcar", 75, "g", 387, 290.25));
			ingredientesBatidos.add(new Ingrediente("Fresas", 100, "g", 32, 32));
			break;
		case 2:
			ingredientesBatidos.add(new Ingrediente("Leche", 250, "ml", 42, 105));
			ingredientesBatidos.add(new Ingrediente("Galletas Oreo", 50, "g", 530, 265));
			ingredientesBatidos.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
			break;
		case 3:
			ingredientesBatidos.add(new Ingrediente("Leche", 250, "ml", 42, 105));
			ingredientesBatidos.add(new Ingrediente("Vainilla", 10, "g", 288, 28.8));
			ingredientesBatidos.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
			break;
		case 4:
			ingredientesBatidos.add(new Ingrediente("Leche", 250, "ml", 42, 105));
			ingredientesBatidos.add(new Ingrediente("Mango", 10, "g", 60, 60));
			ingredientesBatidos.add(new Ingrediente("Azúcar", 100, "g", 387, 387));
			break;
		default:
			System.out.println("No existe el batido");
			break;	
		}
		
		return ingredientesBatidos;
	}//RELLENAR INGREDIENTES REFRESCOS
	
	private void rellenarBebidasCalientesOFrias(ArrayList<Producto> bebidasCalientesOFrias) {
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/bebida caliente.png"), 0.00, "Bebidas Mixtas", null, 0, 0));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/chocolate caliente.png"), 3.00, "Chocolate caliente", rellenarIngredientesBebidasCalientesOFrias(0), 4, 8));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/te de menta.png"), 1.60, "Té de menta", rellenarIngredientesBebidasCalientesOFrias(1), 1, 0));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/te de frutos rojos.png"), 2.20, "Té de frutos rojos", rellenarIngredientesBebidasCalientesOFrias(2), 1.5, 0));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/horchata.png"), 2.00, "Horchata", rellenarIngredientesBebidasCalientesOFrias(3), 1.5, 4));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/limonada.png"), 2.00, "Limonada", rellenarIngredientesBebidasCalientesOFrias(4), 0, 0));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/infusion de canela y manzana.png"), 2.75, "Infusión", rellenarIngredientesBebidasCalientesOFrias(5), 1, 0));
	}
	
	private ArrayList<Ingrediente> rellenarIngredientesBebidasCalientesOFrias(int numeroBebida){
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		
		switch(numeroBebida) {
			case 0:
				ingredientes.add(new Ingrediente("Cacao", 50, "ml", 375, 187.5));
				ingredientes.add(new Ingrediente("Azúcar", 80, "g", 387, 309.6));
				ingredientes.add(new Ingrediente("Leche", 250, "ml", 42, 105));
				break;
			case 1:
				ingredientes.add(new Ingrediente("Agua", 200, "ml", 0, 0));
				ingredientes.add(new Ingrediente("Menta", 10, "g", 1, 0));
				break;
			case 2:
				ingredientes.add(new Ingrediente("Agua", 200, "ml", 0, 0));
				ingredientes.add(new Ingrediente("Frutos Rojos", 10, "g", 30, 3));
				break;
			case 3:
				ingredientes.add(new Ingrediente("Agua", 250, "ml", 0, 0));
				ingredientes.add(new Ingrediente("Arroz", 50, "g", 130, 65));
				ingredientes.add(new Ingrediente("Azúcar", 75, "g", 387, 290.25));
				break;
			case 4:
				ingredientes.add(new Ingrediente("Agua", 300, "ml", 0, 0));
				ingredientes.add(new Ingrediente("Limón", 50, "g", 29, 14.5));
				ingredientes.add(new Ingrediente("Azúcar", 50, "g", 387, 193.5));
				break;
			case 5:
				ingredientes.add(new Ingrediente("Agua", 200, "ml", 0, 0));
				ingredientes.add(new Ingrediente("Canela", 10, "g", 131, 13.1));
				ingredientes.add(new Ingrediente("Azúcar", 50, "g", 52, 26));
				break;
			default:
				System.out.println("No existe la bebida caliente o fria");
				break;	
		}
		return ingredientes;
	}
	
	private void rellenarComboBoxBebidas(ArrayList<Producto> cafes, ArrayList<Producto> refrescos, ArrayList<Producto> batidos, ArrayList<Producto> bebidasCalientesOFrias) {
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
		String tipoCafe = vista.comboBox_TipoCafe.getSelectedItem().toString();
		int numeroCafe;
		
		switch(tipoCafe) {
			case "Café con leche":
				numeroCafe = 1;
				break;
			case "Capuccino":
				numeroCafe = 2;
				break;
			case "Café Americano":
				numeroCafe = 3;
				break;
			case "Café Bombón":
				numeroCafe = 4;
				break;
			case "Café Cortado":
				numeroCafe = 5;
				break;
			default:
				numeroCafe = 0;
				break;
		}
		
		if(numeroCafe>0) {
			vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(numeroCafe).getImagenProducto().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
			vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(numeroCafe).getPrecio()));
			vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
			vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
		}else {
			vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(numeroCafe).getImagenProducto().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
			vista.lbl_PrecioCafe.setText("");
			vista.lbl_IconoEuro1.setIcon(null);
			vista.lbl_InformacionBebida1.setIcon(null);
		}
	}//MOSTRAR INFORMACION CAFE SELECCIONADO
	
	private void mostrarInformacionBatidoSeleccionado() {
		String tipoBatido = vista.comboBox_TipoBatido.getSelectedItem().toString();
		int numeroBatido;
		
		switch(tipoBatido) {
			case "Batido Chocolate":
				numeroBatido = 1;
				break;
			case "Batido Fresa":
				numeroBatido = 2;
				break;
			case "Batido Oreo":
				numeroBatido = 3;
				break;
			case "Batido Vainilla":
				numeroBatido = 4;
				break;
			case "Batido Mango":
				numeroBatido = 5;
				break;
			default:
				numeroBatido = 0;
				break;
		}
		
		if(numeroBatido>0) {
			vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(numeroBatido).getImagenProducto().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
			vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(numeroBatido).getPrecio()));
			vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
			vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
		}else {
			vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(numeroBatido).getImagenProducto().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
			vista.lbl_PrecioBatido.setText("");
			vista.lbl_IconoEuro2.setIcon(null);
			vista.lbl_InformacionBebida2.setIcon(null);
		}
	}//MOSTRAR INFORMACION BATIDO SELECCIONADO
	
	private void mostrarInformacionRefrescoSeleccionado() {
		String tipoRefresco = vista.comboBox_TipoRefresco.getSelectedItem().toString();
		int numeroRefresco;
		
		switch(tipoRefresco) {
			case "Agua":
				numeroRefresco = 1;
				break;
			case "Aquarius Limón":
				numeroRefresco = 2;
				break;
			case "Fanta Naranja":
				numeroRefresco = 3;
				break;
			case "Nestea":
				numeroRefresco = 4;
				break;
			case "Coca-Cola":
				numeroRefresco = 5;
				break;
			default:
				numeroRefresco = 0;
				break;
		}
		
		if(numeroRefresco>0) {
			vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(numeroRefresco).getImagenProducto().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
			vista.lbl_PrecioRefresco.setText(String.valueOf(refrescos.get(numeroRefresco).getPrecio()));
			vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
			vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
		}else {
			vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(numeroRefresco).getImagenProducto().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
			vista.lbl_PrecioRefresco.setText("");
			vista.lbl_IconoEuro3.setIcon(null);
			vista.lbl_InformacionBebida3.setIcon(null);
		}
	}//MOSTRAR INFORMACION REFRESCO SELECCIONADO
	
	private void mostrarInformacionBebidaCalienteOFriaSeleccionada() {
		String tipoBebida = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
		int numeroBebida;
		
		switch(tipoBebida) {
			case "Chocolate caliente":
				numeroBebida = 1;
				break;
			case "Té de menta":
				numeroBebida = 2;
				break;
			case "Té de frutos rojos":
				numeroBebida = 3;
				break;
			case "Horchata":
				numeroBebida = 4;
				break;
			case "Limonada":
				numeroBebida = 5;
				break;
			case "Infusión":
				numeroBebida = 6;
				break;
			default:
				numeroBebida = 0;
				break;
		}
		
		if(numeroBebida>0) {
			vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(numeroBebida).getImagenProducto().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
			vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(numeroBebida).getPrecio()));
			vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
			vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
		}else {
			vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(numeroBebida).getImagenProducto().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
			vista.lbl_PrecioBebidaVariada.setText("");
			vista.lbl_IconoEuro4.setIcon(null);
			vista.lbl_InformacionBebida4.setIcon(null);
		}
	}//MOSTRAR INFORMACION BEBIDA SELECCIONADA
	
	private void retirarBebidas(ArrayList<Producto> bebidas, String bebidaSeleccionada) {
		for(int i=0; i<bebidas.size(); i++) {
			if(bebidaSeleccionada.equals(bebidas.get(i).getNombre())) {
				eliminarBebidaDeComanda(bebidas.get(i).getNombre());
			}
		}
	}
	
	private void seleccionarSeleccionBebidasPorDefecto() {
		vista.comboBox_TipoCafe.setSelectedIndex(0);
		vista.comboBox_TipoBatido.setSelectedIndex(0);
		vista.comboBox_TipoRefresco.setSelectedIndex(0);
		vista.comboBox_TipoBebidaCalienteoFria.setSelectedIndex(0);
	}
	
	private void inicializarLugares() {
		lugares.add(new Lugar("Mesa 1"));
		lugares.add(new Lugar("Mesa 2"));
		lugares.add(new Lugar("Mesa 3"));
		lugares.add(new Lugar("Mesa 4"));
		lugares.add(new Lugar("Mesa 5"));
		lugares.add(new Lugar("Taburete 1"));
		lugares.add(new Lugar("Taburete 2"));
		lugares.add(new Lugar("Taburete 3"));
	}
	
	private Lugar buscarLugar(String nombre) {
		Lugar lugarEncontrado = null;
		for(int i=0; i<lugares.size(); i++) {
			if(lugares.get(i).getNombreLugar().equalsIgnoreCase(nombre)) {
				lugarEncontrado = lugares.get(i);
			}
		}
		return lugarEncontrado;
	}//BUSCAR LUGAR
	
	private void gestionarComandaMesaOTaburete(String sitio) {
		vista.panel_GestionComandas.setVisible(true);
		vista.panel_PantallaPrincipal.setVisible(false);
		
		Lugar lugarElegido = buscarLugar(sitio);
		
		if(lugarElegido != null) {
			
			if(lugarElegido.obtenerComanda(1)==null || lugarElegido.getComandas().isEmpty()){
				lugarElegido.añadirNuevaComanda();
			}
			
			comandaActual = lugarElegido.obtenerComanda(1);
			
			actualizarComanda(comandaActual);

			iniciarGestionComandas();
			vista.lbl_Mesa_o_Taburete.setText(sitio);
			vista.lbl_IdComanda.setText("COMANDA " + comandaActual.getId());
		}
		
	}
	
	private void añadirComidasAComanda(String nombreComida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<comidas.size(); i++) {
			if(comidas.get(i).getNombre().equals(nombreComida)) {
				precio = comidas.get(i).getPrecio();
			}
		}
		
		comandaActual.añadirProducto(nombreComida, precio);
		
		actualizarComanda(comandaActual);
	}
	
	private void eliminarComidaDeComanda(String nombreComida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<comidas.size(); i++) {
			if(comidas.get(i).getNombre().equals(nombreComida)) {
				precio = comidas.get(i).getPrecio();
			}
		}
		
		comandaActual.eliminarProducto(nombreComida, precio);

		actualizarComanda(comandaActual);
	}
	
	private void añadirBebidasAComanda(String nombreBebida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<cafes.size(); i++) {
			if(cafes.get(i).getNombre().equals(nombreBebida)) {
				precio = cafes.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<batidos.size(); i++) {
			if(batidos.get(i).getNombre().equals(nombreBebida)) {
				precio = batidos.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<refrescos.size(); i++) {
			if(refrescos.get(i).getNombre().equals(nombreBebida)) {
				precio = refrescos.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<bebidasCalientesOFrias.size(); i++) {
			if(bebidasCalientesOFrias.get(i).getNombre().equals(nombreBebida)) {
				precio = bebidasCalientesOFrias.get(i).getPrecio();
			}
		}
		
		comandaActual.añadirProducto(nombreBebida, precio);
		
		actualizarComanda(comandaActual);
	}
	
	private void eliminarBebidaDeComanda(String nombreBebida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<cafes.size(); i++) {
			if(cafes.get(i).getNombre().equals(nombreBebida)) {
				precio = cafes.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<batidos.size(); i++) {
			if(batidos.get(i).getNombre().equals(nombreBebida)) {
				precio = batidos.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<refrescos.size(); i++) {
			if(refrescos.get(i).getNombre().equals(nombreBebida)) {
				precio = refrescos.get(i).getPrecio();
			}
		}
		
		for(int i=0; i<bebidasCalientesOFrias.size(); i++) {
			if(bebidasCalientesOFrias.get(i).getNombre().equals(nombreBebida)) {
				precio = bebidasCalientesOFrias.get(i).getPrecio();
			}
		}
		
		comandaActual.eliminarProducto(nombreBebida, precio);
		
		actualizarComanda(comandaActual);
	}

	private void actualizarComanda(Comanda comandaActual) {
		comanda.clear();
		
		deshabilitarBotones();
		
		HashMap<String, Integer> productos = comandaActual.getProductos();
		
		for(Map.Entry<String, Integer> entrada :productos.entrySet()) {
			comanda.addElement(entrada.getKey() + " ~> " + entrada.getValue());
		}
		
		vista.lbl_PrecioTotalComanda.setText("PRECIO TOTAL: " + comandaActual.getPrecioTotal() + "€");
		
		vista.list_ListaPedidos.setModel(comanda);

		comprobarProductosComanda(comandaActual);
	}
	
	private void comprobarProductosComanda(Comanda comandaActual){
		deshabilitarBotones();
		
		HashMap<String, Integer> productos = comandaActual.getProductos();
		
		for(Map.Entry<String, Integer> entrada:productos.entrySet()) {
			for(int i=0; i<comidas.size(); i++) {
				if(entrada.getKey().equals(comidas.get(i).getNombre())) {
					switch(i) {
						case 0:
							vista.btnEliminarComida1.setEnabled(true);
							break;
						case 1:
							vista.btnEliminarComida2.setEnabled(true);
							break;
						case 2:
							vista.btnEliminarComida3.setEnabled(true);
							break;
						case 3:
							vista.btnEliminarComida4.setEnabled(true);
							break;
						case 4:
							vista.btnEliminarComida5.setEnabled(true);
							break;
						case 5:
							vista.btnEliminarComida6.setEnabled(true);
							break;
						default:
							break;
					}
				}
			}
			
			for(int i=0; i<cafes.size(); i++) {
				if(entrada.getKey().equals(cafes.get(i).getNombre())){
					vista.btnRetirarBebida1.setEnabled(true);
				}
			}
			
			for(int i=0; i<batidos.size(); i++) {
				if(entrada.getKey().equals(batidos.get(i).getNombre())) {
					vista.btnRetirarBebida2.setEnabled(true);
				}
			}
			
			for(int i=0; i<refrescos.size(); i++) {
				if(entrada.getKey().equals(refrescos.get(i).getNombre())) {
					vista.btnRetirarBebida3.setEnabled(true);
				}
			}
			
			for(int i=0; i<bebidasCalientesOFrias.size(); i++) {
				if(entrada.getKey().equals(bebidasCalientesOFrias.get(i).getNombre())) {
					vista.btnRetirarBebida4.setEnabled(true);
				}
			}
		}
	}
	
	private boolean comprobarBebidaComanda(String bebidaSeleccionada) {
		boolean bebidaComanda = false;
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		comandaActual = lugarElegido.obtenerComanda(1);
		HashMap<String, Integer> elementosComanda = comandaActual.getProductos();
		
		for(Map.Entry<String, Integer> entrada:elementosComanda.entrySet()) {
			if(entrada.getKey().equals(bebidaSeleccionada)) {
				bebidaComanda=true;
			}
		}
		
		return bebidaComanda;
	}
	
	private void inicializarBotonesRetirarBebidas() {
		for(int i=1; i<cafes.size(); i++) {
			botonesRetirarBebidas.put(cafes.get(i).getNombre(), vista.btnRetirarBebida1);
		}
		
		for(int i=1; i<batidos.size(); i++) {
			botonesRetirarBebidas.put(batidos.get(i).getNombre(), vista.btnRetirarBebida2);
		}
		
		for(int i=1; i<refrescos.size(); i++) {
			botonesRetirarBebidas.put(refrescos.get(i).getNombre(), vista.btnRetirarBebida3);
		}
		
		for(int i=1; i<bebidasCalientesOFrias.size(); i++) {
			botonesRetirarBebidas.put(bebidasCalientesOFrias.get(i).getNombre(), vista.btnRetirarBebida4);
		}
	}
	
	private void deshabilitarBotones() {
		vista.btnEliminarComida1.setEnabled(false);
		vista.btnEliminarComida2.setEnabled(false);
		vista.btnEliminarComida3.setEnabled(false);
		vista.btnEliminarComida4.setEnabled(false);
		vista.btnEliminarComida5.setEnabled(false);
		vista.btnEliminarComida6.setEnabled(false);
		
		vista.btnRetirarBebida1.setEnabled(false);
		vista.btnRetirarBebida2.setEnabled(false);
		vista.btnRetirarBebida3.setEnabled(false);
		vista.btnRetirarBebida4.setEnabled(false);
	}
	
	private void iniciarPanelInformacionProductos(Producto producto) {
		vista.lbl_ImgFondoInfoProductos.setIcon(ajustarTamañoImg("src/img/fondoDetalles.png", vista.lbl_ImgFondoInfoProductos.getWidth(), vista.lbl_ImgFondoInfoProductos.getHeight()));
		vista.lbl_SalirInformacionProductos.setIcon(ajustarTamañoImg("src/img/volverAtras.png", vista.lbl_SalirInformacionProductos.getWidth(), vista.lbl_SalirInformacionProductos.getHeight()));
		vista.lbl_InfoNombreProducto.setText(producto.getNombre());
		vista.lbl_FotoProducto.setIcon(ajustarTamañoImg(producto.getImagenProducto().getDescription(), vista.lbl_FotoProducto.getWidth(), vista.lbl_FotoProducto.getHeight()));
		mostrarIngredientesTabla(producto.getIngredientes());
		vista.lbl_InfoProteinasProducto.setText(String.valueOf(producto.getProteinas()) + " g / 100 g");
		vista.lbl_InfoGrasasProducto.setText(String.valueOf(producto.getGrasas()) + " g / 100 g");
		vista.lbl_InfoCaloriasTotalesProducto.setText(String.valueOf(cacularTotalCalorias(producto.getIngredientes()))+ " kcal");
		
		vista.lbl_Ingredientes.setVisible(false);
		vista.tabla_Ingredientes.setVisible(false);
		vista.checkBox_MostrarTablaIngredientes.setSelected(false);
		vista.tabla_Ingredientes.getTableHeader().setVisible(false);
		vista.scrollPane_Ingredientes.setVisible(false);
	}
	
	private void mostrarIngredientesTabla(ArrayList<Ingrediente> ingredientes) {
		DefaultTableModel modeloTabla = (DefaultTableModel) vista.tabla_Ingredientes.getModel();
		modeloTabla.setRowCount(0);
		
		for(Ingrediente ingrediente:ingredientes) {
			String [] fila = {
				ingrediente.getNombreIngrediente(),
				String.valueOf(ingrediente.getCantidad()),
				ingrediente.getUnidad(),
				String.valueOf(ingrediente.getCaloriasPorUnidad()),
				String.valueOf(ingrediente.getCaloriasTotalesPorIngrediente())
			};
			modeloTabla.addRow(fila);
		}
		vista.tabla_Ingredientes.setModel(modeloTabla);
	}
	
	private double cacularTotalCalorias(ArrayList<Ingrediente> ingredientes) {
		double totalCalorias = 0;
		
		for(int i=0; i<ingredientes.size(); i++) {
			totalCalorias = totalCalorias + ingredientes.get(i).getCaloriasTotalesPorIngrediente();
		}
		return totalCalorias;
	}
	
	private Producto obtenerNombreProductoSeleccionado(String nombreBebida, ArrayList<Producto> bebidas) {
		Producto producto = null;
		
		for(Producto bebida: bebidas) {
			if(bebida.getNombre().equals(nombreBebida)) {
				producto = bebida;
			}
		}
		return producto;
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
		
		if(e.getClickCount()==2 && e.getSource()==vista.lbl_Salir) {
			vista.panel_DetallesEmpleado.setVisible(false);
			vista.panel_PantallaPrincipal.setVisible(true);
			vista.textArea_MensajeInformacionCambiosRealizados.setText("");
		}
		
		if(e.getClickCount()==1 && e.getSource()==vista.lbl_Detalles) {
			vista.panel_DetallesEmpleado.setVisible(true);
			vista.panel_PantallaPrincipal.setVisible(false);
			iniciarAppDetallesEmpleado();
			mostrarDetallesEmpleado();
		}
		
		if(e.getClickCount()==1) {
			if (e.getSource()==vista.lbl_Mesa1) {
				gestionarComandaMesaOTaburete("MESA 1");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa2) {
				gestionarComandaMesaOTaburete("MESA 2");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa3) {
				gestionarComandaMesaOTaburete("MESA 3");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa4) {
				gestionarComandaMesaOTaburete("MESA 4");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Mesa5) {
				gestionarComandaMesaOTaburete("MESA 5");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete1) {
				gestionarComandaMesaOTaburete("TABURETE 1");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete2) {
				gestionarComandaMesaOTaburete("TABURETE 2");
				seleccionarSeleccionBebidasPorDefecto();
			}else if (e.getSource()==vista.lbl_Taburete3) {
				gestionarComandaMesaOTaburete("TABURETE 3");
				seleccionarSeleccionBebidasPorDefecto();
			}
			if(e.getSource()==vista.lbl_SalirComandas) {
				vista.panel_PantallaPrincipal.setVisible(true);
				vista.panel_GestionComandas.setVisible(false);
			}
			if(e.getSource()==vista.lbl_SalirInformacionProductos) {
				vista.panel_InformacionProducto.setVisible(false);
				vista.panel_GestionComandas.setVisible(true);
			}
		}
		
		if(e.getClickCount()==1) {
			if(e.getSource()==vista.lbl_InformacionComida1) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(0));
			}else if(e.getSource()==vista.lbl_InformacionComida2) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(1));
			}else if(e.getSource()==vista.lbl_InformacionComida3) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(2));
			}else if(e.getSource()==vista.lbl_InformacionComida4) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(3));
			}else if(e.getSource()==vista.lbl_InformacionComida5) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(4));
			}else if(e.getSource()==vista.lbl_InformacionComida6) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				iniciarPanelInformacionProductos(comidas.get(5));
			}else if(e.getSource()==vista.lbl_InformacionBebida1) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				String cafeSeleccionado = vista.comboBox_TipoCafe.getSelectedItem().toString();
				Producto cafe = obtenerNombreProductoSeleccionado(cafeSeleccionado, cafes);
				iniciarPanelInformacionProductos(cafe);
			}else if(e.getSource()==vista.lbl_InformacionBebida2) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
				Producto batido = obtenerNombreProductoSeleccionado(batidoSeleccionado, batidos);
				iniciarPanelInformacionProductos(batido);
			}else if(e.getSource()==vista.lbl_InformacionBebida3) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				String refrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedItem().toString();
				Producto refresco = obtenerNombreProductoSeleccionado(refrescoSeleccionado, refrescos);
				iniciarPanelInformacionProductos(refresco);
			}else if(e.getSource()==vista.lbl_InformacionBebida4) {
				vista.panel_GestionComandas.setVisible(false);
				vista.panel_InformacionProducto.setVisible(true);
				String bebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
				Producto bebidaCalienteOFria = obtenerNombreProductoSeleccionado(bebidaSeleccionada, bebidasCalientesOFrias);
				iniciarPanelInformacionProductos(bebidaCalienteOFria);
			}
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