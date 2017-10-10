package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista_CM extends JFrame {

	private JPanel layaut;
	private JTextField campoUsuario;
	private JTextField campoContrasenia;
	private JButton loginBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_CM frame = new Vista_CM();
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
	public Vista_CM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		layaut = new JPanel();
		layaut.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layaut);
		layaut.setLayout(null);

		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(110, 98, 70, 15);
		layaut.add(usuario);

		JLabel contrasenia = new JLabel("Contraseña");
		contrasenia.setBounds(110, 149, 101, 15);
		layaut.add(contrasenia);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(201, 96, 114, 19);
		layaut.add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContrasenia = new JTextField();
		campoContrasenia.setBounds(201, 149, 114, 19);
		layaut.add(campoContrasenia);
		campoContrasenia.setColumns(10);

		loginBtn = new JButton("Login");
		loginBtn.setBounds(182, 215, 117, 25);
		layaut.add(loginBtn);
	}

	public String getCampoUsuario() {
		return campoUsuario.getText();
	}

	public String getCampoContrasenia() {
		return campoContrasenia.getText();
	}

	public void addComprobarListener(ActionListener listenForLoginButton) {

		loginBtn.addActionListener(listenForLoginButton);

	}

	/*
	 * En este apartado vamos a crear los distintos mensajes de error.
	 */
	
	public void mensajeErrorLogin() {
		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto.");
	}
	
	public void mensajeErrorSql() {
		JOptionPane.showMessageDialog(null, "Se ha producido un error durante la ejecucion de la query.");
	}
}
