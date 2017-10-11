package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

public class Vista_MenuPrincipal_CM extends JFrame {
	private JLabel variableUsuario;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_MenuPrincipal_CM frame = new Vista_MenuPrincipal_CM();
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
	public Vista_MenuPrincipal_CM() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		variableUsuario = new JLabel("");
		variableUsuario.setBounds(10, 11, 241, 14);
		getContentPane().add(variableUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 414, 199);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu insertarMn = new JMenu("Insertar");
		menuBar.add(insertarMn);
		
		JPanel panel = new JPanel();
		insertarMn.add(panel);

		JMenu mnNewMenu = new JMenu("Modificar");
		menuBar.add(mnNewMenu);

		JMenu mnBorrar = new JMenu("Borrar");
		menuBar.add(mnBorrar);
	}

	/*
	 * Esta funcion nos permite editar el mensaje de bienvenida.
	 */
	public void editarUsuario(String entrada) {
		variableUsuario.setText(entrada);
	}
	
	/*
	 * Esta funcion nos permite obtener el JTable.
	 */
	
	public JTable getTable() {
		
		return table;
	}
}
