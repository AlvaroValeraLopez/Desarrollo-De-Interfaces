package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionBbdd {

	public static Connection dbConnector() {

		try {

			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:BBDD//jugadores.sqlite");
			JOptionPane.showMessageDialog(null, "Conexión establecida");
			return con;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}
}
