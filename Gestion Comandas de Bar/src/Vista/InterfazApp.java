package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controlador.ControladorCafeteria;
import Modelo.Empleado;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;

public class InterfazApp extends JFrame {

	private static final long serialVersionUID = 1L;
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	public JPanel panel_InicioSesion;
	public JLabel lblNombreLocal;
	public JTextField textFieldUsuario;
	public JLabel lblUsuario;
	public JLabel lblContraseña;
	public JButton btnInicioSesion;
	public JLabel lblEmpleadoIncorrecto;
	public JPanel panel_PantallaPrincipal;
	public JPasswordField passwordField_Contraseña;
	public JLabel lblHora;
	public JLabel lbl_ImgFondo;
	public JLabel lblFecha;
	public JPanel horarioYFechaActual;
	public JLabel lbl_ImgCalendario;
	public JLabel lbl_CerrarSesion;
	public JLabel lbl_ImgPrincipalApp;
	public JPanel panel_ImgMarco;
	public JLabel lbl_NombreEmpleado;
	public JLabel lbl_Mesa1;
	public JLabel lbl_ImgEmpleado;
	public JLabel lbl_Taburete2;
	public JLabel lbl_Mesa2;
	public JLabel lbl_Mesa3;
	public JLabel lbl_Mesa4;
	public JLabel lbl_Mesa5;
	public JLabel lbl_Taburete1;
	public JLabel lbl_Taburete3;
	public JButton btn_Inventario;
	public JButton btn_Contabilidad;
	public JButton btn_Horario;
	public JLabel lbl_Barra;
	public JPanel panel_DetallesEmpleado;
	public JLabel lbl_ImgDetallesEmpleado;
	public JLabel lbl_Salir;
	public JLabel lbl_FotoEmpleado;
	public JLabel lbl_Detalles;
	public JPanel panel_FotoEmpleado;
	public JLabel lbl_Nombre;
	public JLabel lbl_Apellidos;
	public JLabel lbl_InformacionNombre;
	public JLabel lbl_InformacionApellidos;
	public JLabel lbl_FechaIngreso;
	public JLabel lbl_InformacionFechaIngreso;
	public JLabel lbl_Direccion;
	public JTextField textField_Direccion;
	public JLabel lbl_Telefono;
	public JTextField textField_Telefono;
	public JLabel lbl_Contraseña;
	public JTextField textField_Contraseña;
	public JButton btn_GuardarCambios;
	public JTextArea textArea_RequisitosContraseña;
	public JPanel panel_InformacionProducto;
	public JPanel panel_GestionComandas;
	public JLabel lbl_SalirComandas;
	public JPanel panel_Comidas;
	public JComboBox comboBox_Menu;
	public JLabel lbl_Comida1;
	public JLabel lbl_InformacionComida1;
	public JLabel lbl_Comida4;
	public JLabel lbl_NombreComida1;
	public JLabel lbl_NombreComida4;
	public JButton btnAñadirComida1;
	public JButton btnEliminarComida1;
	public JLabel lbl_PrecioComida1;
	public JLabel lbl_PrecioComida4;
	public JList list_ListaPedidos;
	public JButton btnAñadirComida4;
	public JScrollPane scrollPane;
	public JLabel lbl_InformacionComida4;
	public JButton btnEliminarComida4;
	public JLabel lbl_Comida2;
	public JLabel lbl_InformacionComida2;
	public JButton btnAñadirComida2;
	public JButton btnEliminarComida2;
	public JLabel lbl_NombreComida2;
	public JLabel lbl_PrecioComida2;
	public JLabel lbl_Comida5;
	public JLabel lbl_NombreComida5;
	public JLabel lbl_PrecioComida5;
	public JLabel lbl_InformacionComida5;
	public JButton btnAñadirComida5;
	public JButton btnEliminarComida5;
	public JLabel lbl_Comida3;
	public JLabel lbl_InformacionComida3;
	public JButton btnAñadirComida3;
	public JButton btnEliminarComida3;
	public JLabel lbl_NombreComida3;
	public JLabel lbl_PrecioComida3;
	public JLabel lbl_Comida6;
	public JLabel lbl_NombreComida6;
	public JLabel lbl_PrecioComida6;
	public JButton btnAñadirComida6;
	public JButton btnEliminarComida6;
	public JLabel lbl_InformacionComida6;
	public JLabel lbl_ImgFondoComandas;
	public JLabel lbl_Mesa_o_Taburete;
	public JTextArea textArea_RequisitosTelefono;
	public JTextArea textArea_MensajeInformacionCambiosRealizados;
	public JLabel lbl_ImgFondoInfoProductos;
	public JProgressBar progressBar_Comida1;
	public JProgressBar progressBar_Comida2;
	public JProgressBar progressBar_Comida3;
	public JProgressBar progressBar_Comida4;
	public JProgressBar progressBar_Comida5;
	public JProgressBar progressBar_Comida6;
	public JPanel panel_Bebidas;
	public JComboBox comboBox_TipoCafe;
	public JLabel lbl_Cafe;
	public JLabel lbl_InformacionBebida1;
	public JButton btnAñadirBebida1;
	public JButton btnRetirarBebida1;
	public JLabel lbl_Refresco;
	public JProgressBar progressBar_Bebida1;
	public JComboBox comboBox_TipoRefresco;
	public JButton btnAñadirBebida3;
	public JButton btnRetirarBebida3;
	public JLabel lbl_InformacionBebida3;
	public JProgressBar progressBar_Bebida3;
	public JLabel lbl_Batido;
	public JComboBox comboBox_TipoBatido;
	public JLabel lbl_BebidaCalienteoFria;
	public JLabel lbl_InformacionBebida2;
	public JButton btnAñadirBebida2;
	public JButton btnRetirarBebida2;
	public JProgressBar progressBar_Bebida2;
	public JComboBox comboBox_TipoBebidaCalienteoFria;
	public JLabel lbl_InformacionBebida4;
	public JButton btnAñadirBebida4;
	public JButton btnRetirarBebida4;
	public JProgressBar progressBar_Bebida4;
	public JLabel lbl_PrecioCafe;
	public JLabel lbl_IconoEuro1;
	public JLabel lbl_PrecioRefresco;
	public JLabel lbl_IconoEuro3;
	public JLabel lbl_PrecioBatido;
	public JLabel lbl_IconoEuro2;
	public JLabel lbl_PrecioBebidaVariada;
	public JLabel lbl_IconoEuro4;
	public JLabel lbl_SimboloEuroComida1;
	public JLabel lbl_SimboloEuroComida4;
	public JLabel lbl_SimboloEuroComida2;
	public JLabel lbl_SimboloEuroComida3;
	public JLabel lbl_SimboloEuroComida5;
	public JLabel lbl_SimboloEuroComida6;
	public JLabel lbl_PedirComanda;
	public JLabel lbl_PagarComanda;
	public JLabel lbl_IdComanda;
	public JLabel lbl_PrecioTotalComanda;
	public JLabel lbl_SalirInformacionProductos;
	public JLabel lbl_FotoProducto;
	public JLabel lbl_NombreProducto;
	public JLabel lbl_Ingredientes;
	public JLabel lbl_InfoNombreProducto;
	public JTable tabla_Ingredientes;
	public JScrollPane scrollPane_Ingredientes;
	public JLabel lbl_CaloriasTotalesProducto;
	public JLabel lbl_ProteinasProducto;
	public JLabel lbl_GrasasProducto;
	public JLabel lbl_InfoProteinasProducto;
	public JLabel lbl_InfoGrasasProducto;
	public JLabel lbl_InfoCaloriasTotalesProducto;
	public JCheckBox checkBox_MostrarTablaIngredientes;
	public JPanel panel_Inventario;
	public JLabel lbl_FondoInventario;
	public JLabel lbl_SalirInventario;
	public JComboBox comboBox_Inventario;
	public JList list_ListaProductos;
	public JLabel lbl_Comida1Agotada;
	public JLabel lbl_Comida2Agotada;
	public JLabel lbl_Comida3Agotada;
	public JLabel lbl_Comida4Agotada;
	public JLabel lbl_Comida5Agotada;
	public JLabel lbl_Comida6Agotada;
	public JLabel lbl_CafeAgotado;
	public JLabel lbl_RefrescoAgotado;
	public JLabel lbl_BatidoAgotado;
	public JLabel lbl_BebidaCalienteOFriaAgotada;
	public JLabel lbl_ComprobacionMesa1;
	public JLabel lbl_ComprobacionMesa2;
	public JLabel lbl_ComprobacionMesa3;
	public JLabel lbl_ComprobacionMesa4;
	public JLabel lbl_ComprobacionMesa5;
	public JLabel lbl_ComprobacionTaburete1;
	public JLabel lbl_ComprobacionTaburete2;
	public JLabel lbl_ComprobacionTaburete3;
	public JLabel lbl_FotoProductoInventario;
	public JSpinner spinner_Inventario;
	public JLabel lbl_PrecioProducto;
	public JTextField textField_PrecioProducto;
	public JButton btn_IngresarStock;
	public JButton btn_ReducirStock;
	public JLabel lbl_MensajeReduccionOIngresoStock;
	public JLabel lbl_CantidadProducto;
	public JLabel lbl_NumeroCantidadStock;
	public JButton btn_ConfirmarPrecioNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazApp frame = new InterfazApp();
					ControladorCafeteria controlador = new ControladorCafeteria(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 569);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_GestionComandas = new JPanel();
		panel_GestionComandas.setBackground(new Color(245, 209, 215));
		panel_GestionComandas.setBounds(0, 0, 897, 532);
		contentPane.add(panel_GestionComandas);
		panel_GestionComandas.setLayout(null);
		
		panel_Bebidas = new JPanel();
		panel_Bebidas.setBackground(new Color(245, 209, 215));
		panel_Bebidas.setBounds(0, 82, 715, 450);
		panel_GestionComandas.add(panel_Bebidas);
		panel_Bebidas.setLayout(null);
		
		lbl_BebidaCalienteOFriaAgotada = new JLabel("");
		lbl_BebidaCalienteOFriaAgotada.setBounds(625, 268, 64, 64);
		panel_Bebidas.add(lbl_BebidaCalienteOFriaAgotada);
		
		lbl_BatidoAgotado = new JLabel("");
		lbl_BatidoAgotado.setBounds(625, 40, 64, 64);
		panel_Bebidas.add(lbl_BatidoAgotado);
		
		lbl_CafeAgotado = new JLabel("");
		lbl_CafeAgotado.setBounds(283, 40, 64, 64);
		panel_Bebidas.add(lbl_CafeAgotado);
		
		lbl_RefrescoAgotado = new JLabel("");
		lbl_RefrescoAgotado.setBounds(283, 268, 64, 64);
		panel_Bebidas.add(lbl_RefrescoAgotado);
		
		lbl_IconoEuro4 = new JLabel("");
		lbl_IconoEuro4.setBounds(600, 413, 32, 32);
		panel_Bebidas.add(lbl_IconoEuro4);
		
		lbl_PrecioBebidaVariada = new JLabel("");
		lbl_PrecioBebidaVariada.setForeground(Color.BLACK);
		lbl_PrecioBebidaVariada.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioBebidaVariada.setBounds(556, 420, 46, 16);
		panel_Bebidas.add(lbl_PrecioBebidaVariada);
		
		lbl_IconoEuro2 = new JLabel("");
		lbl_IconoEuro2.setBounds(600, 190, 32, 32);
		panel_Bebidas.add(lbl_IconoEuro2);
		
		lbl_PrecioBatido = new JLabel("");
		lbl_PrecioBatido.setForeground(Color.BLACK);
		lbl_PrecioBatido.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioBatido.setBounds(556, 200, 46, 16);
		panel_Bebidas.add(lbl_PrecioBatido);
		
		lbl_IconoEuro3 = new JLabel("");
		lbl_IconoEuro3.setBounds(255, 413, 32, 32);
		panel_Bebidas.add(lbl_IconoEuro3);
		
		lbl_PrecioRefresco = new JLabel("");
		lbl_PrecioRefresco.setForeground(Color.BLACK);
		lbl_PrecioRefresco.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioRefresco.setBounds(215, 420, 46, 16);
		panel_Bebidas.add(lbl_PrecioRefresco);
		
		lbl_IconoEuro1 = new JLabel("");
		lbl_IconoEuro1.setBounds(255, 190, 32, 32);
		panel_Bebidas.add(lbl_IconoEuro1);
		
		lbl_PrecioCafe = new JLabel("");
		lbl_PrecioCafe.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioCafe.setForeground(new Color(0, 0, 0));
		lbl_PrecioCafe.setBounds(215, 200, 46, 16);
		panel_Bebidas.add(lbl_PrecioCafe);
		
		lbl_Refresco = new JLabel("");
		lbl_Refresco.setBounds(22, 243, 169, 165);
		panel_Bebidas.add(lbl_Refresco);
		
		comboBox_TipoCafe = new JComboBox();
		comboBox_TipoCafe.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox_TipoCafe.setForeground(new Color(0, 0, 0));
		comboBox_TipoCafe.setBounds(203, 0, 144, 33);
		panel_Bebidas.add(comboBox_TipoCafe);
		
		lbl_Cafe = new JLabel("");
		lbl_Cafe.setBounds(22, 22, 169, 165);
		panel_Bebidas.add(lbl_Cafe);
		
		lbl_InformacionBebida1 = new JLabel("");
		lbl_InformacionBebida1.setBounds(203, 67, 32, 32);
		panel_Bebidas.add(lbl_InformacionBebida1);
		
		btnAñadirBebida1 = new JButton("Añadir");
		btnAñadirBebida1.setForeground(Color.BLACK);
		btnAñadirBebida1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirBebida1.setBackground(new Color(0, 213, 0));
		btnAñadirBebida1.setBounds(203, 111, 92, 31);
		panel_Bebidas.add(btnAñadirBebida1);
		
		btnRetirarBebida1 = new JButton("Retirar");
		btnRetirarBebida1.setForeground(Color.BLACK);
		btnRetirarBebida1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRetirarBebida1.setBackground(new Color(255, 0, 0));
		btnRetirarBebida1.setBounds(203, 154, 92, 31);
		panel_Bebidas.add(btnRetirarBebida1);
		
		progressBar_Bebida1 = new JProgressBar();
		progressBar_Bebida1.setForeground(new Color(0, 0, 255));
		progressBar_Bebida1.setBounds(22, 199, 169, 14);
		panel_Bebidas.add(progressBar_Bebida1);
		
		comboBox_TipoRefresco = new JComboBox();
		comboBox_TipoRefresco.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox_TipoRefresco.setForeground(new Color(0, 0, 0));
		comboBox_TipoRefresco.setBounds(203, 234, 144, 33);
		panel_Bebidas.add(comboBox_TipoRefresco);
		
		btnAñadirBebida3 = new JButton("Añadir");
		btnAñadirBebida3.setForeground(Color.BLACK);
		btnAñadirBebida3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirBebida3.setBackground(new Color(0, 213, 0));
		btnAñadirBebida3.setBounds(203, 334, 92, 31);
		panel_Bebidas.add(btnAñadirBebida3);
		
		btnRetirarBebida3 = new JButton("Retirar");
		btnRetirarBebida3.setForeground(Color.BLACK);
		btnRetirarBebida3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRetirarBebida3.setBackground(Color.RED);
		btnRetirarBebida3.setBounds(203, 377, 92, 31);
		panel_Bebidas.add(btnRetirarBebida3);
		
		lbl_InformacionBebida3 = new JLabel("");
		lbl_InformacionBebida3.setBounds(203, 290, 32, 32);
		panel_Bebidas.add(lbl_InformacionBebida3);
		
		progressBar_Bebida3 = new JProgressBar();
		progressBar_Bebida3.setForeground(new Color(0, 0, 255));
		progressBar_Bebida3.setBounds(22, 420, 169, 14);
		panel_Bebidas.add(progressBar_Bebida3);
		
		lbl_Batido = new JLabel("");
		lbl_Batido.setBounds(365, 22, 169, 165);
		panel_Bebidas.add(lbl_Batido);
		
		comboBox_TipoBatido = new JComboBox();
		comboBox_TipoBatido.setForeground(new Color(0, 0, 0));
		comboBox_TipoBatido.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox_TipoBatido.setBounds(546, 0, 157, 33);
		panel_Bebidas.add(comboBox_TipoBatido);
		
		lbl_BebidaCalienteoFria = new JLabel("");
		lbl_BebidaCalienteoFria.setBounds(365, 243, 169, 165);
		panel_Bebidas.add(lbl_BebidaCalienteoFria);
		
		lbl_InformacionBebida2 = new JLabel("");
		lbl_InformacionBebida2.setBounds(546, 67, 32, 32);
		panel_Bebidas.add(lbl_InformacionBebida2);
		
		btnAñadirBebida2 = new JButton("Añadir");
		btnAñadirBebida2.setForeground(Color.BLACK);
		btnAñadirBebida2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirBebida2.setBackground(new Color(0, 213, 0));
		btnAñadirBebida2.setBounds(546, 111, 92, 31);
		panel_Bebidas.add(btnAñadirBebida2);
		
		btnRetirarBebida2 = new JButton("Retirar");
		btnRetirarBebida2.setForeground(Color.BLACK);
		btnRetirarBebida2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRetirarBebida2.setBackground(Color.RED);
		btnRetirarBebida2.setBounds(546, 154, 92, 31);
		panel_Bebidas.add(btnRetirarBebida2);
		
		progressBar_Bebida2 = new JProgressBar();
		progressBar_Bebida2.setForeground(new Color(0, 0, 255));
		progressBar_Bebida2.setBounds(365, 199, 169, 14);
		panel_Bebidas.add(progressBar_Bebida2);
		
		comboBox_TipoBebidaCalienteoFria = new JComboBox();
		comboBox_TipoBebidaCalienteoFria.setForeground(new Color(0, 0, 0));
		comboBox_TipoBebidaCalienteoFria.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox_TipoBebidaCalienteoFria.setBounds(546, 234, 157, 33);
		panel_Bebidas.add(comboBox_TipoBebidaCalienteoFria);
		
		lbl_InformacionBebida4 = new JLabel("");
		lbl_InformacionBebida4.setBounds(546, 290, 32, 32);
		panel_Bebidas.add(lbl_InformacionBebida4);
		
		btnAñadirBebida4 = new JButton("Añadir");
		btnAñadirBebida4.setForeground(Color.BLACK);
		btnAñadirBebida4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirBebida4.setBackground(new Color(0, 213, 0));
		btnAñadirBebida4.setBounds(546, 334, 92, 31);
		panel_Bebidas.add(btnAñadirBebida4);
		
		btnRetirarBebida4 = new JButton("Retirar");
		btnRetirarBebida4.setForeground(Color.BLACK);
		btnRetirarBebida4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRetirarBebida4.setBackground(Color.RED);
		btnRetirarBebida4.setBounds(546, 377, 92, 31);
		panel_Bebidas.add(btnRetirarBebida4);
		
		progressBar_Bebida4 = new JProgressBar();
		progressBar_Bebida4.setForeground(new Color(0, 0, 255));
		progressBar_Bebida4.setBounds(365, 420, 169, 14);
		panel_Bebidas.add(progressBar_Bebida4);
		
		panel_Comidas = new JPanel();
		panel_Comidas.setBackground(new Color(245, 209, 215));
		panel_Comidas.setBounds(0, 82, 715, 450);
		panel_GestionComandas.add(panel_Comidas);
		panel_Comidas.setLayout(null);
		
		lbl_Comida5Agotada = new JLabel("");
		lbl_Comida5Agotada.setBounds(424, 237, 64, 64);
		panel_Comidas.add(lbl_Comida5Agotada);
		
		lbl_Comida6Agotada = new JLabel("");
		lbl_Comida6Agotada.setBounds(650, 237, 64, 64);
		panel_Comidas.add(lbl_Comida6Agotada);
		
		lbl_Comida4Agotada = new JLabel("");
		lbl_Comida4Agotada.setBounds(177, 237, 64, 64);
		panel_Comidas.add(lbl_Comida4Agotada);
		
		lbl_Comida3Agotada = new JLabel("");
		lbl_Comida3Agotada.setBounds(650, 31, 64, 64);
		panel_Comidas.add(lbl_Comida3Agotada);
		
		lbl_Comida2Agotada = new JLabel("");
		lbl_Comida2Agotada.setBounds(424, 31, 64, 64);
		panel_Comidas.add(lbl_Comida2Agotada);
		
		lbl_Comida1Agotada = new JLabel("");
		lbl_Comida1Agotada.setBounds(177, 31, 64, 64);
		panel_Comidas.add(lbl_Comida1Agotada);
		
		lbl_SimboloEuroComida1 = new JLabel("");
		lbl_SimboloEuroComida1.setForeground(new Color(0, 0, 0));
		lbl_SimboloEuroComida1.setBounds(194, 182, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida1);
		
		lbl_PrecioComida1 = new JLabel("");
		lbl_PrecioComida1.setForeground(new Color(0, 0, 0));
		lbl_PrecioComida1.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida1.setBounds(150, 190, 37, 16);
		panel_Comidas.add(lbl_PrecioComida1);
		
		progressBar_Comida6 = new JProgressBar();
		progressBar_Comida6.setForeground(new Color(0, 0, 255));
		progressBar_Comida6.setBounds(480, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida6);
		
		progressBar_Comida5 = new JProgressBar();
		progressBar_Comida5.setForeground(new Color(0, 0, 255));
		progressBar_Comida5.setBounds(248, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida5);
		
		progressBar_Comida4 = new JProgressBar();
		progressBar_Comida4.setForeground(new Color(0, 0, 255));
		progressBar_Comida4.setBounds(12, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida4);
		
		progressBar_Comida3 = new JProgressBar();
		progressBar_Comida3.setForeground(new Color(0, 0, 255));
		progressBar_Comida3.setBounds(480, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida3);
		
		progressBar_Comida2 = new JProgressBar();
		progressBar_Comida2.setForeground(new Color(0, 0, 255));
		progressBar_Comida2.setBounds(248, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida2);
		
		progressBar_Comida1 = new JProgressBar();
		progressBar_Comida1.setForeground(new Color(0, 0, 255));
		progressBar_Comida1.setBounds(12, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida1);
		
		btnAñadirComida6 = new JButton("Añadir");
		btnAñadirComida6.setForeground(Color.BLACK);
		btnAñadirComida6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida6.setBackground(new Color(0, 213, 0));
		btnAñadirComida6.setBounds(616, 307, 92, 31);
		panel_Comidas.add(btnAñadirComida6);
		
		lbl_NombreComida6 = new JLabel("");
		lbl_NombreComida6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida6.setForeground(new Color(0, 0, 0));
		lbl_NombreComida6.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida6.setBounds(483, 391, 125, 16);
		panel_Comidas.add(lbl_NombreComida6);
		
		lbl_InformacionComida6 = new JLabel("");
		lbl_InformacionComida6.setBounds(616, 253, 32, 32);
		panel_Comidas.add(lbl_InformacionComida6);
		
		btnEliminarComida6 = new JButton("Retirar");
		btnEliminarComida6.setEnabled(false);
		btnEliminarComida6.setForeground(Color.BLACK);
		btnEliminarComida6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida6.setBackground(Color.RED);
		btnEliminarComida6.setBounds(616, 348, 92, 31);
		panel_Comidas.add(btnEliminarComida6);
		
		lbl_PrecioComida6 = new JLabel("");
		lbl_PrecioComida6.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida6.setBounds(635, 391, 37, 16);
		panel_Comidas.add(lbl_PrecioComida6);
		
		lbl_PrecioComida5 = new JLabel("");
		lbl_PrecioComida5.setForeground(new Color(0, 0, 0));
		lbl_PrecioComida5.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida5.setBounds(400, 391, 37, 16);
		panel_Comidas.add(lbl_PrecioComida5);
		
		lbl_Comida6 = new JLabel("");
		lbl_Comida6.setBounds(480, 256, 128, 126);
		panel_Comidas.add(lbl_Comida6);
		
		lbl_NombreComida3 = new JLabel("");
		lbl_NombreComida3.setForeground(new Color(0, 0, 0));
		lbl_NombreComida3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida3.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida3.setBounds(483, 190, 125, 16);
		panel_Comidas.add(lbl_NombreComida3);
		
		btnEliminarComida3 = new JButton("Retirar");
		btnEliminarComida3.setEnabled(false);
		btnEliminarComida3.setForeground(Color.BLACK);
		btnEliminarComida3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida3.setBackground(Color.RED);
		btnEliminarComida3.setBounds(616, 148, 92, 31);
		panel_Comidas.add(btnEliminarComida3);
		
		lbl_PrecioComida3 = new JLabel("");
		lbl_PrecioComida3.setForeground(new Color(0, 0, 0));
		lbl_PrecioComida3.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida3.setBounds(635, 192, 37, 16);
		panel_Comidas.add(lbl_PrecioComida3);
		
		lbl_InformacionComida3 = new JLabel("");
		lbl_InformacionComida3.setBounds(616, 52, 32, 32);
		panel_Comidas.add(lbl_InformacionComida3);
		
		btnAñadirComida3 = new JButton("Añadir");
		btnAñadirComida3.setForeground(Color.BLACK);
		btnAñadirComida3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida3.setBackground(new Color(0, 213, 0));
		btnAñadirComida3.setBounds(616, 104, 92, 31);
		panel_Comidas.add(btnAñadirComida3);
		
		lbl_Comida3 = new JLabel("");
		lbl_Comida3.setBounds(480, 52, 128, 126);
		panel_Comidas.add(lbl_Comida3);
		
		lbl_InformacionComida5 = new JLabel("");
		lbl_InformacionComida5.setBounds(380, 253, 32, 32);
		panel_Comidas.add(lbl_InformacionComida5);
		
		btnEliminarComida5 = new JButton("Retirar");
		btnEliminarComida5.setEnabled(false);
		btnEliminarComida5.setForeground(Color.BLACK);
		btnEliminarComida5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida5.setBackground(Color.RED);
		btnEliminarComida5.setBounds(380, 348, 92, 31);
		panel_Comidas.add(btnEliminarComida5);
		
		btnAñadirComida5 = new JButton("Añadir");
		btnAñadirComida5.setForeground(Color.BLACK);
		btnAñadirComida5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida5.setBackground(new Color(0, 213, 0));
		btnAñadirComida5.setBounds(380, 307, 92, 31);
		panel_Comidas.add(btnAñadirComida5);
		
		lbl_NombreComida5 = new JLabel("");
		lbl_NombreComida5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida5.setForeground(new Color(0, 0, 0));
		lbl_NombreComida5.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida5.setBounds(240, 391, 153, 16);
		panel_Comidas.add(lbl_NombreComida5);
		
		lbl_Comida5 = new JLabel("");
		lbl_Comida5.setBounds(248, 256, 128, 126);
		panel_Comidas.add(lbl_Comida5);
		
		lbl_NombreComida2 = new JLabel("");
		lbl_NombreComida2.setForeground(new Color(0, 0, 0));
		lbl_NombreComida2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida2.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida2.setBounds(248, 190, 128, 16);
		panel_Comidas.add(lbl_NombreComida2);
		
		lbl_PrecioComida2 = new JLabel("");
		lbl_PrecioComida2.setForeground(new Color(0, 0, 0));
		lbl_PrecioComida2.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida2.setBounds(400, 190, 37, 16);
		panel_Comidas.add(lbl_PrecioComida2);
		
		btnEliminarComida2 = new JButton("Retirar");
		btnEliminarComida2.setEnabled(false);
		btnEliminarComida2.setForeground(Color.BLACK);
		btnEliminarComida2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida2.setBackground(Color.RED);
		btnEliminarComida2.setBounds(380, 148, 92, 31);
		panel_Comidas.add(btnEliminarComida2);
		
		btnAñadirComida2 = new JButton("Añadir");
		btnAñadirComida2.setForeground(Color.BLACK);
		btnAñadirComida2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida2.setBackground(new Color(0, 213, 0));
		btnAñadirComida2.setBounds(380, 104, 92, 31);
		panel_Comidas.add(btnAñadirComida2);
		
		lbl_InformacionComida2 = new JLabel("");
		lbl_InformacionComida2.setBounds(380, 52, 32, 32);
		panel_Comidas.add(lbl_InformacionComida2);
		
		lbl_Comida2 = new JLabel("");
		lbl_Comida2.setBounds(248, 52, 128, 126);
		panel_Comidas.add(lbl_Comida2);
		
		btnAñadirComida4 = new JButton("Añadir");
		btnAñadirComida4.setForeground(Color.BLACK);
		btnAñadirComida4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida4.setBackground(new Color(0, 213, 0));
		btnAñadirComida4.setBounds(138, 307, 92, 31);
		panel_Comidas.add(btnAñadirComida4);
		
		btnEliminarComida4 = new JButton("Retirar");
		btnEliminarComida4.setEnabled(false);
		btnEliminarComida4.setForeground(new Color(0, 0, 0));
		btnEliminarComida4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida4.setBackground(Color.RED);
		btnEliminarComida4.setBounds(138, 348, 92, 31);
		panel_Comidas.add(btnEliminarComida4);
		
		lbl_InformacionComida4 = new JLabel("");
		lbl_InformacionComida4.setBounds(140, 253, 32, 32);
		panel_Comidas.add(lbl_InformacionComida4);
		
		lbl_NombreComida4 = new JLabel("");
		lbl_NombreComida4.setForeground(new Color(0, 0, 0));
		lbl_NombreComida4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida4.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida4.setBounds(6, 391, 135, 16);
		panel_Comidas.add(lbl_NombreComida4);
		
		lbl_NombreComida1 = new JLabel("");
		lbl_NombreComida1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreComida1.setForeground(new Color(0, 0, 0));
		lbl_NombreComida1.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida1.setBounds(6, 190, 135, 16);
		panel_Comidas.add(lbl_NombreComida1);
		
		lbl_InformacionComida1 = new JLabel("");
		lbl_InformacionComida1.setBounds(140, 52, 32, 32);
		panel_Comidas.add(lbl_InformacionComida1);
		
		lbl_Comida1 = new JLabel("");
		lbl_Comida1.setBounds(6, 52, 128, 126);
		panel_Comidas.add(lbl_Comida1);
		
		lbl_Comida4 = new JLabel("");
		lbl_Comida4.setBounds(6, 253, 128, 126);
		panel_Comidas.add(lbl_Comida4);
		
		btnAñadirComida1 = new JButton("Añadir");
		btnAñadirComida1.setBackground(new Color(0, 213, 0));
		btnAñadirComida1.setForeground(new Color(0, 0, 0));
		btnAñadirComida1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida1.setBounds(138, 104, 92, 31);
		panel_Comidas.add(btnAñadirComida1);
		
		btnEliminarComida1 = new JButton("Retirar");
		btnEliminarComida1.setEnabled(false);
		btnEliminarComida1.setForeground(new Color(0, 0, 0));
		btnEliminarComida1.setBackground(new Color(255, 0, 0));
		btnEliminarComida1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida1.setBounds(138, 147, 92, 31);
		panel_Comidas.add(btnEliminarComida1);
		
		lbl_PrecioComida4 = new JLabel("");
		lbl_PrecioComida4.setForeground(new Color(0, 0, 0));
		lbl_PrecioComida4.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida4.setBounds(150, 391, 37, 16);
		panel_Comidas.add(lbl_PrecioComida4);
		
		lbl_SimboloEuroComida4 = new JLabel("");
		lbl_SimboloEuroComida4.setForeground(Color.BLACK);
		lbl_SimboloEuroComida4.setBounds(194, 382, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida4);
		
		lbl_SimboloEuroComida2 = new JLabel("");
		lbl_SimboloEuroComida2.setForeground(Color.BLACK);
		lbl_SimboloEuroComida2.setBounds(436, 182, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida2);
		
		lbl_SimboloEuroComida3 = new JLabel("");
		lbl_SimboloEuroComida3.setForeground(Color.BLACK);
		lbl_SimboloEuroComida3.setBounds(671, 182, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida3);
		
		lbl_SimboloEuroComida5 = new JLabel("");
		lbl_SimboloEuroComida5.setForeground(Color.BLACK);
		lbl_SimboloEuroComida5.setBounds(436, 382, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida5);
		
		lbl_SimboloEuroComida6 = new JLabel("");
		lbl_SimboloEuroComida6.setForeground(Color.BLACK);
		lbl_SimboloEuroComida6.setBounds(671, 382, 32, 31);
		panel_Comidas.add(lbl_SimboloEuroComida6);
		
		lbl_SalirComandas = new JLabel("");
		lbl_SalirComandas.setBounds(0, 0, 68, 70);
		panel_GestionComandas.add(lbl_SalirComandas);
		
		lbl_PrecioTotalComanda = new JLabel("");
		lbl_PrecioTotalComanda.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PrecioTotalComanda.setForeground(Color.BLACK);
		lbl_PrecioTotalComanda.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_PrecioTotalComanda.setBounds(718, 333, 178, 30);
		panel_GestionComandas.add(lbl_PrecioTotalComanda);
		
		lbl_IdComanda = new JLabel("");
		lbl_IdComanda.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IdComanda.setForeground(Color.BLACK);
		lbl_IdComanda.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_IdComanda.setBounds(731, 55, 142, 37);
		panel_GestionComandas.add(lbl_IdComanda);
		
		lbl_PagarComanda = new JLabel("");
		lbl_PagarComanda.setBounds(775, 445, 64, 64);
		panel_GestionComandas.add(lbl_PagarComanda);
		
		lbl_PedirComanda = new JLabel("");
		lbl_PedirComanda.setBounds(775, 375, 64, 64);
		panel_GestionComandas.add(lbl_PedirComanda);
		
		lbl_Mesa_o_Taburete = new JLabel("");
		lbl_Mesa_o_Taburete.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Mesa_o_Taburete.setForeground(new Color(0, 0, 0));
		lbl_Mesa_o_Taburete.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_Mesa_o_Taburete.setBounds(731, 12, 142, 37);
		panel_GestionComandas.add(lbl_Mesa_o_Taburete);
		
		comboBox_Menu = new JComboBox();
		comboBox_Menu.setForeground(new Color(0, 0, 0));
		comboBox_Menu.setFont(new Font("Consolas", Font.BOLD, 16));
		comboBox_Menu.setBounds(133, 12, 142, 37);
		panel_GestionComandas.add(comboBox_Menu);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(718, 99, 175, 229);
		panel_GestionComandas.add(scrollPane);
		
		list_ListaPedidos = new JList();
		list_ListaPedidos.setForeground(new Color(0, 0, 0));
		list_ListaPedidos.setFont(new Font("Consolas", Font.BOLD, 15));
		scrollPane.setViewportView(list_ListaPedidos);
		
		lbl_ImgFondoComandas = new JLabel("");
		lbl_ImgFondoComandas.setBounds(0, 0, 897, 532);
		panel_GestionComandas.add(lbl_ImgFondoComandas);
		
		panel_Inventario = new JPanel();
		panel_Inventario.setBackground(new Color(245, 209, 215));
		panel_Inventario.setBounds(0, 0, 897, 532);
		contentPane.add(panel_Inventario);
		panel_Inventario.setLayout(null);
		
		btn_ConfirmarPrecioNuevo = new JButton("");
		btn_ConfirmarPrecioNuevo.setIcon(new ImageIcon(InterfazApp.class.getResource("/img/comprobar.png")));
		btn_ConfirmarPrecioNuevo.setBounds(563, 194, 54, 39);
		panel_Inventario.add(btn_ConfirmarPrecioNuevo);
		
		lbl_NumeroCantidadStock = new JLabel("");
		lbl_NumeroCantidadStock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NumeroCantidadStock.setForeground(Color.BLACK);
		lbl_NumeroCantidadStock.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NumeroCantidadStock.setBounds(495, 163, 56, 24);
		panel_Inventario.add(lbl_NumeroCantidadStock);
		
		lbl_MensajeReduccionOIngresoStock = new JLabel("");
		lbl_MensajeReduccionOIngresoStock.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_MensajeReduccionOIngresoStock.setBounds(166, 356, 451, 30);
		panel_Inventario.add(lbl_MensajeReduccionOIngresoStock);
		
		lbl_CantidadProducto = new JLabel("CANTIDAD STOCK");
		lbl_CantidadProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_CantidadProducto.setBounds(351, 157, 132, 39);
		panel_Inventario.add(lbl_CantidadProducto);
		
		btn_ReducirStock = new JButton("RETIRAR");
		btn_ReducirStock.setBackground(new Color(255, 0, 0));
		btn_ReducirStock.setForeground(new Color(0, 0, 0));
		btn_ReducirStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_ReducirStock.setBounds(419, 290, 132, 39);
		panel_Inventario.add(btn_ReducirStock);
		
		btn_IngresarStock = new JButton("INGRESAR");
		btn_IngresarStock.setBackground(new Color(0, 213, 0));
		btn_IngresarStock.setForeground(new Color(0, 0, 0));
		btn_IngresarStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_IngresarStock.setBounds(419, 239, 132, 39);
		panel_Inventario.add(btn_IngresarStock);
		
		textField_PrecioProducto = new JTextField();
		textField_PrecioProducto.setForeground(new Color(0, 0, 0));
		textField_PrecioProducto.setFont(new Font("Consolas", Font.BOLD, 18));
		textField_PrecioProducto.setBounds(419, 203, 132, 24);
		panel_Inventario.add(textField_PrecioProducto);
		textField_PrecioProducto.setColumns(10);
		
		lbl_PrecioProducto = new JLabel("PRECIO");
		lbl_PrecioProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PrecioProducto.setForeground(new Color(0, 0, 0));
		lbl_PrecioProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioProducto.setBounds(351, 208, 56, 19);
		panel_Inventario.add(lbl_PrecioProducto);
		
		spinner_Inventario = new JSpinner();
		spinner_Inventario.setForeground(new Color(255, 255, 255));
		spinner_Inventario.setFont(new Font("Consolas", Font.BOLD, 16));
		spinner_Inventario.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_Inventario.setBounds(351, 273, 56, 24);
		panel_Inventario.add(spinner_Inventario);
		
		lbl_FotoProductoInventario = new JLabel("");
		lbl_FotoProductoInventario.setBounds(635, 149, 141, 180);
		panel_Inventario.add(lbl_FotoProductoInventario);
		
		list_ListaProductos = new JList();
		list_ListaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_ListaProductos.setForeground(new Color(0, 0, 0));
		list_ListaProductos.setFont(new Font("Consolas", Font.BOLD, 16));
		list_ListaProductos.setBorder(new LineBorder(new Color(128, 0, 128), 4));
		list_ListaProductos.setBounds(166, 184, 173, 145);
		panel_Inventario.add(list_ListaProductos);
		
		comboBox_Inventario = new JComboBox();
		comboBox_Inventario.setForeground(new Color(0, 0, 0));
		comboBox_Inventario.setFont(new Font("Consolas", Font.BOLD, 15));
		comboBox_Inventario.setBounds(166, 12, 173, 42);
		panel_Inventario.add(comboBox_Inventario);
		
		lbl_SalirInventario = new JLabel("");
		lbl_SalirInventario.setBounds(0, 0, 68, 70);
		panel_Inventario.add(lbl_SalirInventario);
		
		lbl_FondoInventario = new JLabel("");
		lbl_FondoInventario.setBounds(0, 0, 897, 532);
		panel_Inventario.add(lbl_FondoInventario);
		
		panel_PantallaPrincipal = new JPanel();
		panel_PantallaPrincipal.setBackground(new Color(245, 209, 215));
		panel_PantallaPrincipal.setBounds(0, 0, 897, 532);
		panel_PantallaPrincipal.setBorder(new LineBorder(null, 0));
		contentPane.add(panel_PantallaPrincipal);
		panel_PantallaPrincipal.setVisible(false);
		panel_PantallaPrincipal.setLayout(null);
		
		lbl_ComprobacionTaburete3 = new JLabel("");
		lbl_ComprobacionTaburete3.setBounds(698, 107, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionTaburete3);
		
		lbl_ComprobacionTaburete2 = new JLabel("");
		lbl_ComprobacionTaburete2.setBounds(636, 107, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionTaburete2);
		
		lbl_ComprobacionTaburete1 = new JLabel("");
		lbl_ComprobacionTaburete1.setBounds(595, 87, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionTaburete1);
		
		lbl_ComprobacionMesa5 = new JLabel("");
		lbl_ComprobacionMesa5.setBounds(633, 292, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionMesa5);
		
		lbl_ComprobacionMesa4 = new JLabel("");
		lbl_ComprobacionMesa4.setBounds(438, 292, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionMesa4);
		
		lbl_ComprobacionMesa3 = new JLabel("");
		lbl_ComprobacionMesa3.setBounds(726, 192, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionMesa3);
		
		lbl_ComprobacionMesa2 = new JLabel("");
		lbl_ComprobacionMesa2.setBounds(535, 192, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionMesa2);
		
		lbl_ComprobacionMesa1 = new JLabel("");
		lbl_ComprobacionMesa1.setBounds(348, 192, 32, 32);
		panel_PantallaPrincipal.add(lbl_ComprobacionMesa1);
		
		lbl_Taburete3 = new JLabel("");
		lbl_Taburete3.setBounds(689, 124, 50, 56);
		panel_PantallaPrincipal.add(lbl_Taburete3);
		
		lbl_Taburete1 = new JLabel("");
		lbl_Taburete1.setBounds(585, 106, 50, 56);
		panel_PantallaPrincipal.add(lbl_Taburete1);
		
		lbl_Taburete2 = new JLabel("");
		lbl_Taburete2.setBounds(627, 126, 50, 56);
		panel_PantallaPrincipal.add(lbl_Taburete2);
		
		lbl_Detalles = new JLabel("");
		lbl_Detalles.setBounds(419, 82, 61, 70);
		panel_PantallaPrincipal.add(lbl_Detalles);
		
		lbl_Barra = new JLabel("");
		lbl_Barra.setBounds(572, 22, 170, 156);
		panel_PantallaPrincipal.add(lbl_Barra);
		
		btn_Horario = new JButton("Horario");
		btn_Horario.setForeground(Color.WHITE);
		btn_Horario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_Horario.setBorder(new LineBorder(null, 0));
		btn_Horario.setBackground(new Color(128, 0, 128));
		btn_Horario.setBounds(85, 280, 138, 48);
		panel_PantallaPrincipal.add(btn_Horario);
		
		btn_Contabilidad = new JButton("Contabilidad");
		btn_Contabilidad.setForeground(Color.WHITE);
		btn_Contabilidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_Contabilidad.setBorder(new LineBorder(null, 0));
		btn_Contabilidad.setBackground(new Color(128, 0, 128));
		btn_Contabilidad.setBounds(85, 220, 138, 48);
		panel_PantallaPrincipal.add(btn_Contabilidad);
		
		btn_Inventario = new JButton("Inventario");
		btn_Inventario.setForeground(Color.WHITE);
		btn_Inventario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_Inventario.setBorder(new LineBorder(null, 0));
		btn_Inventario.setBackground(new Color(128, 0, 128));
		btn_Inventario.setBounds(85, 160, 138, 48);
		panel_PantallaPrincipal.add(btn_Inventario);
		
		lbl_Mesa5 = new JLabel("");
		lbl_Mesa5.setBounds(595, 305, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa5);
		
		lbl_Mesa4 = new JLabel("");
		lbl_Mesa4.setBounds(400, 305, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa4);
		
		lbl_Mesa3 = new JLabel("");
		lbl_Mesa3.setBounds(688, 205, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa3);
		
		lbl_Mesa2 = new JLabel("");
		lbl_Mesa2.setBounds(495, 205, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa2);
		
		lbl_Mesa1 = new JLabel("");
		lbl_Mesa1.setBounds(310, 205, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa1);
		
		panel_ImgMarco = new JPanel();
		panel_ImgMarco.setBackground(new Color(245, 209, 215));
		panel_ImgMarco.setBorder(new LineBorder(new Color(70, 0, 130), 4));
		panel_ImgMarco.setBounds(274, 22, 127, 130);
		panel_PantallaPrincipal.add(panel_ImgMarco);
		panel_ImgMarco.setLayout(null);
		
		lbl_ImgEmpleado = new JLabel("");
		lbl_ImgEmpleado.setBounds(10, 10, 105, 108);
		panel_ImgMarco.add(lbl_ImgEmpleado);
		
		lbl_NombreEmpleado = new JLabel("");
		lbl_NombreEmpleado.setForeground(new Color(70, 0, 130));
		lbl_NombreEmpleado.setBounds(257, 122, 96, 17);
		panel_PantallaPrincipal.add(lbl_NombreEmpleado);
		lbl_NombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreEmpleado.setFont(new Font("Consolas", Font.BOLD, 16));
		
		lbl_CerrarSesion = new JLabel("");
		lbl_CerrarSesion.setBounds(10, 10, 68, 70);
		panel_PantallaPrincipal.add(lbl_CerrarSesion);
		
		lbl_ImgPrincipalApp = new JLabel("");
		lbl_ImgPrincipalApp.setBounds(0, 0, 897, 532);
		panel_PantallaPrincipal.add(lbl_ImgPrincipalApp);
		
		panel_InformacionProducto = new JPanel();
		panel_InformacionProducto.setForeground(new Color(0, 0, 0));
		panel_InformacionProducto.setBackground(new Color(245, 209, 215));
		panel_InformacionProducto.setBounds(0, 0, 897, 532);
		contentPane.add(panel_InformacionProducto);
		panel_InformacionProducto.setLayout(null);
		
		String[] columnas = {"Nombre", "Cantidad", "Unidad", "Calorías cada 100g/ml", "Calorías/Ingrediente"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
		
		tabla_Ingredientes = new JTable();
		tabla_Ingredientes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tabla_Ingredientes.setEnabled(false);
		tabla_Ingredientes.setBackground(new Color(255,255,255));
		tabla_Ingredientes.setForeground(new Color(0, 0, 0));
		tabla_Ingredientes.setFont(new Font("Consolas", Font.PLAIN, 16));
		tabla_Ingredientes.setModel(modeloTabla);
		
		tabla_Ingredientes.getColumnModel().getColumn(0).setPreferredWidth(650);
		tabla_Ingredientes.getColumnModel().getColumn(1).setPreferredWidth(225);
		tabla_Ingredientes.getColumnModel().getColumn(2).setPreferredWidth(225);
		tabla_Ingredientes.getColumnModel().getColumn(3).setPreferredWidth(525);
		tabla_Ingredientes.getColumnModel().getColumn(4).setPreferredWidth(525);
		
		tabla_Ingredientes.setRowHeight(30);
		
		tabla_Ingredientes.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
		tabla_Ingredientes.getTableHeader().setForeground(Color.WHITE);
		tabla_Ingredientes.getTableHeader().setBackground(new Color(128, 0, 128));
		
		checkBox_MostrarTablaIngredientes = new JCheckBox("Mostrar Tabla Ingredientes");
		checkBox_MostrarTablaIngredientes.setBackground(new Color(245, 209, 215));
		checkBox_MostrarTablaIngredientes.setForeground(new Color(0, 0, 0));
		checkBox_MostrarTablaIngredientes.setFont(new Font("Consolas", Font.BOLD, 16));
		checkBox_MostrarTablaIngredientes.setBounds(215, 235, 263, 35);
		checkBox_MostrarTablaIngredientes.setOpaque(false);
		checkBox_MostrarTablaIngredientes.setBorder(new LineBorder(new Color(60, 0, 200), 4));
		panel_InformacionProducto.add(checkBox_MostrarTablaIngredientes);
		
		lbl_InfoCaloriasTotalesProducto = new JLabel("");
		lbl_InfoCaloriasTotalesProducto.setForeground(Color.BLACK);
		lbl_InfoCaloriasTotalesProducto.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InfoCaloriasTotalesProducto.setBounds(521, 200, 165, 26);
		panel_InformacionProducto.add(lbl_InfoCaloriasTotalesProducto);
		
		lbl_InfoGrasasProducto = new JLabel("");
		lbl_InfoGrasasProducto.setForeground(Color.BLACK);
		lbl_InfoGrasasProducto.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InfoGrasasProducto.setBounds(461, 162, 150, 26);
		panel_InformacionProducto.add(lbl_InfoGrasasProducto);
		
		lbl_InfoProteinasProducto = new JLabel("");
		lbl_InfoProteinasProducto.setForeground(Color.BLACK);
		lbl_InfoProteinasProducto.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InfoProteinasProducto.setBounds(461, 124, 150, 26);
		panel_InformacionProducto.add(lbl_InfoProteinasProducto);
		
		lbl_GrasasProducto = new JLabel("GRASAS");
		lbl_GrasasProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_GrasasProducto.setForeground(new Color(60, 0, 200));
		lbl_GrasasProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_GrasasProducto.setBounds(363, 162, 58, 26);
		panel_InformacionProducto.add(lbl_GrasasProducto);
		
		lbl_ProteinasProducto = new JLabel("PROTEÍNAS");
		lbl_ProteinasProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ProteinasProducto.setForeground(new Color(60, 0, 200));
		lbl_ProteinasProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_ProteinasProducto.setBounds(363, 124, 83, 26);
		panel_InformacionProducto.add(lbl_ProteinasProducto);
		
		lbl_CaloriasTotalesProducto = new JLabel("CALORÍAS TOTALES");
		lbl_CaloriasTotalesProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CaloriasTotalesProducto.setForeground(new Color(60, 0, 200));
		lbl_CaloriasTotalesProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_CaloriasTotalesProducto.setBounds(363, 200, 146, 26);
		panel_InformacionProducto.add(lbl_CaloriasTotalesProducto);
		
		scrollPane_Ingredientes = new JScrollPane();
		scrollPane_Ingredientes.setEnabled(false);
		scrollPane_Ingredientes.setBounds(61, 302, 768, 117);
		scrollPane_Ingredientes.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		scrollPane_Ingredientes.setViewportView(tabla_Ingredientes);
		panel_InformacionProducto.add(scrollPane_Ingredientes);
		
		lbl_InfoNombreProducto = new JLabel("");
		lbl_InfoNombreProducto.setForeground(new Color(0, 0, 0));
		lbl_InfoNombreProducto.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InfoNombreProducto.setBounds(433, 91, 203, 21);
		panel_InformacionProducto.add(lbl_InfoNombreProducto);
		
		lbl_Ingredientes = new JLabel("INGREDIENTES");
		lbl_Ingredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ingredientes.setForeground(new Color(60, 0, 200));
		lbl_Ingredientes.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_Ingredientes.setBounds(377, 282, 127, 21);
		panel_InformacionProducto.add(lbl_Ingredientes);
		
		lbl_NombreProducto = new JLabel("NOMBRE");
		lbl_NombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreProducto.setForeground(new Color(60, 0, 200));
		lbl_NombreProducto.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreProducto.setBounds(363, 91, 58, 21);
		panel_InformacionProducto.add(lbl_NombreProducto);
		
		lbl_FotoProducto = new JLabel("");
		lbl_FotoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_FotoProducto.setBounds(215, 86, 139, 140);
		lbl_FotoProducto.setBorder(new LineBorder(new Color(60, 0, 200), 5));
		panel_InformacionProducto.add(lbl_FotoProducto);
		
		lbl_SalirInformacionProductos = new JLabel("");
		lbl_SalirInformacionProductos.setBounds(0, 0, 68, 70);
		panel_InformacionProducto.add(lbl_SalirInformacionProductos);
		
		lbl_ImgFondoInfoProductos = new JLabel("");
		lbl_ImgFondoInfoProductos.setBounds(0, 0, 897, 532);
		panel_InformacionProducto.add(lbl_ImgFondoInfoProductos);
		
		panel_InicioSesion = new JPanel();
		panel_InicioSesion.setBackground(new Color(255, 209, 220));
		panel_InicioSesion.setBounds(0, 0, 897, 532);
		contentPane.add(panel_InicioSesion);
		panel_InicioSesion.setLayout(null);
		
		horarioYFechaActual = new JPanel();
		horarioYFechaActual.setBounds(0,0,230,85);
		horarioYFechaActual.setBackground(new Color(252, 231, 234));
		panel_InicioSesion.add(horarioYFechaActual);
		horarioYFechaActual.setLayout(null);
		
		lblFecha = new JLabel("");
		lblFecha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblFecha.setBounds(121, 51, 99, 18);
		horarioYFechaActual.add(lblFecha);
		
		lblHora = new JLabel("");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Consolas", Font.BOLD, 16));
		lblHora.setBounds(121, 23, 77, 18);
		horarioYFechaActual.add(lblHora);
		
		lbl_ImgCalendario = new JLabel("");
		lbl_ImgCalendario.setBounds(10, 10, 99, 75);
		horarioYFechaActual.add(lbl_ImgCalendario);
		
		lblNombreLocal = new JLabel("La Casa del Pastel");
		lblNombreLocal.setForeground(new Color(128, 0, 128));
		lblNombreLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreLocal.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNombreLocal.setBounds(127, 91, 312, 43);
		panel_InicioSesion.add(lblNombreLocal);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		textFieldUsuario.setBounds(259, 161, 295, 25);
		panel_InicioSesion.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(60, 0, 200));
		lblUsuario.setFont(new Font("Consolas", Font.BOLD, 18));
		lblUsuario.setBounds(259, 146, 99, 18);
		panel_InicioSesion.add(lblUsuario);
		
		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setForeground(new Color(60, 0, 200));
		lblContraseña.setFont(new Font("Consolas", Font.BOLD, 18));
		lblContraseña.setBounds(259, 207, 111, 18);
		panel_InicioSesion.add(lblContraseña);
		
		btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.setBackground(new Color(128, 0, 128));
		btnInicioSesion.setForeground(new Color(255, 255, 255));
		btnInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInicioSesion.setBounds(337, 264, 146, 48);
		panel_InicioSesion.add(btnInicioSesion);
		
		lblEmpleadoIncorrecto = new JLabel("");
		lblEmpleadoIncorrecto.setForeground(new Color(255, 0, 0));
		lblEmpleadoIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleadoIncorrecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmpleadoIncorrecto.setBounds(259, 320, 295, 18);
		panel_InicioSesion.add(lblEmpleadoIncorrecto);
		
		passwordField_Contraseña = new JPasswordField();
		passwordField_Contraseña.setFont(new Font("Consolas", Font.PLAIN, 16));
		passwordField_Contraseña.setBounds(259, 227, 295, 25);
		panel_InicioSesion.add(passwordField_Contraseña);
		
		lbl_ImgFondo = new JLabel("");
		lbl_ImgFondo.setBounds(0, 0, 897, 532);
		panel_InicioSesion.add(lbl_ImgFondo);
		
		panel_DetallesEmpleado = new JPanel();
		panel_DetallesEmpleado.setBackground(new Color(245, 209, 215));
		panel_DetallesEmpleado.setBounds(0, 0, 897, 532);
		contentPane.add(panel_DetallesEmpleado);
		panel_DetallesEmpleado.setLayout(null);
		
		textArea_RequisitosTelefono = new JTextArea();
		textArea_RequisitosTelefono.setWrapStyleWord(true);
		textArea_RequisitosTelefono.setLineWrap(true);
		textArea_RequisitosTelefono.setForeground(new Color(83, 83, 83));
		textArea_RequisitosTelefono.setFont(new Font("Consolas", Font.BOLD, 13));
		textArea_RequisitosTelefono.setText("*El teléfono debe contener 9 números y sin caracteres especiales y sin espacios");
		textArea_RequisitosTelefono.setBackground(new Color(245, 209, 215));
		textArea_RequisitosTelefono.setBounds(376, 384, 340, 32);
		textArea_RequisitosTelefono.setOpaque(false);
		panel_DetallesEmpleado.add(textArea_RequisitosTelefono);
		
		textArea_MensajeInformacionCambiosRealizados = new JTextArea();
		textArea_MensajeInformacionCambiosRealizados.setFont(new Font("Consolas", Font.BOLD, 14));
		textArea_MensajeInformacionCambiosRealizados.setWrapStyleWord(true);
		textArea_MensajeInformacionCambiosRealizados.setLineWrap(true);
		textArea_MensajeInformacionCambiosRealizados.setBackground(new Color(245, 209, 215));
		textArea_MensajeInformacionCambiosRealizados.setEditable(false);
		textArea_MensajeInformacionCambiosRealizados.setOpaque(false);
		textArea_MensajeInformacionCambiosRealizados.setBounds(163, 306, 201, 77);
		panel_DetallesEmpleado.add(textArea_MensajeInformacionCambiosRealizados);
		
		textArea_RequisitosContraseña = new JTextArea();
		textArea_RequisitosContraseña.setEditable(false);
		textArea_RequisitosContraseña.setForeground(new Color(83, 83, 83));
		textArea_RequisitosContraseña.setFont(new Font("Consolas", Font.BOLD, 13));
		textArea_RequisitosContraseña.setText("*La contraseña debe contener 8 o más caracteres");
		textArea_RequisitosContraseña.setBackground(new Color(245, 209, 215));
		textArea_RequisitosContraseña.setBounds(376, 367, 340, 16);
		textArea_RequisitosContraseña.setOpaque(false);
		panel_DetallesEmpleado.add(textArea_RequisitosContraseña);
		
		btn_GuardarCambios = new JButton("Guardar Cambios");
		btn_GuardarCambios.setForeground(Color.WHITE);
		btn_GuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_GuardarCambios.setBackground(new Color(128, 0, 128));
		btn_GuardarCambios.setBounds(376, 419, 165, 44);
		panel_DetallesEmpleado.add(btn_GuardarCambios);
		
		textField_Contraseña = new JTextField();
		textField_Contraseña.setFont(new Font("Consolas", Font.BOLD, 18));
		textField_Contraseña.setBounds(376, 339, 171, 22);
		panel_DetallesEmpleado.add(textField_Contraseña);
		textField_Contraseña.setColumns(10);
		
		lbl_Contraseña = new JLabel("Contraseña*");
		lbl_Contraseña.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Contraseña.setForeground(new Color(60, 0, 200));
		lbl_Contraseña.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Contraseña.setBounds(376, 320, 102, 22);
		panel_DetallesEmpleado.add(lbl_Contraseña);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setFont(new Font("Consolas", Font.BOLD, 18));
		textField_Telefono.setColumns(10);
		textField_Telefono.setBounds(376, 290, 171, 22);
		panel_DetallesEmpleado.add(textField_Telefono);
		
		lbl_Telefono = new JLabel("Teléfono*");
		lbl_Telefono.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Telefono.setForeground(new Color(60, 0, 200));
		lbl_Telefono.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Telefono.setBounds(376, 270, 83, 22);
		panel_DetallesEmpleado.add(lbl_Telefono);
		
		textField_Direccion = new JTextField();
		textField_Direccion.setFont(new Font("Consolas", Font.BOLD, 18));
		textField_Direccion.setBounds(376, 237, 171, 22);
		panel_DetallesEmpleado.add(textField_Direccion);
		textField_Direccion.setColumns(10);
		
		lbl_Direccion = new JLabel("Dirección");
		lbl_Direccion.setForeground(new Color(60, 0, 200));
		lbl_Direccion.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Direccion.setBounds(376, 220, 102, 16);
		panel_DetallesEmpleado.add(lbl_Direccion);
		
		lbl_InformacionFechaIngreso = new JLabel("");
		lbl_InformacionFechaIngreso.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InformacionFechaIngreso.setBounds(376, 193, 130, 21);
		panel_DetallesEmpleado.add(lbl_InformacionFechaIngreso);
		
		lbl_FechaIngreso = new JLabel("Fecha Ingreso");
		lbl_FechaIngreso.setForeground(new Color(60, 0, 200));
		lbl_FechaIngreso.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_FechaIngreso.setBounds(376, 178, 135, 16);
		panel_DetallesEmpleado.add(lbl_FechaIngreso);
		
		lbl_InformacionApellidos = new JLabel("");
		lbl_InformacionApellidos.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InformacionApellidos.setBounds(376, 150, 201, 16);
		panel_DetallesEmpleado.add(lbl_InformacionApellidos);
		
		lbl_InformacionNombre = new JLabel("");
		lbl_InformacionNombre.setFont(new Font("Consolas", Font.BOLD, 18));
		lbl_InformacionNombre.setBounds(376, 104, 124, 16);
		panel_DetallesEmpleado.add(lbl_InformacionNombre);
		
		lbl_Apellidos = new JLabel("Apellidos");
		lbl_Apellidos.setForeground(new Color(60, 0, 200));
		lbl_Apellidos.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Apellidos.setBounds(376, 127, 100, 22);
		panel_DetallesEmpleado.add(lbl_Apellidos);
		
		lbl_Nombre = new JLabel("Nombre ");
		lbl_Nombre.setForeground(new Color(60, 0, 200));
		lbl_Nombre.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Nombre.setBounds(376, 88, 73, 16);
		panel_DetallesEmpleado.add(lbl_Nombre);
		
		panel_FotoEmpleado = new JPanel();
		panel_FotoEmpleado.setBackground(new Color(245, 209, 215));
		panel_FotoEmpleado.setBorder(new LineBorder(new Color(60, 0, 200), 4, true));
		panel_FotoEmpleado.setBounds(183, 85, 184, 213);
		panel_DetallesEmpleado.add(panel_FotoEmpleado);
		panel_FotoEmpleado.setLayout(null);
		
		lbl_FotoEmpleado = new JLabel("");
		lbl_FotoEmpleado.setBounds(12, 12, 160, 189);
		panel_FotoEmpleado.add(lbl_FotoEmpleado);
		
		lbl_Salir = new JLabel("");
		lbl_Salir.setBounds(0, 0, 68, 66);
		panel_DetallesEmpleado.add(lbl_Salir);
		
		lbl_ImgDetallesEmpleado = new JLabel("");
		lbl_ImgDetallesEmpleado.setBounds(0, 0, 897, 532);
		panel_DetallesEmpleado.add(lbl_ImgDetallesEmpleado);
		
		inicializarApp();
	}
	
	public void inicializarApp() {
		lbl_ImgFondo.setIcon(ajustarTamañoImg("src/img/fondoInicioSesion.jpg", lbl_ImgFondo.getWidth(), lbl_ImgFondo.getHeight()));
		actualizarFechaYHora();
		panel_PantallaPrincipal.setVisible(false);
		panel_DetallesEmpleado.setVisible(false);
		panel_InformacionProducto.setVisible(false);
		panel_GestionComandas.setVisible(false);
		panel_Inventario.setVisible(false);
	}
	
	private ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
	}//FIN AJUSTAR TAMAÑO IMG
	
	public void actualizarFechaYHora() {
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		lblHora.setText(ahora.format(formatoHora));
		lblFecha.setText(ahora.format(formatoFecha));
		lbl_ImgCalendario.setIcon(ajustarTamañoImg("src/img/calendario.png", lbl_ImgCalendario.getWidth(), lbl_ImgCalendario.getHeight()));
	}
}
