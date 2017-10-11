package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Modelo_CM {

	private Connection con = ConexionBbdd.dbConnector();
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private boolean comprobarEjecucionSql = false;

	private boolean ejecutarSql(String usuario, String contrasenia) {

		try {

			String sql = "SELECT NUM_FICHA, NOMBRE FROM jugadoresinfo WHERE USUARIO=? and PASSWORD=? and CAPITAN=1 ";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, contrasenia);
			rs = pst.executeQuery();
			
			comprobarEjecucionSql = true;

		} catch (Exception e) {
			e.printStackTrace();
			comprobarEjecucionSql = false;
		}

		return comprobarEjecucionSql;

	}

	public boolean comprobarIdentidad(String usuario, String contrasenia) {

		boolean retorno = false;

		if (ejecutarSql(usuario, contrasenia)) {

			int contador = 0;

			try {
				while (rs.next() && contador == 0) {
					contador++;
				}

				if (contador == 1) {
					retorno = true;
				} else {
					retorno = false;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			retorno = false;
		}

		return retorno;
	}

	public boolean getComrpobarEjecucionSql() {
		return comprobarEjecucionSql;
	}
}
