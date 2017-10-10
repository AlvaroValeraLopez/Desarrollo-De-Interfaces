package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Modelo;
import Vista.vistaLogin;
import Vista.vistaMenu;

public class Controlador {

	private Modelo ml = new Modelo();
	private vistaLogin vl = new vistaLogin();

	public Controlador(vistaLogin vl, Modelo ml) {
		this.vl = vl;
		this.ml = ml;
		this.vl.addComprobarListener(new comprobarListener());
	}

	class comprobarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String usuario = "";
			String contrasenia = "";
			boolean comprobacion = false;
			try {
				usuario = vl.getCampoUsuario();
				contrasenia = vl.getCampoContrasenia();

				comprobacion = ml.comprobarIdentidad(usuario, contrasenia);
				if (comprobacion) {
					vistaMenu vm = new vistaMenu();
					vm.setVisible(true);
					vl.setVisible(false);
				}
			} catch (Exception Ex) {
				Ex.printStackTrace();
			}

		}

	}

}
