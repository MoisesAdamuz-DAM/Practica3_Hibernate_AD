package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelFunciones {
	
	
	private static SessionFactory getSessionFactory()
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(ClientePOJO.class).configure().buildSessionFactory();
		return sessionFactory;
	}
	
	//Guardamos un objeto, para hacerlo persistente
	public static void create(ClientePOJO cliente) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); // Crea una transacción
		session.save(cliente);
		
		tx.commit();
		session.close();
		System.out.println("Cliente "+ cliente.getIdCliente()+ " insertado correctamente.");
		
	}

	public static List readCliente() 
	{
		String c = "FROM Clientes";
		Session sessionObj = getSessionFactory().openSession();
		List results =  sessionObj.createQuery(c).list();
		Iterator clienteiterator = results.iterator();
		while(clienteiterator.hasNext())
		{
			ClientePOJO a2 = (ClientePOJO) clienteiterator.next();
			System.out.println(" - " + a2.getNombre() + " - " +
					a2.getApellidos() + " - " + a2.getEmail() + " - " + a2.getDni()+ " - " + a2.getClave());
					 }
					 sessionObj.close();
					 return results; 
	}

}
