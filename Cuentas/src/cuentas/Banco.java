package cuentas;

import java.util.Scanner;

	/**
	 * 
	 * @author Iñaki Jorge Ramirez
	 * @version V3.1
	 * <a href="https://github.com/zekan97/JavaDoc_Practica.git">Enlace a github </a>
	 */
public class Banco {

	/**
	 *  Variables que vamos a usar
	 *  en este proyecto
	 */
		private int numCuentas;
		private CCuenta array[];
		
	/**
	 *  Constructor de la clase
	 *  banco, el array sera dinamico.
	 */
	/////////////////////////////////////////////////////
		
		public Banco() {
			numCuentas = 0;
			array = new CCuenta[numCuentas];
		}
		
	/**
	 * Este metodo lo que hace es hacer 
	 * un hueco mas grande el array.
	 * No devulve nada.
	 */
		/////////////////////////////////////////////////////
		public void unElementoMas(CCuenta aux[]) {
			array = new CCuenta[numCuentas +1];
			for(int i = 0; i < numCuentas; i++)	{
				array[i] = aux[i];
			} 
			numCuentas++;
		}
		
		/**
		 * Este metodo hace exactamente lo 
		 * contrario a unElementoMas.
		 * Este metodo no devuelve nada
		 */
		/////////////////////////////////////////////////////
		
		public void unElementoMenos(CCuenta aux[])	{
			

			array = new CCuenta[numCuentas -1];
			/**
			 * J se usa para posicionarte en el array destino
			 */
			int j = 0;
			for(int i = 0; i < numCuentas; i++)	{
				if(aux[i] != null)	{
					array[j] = aux[i];
					j++;
				}
			}
			numCuentas --;
		}
		
	/////////////////////////////////////////////////////
	
		/**
		 * 
		 * Este metodo se encarga de comprobar
		 * si el array esta vacio o no.
		 * @return boolean arrayVacio()
		 */
		
		public boolean arrayVacio() {
			return (numCuentas == 0);
		}
		
		/////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se encarga de redireccionarte
		 * atraves de un switch al metodo que elijas.
		 */
		
		public void operacionesMenu() {
			boolean salir = false;
;
			
			if (!salir)
			do {
				int opcion = verMenu();
				salir = (opcion == 7);
				switch(opcion)	{ 
				case 1:
					consulta();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					altas();
					break;
				case 5:
					bajas();
					break;					
				case 6:
					
					break;
				}
			}while (!salir);	
			System.out.println("Programa finalizado");
		}


		/////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo visualiza el menu de la
		 * aplicación el cual te pide una opcion 
		 * y la devuelve.
		 * @return opcion
		 */
		public int verMenu()
		{
			Scanner entrada = new Scanner (System.in);
			boolean opcionValida = true;
			int opcion;
			System.out.println("¿Que quieres hacer?");
			System.out.println("-------------------");
			System.out.println("1.Consultar saldo");
			System.out.println("2.Ingreso");
			System.out.println("3.Reintegro");
			System.out.println("4.Altas");
			System.out.println("5.Bajas");
			System.out.println("6.Mantemiento");
			System.out.println("7.Salir");
			do 
			{ 	
				System.out.println("Elige una opción: ");
				opcion = entrada.nextInt();	
				opcionValida = (opcion >=1 && opcion <=7);
				if (!opcionValida) 
				{
					System.err.println("La opcion no es valida");	
				}
			}while (!opcionValida);
			return opcion;	
		}
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		/** 
		 * Este metodo busca el ter
		 * @param termino
		 * @return i en caso afirmativo 
		 * y -1 en caso negativo
		 */
		
		public int buscar(String termino) {
				for(int i = 0; i < numCuentas; i++) {
				if(termino.equals(array[i].getNombre()) || termino.equals(array[i].getCuenta())) {
					return i;
				}	
			}
			return -1;
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se encarga de eliminar una cuenta
		 * la cual se le pasa por referencia y devuelve 
		 * true o false dependiendo de si la elimina o 
		 * no
		 * @param cuenta
		 * @return true or false
		 */
		public boolean eliminar(String cuenta) {
			if (arrayVacio()) {
				System.out.println("No hay ninguna cuenta guardada");
				return false;
			} else {	

			int pos = buscar(cuenta);
				if (pos == -1) {
					return false;
				} else {
					array[pos] = null;
					unElementoMenos(array);
					System.out.println("La cuenta ha sido eliminida.");
					return true;
				}
		}
	}	
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo inserta en una posicion
		 * del array una cuenta nueva
		 * @param cuenta
		 * @param pos
		 */
		public void insertarEn(CCuenta cuenta, int pos ) {
			boolean posValida; 
			posValida = (pos >= numCuentas);
				if (posValida) {
					System.err.println("La posicion donde deseas insertar esta cuenta no es valida");
				} else {
					array[pos] = cuenta;
					System.out.println("Se ha insertado correctamente");
				}
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se encarga de devolver la referencia
		 * de la cuenta que hay en X posicion
		 * @param pos
		 * @return array[pos].cuenta
		 */
		public String retornarValor(int pos) {
			boolean posValida;
			posValida = (pos >= numCuentas);
			if (posValida) {
				return null;
			}
			return array[pos].cuenta;
			
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo combina
		 * dos de los anteriores 
		 * e inserta en el array 
		 * unos datos
		 * @param cuenta
		 */
		public void anadir(CCuenta cuenta)
		{
			unElementoMas(array);
			insertarEn(cuenta, numCuentas-1);
		}
		
		//////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo sirve para dar de alta 
		 * una cuenta y decir de que tipo es
		 */
		public void altas() {
				Scanner entrada = new Scanner (System.in);
				boolean opcionValida = true;
				int opcion;
				System.out.println("¿Que quieres tipo de cuentas es?");
				System.out.println("-------------------");
				System.out.println("1.Cuenta ahorro");
				System.out.println("2.Cuenta corriente");
				System.out.println("3.Cuenta corriente con intereses");
				do 	{ 	
					System.out.println("Elige el tipo de cuenta: ");
					opcion = entrada.nextInt();	
					opcionValida = (opcion >=1 && opcion <=3);
					if (!opcionValida) 
					{
						System.err.println("La opcion no es valida");	
					}
				}while (!opcionValida);
				leerDatos(opcion);
			}	
		
		//////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo recibe la opcion
		 * que dice que tipo de cuenta es
		 * y rellena los datos de la misma
		 * @param opcion
		 */
		public void leerDatos(int opcion) {
			//Introducimos los datos
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce el nombre");
			String nombre = entrada.nextLine();
			System.out.println("Introduce el numero de cuenta");
			String cuenta = entrada.nextLine();
			System.out.println("Introduce los intereses de la cuenta");
			double intereses = entrada.nextDouble();
			System.out.println("¿Cuanto quieres ingresar en esta cuenta?");
			double saldo = entrada.nextDouble();
				if (opcion == 1) {
					System.out.println("¿Que cuota de mantenimiento tiene esta cuenta?");
					double cuotaMantenimiento = entrada.nextDouble();
				anadir( new CCuentaAhorro (nombre, cuenta, intereses, saldo, cuotaMantenimiento));
				} else {
					if(opcion == 2) {
						System.out.println("¿Cuantas transacciones tiene exentas de comision?");
						int transExentas = entrada.nextInt();
						System.out.println("¿Que comision tiene por transaccion?");
						double importePorTrans = entrada.nextDouble();
						anadir( new CCuentaCorriente (nombre, cuenta, intereses, saldo, importePorTrans, transExentas ));
					} else {
						System.out.println("¿Cuantas transacciones tiene exentas de comision?");
						int transExentas = entrada.nextInt();
						System.out.println("¿Que comision tiene por transaccion?");
						double importePorTrans = entrada.nextDouble();
						anadir( new CCuentaCorrienteConIn (nombre, cuenta, intereses, saldo, importePorTrans, transExentas ));
					}
				}
			
		}	
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se usa para leer el numero de una cuenta
		 * @return cuenta
		 */
		public String leerCuenta() {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce el numero de cuenta que deseas buscar");
			String cuenta = entrada.nextLine();
			return cuenta;
			
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se usa para leer el nombre de una cuenta
		 * @return nombre
		 */
		public String leerNombre() {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce el nombre del titular");
			String nombre = entrada.nextLine();
			return nombre;			
		}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se encarga de realizar una 
		 * consulta y de buscar por el nombre o por el 
		 * numero de cuenta
		 */
		
		public void consulta() {
			Scanner entrada = new Scanner(System.in);
			boolean opcionValida;
			String opcion;
			String cuentaonombre = null;
			if (arrayVacio()) {
					System.out.println("No hay cuentas");
			} else {
			System.out.println("¿Quieres buscar por nombre de titular o numero de cuenta?");
			System.out.println("Introduce una 'n' para el nombre o una 'c' para el numero de cuenta");
			System.out.println("-------------------------------------------------------------------");
			do {
			opcion = entrada.nextLine();
			opcionValida = (opcion.equals("n") || opcion.equals("c"));
				if(opcion.equals("n")) {
					cuentaonombre = leerNombre();
				} else {
					if(opcion.equals("c")) {
						cuentaonombre = leerCuenta();
					} else { 
						System.err.println("La opcion no es valida");
					}
				}
			} while (!opcionValida);
			int pos = buscar(cuentaonombre);
			System.out.println("El nombre es " + array[pos].getNombre() + " el numero de cuenta es " + array[pos].getCuenta() + " y el saldo que tiene es " + array[pos].getSaldo());
			}
		}	
		
		////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo elimina la cuenta que le digas
		 */
		public void bajas() {
			if (arrayVacio()) {
				System.out.println("No hay cuentas");
			} else {
				String cuenta = leerCuenta();
				eliminar(cuenta);
			}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * Este metodo se encarga de ingresar 
		 * una cantidad en una cuenta
		 */
		public void ingresar() {
			Scanner entrada = new Scanner(System.in);
			System.out.println("¿Cuanto deseas ingresar?");
			double cantidad = entrada.nextDouble();
			
		
		}
	}
