package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Persistencia {

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
		 System.out.println("El cliente " + p.getIdCliente() + ", " + p.getNombre() + ", "  + p.getApellidos() + ", "  + p.getEmail() + ", "  + p.getDni() + ", " + p.getClave() + " ha sido insertada correctamente");
		}
	

	public static List readClientes(int id) {
		Session sessionObj = getSessionFactory().openSession();
		//Para mostrar solo el contenido que indicamos mediante el id
		String query = "FROM ClientePOJO WHERE idCliente ='"+ id + "'";
		List resultado = sessionObj.createQuery(query).list();
	    Iterator clienteiterator = resultado.iterator();
	  
		 while (clienteiterator.hasNext()) {
		 ClientePOJO a2 = (ClientePOJO) clienteiterator.next();
		 System.out.println( a2.getIdCliente() +" - " + a2.getNombre() + " - " +
		  a2.getApellidos() + " - " + a2.getEmail() + " - " + a2.getDni()+ " - " + a2.getClave());
	 } 
		 sessionObj.close();
		 return resultado;
		
		
	} 
	public static void updateCliente(ClientePOJO ac, int id, String ap3) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 /*El método load(Pelicula.class, pelicula.getIdPelicula());
		  *  devuelve el objeto de tipo Dogs con el id especificado en el parámetro, del que queremos hacer la persistencia, 
		  *  en este caso concreto queremos actualizarlo.*/
		 ClientePOJO clienteBD = (ClientePOJO)sessionObj.load(ClientePOJO.class, id);
		 clienteBD.setApellidos(ap3);
		 transObj.commit();
		 sessionObj.close();
		 System.out.println(ac.getIdCliente()+" - "+ ac.getApellidos());
		 System.out.println("Actualizado correctamente");
		
	}
	


	 public static void deleteCliente(ClientePOJO ac, int id) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 ClientePOJO clienteBD = (ClientePOJO) sessionObj.load(ClientePOJO.class, id);
		 sessionObj.delete(clienteBD);
		 transObj.commit();
		 sessionObj.close();
		 System.out.println("Eliminado correctamente");
		 }
	


}

/****************************************************read según los apuntes*********************************************/
//public static List readClientes() {
//	Session sessionObj = getSessionFactory().openSession();
//    Para mostrar todo el contenido
//	//String query = "FROM ClientePOJO";
//	String query = "FROM ClientePOJO WHERE idCliente ='"+ idCliente + "'";
//	List resultado = sessionObj.createQuery(query).list();
//    Iterator clienteiterator = resultado.iterator();
//  
//	 while (clienteiterator.hasNext()) {
//	 ClientePOJO a2 = (ClientePOJO) clienteiterator.next();
//	 System.out.println( a2.getIdCliente() +" - " + a2.getNombre() + " - " +
//	  a2.getApellidos() + " - " + a2.getEmail() + " - " + a2.getDni()+ " - " + a2.getClave());
// } 
//	 sessionObj.close();
//	 return resultado;
//	
//	
//}

/************************************** Update según los apuntes*********************************/
//public static void updatePelicula(ClientePOJO cliente) {
//	 Session sessionObj = getSessionFactory().openSession();
//	 Transaction transObj = sessionObj.beginTransaction();
//	 ClientePOJO clienteBD = (ClientePOJO)sessionObj.load(ClientePOJO.class, cliente.getIdCliente());
//	 /* Modificamos todos los atributos */
//	 clienteBD.setNombre(cliente.getNombre());
//	 clienteBD.setApellidos(cliente.getApellidos());
//	 clienteBD.setEmail(cliente.getEmail());
//	 clienteBD.setDni(cliente.getDni());
//	 clienteBD.setClave(cliente.getClave());
//	 clienteBD.setNombre("Mario");
//	 clienteBD.setApellidos("Fernadez Ramirez");
//	 clienteBD.setEmail("marioramirez@gemail.com");
//	 clienteBD.setDni("30969421M");
//	 clienteBD.setClave("Studium2020;");
//	 transObj.commit();
//	 sessionObj.close();
//	 System.out.println(cliente.getNombre()+", "+ cliente.getApellidos()+", "+ cliente.getEmail()+", "+ cliente.getDni()+", "+ cliente.getClave());
//	 System.out.println("Actualizado correctamente");
//	
//	 }
