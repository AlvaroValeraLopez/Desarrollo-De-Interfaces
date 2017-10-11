package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Modelo_MenuPrincipal_CM {

	private Connection con = ConexionBbdd.dbConnector();
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public boolean fillingTable(JTable table, ResultSet rs) {

		try {
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String setUserWellcoming(String usuario) {

		try {

			return "Se ha autentificado como: " + usuario + ".";

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public ResultSet sql() {

		try {

			String sql = "SELECT NOMBRE, APELLIDOS, DORSAL, POBLACION, EQUIPO, EDAD, POSICION, GOLES, ASISTENCIAS,"
					+ "PARTIDOSJUGADOS, INFORMEDELJUGADOR, CAPITAN FROM jugadoresinfo";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String captainTeam() {

		String equipo = "";

		try {
			String sql = "SELECT EQUIPO FROM jugadoresinfo WHERE NUM_FICHA = ";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			equipo = rs.getString("EQUIPO");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return equipo;

	}

}
