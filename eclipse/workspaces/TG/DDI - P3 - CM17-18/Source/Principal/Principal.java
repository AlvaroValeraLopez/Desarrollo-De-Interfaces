package Principal;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.vistaLogin;

public class Principal {

	public static void main(String[] args) {

		vistaLogin vl = new vistaLogin();

		Modelo ml = new Modelo();

		Controlador control = new Controlador(vl, ml);

		vl.setVisible(true);

	}
}
