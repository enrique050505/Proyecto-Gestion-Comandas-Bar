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
import javax.swing.JLabel;
import javax.swing.JProgressBar;
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
	JLabel [] lblFotosComidas;
	JLabel [] lblNombresComidas;
	JLabel [] lblPreciosComidas;
	JLabel [] lblSimbolosEuroComidas;
	JLabel [] lbComidasAgotadas;
	JProgressBar [] progressBarsComidas;
	JButton [] botonesAñadirComidas;
	HashMap<String, JProgressBar> progressBarsProductos = new HashMap<>(); 
	Timer fechaYHora;
	Empleado empleadoActual;
	Comanda comandaActual;
	DefaultListModel<String> comanda = new DefaultListModel<>();
	DefaultListModel<String> productosInventario = new DefaultListModel<>();
	
	public ControladorCafeteria(InterfazApp vista) {
		this.vista = vista;
		this.vista.btnInicioSesion.addActionListener(this);
		this.vista.btn_GuardarCambios.addActionListener(this);
		this.vista.btn_Inventario.addActionListener(this);
		this.vista.btn_ConfirmarPrecioNuevo.addActionListener(this);
		this.vista.btn_IngresarStock.addActionListener(this);
		this.vista.btn_ReducirStock.addActionListener(this);
		
		//COMBOBOX
		this.vista.comboBox_Menu.addActionListener(this);
		this.vista.comboBox_TipoCafe.addActionListener(this);
		this.vista.comboBox_TipoBatido.addActionListener(this);
		this.vista.comboBox_TipoRefresco.addActionListener(this);
		this.vista.comboBox_TipoBebidaCalienteoFria.addActionListener(this);
		this.vista.comboBox_Inventario.addActionListener(this);
		
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
		this.vista.lbl_SalirInventario.addMouseListener(this);
		this.vista.list_ListaProductos.addMouseListener(this);
		
		this.vista.list_ListaPedidos.setModel(comanda);
		this.vista.list_ListaProductos.setModel(productosInventario);
		
		rellenarListaEmpleados(empleados);
		rellenarComidas(comidas);
		rellenarCafes(cafes);
		rellenarRefrescos(refrescos);
		rellenarBatidos(batidos);
		rellenarBebidasCalientesOFrias(bebidasCalientesOFrias);
		
		rellenarComboBoxBebidas();
		
		inicializarLugares();
		
		rellenarComboboxInventario();
		
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
				int indiceCafeSeleccionado = vista.comboBox_TipoCafe.getSelectedIndex();
				Producto cafeSeleccionado = cafes.get(indiceCafeSeleccionado);
				
				if(cafeSeleccionado.getCantidadStock()>0) {
					vista.btnAñadirBebida1.setEnabled(true);
					vista.lbl_CafeAgotado.setVisible(false);
				}else {
					vista.btnAñadirBebida1.setEnabled(false);
					vista.lbl_CafeAgotado.setVisible(true);
					vista.lbl_CafeAgotado.setIcon(ajustarTamañoImg("src/img/sin stock.png", vista.lbl_CafeAgotado.getWidth(), vista.lbl_CafeAgotado.getHeight()));
				}
				
				vista.btnRetirarBebida1.setEnabled(comprobarBebidaComanda(cafeSeleccionado.getNombre()));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoBatido) {
			mostrarInformacionBatidoSeleccionado();
			
			if(vista.comboBox_TipoBatido.getSelectedIndex()==0) {
				vista.btnAñadirBebida2.setEnabled(false);
				vista.btnRetirarBebida2.setEnabled(false);
			}else {
				vista.btnAñadirBebida2.setEnabled(true);
				int indiceBatidoSeleccionado = vista.comboBox_TipoBatido.getSelectedIndex();
				Producto batidoSeleccionado = batidos.get(indiceBatidoSeleccionado);
				
				if(batidoSeleccionado.getCantidadStock()>0) {
					vista.btnAñadirBebida2.setEnabled(true);
					vista.lbl_BatidoAgotado.setVisible(false);
				}else {
					vista.btnAñadirBebida2.setEnabled(false);
					vista.lbl_BatidoAgotado.setVisible(true);
					vista.lbl_BatidoAgotado.setIcon(ajustarTamañoImg("src/img/sin stock.png", vista.lbl_BatidoAgotado.getWidth(), vista.lbl_BatidoAgotado.getHeight()));
				}
				
				vista.btnRetirarBebida2.setEnabled(comprobarBebidaComanda(batidoSeleccionado.getNombre()));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoRefresco) {
			mostrarInformacionRefrescoSeleccionado();
			
			if(vista.comboBox_TipoRefresco.getSelectedIndex()==0) {
				vista.btnAñadirBebida3.setEnabled(false);
				vista.btnRetirarBebida3.setEnabled(false);
			}else {
				vista.btnAñadirBebida3.setEnabled(true);
				int indiceRefrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedIndex();
				Producto refrescoSeleccionado = refrescos.get(indiceRefrescoSeleccionado);
				
				if(refrescoSeleccionado.getCantidadStock()>0) {
					vista.btnAñadirBebida3.setEnabled(true);
					vista.lbl_RefrescoAgotado.setVisible(false);
				}else {
					vista.btnAñadirBebida3.setEnabled(false);
					vista.lbl_RefrescoAgotado.setVisible(true);
					vista.lbl_RefrescoAgotado.setIcon(ajustarTamañoImg("src/img/sin stock.png", vista.lbl_RefrescoAgotado.getWidth(), vista.lbl_RefrescoAgotado.getHeight()));
				}
				
				vista.btnRetirarBebida3.setEnabled(comprobarBebidaComanda(refrescoSeleccionado.getNombre()));
			}
		}
		
		if(e.getSource()==vista.comboBox_TipoBebidaCalienteoFria) {
			mostrarInformacionBebidaCalienteOFriaSeleccionada();
			
			if(vista.comboBox_TipoBebidaCalienteoFria.getSelectedIndex()==0) {
				vista.btnAñadirBebida4.setEnabled(false);
				vista.btnRetirarBebida4.setEnabled(false);
			}else {
				vista.btnAñadirBebida4.setEnabled(true);
				int indiceBebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedIndex();
				Producto bebidaSeleccionada = bebidasCalientesOFrias.get(indiceBebidaSeleccionada);
				
				if(bebidaSeleccionada.getCantidadStock()>0) {
					vista.btnAñadirBebida4.setEnabled(true);
					vista.lbl_BebidaCalienteOFriaAgotada.setVisible(false);
				}else {
					vista.btnAñadirBebida4.setEnabled(false);
					vista.lbl_BebidaCalienteOFriaAgotada.setVisible(true);
					vista.lbl_BebidaCalienteOFriaAgotada.setIcon(ajustarTamañoImg("src/img/sin stock.png", vista.lbl_BebidaCalienteOFriaAgotada.getWidth(), vista.lbl_BebidaCalienteOFriaAgotada.getHeight()));
				}
				
				vista.btnRetirarBebida4.setEnabled(comprobarBebidaComanda(bebidaSeleccionada.getNombre()));
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
		}
		
		if(e.getSource()==vista.btnRetirarBebida2) {
			String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
			retirarBebidas(batidos, batidoSeleccionado);
		}
		
		if(e.getSource()==vista.btnRetirarBebida3) {
			String refrescoSeleccionado= vista.comboBox_TipoRefresco.getSelectedItem().toString();
			retirarBebidas(refrescos, refrescoSeleccionado);
		}
		
		if(e.getSource()==vista.btnRetirarBebida4) {
			String bebidaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
			retirarBebidas(bebidasCalientesOFrias, bebidaSeleccionada);
		}
		
		//CHECKBOX
		if(e.getSource()==vista.checkBox_MostrarTablaIngredientes) {
			boolean mostrarTabla = vista.checkBox_MostrarTablaIngredientes.isSelected();
			vista.lbl_Ingredientes.setVisible(mostrarTabla);
			vista.tabla_Ingredientes.setVisible(mostrarTabla);
			vista.checkBox_MostrarTablaIngredientes.setSelected(mostrarTabla);
			vista.tabla_Ingredientes.getTableHeader().setVisible(mostrarTabla);
			vista.scrollPane_Ingredientes.setVisible(mostrarTabla);
		}
		
		//INVENTARIO
		if(e.getSource()==vista.btn_Inventario) {
			vista.panel_PantallaPrincipal.setVisible(false);
			vista.panel_Inventario.setVisible(true);
			iniciarInventario();
		}
		
		if(e.getSource()==vista.comboBox_Inventario) {
			String tipoProducto = vista.comboBox_Inventario.getSelectedItem().toString();
			actualizarJlistInventario(tipoProducto);
		}
		
		if(e.getSource()==vista.btn_IngresarStock) {
			ingresarStockInventario();
		}
		
		if(e.getSource()==vista.btn_ReducirStock) {
			reducirStockInventario();
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
		vista.lbl_ComprobacionMesa1.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa1.getWidth(),vista.lbl_ComprobacionMesa1.getHeight()));
		vista.lbl_ComprobacionMesa2.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa2.getWidth(),vista.lbl_ComprobacionMesa2.getHeight()));
		vista.lbl_ComprobacionMesa3.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa3.getWidth(),vista.lbl_ComprobacionMesa3.getHeight()));
		vista.lbl_ComprobacionMesa4.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa4.getWidth(),vista.lbl_ComprobacionMesa4.getHeight()));
		vista.lbl_ComprobacionMesa5.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa5.getWidth(),vista.lbl_ComprobacionMesa5.getHeight()));
		vista.lbl_ComprobacionTaburete1.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete1.getWidth(),vista.lbl_ComprobacionTaburete1.getHeight()));
		vista.lbl_ComprobacionTaburete2.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete2.getWidth(),vista.lbl_ComprobacionTaburete2.getHeight()));
		vista.lbl_ComprobacionTaburete3.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete3.getWidth(),vista.lbl_ComprobacionTaburete3.getHeight()));
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
		
		if(!comprobarTelefonoValido(telefono)) {
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
	
	private boolean comprobarTelefonoValido(String telefono) {
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
		comidas.add(new Producto(new ImageIcon("src/img/bizcocho.png"), 3.50, "Bizcocho", rellenarIngredientesComidas(0), 5, 20, 40));
		comidas.add(new Producto(new ImageIcon("src/img/napolitana.png"), 1.80, "Napolitana", rellenarIngredientesComidas(1), 6, 25, 32));
		comidas.add(new Producto(new ImageIcon("src/img/croissant.png"), 1.50, "Croissant", rellenarIngredientesComidas(2), 7, 25, 35));
		comidas.add(new Producto(new ImageIcon("src/img/brazo de gitano.png"), 3.25, "Brazo de gitano", rellenarIngredientesComidas(3), 5, 18.5, 25));
		comidas.add(new Producto(new ImageIcon("src/img/milhojas de crema.png"), 2.50, "Milhojas de crema", rellenarIngredientesComidas(4), 6, 25, 32));
		comidas.add(new Producto(new ImageIcon("src/img/tarta de queso.png"), 3.50, "Tarta de queso", rellenarIngredientesComidas(5), 6.5, 28, 28));
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
	
	private void inicializarComponentesComidas() {
		lblFotosComidas = new JLabel [] {vista.lbl_Comida1, vista.lbl_Comida2, vista.lbl_Comida3, vista.lbl_Comida4, vista.lbl_Comida5, vista.lbl_Comida6};
		lblNombresComidas = new JLabel [] {vista.lbl_NombreComida1, vista.lbl_NombreComida2, vista.lbl_NombreComida3, vista.lbl_NombreComida4, vista.lbl_NombreComida5, vista.lbl_NombreComida6};
		lblPreciosComidas = new JLabel [] {vista.lbl_PrecioComida1, vista.lbl_PrecioComida2, vista.lbl_PrecioComida3, vista.lbl_PrecioComida4, vista.lbl_PrecioComida5, vista.lbl_PrecioComida6};
		lblSimbolosEuroComidas =  new JLabel [] {vista.lbl_SimboloEuroComida1, vista.lbl_SimboloEuroComida2, vista.lbl_SimboloEuroComida3, vista.lbl_SimboloEuroComida4, vista.lbl_SimboloEuroComida5, vista.lbl_SimboloEuroComida6};
		progressBarsComidas = new JProgressBar [] {vista.progressBar_Comida1, vista.progressBar_Comida2, vista.progressBar_Comida3, vista.progressBar_Comida4, vista.progressBar_Comida5, vista.progressBar_Comida6};
		lbComidasAgotadas = new JLabel [] {vista.lbl_Comida1Agotada, vista.lbl_Comida2Agotada, vista.lbl_Comida3Agotada, vista.lbl_Comida4Agotada, vista.lbl_Comida5Agotada, vista.lbl_Comida6Agotada};
		botonesAñadirComidas = new JButton [] {vista.btnAñadirComida1, vista.btnAñadirComida2, vista.btnAñadirComida3, vista.btnAñadirComida4, vista.btnAñadirComida5, vista.btnAñadirComida6};
	}
	
	private void mostrarComidas() {
		inicializarComponentesComidas();
		
		for(int i=0; i<comidas.size(); i++) {
			Producto comida = comidas.get(i);
			
			lblFotosComidas[i].setIcon(ajustarTamañoImg(comida.getImagenProducto().getDescription(), lblFotosComidas[i].getWidth(), lblFotosComidas[i].getHeight()));
			lblNombresComidas[i].setText(comida.getNombre());
			lblPreciosComidas[i].setText(String.valueOf(comida.getPrecio()));
			lblSimbolosEuroComidas[i].setIcon(ajustarTamañoImg("src/img/euro.png", lblSimbolosEuroComidas[i].getWidth(), lblSimbolosEuroComidas[i].getHeight()));
			progressBarsComidas[i].setMaximum(comida.getCantidadStock());
			progressBarsComidas[i].setValue(comida.getCantidadStock());
		}
	}
	
	private void rellenarCafes(ArrayList<Producto> cafes) {
		cafes.add(new Producto(new ImageIcon("src/img/cafe.png"), 0.00, "Cafés", null, 0, 0, 0));
		cafes.add(new Producto(new ImageIcon("src/img/cafe con leche.png"), 1.30, "Café con leche", rellenarIngredientesCafes(0), 3.3, 3.2, 100));
		cafes.add(new Producto(new ImageIcon("src/img/capuccino.png"), 1.80, "Capuccino", rellenarIngredientesCafes(1), 5, 4.4, 60));
		cafes.add(new Producto(new ImageIcon("src/img/cafe americano.png"), 1.40, "Café Americano", rellenarIngredientesCafes(2), 0.2, 0.1, 85));
		cafes.add(new Producto(new ImageIcon("src/img/cafe bombon.png"), 1.90, "Café Bombón", rellenarIngredientesCafes(3), 2.6, 3.4, 90));
		cafes.add(new Producto(new ImageIcon("src/img/cafe cortado.png"), 1.25, "Café Cortado", rellenarIngredientesCafes(4), 1.2, 1.1, 45));
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
		refrescos.add(new Producto(new ImageIcon("src/img/refresco.png"), 0.00, "Refrescos", null, 0, 0, 0));
		refrescos.add(new Producto(new ImageIcon("src/img/agua.png"), 1.00, "Agua", rellenarIngredientesRefrescos(0), 0, 0, 45));
		refrescos.add(new Producto(new ImageIcon("src/img/aquarius.png"), 1.75, "Aquarius Limón", rellenarIngredientesRefrescos(1), 0.2, 0, 32));
		refrescos.add(new Producto(new ImageIcon("src/img/fanta de naranja.png"), 1.75, "Fanta Naranja", rellenarIngredientesRefrescos(2), 0, 0, 30));
		refrescos.add(new Producto(new ImageIcon("src/img/nestea.png"), 1.60, "Nestea", rellenarIngredientesRefrescos(3), 0.1, 0, 25));
		refrescos.add(new Producto(new ImageIcon("src/img/coca cola.png"), 1.90, "Coca-Cola", rellenarIngredientesRefrescos(4), 0, 0, 40));
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
		batidos.add(new Producto(new ImageIcon("src/img/batido.png"), 0.00, "Batidos", null, 0, 0, 0));
		batidos.add(new Producto(new ImageIcon("src/img/batido de chocolate.png"), 3.00, "Batido Chocolate", rellenarIngredientesBatidos(0), 8, 10, 30));
		batidos.add(new Producto(new ImageIcon("src/img/batido de fresa.png"), 3.00, "Batido Fresa", rellenarIngredientesBatidos(1), 7, 8, 30));
		batidos.add(new Producto(new ImageIcon("src/img/batido de oreo.png"), 3.50, "Batido Oreo", rellenarIngredientesBatidos(2), 8, 12, 25));
		batidos.add(new Producto(new ImageIcon("src/img/batido de vainilla.png"), 3.00, "Batido Vainilla", rellenarIngredientesBatidos(3), 7, 8, 20));
		batidos.add(new Producto(new ImageIcon("src/img/batido de mango.png"), 3.25, "Batido Mango", rellenarIngredientesBatidos(4), 6, 8, 15));
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
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/bebida caliente.png"), 0.00, "Bebidas Mixtas", null, 0, 0, 0));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/chocolate caliente.png"), 3.00, "Chocolate caliente", rellenarIngredientesBebidasCalientesOFrias(0), 4, 8, 30));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/te de menta.png"), 1.60, "Té de menta", rellenarIngredientesBebidasCalientesOFrias(1), 1, 0, 20));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/te de frutos rojos.png"), 2.20, "Té de frutos rojos", rellenarIngredientesBebidasCalientesOFrias(2), 1.5, 0, 18));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/horchata.png"), 2.00, "Horchata", rellenarIngredientesBebidasCalientesOFrias(3), 1.5, 4, 22));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/limonada.png"), 2.00, "Limonada", rellenarIngredientesBebidasCalientesOFrias(4), 0, 0, 25));
		bebidasCalientesOFrias.add(new Producto(new ImageIcon("src/img/infusion de canela y manzana.png"), 2.75, "Infusión", rellenarIngredientesBebidasCalientesOFrias(5), 1, 0, 15));
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
	
	private void rellenarComboBoxBebidas() {
		//COMBOBOX CAFES
		for(int i=0; i<cafes.size(); i++) {
			vista.comboBox_TipoCafe.addItem(cafes.get(i).getNombre());
		}
		
		//COMBOBOX BATIDOS
		for(int i=0; i<batidos.size(); i++) {
			vista.comboBox_TipoBatido.addItem(batidos.get(i).getNombre());
		}
		
		//COMBOBOX REFRESCOS
		for(int i=0; i<refrescos.size(); i++) {
			vista.comboBox_TipoRefresco.addItem(refrescos.get(i).getNombre());
		}
		
		//COMBOBOX BEBIDAS CALIENTES O FRIAS
		for(int i=0; i<bebidasCalientesOFrias.size(); i++) {
			vista.comboBox_TipoBebidaCalienteoFria.addItem(bebidasCalientesOFrias.get(i).getNombre());
		}
	}
	
	private void mostrarInformacionCafeSeleccionado() {
		String cafeSeleccionado = vista.comboBox_TipoCafe.getSelectedItem().toString();
		
		if(cafeSeleccionado.equals(cafes.get(0).getNombre())) {
			vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(0).getImagenProducto().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
			vista.lbl_PrecioCafe.setText(null);
			vista.lbl_IconoEuro1.setIcon(null);
			vista.lbl_InformacionBebida1.setIcon(null);
			vista.progressBar_Bebida1.setMaximum(0);
			vista.progressBar_Bebida1.setValue(0);
		}else {
			for(int i=1; i<cafes.size(); i++) {
				if(cafes.get(i).getNombre().equals(cafeSeleccionado)) {
					vista.lbl_Cafe.setIcon(ajustarTamañoImg(cafes.get(i).getImagenProducto().getDescription(), vista.lbl_Cafe.getWidth(), vista.lbl_Cafe.getHeight()));
					vista.lbl_PrecioCafe.setText(String.valueOf(cafes.get(i).getPrecio()));
					vista.lbl_IconoEuro1.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro1.getWidth(), vista.lbl_IconoEuro1.getHeight()));
					vista.lbl_InformacionBebida1.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida1.getWidth(), vista.lbl_InformacionBebida1.getHeight()));
					vista.progressBar_Bebida1.setMaximum(cafes.get(i).getCantidadStock());
					vista.progressBar_Bebida1.setValue(cafes.get(i).getCantidadStock());
				}
			}
		}	
	}//MOSTRAR INFORMACION CAFE SELECCIONADO

	private void mostrarInformacionBatidoSeleccionado() {
		String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
		
		if(batidoSeleccionado.equals(batidos.get(0).getNombre())) {
			vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(0).getImagenProducto().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
			vista.lbl_PrecioBatido.setText(null);
			vista.lbl_IconoEuro2.setIcon(null);
			vista.lbl_InformacionBebida2.setIcon(null);
			vista.progressBar_Bebida2.setMaximum(0);
			vista.progressBar_Bebida2.setValue(0);
		}else {
			for(int i=1; i<batidos.size(); i++) {
				if(batidos.get(i).getNombre().equals(batidoSeleccionado)) {
					vista.lbl_Batido.setIcon(ajustarTamañoImg(batidos.get(i).getImagenProducto().getDescription(), vista.lbl_Batido.getWidth(), vista.lbl_Batido.getHeight()));
					vista.lbl_PrecioBatido.setText(String.valueOf(batidos.get(i).getPrecio()));
					vista.lbl_IconoEuro2.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro2.getWidth(), vista.lbl_IconoEuro2.getHeight()));
					vista.lbl_InformacionBebida2.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida2.getWidth(), vista.lbl_InformacionBebida2.getHeight()));
					vista.progressBar_Bebida2.setMaximum(batidos.get(i).getCantidadStock());
					vista.progressBar_Bebida2.setValue(batidos.get(i).getCantidadStock());
				}
			}
		}	
	}//MOSTRAR INFORMACION BATIDO SELECCIONADO
	
	private void mostrarInformacionRefrescoSeleccionado() {
		String refrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedItem().toString();
		
		if(refrescoSeleccionado.equals(refrescos.get(0).getNombre())) {
			vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(0).getImagenProducto().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
			vista.lbl_PrecioRefresco.setText(null);
			vista.lbl_IconoEuro3.setIcon(null);
			vista.lbl_InformacionBebida3.setIcon(null);
			vista.progressBar_Bebida3.setMaximum(0);
			vista.progressBar_Bebida3.setValue(0);
		}else {
			for(int i=1; i<refrescos.size(); i++) {
				if(refrescos.get(i).getNombre().equals(refrescoSeleccionado)) {
					vista.lbl_Refresco.setIcon(ajustarTamañoImg(refrescos.get(i).getImagenProducto().getDescription(), vista.lbl_Refresco.getWidth(), vista.lbl_Refresco.getHeight()));
					vista.lbl_PrecioBebidaVariada.setText(String.valueOf(refrescos.get(i).getPrecio()));
					vista.lbl_IconoEuro3.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro3.getWidth(), vista.lbl_IconoEuro3.getHeight()));
					vista.lbl_InformacionBebida3.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida3.getWidth(), vista.lbl_InformacionBebida3.getHeight()));
					vista.progressBar_Bebida3.setMaximum(refrescos.get(i).getCantidadStock());
					vista.progressBar_Bebida3.setValue(refrescos.get(i).getCantidadStock());
				}
			}
		}	
	}//MOSTRAR INFORMACION REFRESCO SELECCIONADO
	
	private void mostrarInformacionBebidaCalienteOFriaSeleccionada() {
		String bebidaMixta = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
		
		if(bebidaMixta.equals(bebidasCalientesOFrias.get(0).getNombre())) {
			vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(0).getImagenProducto().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
			vista.lbl_PrecioBebidaVariada.setText(null);
			vista.lbl_IconoEuro4.setIcon(null);
			vista.lbl_InformacionBebida4.setIcon(null);
			vista.progressBar_Bebida4.setMaximum(0);
			vista.progressBar_Bebida4.setValue(0);
		}else {
			for(int i=1; i<bebidasCalientesOFrias.size(); i++) {
				if(bebidasCalientesOFrias.get(i).getNombre().equals(bebidaMixta)) {
					vista.lbl_BebidaCalienteoFria.setIcon(ajustarTamañoImg(bebidasCalientesOFrias.get(i).getImagenProducto().getDescription(), vista.lbl_BebidaCalienteoFria.getWidth(), vista.lbl_BebidaCalienteoFria.getHeight()));
					vista.lbl_PrecioBebidaVariada.setText(String.valueOf(bebidasCalientesOFrias.get(i).getPrecio()));
					vista.lbl_IconoEuro4.setIcon(ajustarTamañoImg("src/img/euro.png", vista.lbl_IconoEuro4.getWidth(), vista.lbl_IconoEuro4.getHeight()));
					vista.lbl_InformacionBebida4.setIcon(ajustarTamañoImg("src/img/informacion.png", vista.lbl_InformacionBebida4.getWidth(), vista.lbl_InformacionBebida4.getHeight()));
					vista.progressBar_Bebida4.setMaximum(bebidasCalientesOFrias.get(i).getCantidadStock());
					vista.progressBar_Bebida4.setValue(bebidasCalientesOFrias.get(i).getCantidadStock());
				}
			}
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
		lugares.add(new Lugar("MESA 1"));
		lugares.add(new Lugar("MESA 2"));
		lugares.add(new Lugar("MESA 3"));
		lugares.add(new Lugar("MESA 4"));
		lugares.add(new Lugar("MESA 5"));
		lugares.add(new Lugar("TABURETE 1"));
		lugares.add(new Lugar("TABURETE 2"));
		lugares.add(new Lugar("TABURETE 3"));
	}
	
	private Lugar buscarLugar(String nombre) {
		Lugar lugarEncontrado = null;
		for(int i=0; i<lugares.size(); i++) {
			if(lugares.get(i).getNombreLugar().equals(nombre)) {
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
			
			actualizarIconoDisponibilidadLugares(lugarElegido);
		}
	}
	
	private void actualizarIconoDisponibilidadLugares(Lugar lugar) {
		if(lugar.obtenerComanda(1) != null && !lugar.obtenerComanda(1).getProductos().isEmpty()) {
			switch(lugar.getNombreLugar()) {
			case "MESA 1":
				vista.lbl_ComprobacionMesa1.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionMesa1.getHeight(), vista.lbl_ComprobacionMesa1.getWidth()));
				break;
			case "MESA 2":
				vista.lbl_ComprobacionMesa2.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionMesa2.getHeight(), vista.lbl_ComprobacionMesa2.getWidth()));
				break;
			case "MESA 3":
				vista.lbl_ComprobacionMesa3.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionMesa3.getHeight(), vista.lbl_ComprobacionMesa3.getWidth()));
				break;
			case "MESA 4":
				vista.lbl_ComprobacionMesa4.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionMesa4.getHeight(), vista.lbl_ComprobacionMesa4.getWidth()));
				break;
			case "MESA 5":
				vista.lbl_ComprobacionMesa5.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionMesa5.getHeight(), vista.lbl_ComprobacionMesa5.getWidth()));
				break;
			case "TABURETE 1":
				vista.lbl_ComprobacionTaburete1.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionTaburete1.getHeight(), vista.lbl_ComprobacionTaburete1.getWidth()));
				break;
			case "TABURETE 2":
				vista.lbl_ComprobacionTaburete2.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionTaburete2.getHeight(), vista.lbl_ComprobacionTaburete2.getWidth()));
				break;
			case "TABURETE 3":
				vista.lbl_ComprobacionTaburete3.setIcon(ajustarTamañoImg("src/img/ocupado.png", vista.lbl_ComprobacionTaburete3.getHeight(), vista.lbl_ComprobacionTaburete3.getWidth()));
				break;
			default:
				break;
			}
		}else {
			switch(lugar.getNombreLugar()) {
			case "MESA 1":
				vista.lbl_ComprobacionMesa1.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa1.getHeight(), vista.lbl_ComprobacionMesa1.getWidth()));
				break;
			case "MESA 2":
				vista.lbl_ComprobacionMesa2.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa2.getHeight(), vista.lbl_ComprobacionMesa2.getWidth()));
				break;
			case "MESA 3":
				vista.lbl_ComprobacionMesa3.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa3.getHeight(), vista.lbl_ComprobacionMesa3.getWidth()));
				break;
			case "MESA 4":
				vista.lbl_ComprobacionMesa4.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa4.getHeight(), vista.lbl_ComprobacionMesa4.getWidth()));
				break;
			case "MESA 5":
				vista.lbl_ComprobacionMesa5.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionMesa5.getHeight(), vista.lbl_ComprobacionMesa5.getWidth()));
				break;
			case "TABURETE 1":
				vista.lbl_ComprobacionTaburete1.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete1.getHeight(), vista.lbl_ComprobacionTaburete1.getWidth()));
				break;
			case "TABURETE 2":
				vista.lbl_ComprobacionTaburete2.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete2.getHeight(), vista.lbl_ComprobacionTaburete2.getWidth()));
				break;
			case "TABURETE 3":
				vista.lbl_ComprobacionTaburete3.setIcon(ajustarTamañoImg("src/img/disponible.png", vista.lbl_ComprobacionTaburete3.getHeight(), vista.lbl_ComprobacionTaburete3.getWidth()));
				break;
			default:
				break;
			}
		}
	}
	
	private void actualizarIconosLugares() {
		actualizarIconoDisponibilidadLugares(buscarLugar("MESA 1"));
		actualizarIconoDisponibilidadLugares(buscarLugar("MESA 2"));
		actualizarIconoDisponibilidadLugares(buscarLugar("MESA 3"));
		actualizarIconoDisponibilidadLugares(buscarLugar("MESA 4"));
		actualizarIconoDisponibilidadLugares(buscarLugar("MESA 5"));
		actualizarIconoDisponibilidadLugares(buscarLugar("TABURETE 1"));
		actualizarIconoDisponibilidadLugares(buscarLugar("TABURETE 2"));
		actualizarIconoDisponibilidadLugares(buscarLugar("TABURETE 3"));
	}
	
	private void añadirComidasAComanda(String nombreComida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<comidas.size(); i++) {
			if(comidas.get(i).getNombre().equals(nombreComida)) {
				
				if(comidas.get(i).getCantidadStock()>0) {
					comidas.get(i).setCantidadStock(comidas.get(i).getCantidadStock()-1);
					precio = comidas.get(i).getPrecio();
					
					actualizarStockBarraProgreso(progressBarsComidas[i], comidas.get(i).getCantidadStock(), comidas.get(i).getStockMaximo());
					
					comandaActual.añadirProducto(nombreComida, precio);
					
					lbComidasAgotadas[i].setVisible(false);
					
					if(comidas.get(i).getCantidadStock()==0) {
						botonesAñadirComidas[i].setEnabled(false);
						lbComidasAgotadas[i].setVisible(true);
						lbComidasAgotadas[i].setIcon(ajustarTamañoImg("src/img/sin stock.png", lbComidasAgotadas[i].getWidth(), lbComidasAgotadas[i].getHeight()));
					}
				}
			}
		}
		
		actualizarComanda(comandaActual);
	}
	
	private void eliminarComidaDeComanda(String nombreComida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		for(int i=0; i<comidas.size(); i++) {
			if(comidas.get(i).getNombre().equals(nombreComida)) {
				comidas.get(i).setCantidadStock(comidas.get(i).getCantidadStock()+1);
				precio = comidas.get(i).getPrecio();
				
				actualizarStockBarraProgreso(progressBarsComidas[i], comidas.get(i).getCantidadStock(), comidas.get(i).getStockMaximo());
				
				if(comidas.get(i).getCantidadStock()>0) {
					lbComidasAgotadas[i].setVisible(false);
					botonesAñadirComidas[i].setEnabled(true);
				}
			}
		}
		
		comandaActual.eliminarProducto(nombreComida, precio);

		actualizarComanda(comandaActual);
	}
	
	private void añadirBebidasAComanda(String nombreBebida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		precio = reducirStockBebida(nombreBebida, cafes, vista.progressBar_Bebida1, vista.lbl_CafeAgotado, vista.btnAñadirBebida1);
		if(precio>0.0) {
			comandaActual.añadirProducto(nombreBebida, precio);
		}
		
		precio = reducirStockBebida(nombreBebida, batidos, vista.progressBar_Bebida2, vista.lbl_BatidoAgotado, vista.btnAñadirBebida2);
		if(precio>0.0) {
			comandaActual.añadirProducto(nombreBebida, precio);
		}
		
		precio = reducirStockBebida(nombreBebida, refrescos, vista.progressBar_Bebida3, vista.lbl_RefrescoAgotado, vista.btnAñadirBebida3);
		if(precio>0.0) {
			comandaActual.añadirProducto(nombreBebida, precio);
		}
		
		precio = reducirStockBebida(nombreBebida, bebidasCalientesOFrias, vista.progressBar_Bebida4, vista.lbl_BebidaCalienteOFriaAgotada, vista.btnAñadirBebida4);
		if(precio>0.0) {
			comandaActual.añadirProducto(nombreBebida, precio);
		}
		
		actualizarComanda(comandaActual);
	}
	
	private double reducirStockBebida(String nombreBebida, ArrayList<Producto> bebidas, JProgressBar progressBarBebida, JLabel lblAgotado, JButton btnAñadirBebida) {
		double precio = 0.0;
		
		for(int i=0; i<bebidas.size(); i++) {
			if(bebidas.get(i).getNombre().equals(nombreBebida)) {
				if(bebidas.get(i).getCantidadStock()>0) {
					bebidas.get(i).setCantidadStock(bebidas.get(i).getCantidadStock()-1);
					precio = bebidas.get(i).getPrecio();
				}
				
				actualizarStockBarraProgreso(progressBarBebida, bebidas.get(i).getCantidadStock(), bebidas.get(i).getStockMaximo());
				if(bebidas.get(i).getCantidadStock()==0) {
					lblAgotado.setVisible(true);
					lblAgotado.setIcon(ajustarTamañoImg("src/img/sin stock.png", lblAgotado.getWidth(), lblAgotado.getHeight()));
					btnAñadirBebida.setEnabled(false);
				}else {
					lblAgotado.setVisible(false);
					lblAgotado.setIcon(null);
					btnAñadirBebida.setEnabled(true);
				}
			}
		}
		
		return precio;
	}
	
	private void eliminarBebidaDeComanda(String nombreBebida) {
		Lugar lugarElegido = buscarLugar(vista.lbl_Mesa_o_Taburete.getText());
		Comanda comandaActual = lugarElegido.obtenerComanda(1);
		double precio = 0.0;
		
		precio = añadirStockBebida(nombreBebida, cafes, vista.progressBar_Bebida1, vista.lbl_CafeAgotado, vista.btnAñadirBebida1);
		if(precio>0.0) {
			comandaActual.eliminarProducto(nombreBebida, precio);
		}
		
		precio = añadirStockBebida(nombreBebida, batidos, vista.progressBar_Bebida2, vista.lbl_BatidoAgotado, vista.btnAñadirBebida2);
		if(precio>0.0) {
			comandaActual.eliminarProducto(nombreBebida, precio);
		}
		
		precio = añadirStockBebida(nombreBebida, refrescos, vista.progressBar_Bebida3, vista.lbl_RefrescoAgotado, vista.btnAñadirBebida3);
		if(precio>0.0) {
			comandaActual.eliminarProducto(nombreBebida, precio);
		}
		
		precio = añadirStockBebida(nombreBebida, bebidasCalientesOFrias, vista.progressBar_Bebida4, vista.lbl_BebidaCalienteOFriaAgotada, vista.btnAñadirBebida4);
		if(precio>0.0) {
			comandaActual.eliminarProducto(nombreBebida, precio);
		}
		
		actualizarComanda(comandaActual);
	}

	private double añadirStockBebida(String nombreBebida, ArrayList<Producto> bebidas, JProgressBar progressBarBebida, JLabel lblAgotado, JButton btn_AñadirBebida) {
		double precio = 0.0;
		
		for(int i=0; i<bebidas.size(); i++) {
			if(bebidas.get(i).getNombre().equals(nombreBebida)) {
				bebidas.get(i).setCantidadStock(bebidas.get(i).getCantidadStock()+1);
				precio = bebidas.get(i).getPrecio();
				actualizarStockBarraProgreso(progressBarBebida, bebidas.get(i).getCantidadStock(), bebidas.get(i).getStockMaximo());
				btn_AñadirBebida.setEnabled(true);
				lblAgotado.setVisible(false);
			}
		}
		
		return precio;
	}
	
	private void actualizarComanda(Comanda comandaActual) {
		comanda.clear();
		
		deshabilitarBotones();
		
		HashMap<String, Integer> productos = comandaActual.getProductos();
		
		for(Map.Entry<String, Integer> entrada :productos.entrySet()) {
			comanda.addElement(entrada.getKey() + " ~> " + entrada.getValue());
		}
		
		vista.lbl_PrecioTotalComanda.setText("TOTAL: " + comandaActual.getPrecioTotal() + "€");
		
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
			
			String cafeSeleccionado = vista.comboBox_TipoCafe.getSelectedItem().toString();
			if(entrada.getKey().equals(cafeSeleccionado)) {
				vista.btnRetirarBebida1.setEnabled(true);
			}
			
			String batidoSeleccionado = vista.comboBox_TipoBatido.getSelectedItem().toString();
			if(entrada.getKey().equals(batidoSeleccionado)) {
				vista.btnRetirarBebida2.setEnabled(true);
			}
			
			String refrescoSeleccionado = vista.comboBox_TipoRefresco.getSelectedItem().toString();
			if(entrada.getKey().equals(refrescoSeleccionado)) {
				vista.btnRetirarBebida3.setEnabled(true);
			}
			
			String bebidaCalienteOFriaSeleccionada = vista.comboBox_TipoBebidaCalienteoFria.getSelectedItem().toString();
			if(entrada.getKey().equals(bebidaCalienteOFriaSeleccionada)) {
				vista.btnRetirarBebida4.setEnabled(true);
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
	
	private void actualizarStockBarraProgreso(JProgressBar progressBar, int cantidadStock, int stockMaximo) {
		progressBar.setMaximum(stockMaximo);
		progressBar.setValue(cantidadStock);
		
		System.out.println("Maximo: " + progressBar.getMaximum() + " Valor: " + progressBar.getValue());
		if(cantidadStock > 0.75 *progressBar.getMaximum()) {
			progressBar.setForeground(Color.GREEN);
		}else if (cantidadStock > 0.25* progressBar.getMaximum()) {
			progressBar.setForeground(Color.YELLOW);
		}else {
			progressBar.setForeground(Color.RED);
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
		
	private void iniciarInventario() {
		vista.lbl_FondoInventario.setIcon(ajustarTamañoImg("src/img/fondoPrincipalApp.png", vista.lbl_FondoInventario.getWidth(), vista.lbl_FondoInventario.getHeight()));
		vista.lbl_SalirInventario.setIcon(ajustarTamañoImg("src/img/volverAtras.png", vista.lbl_SalirInventario.getWidth(), vista.lbl_SalirInventario.getHeight()));
	}
	
	private void rellenarComboboxInventario() {
		vista.comboBox_Inventario.addItem("Tipo de Productos");
		vista.comboBox_Inventario.addItem("Comidas");
		vista.comboBox_Inventario.addItem("Cafés");
		vista.comboBox_Inventario.addItem("Batidos");
		vista.comboBox_Inventario.addItem("Refrescos");
		vista.comboBox_Inventario.addItem("Bebidas Mixtas");
	}
	
	private void actualizarJlistInventario(String eleccion) {
		productosInventario.clear();
		
		switch(eleccion) {
			case "Comidas":
				for(int i=0; i<comidas.size(); i++){
					productosInventario.addElement(comidas.get(i).getNombre());
				}
				break;
			case "Cafés":
				for(int i=1; i<cafes.size(); i++){
					productosInventario.addElement(cafes.get(i).getNombre());
				}
				break;
			case "Batidos":
				for(int i=1; i<batidos.size(); i++){
					productosInventario.addElement(batidos.get(i).getNombre());
				}
				break;
			case "Refrescos":
				for(int i=1; i<refrescos.size(); i++){
					productosInventario.addElement(refrescos.get(i).getNombre());
				}
				break;
			case "Bebidas Mixtas":
				for(int i=1; i<bebidasCalientesOFrias.size(); i++){
					productosInventario.addElement(bebidasCalientesOFrias.get(i).getNombre());
				}
				break;
			default:
				break;
		}
		vista.list_ListaProductos.setModel(productosInventario);
	}
	
	private void mostrarInformacionProductoSelecccionado() {
		int indiceProductoSeleccionado = vista.list_ListaProductos.getSelectedIndex();
		String categoriaProductoSeleccionada = vista.comboBox_Inventario.getSelectedItem().toString();

		switch(categoriaProductoSeleccionada) {
			case "Comidas":
				obtenerInformacionProducto(comidas, indiceProductoSeleccionado);
				break;
			case "Cafés":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				obtenerInformacionProducto(cafes, indiceProductoSeleccionado);
				break;
			case "Batidos":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				obtenerInformacionProducto(batidos, indiceProductoSeleccionado);
				break;
			case "Refrescos":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				obtenerInformacionProducto(refrescos, indiceProductoSeleccionado);
				break;
			case "Bebidas Mixtas":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				obtenerInformacionProducto(bebidasCalientesOFrias, indiceProductoSeleccionado);
				break;
			default:
				break;
		}
	}
	
	private void obtenerInformacionProducto(ArrayList<Producto> productos, int indiceProducto) {
		Producto productoSeleccionado = productos.get(indiceProducto);
		
		vista.lbl_FotoProductoInventario.setIcon(ajustarTamañoImg(productoSeleccionado.getImagenProducto().getDescription(), vista.lbl_FotoProductoInventario.getWidth(), vista.lbl_FotoProductoInventario.getHeight()));
		vista.lbl_NumeroCantidadStock.setText(String.valueOf(productoSeleccionado.getCantidadStock()));
		vista.textField_PrecioProducto.setText(String.valueOf(productoSeleccionado.getPrecio()));
	}
	
	private void ingresarStockInventario() {
		int indiceProductoSeleccionado = vista.list_ListaProductos.getSelectedIndex();
		String categoriaProducto = vista.comboBox_Inventario.getSelectedItem().toString();
		Producto productoSeleccionado = null;
		
		if(indiceProductoSeleccionado<0) {
			vista.lbl_MensajeReduccionOIngresoStock.setText("NO HAS SELECCIONADO NADA. SELECCIONE ALGO");
			vista.lbl_MensajeReduccionOIngresoStock.setForeground(Color.RED);
		}else {
			switch(categoriaProducto) {
				case "Comidas":
					productoSeleccionado = comidas.get(indiceProductoSeleccionado);
					break;
				case "Cafés":
					indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
					productoSeleccionado = cafes.get(indiceProductoSeleccionado);
					break;
				case "Batidos":
					indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
					productoSeleccionado = batidos.get(indiceProductoSeleccionado);
					break;
				case "Refrescos":
					indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
					productoSeleccionado = refrescos.get(indiceProductoSeleccionado);
					break;
				case "Bebidas Mixtas":
					indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
					productoSeleccionado = bebidasCalientesOFrias.get(indiceProductoSeleccionado);
					break;
				default:
					System.out.println("No hay producto seleccionado");
					break;
			}
		}
		
		int cantidad = (int) vista.spinner_Inventario.getValue();
		
		if(cantidad==0) {
			vista.lbl_MensajeReduccionOIngresoStock.setText("SELECCIONA UNA CANTIDAD MAYOR A 0");
		}else {
			productoSeleccionado.setCantidadStock(productoSeleccionado.getCantidadStock()+cantidad);
			vista.lbl_MensajeReduccionOIngresoStock.setText("SE HAN INGRESADO " + cantidad + " UNIDADES PARA EL " + productoSeleccionado.getNombre().toUpperCase());
			vista.lbl_MensajeReduccionOIngresoStock.setForeground(new Color(0, 136, 0));
			vista.lbl_NumeroCantidadStock.setText(String.valueOf(productoSeleccionado.getCantidadStock()));
		}
	}
	
	private void reducirStockInventario() {
		int indiceProductoSeleccionado = vista.list_ListaProductos.getSelectedIndex();
		String categoriaProducto = vista.comboBox_Inventario.getSelectedItem().toString();
		Producto productoSeleccionado = null;
		
		if(indiceProductoSeleccionado<0) {
			vista.lbl_MensajeReduccionOIngresoStock.setText("NO HAS SELECCIONADO NADA. SELECCIONE ALGO");
			vista.lbl_MensajeReduccionOIngresoStock.setForeground(Color.RED);
		}else {
			switch(categoriaProducto) {
			case "Comidas":
				productoSeleccionado = comidas.get(indiceProductoSeleccionado);
				break;
			case "Cafés":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				productoSeleccionado = cafes.get(indiceProductoSeleccionado);
				break;
			case "Batidos":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				productoSeleccionado = batidos.get(indiceProductoSeleccionado);
				break;
			case "Refrescos":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				productoSeleccionado = refrescos.get(indiceProductoSeleccionado);
				break;
			case "Bebidas Mixtas":
				indiceProductoSeleccionado = indiceProductoSeleccionado + 1;
				productoSeleccionado = bebidasCalientesOFrias.get(indiceProductoSeleccionado);
				break;
			default:
				System.out.println("No hay producto seleccionado");
				break;
			}
		}
		
		int cantidad = (int) vista.spinner_Inventario.getValue();
		
		if(cantidad==0) {
			vista.lbl_MensajeReduccionOIngresoStock.setText("SELECCIONA UNA CANTIDAD MAYOR A 0");
		}else if(cantidad>productoSeleccionado.getCantidadStock()) {
			vista.lbl_MensajeReduccionOIngresoStock.setText("NO SE PUEDE REDUCIR ESA CANTIDAD DE STOCK");
			vista.lbl_MensajeReduccionOIngresoStock.setForeground(Color.RED);
		}else {
			productoSeleccionado.setCantidadStock(productoSeleccionado.getCantidadStock()-cantidad);
			vista.lbl_MensajeReduccionOIngresoStock.setText("SE HAN REDUCIDO " + cantidad + " UNIDADES DEL " + productoSeleccionado.getNombre().toUpperCase());
			vista.lbl_MensajeReduccionOIngresoStock.setForeground(new Color(0, 136, 0));
			vista.lbl_NumeroCantidadStock.setText(String.valueOf(productoSeleccionado.getCantidadStock()));
		}
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
				actualizarIconosLugares();
				vista.panel_PantallaPrincipal.setVisible(true);
				vista.panel_GestionComandas.setVisible(false);
			}
			if(e.getSource()==vista.lbl_SalirInformacionProductos) {
				vista.panel_InformacionProducto.setVisible(false);
				vista.panel_GestionComandas.setVisible(true);
			}
			if(e.getSource()==vista.lbl_SalirInventario) {
				vista.panel_Inventario.setVisible(false);
				vista.panel_PantallaPrincipal.setVisible(true);
				vista.comboBox_Inventario.setSelectedIndex(0);
				productosInventario.clear();
				vista.list_ListaProductos.clearSelection();
				vista.lbl_FotoProductoInventario.setIcon(null);
				vista.textField_PrecioProducto.setText("");
				vista.lbl_NumeroCantidadStock.setText("");
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
		
		if(e.getClickCount()==2 && e.getSource()==vista.list_ListaProductos) {
			mostrarInformacionProductoSelecccionado();
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