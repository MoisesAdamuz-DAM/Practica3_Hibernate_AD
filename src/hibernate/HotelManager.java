package hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HotelManager {

	private static SessionFactory getSessionFactory() {
		 SessionFactory sessionFactory = new Configuration().addAnnotatedClass(ClientePOJO.class).configure().buildSessionFactory();
		 return sessionFactory;
		 } 
	
	public static void create(ClientePOJO p) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 sessionObj.save(p);
		 transObj.commit();
		 sessionObj.close();
		 System.out.println("Persona " + p.getIdCliente() + " insertada correctamente");
		} 
	
	public static List readClientes() {
		 Session sessionObj = getSessionFactory().openSession();
		 String query = "FROM Pelicula";
		 List resultado = sessionObj.createQuery(query).list();
		 sessionObj.close();
		 return resultado;
		 } 
	
	public static void updatePelicula(ClientePOJO cliente) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 ClientePOJO clienteBD = (ClientePOJO)sessionObj.load(ClientePOJO.class, cliente.getIdCliente());
		 /* Modificamos todos los atributos */
		 clienteBD.setNombre(cliente.getNombre());
		 clienteBD.setApellidos(cliente.getApellidos());
		 clienteBD.setEmail(cliente.getEmail());
		 clienteBD.setDni(cliente.getDni());
		 clienteBD.setClave(cliente.getClave());
		 transObj.commit();
		 sessionObj.close();
		 System.out.println("Actualizado correctamente");
		 }
	
	 public static void deletePelicula(ClientePOJO cliente) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 ClientePOJO clienteBD = (ClientePOJO) sessionObj.load(ClientePOJO.class, cliente.getIdCliente());
		 sessionObj.delete(clienteBD);
		transObj.commit();
		 sessionObj.close();
		 System.out.println("Eliminado correctamente");
		 }
	public static void main(String[] args) {
		
		ClientePOJO ac = new ClientePOJO("María José", "Martínez", "mjmartinez@grupostudium.com", "12345678Z",
				"Studium2020");
				
				
				create(ac);
				

	}

}
