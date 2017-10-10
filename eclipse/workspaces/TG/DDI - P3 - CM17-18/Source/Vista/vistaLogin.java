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

public class vistaLogin extends JFrame {

	private JPanel layaout;
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
					vistaLogin frame = new vistaLogin();
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
	public vistaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		layaout = new JPanel();
		layaout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(layaout);
		layaout.setLayout(null);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(114, 86, 70, 15);
		layaout.add(usuario);
		
		JLabel contrasenia = new JLabel("Contraseña");
		contrasenia.setBounds(114, 144, 95, 15);
		layaout.add(contrasenia);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(213, 84, 114, 19);
		layaout.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrasenia = new JTextField();
		campoContrasenia.setColumns(10);
		campoContrasenia.setBounds(213, 142, 114, 19);
		layaout.add(campoContrasenia);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(165, 220, 117, 25);
		layaout.add(loginBtn);
	}

	public String getCampoUsuario() {
		return campoUsuario.getText();

	}

	public String getCampoContrasenia() {
		return campoContrasenia.getText();

	}

	public void mensajeErrorBbdd() {	
		JOptionPane.showMessageDialog(null, "La conexion con la bbdd ha fallado.");
	}
	
	public void mensajeErrorComprobacion() {	
		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
	}
	
	public void mensajeError() {
		
	}
	public void addComprobarListener(ActionListener listenForLoginButton) {

		loginBtn.addActionListener(listenForLoginButton);

	}
}
