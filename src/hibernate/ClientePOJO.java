package hibernate;

import javax.persistence.*;


@Entity
@Table(name = "clientes", schema = "Hotel")

public class ClientePOJO implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Integer idCliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "email")
	private String email;
	@Column(name = "dni")
	private String dni;
	@Column(name = "clave")
	private String clave;

	public ClientePOJO() {
		
		Integer idCliente = 0;
		String nombre = "";
		String apellidos = "";
		String email = "";
	    String DNI = "";
		String clave = "";
	}

	public ClientePOJO(String nombre, String apellidos, String email, String dni, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.clave = clave;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}

