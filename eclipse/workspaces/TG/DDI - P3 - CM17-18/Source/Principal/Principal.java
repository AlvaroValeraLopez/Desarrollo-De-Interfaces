package Principal;

import Controlador.Controlador_CM;
import Modelo.Modelo_CM;
import Vista.Vista_CM;

public class Principal {

	public static void main(String[] args) {

		Modelo_CM mcm = new Modelo_CM();
		Vista_CM vcm = new Vista_CM();
		Controlador_CM ccm = new Controlador_CM(vcm, mcm);
		vcm.setVisible(true);

	}

}
