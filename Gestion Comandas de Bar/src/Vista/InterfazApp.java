package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	public JLabel lbl_NombreComida1_1;
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
	public JLabel lbl_BebidaCaliente;
	public JLabel lbl_InformacionBebida2;
	public JButton btnAñadirBebida2;
	public JButton btnRetirarBebida2;
	public JProgressBar progressBar_Bebida2;
	public JComboBox comboBox_TipoBebidaCaliente;
	public JLabel lbl_InformacionBebida4;
	public JButton btnAñadirBebida4;
	public JButton btnRetirarBebida4;
	public JProgressBar progressBar_Bebida4;

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
		//panel_Bebidas.setOpaque(false);
		panel_GestionComandas.add(panel_Bebidas);
		panel_Bebidas.setLayout(null);
		
		lbl_Refresco = new JLabel("");
		lbl_Refresco.setBounds(22, 243, 169, 165);
		panel_Bebidas.add(lbl_Refresco);
		
		comboBox_TipoCafe = new JComboBox();
		comboBox_TipoCafe.setFont(new Font("Consolas", Font.BOLD, 14));
		comboBox_TipoCafe.setForeground(new Color(0, 0, 0));
		comboBox_TipoCafe.setBounds(203, 22, 138, 33);
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
		progressBar_Bebida1.setBounds(22, 199, 169, 14);
		panel_Bebidas.add(progressBar_Bebida1);
		
		comboBox_TipoRefresco = new JComboBox();
		comboBox_TipoRefresco.setFont(new Font("Consolas", Font.BOLD, 14));
		comboBox_TipoRefresco.setForeground(new Color(0, 0, 0));
		comboBox_TipoRefresco.setBounds(203, 243, 138, 33);
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
		progressBar_Bebida3.setBounds(22, 420, 169, 14);
		panel_Bebidas.add(progressBar_Bebida3);
		
		lbl_Batido = new JLabel("");
		lbl_Batido.setBounds(365, 22, 169, 165);
		panel_Bebidas.add(lbl_Batido);
		
		comboBox_TipoBatido = new JComboBox();
		comboBox_TipoBatido.setFont(new Font("Consolas", Font.BOLD, 14));
		comboBox_TipoBatido.setBounds(546, 22, 153, 33);
		panel_Bebidas.add(comboBox_TipoBatido);
		
		lbl_BebidaCaliente = new JLabel("");
		lbl_BebidaCaliente.setBounds(365, 243, 169, 165);
		panel_Bebidas.add(lbl_BebidaCaliente);
		
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
		progressBar_Bebida2.setBounds(365, 199, 169, 14);
		panel_Bebidas.add(progressBar_Bebida2);
		
		comboBox_TipoBebidaCaliente = new JComboBox();
		comboBox_TipoBebidaCaliente.setFont(new Font("Consolas", Font.BOLD, 14));
		comboBox_TipoBebidaCaliente.setBounds(542, 243, 157, 33);
		panel_Bebidas.add(comboBox_TipoBebidaCaliente);
		
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
		progressBar_Bebida4.setBounds(365, 420, 169, 14);
		panel_Bebidas.add(progressBar_Bebida4);
		
		panel_Comidas = new JPanel();
		panel_Comidas.setBackground(new Color(245, 209, 215));
		panel_Comidas.setBounds(0, 82, 715, 450);
		panel_Comidas.setOpaque(false);
		panel_GestionComandas.add(panel_Comidas);
		panel_Comidas.setLayout(null);
		
		progressBar_Comida6 = new JProgressBar();
		progressBar_Comida6.setBounds(12, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida6);
		
		progressBar_Comida5 = new JProgressBar();
		progressBar_Comida5.setBounds(248, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida5);
		
		progressBar_Comida4 = new JProgressBar();
		progressBar_Comida4.setBounds(480, 419, 160, 14);
		panel_Comidas.add(progressBar_Comida4);
		
		progressBar_Comida3 = new JProgressBar();
		progressBar_Comida3.setBounds(480, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida3);
		
		progressBar_Comida2 = new JProgressBar();
		progressBar_Comida2.setBounds(248, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida2);
		
		progressBar_Comida1 = new JProgressBar();
		progressBar_Comida1.setBounds(12, 218, 160, 14);
		panel_Comidas.add(progressBar_Comida1);
		
		btnAñadirComida6 = new JButton("Añadir");
		btnAñadirComida6.setForeground(Color.BLACK);
		btnAñadirComida6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida6.setBackground(new Color(0, 213, 0));
		btnAñadirComida6.setBounds(616, 307, 92, 31);
		panel_Comidas.add(btnAñadirComida6);
		
		lbl_NombreComida6 = new JLabel("New label");
		lbl_NombreComida6.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida6.setBounds(480, 391, 145, 16);
		panel_Comidas.add(lbl_NombreComida6);
		
		lbl_InformacionComida6 = new JLabel("");
		lbl_InformacionComida6.setBounds(616, 253, 32, 32);
		panel_Comidas.add(lbl_InformacionComida6);
		
		btnEliminarComida6 = new JButton("Retirar");
		btnEliminarComida6.setForeground(Color.BLACK);
		btnEliminarComida6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida6.setBackground(Color.RED);
		btnEliminarComida6.setBounds(616, 351, 92, 31);
		panel_Comidas.add(btnEliminarComida6);
		
		lbl_PrecioComida6 = new JLabel("");
		lbl_PrecioComida6.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida6.setBounds(644, 387, 51, 16);
		panel_Comidas.add(lbl_PrecioComida6);
		
		lbl_PrecioComida5 = new JLabel("");
		lbl_PrecioComida5.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida5.setBounds(412, 387, 51, 16);
		panel_Comidas.add(lbl_PrecioComida5);
		
		lbl_Comida6 = new JLabel("");
		lbl_Comida6.setBounds(480, 256, 128, 126);
		panel_Comidas.add(lbl_Comida6);
		
		lbl_NombreComida3 = new JLabel("New label");
		lbl_NombreComida3.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida3.setBounds(480, 190, 145, 16);
		panel_Comidas.add(lbl_NombreComida3);
		
		btnEliminarComida3 = new JButton("Retirar");
		btnEliminarComida3.setForeground(Color.BLACK);
		btnEliminarComida3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida3.setBackground(Color.RED);
		btnEliminarComida3.setBounds(616, 148, 92, 31);
		panel_Comidas.add(btnEliminarComida3);
		
		lbl_PrecioComida3 = new JLabel("");
		lbl_PrecioComida3.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida3.setBounds(648, 188, 51, 16);
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
		
		JButton btnEliminarComida5 = new JButton("Retirar");
		btnEliminarComida5.setForeground(Color.BLACK);
		btnEliminarComida5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida5.setBackground(Color.RED);
		btnEliminarComida5.setBounds(380, 351, 92, 31);
		panel_Comidas.add(btnEliminarComida5);
		
		btnAñadirComida5 = new JButton("Añadir");
		btnAñadirComida5.setForeground(Color.BLACK);
		btnAñadirComida5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAñadirComida5.setBackground(new Color(0, 213, 0));
		btnAñadirComida5.setBounds(380, 307, 92, 31);
		panel_Comidas.add(btnAñadirComida5);
		
		lbl_NombreComida5 = new JLabel("New label");
		lbl_NombreComida5.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida5.setBounds(248, 391, 145, 16);
		panel_Comidas.add(lbl_NombreComida5);
		
		lbl_Comida5 = new JLabel("");
		lbl_Comida5.setBounds(248, 256, 128, 126);
		panel_Comidas.add(lbl_Comida5);
		
		lbl_NombreComida2 = new JLabel("New label");
		lbl_NombreComida2.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida2.setBounds(248, 190, 145, 16);
		panel_Comidas.add(lbl_NombreComida2);
		
		lbl_PrecioComida2 = new JLabel("");
		lbl_PrecioComida2.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida2.setBounds(410, 186, 51, 16);
		panel_Comidas.add(lbl_PrecioComida2);
		
		btnEliminarComida2 = new JButton("Retirar");
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
		btnEliminarComida4.setForeground(new Color(0, 0, 0));
		btnEliminarComida4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida4.setBackground(Color.RED);
		btnEliminarComida4.setBounds(138, 348, 92, 31);
		panel_Comidas.add(btnEliminarComida4);
		
		lbl_InformacionComida4 = new JLabel("");
		lbl_InformacionComida4.setBounds(140, 253, 32, 32);
		panel_Comidas.add(lbl_InformacionComida4);
		
		lbl_NombreComida1_1 = new JLabel("New label");
		lbl_NombreComida1_1.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida1_1.setBounds(12, 391, 145, 16);
		panel_Comidas.add(lbl_NombreComida1_1);
		
		lbl_NombreComida1 = new JLabel("New label");
		lbl_NombreComida1.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_NombreComida1.setBounds(12, 190, 145, 16);
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
		btnEliminarComida1.setForeground(new Color(0, 0, 0));
		btnEliminarComida1.setBackground(new Color(255, 0, 0));
		btnEliminarComida1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarComida1.setBounds(138, 147, 92, 31);
		panel_Comidas.add(btnEliminarComida1);
		
		lbl_PrecioComida1 = new JLabel("");
		lbl_PrecioComida1.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida1.setBounds(173, 190, 51, 16);
		panel_Comidas.add(lbl_PrecioComida1);
		
		lbl_PrecioComida4 = new JLabel("");
		lbl_PrecioComida4.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_PrecioComida4.setBounds(169, 391, 51, 16);
		panel_Comidas.add(lbl_PrecioComida4);
		
		lbl_Mesa_o_Taburete = new JLabel("");
		lbl_Mesa_o_Taburete.setForeground(new Color(0, 0, 0));
		lbl_Mesa_o_Taburete.setFont(new Font("Consolas", Font.BOLD, 16));
		lbl_Mesa_o_Taburete.setBounds(740, 55, 130, 37);
		panel_GestionComandas.add(lbl_Mesa_o_Taburete);
		
		comboBox_Menu = new JComboBox();
		comboBox_Menu.setFont(new Font("Consolas", Font.BOLD, 16));
		comboBox_Menu.setBounds(133, 12, 142, 37);
		panel_GestionComandas.add(comboBox_Menu);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(728, 99, 157, 229);
		panel_GestionComandas.add(scrollPane);
		
		list_ListaPedidos = new JList();
		scrollPane.setViewportView(list_ListaPedidos);
		
		lbl_SalirComandas = new JLabel("");
		lbl_SalirComandas.setBounds(0, 0, 68, 70);
		panel_GestionComandas.add(lbl_SalirComandas);
		
		lbl_ImgFondoComandas = new JLabel("");
		lbl_ImgFondoComandas.setBounds(0, 0, 897, 532);
		panel_GestionComandas.add(lbl_ImgFondoComandas);
		
		panel_InformacionProducto = new JPanel();
		panel_InformacionProducto.setBackground(new Color(245, 209, 215));
		panel_InformacionProducto.setBounds(0, 0, 897, 532);
		contentPane.add(panel_InformacionProducto);
		panel_InformacionProducto.setLayout(null);
		
		lbl_ImgFondoInfoProductos = new JLabel("");
		lbl_ImgFondoInfoProductos.setBounds(0, 0, 897, 532);
		panel_InformacionProducto.add(lbl_ImgFondoInfoProductos);
		
		panel_PantallaPrincipal = new JPanel();
		panel_PantallaPrincipal.setBackground(new Color(245, 209, 215));
		panel_PantallaPrincipal.setBounds(0, 0, 897, 532);
		panel_PantallaPrincipal.setBorder(new LineBorder(null, 0));
		contentPane.add(panel_PantallaPrincipal);
		panel_PantallaPrincipal.setVisible(false);
		panel_PantallaPrincipal.setLayout(null);
		
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
		lbl_Mesa5.setBounds(598, 305, 110, 110);
		panel_PantallaPrincipal.add(lbl_Mesa5);
		
		lbl_Mesa4 = new JLabel("");
		lbl_Mesa4.setBounds(390, 305, 110, 110);
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
		lblNombreLocal.setForeground(new Color(75, 0, 130));
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
		textArea_RequisitosTelefono.setFont(new Font("Consolas", Font.BOLD, 12));
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
		textArea_RequisitosContraseña.setFont(new Font("Consolas", Font.BOLD, 12));
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
