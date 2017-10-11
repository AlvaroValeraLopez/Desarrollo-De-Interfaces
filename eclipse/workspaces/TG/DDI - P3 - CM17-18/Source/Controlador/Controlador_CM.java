package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Modelo_CM;
import Modelo.Modelo_MenuPrincipal_CM;
import Vista.Vista_CM;
import Vista.Vista_MenuPrincipal_CM;

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
						Vista_MenuPrincipal_CM vmpvm = new Vista_MenuPrincipal_CM();
						Modelo_MenuPrincipal_CM mmpcm = new Modelo_MenuPrincipal_CM();
						vmpvm.setVisible(true);

						String saludo = mmpcm.setUserWellcoming(usuario);
						vmpvm.editarUsuario(saludo);
						
						mmpcm.fillingTable(vmpvm.getTable(), mmpcm.sql());
						vcm.setVisible(false);

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
