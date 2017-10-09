import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;

public class Login {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//CREAMOS UN OBJETO PARA GUARDAR LA CONEXIÓN
	Connection conn=null;
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		//ESTABLECEMOS LA CONEXION Y LA GUARDAMOS EN UNA VARIABLE
		conn = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\key-icon16.png"));
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblUsuario.setBounds(111, 44, 46, 14);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblPassword.setBounds(95, 96, 62, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		userField = new JTextField();
		userField.setBounds(191, 38, 185, 29);
		frmLogin.getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 90, 185, 29);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setIcon(new ImageIcon("img\\tick_circle.png"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//CREAMOS LA CONSULTA
					String query = "SELECT NUM_FICHA FROM jugadoresinfo WHERE USUARIO=? and PASSWORD=? and CAPITAN=1";
					//PREPARALAMOS LA CONSULTA
					PreparedStatement pst = conn.prepareStatement(query);
					//PASAMOS LOS DATOS DE LOS INPUT A LA CONSULTA
					pst.setString(1, userField.getText());
					pst.setString(2, new String(passwordField.getPassword()));
					ResultSet rs = pst.executeQuery();
					
					int contador = 0;
					
					while(rs.next() && contador==0) {
						contador++;
					}
					
					if(contador == 1) {
						JOptionPane.showMessageDialog(null, "Identificado correctamente");
						frmLogin.dispose();
						EmpleadoInfo emp1 = new EmpleadoInfo();
						emp1.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecta");
						
					}
					rs.close();
					pst.close();
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnEntrar.setForeground(new Color(0, 128, 0));
		btnEntrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnEntrar.setBounds(201, 167, 164, 34);
		frmLogin.getContentPane().add(btnEntrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\2\u00BA DAM\\Workspace\\Company\\img\\Amazon-Kindle-icon.png"));
		lblNewLabel.setBounds(14, 134, 70, 70);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{userField, passwordField, btnEntrar}));
	}
}
