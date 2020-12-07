package hotel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelManager {
	
	

	public static void main(String[] args) {
	
	//1.Crear objetos
	  ClientePOJO cliente = new ClientePOJO("María José", "Martínez", "mjmartinez@grupostudium.com", "12345678Z","Studium2020");
	  HotelFunciones.create(cliente);
	
	//2.Leer
	  HotelFunciones.readCliente();
		
		
	}



}
