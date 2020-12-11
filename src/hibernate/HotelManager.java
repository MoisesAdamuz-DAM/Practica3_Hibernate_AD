package hibernate;

import java.util.Scanner;

public class HotelManager {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ClientePOJO ac = new ClientePOJO();
		int opcion;
		String cli;
		int id;
		
		do
		{
			System.out.println(" ");
			System.out.println("Menú");
			System.out.println(" ");
			System.out.println("1 - Crear Cliente");
			System.out.println("2 - Leer Datos Cliente");
			System.out.println("3 - Actualizar Cliente");
			System.out.println("4 - Eliminar Cliente");
			System.out.println("5 - Salir de la aplicación");
			
			
			opcion = teclado.nextInt();
			
			if(opcion == 1)
			{
				System.out.println("**** Crear Cliente ****");
				
				System.out.println("Inserte el nombre del cliente: ");
				cli = teclado.next();
				ac.setNombre(cli);
				
				System.out.println("Inserte el 1º apellido: ");
				String cli1P = teclado.next();
				
				
				System.out.println("Inserte el 2º apellido: ");
				String cli2P = teclado.next();
				String cli3 = cli1P + " "+ cli2P ;
				ac.setApellidos(cli3);
				
				System.out.println("Inserte el E-mail del cliente: ");
				cli = teclado.next();
				ac.setEmail(cli);
				
				System.out.println("Inserte el DNI del cliente: ");
				cli = teclado.next();
				ac.setDni(cli);
				
				System.out.println("Inserte la Clave del cliente: ");
				cli = teclado.next();
				ac.setClave(cli);
				
				Persistencia.create(ac);
				
			}
			else if(opcion == 2)
			{
				System.out.println("**** Leer Datos del Cliente ****");
				System.out.println("Inserte id del cliente: ");
				id = teclado.nextInt();
				
				Persistencia.readClientes(id);
				
			}
			else if (opcion == 3)
			{
				System.out.println("**** Actualizar Cliente ****");
				System.out.println("Inserte id del cliente: ");
				id = teclado.nextInt();
				System.out.println("Inserte el nuevo 1º apellido del cliente: ");
				String ap1 = teclado.next();
				System.out.println("Inserte el nuevo 2º apellido del cliente: ");
				String ap2 = teclado.next();
				String ap3 = ap1 + " " + ap2;
				
				Persistencia.updateCliente(ac,id,ap3);
				
			}
			else if (opcion == 4)
			{
				System.out.println("**** Eliminar Cliente ****");
				System.out.println("Inserte id del cliente: ");
				id = teclado.nextInt();
				
				Persistencia.deleteCliente(ac,id);
			}
			else if (opcion == 5)
			{
				 System.out.println("Salió del menu");
				 teclado.close();
			}
			else
			{
				System.err.println("Inserte solo los números del 1 al 5");
			}
		}
		while(opcion != 5);

	}

}
