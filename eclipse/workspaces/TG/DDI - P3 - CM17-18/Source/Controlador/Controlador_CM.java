package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Modelo_CM;
import Vista.Vista_CM;

public class Controlador_CM {

	Vista_CM vcm;
	Modelo_CM mcm;

	public Controlador_CM(Vista_CM vcm, Modelo_CM mcm) {
		this.vcm = vcm;
		this.mcm = mcm;
		this.vcm.addComprobarListener(new comprobarListener());
	}

	class comprobarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String usuario = "";
			String contrasenia = "";
			boolean comprobacion = false;

			try {

				usuario = vcm.getCampoUsuario();
				contrasenia = vcm.getCampoContrasenia();

				comprobacion = mcm.comprobarIdentidad(usuario, contrasenia);

				if (mcm.getComrpobarEjecucionSql()) {
					if (comprobacion) {
						// ESTE ESTA AQUI SOLO PARA LA COMRPOBACION DEL TRUE,
						// PERO EN UN FUTURO TIENE QUE DESAPARECER Y DAR PASO A
						// LA CREACION DE LA VENTANA NUEVA Y EL CIERRE DE LA ACTUAL
						JOptionPane.showMessageDialog(null, "TRUE");
					} else {
						vcm.mensajeErrorLogin();
					}
				} else {
					vcm.mensajeErrorSql();
				}

			} catch (Exception Ex) {
				Ex.printStackTrace();
			}
		}

	}

}
