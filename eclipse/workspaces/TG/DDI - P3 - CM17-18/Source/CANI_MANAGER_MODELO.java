import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class CANI_MANAGER_MODELO {

	
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
