package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {

	Connection conn = sqliteConnection.dbConnector();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private boolean consultaSql(String usuario, String contrasenia) {

		String sql = "SELECT NUM_FICHA FROM jugadoresinfo WHERE USUARIO=? and PASSWORD=? and CAPITAN=1";

		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, contrasenia);
			rs = pst.executeQuery();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean comprobarIdentidad(String usuario, String contrasenia) {

		if (consultaSql(usuario, contrasenia)) {
			int contador = 0;

			try {
				while (rs.next() && contador == 0) {
					contador++;
				}
				if (contador == 1) {

					pst.close();
					rs.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

}
