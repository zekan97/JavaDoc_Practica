package cuentas;

import java.util.Scanner;

public class TestBanco {

	public static void main(String[] args) {
		/**
		 * Desde el test creamos el banco
		 * y llamamos a opercionesMenu 
		 * y desde hay podemos hacer todo
		 */
		Banco cuenta = new Banco();
		cuenta.operacionesMenu();
		
	}
}
