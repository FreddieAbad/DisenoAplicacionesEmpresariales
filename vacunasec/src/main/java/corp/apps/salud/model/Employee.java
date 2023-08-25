package corp.apps.salud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Los nombres son obligatorios")
	@Pattern(regexp="(^[\\p{L}\\s.’\\-,]+$)", message="Nombres invalidos")
	@Column(name = "firstName", nullable = false)
	private String firstName;
	 
	@NotEmpty(message = "Los apellidos son obligatorios")
	@Pattern(regexp="(^[\\p{L}\\s.’\\-,]+$)", message="Apellidos invalidos")
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@NotEmpty(message = "El correo electronico es obligatorio")
	@Pattern(regexp="(^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$)", message="El formato del correo es invalido")
	@Column(name = "email", nullable = false)
	private String email;

	@NotEmpty(message = "La cedula es obligatoria")
	@Pattern(regexp="(^$|[0-9]{10})", message="La cedula debe ser un valor de 10 digitos")
	@Column(name = "documentID", nullable = false)
	private String documentID;

/*	@NotEmpty(message = "La cedula es obligatoria")
	@Pattern(regexp="(^$|[0-9]{10})", message="La cedula debe ser un valor de 10 digitos")
	@Column(name = "documentID", nullable = false)
	private String documentID;*/

	@NotEmpty(message = "El usuario es obligatorio")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="El usuario debe ser un valor alfanumerico")
	@Column(name = "user", nullable = false)
	private String user;
	
/*	@Column(name = "user")
	private String user;*/

	@NotEmpty(message = "El password es obligatorio")
	//@Pattern(regexp="(^$|[0-9]{10})", message="La cedula debe ser un valor de 10 digitos")
	@Column(name = "password", nullable = false)
	//@Column(name = "password")
	private String password;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobilePhone")
	private String mobilePhone;
	
	@Column(name = "vaccinationStatus")
	private String vaccinationStatus;
	
	@Column(name = "vaccine")
	private String vaccine;

	@Column(name = "vaccinationDate")
	private String vaccinationDate;
	
	@Column(name = "numberDoses")
	private int numberDoses; 
	
	public String getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(String vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public int getNumberDoses() {
		return numberDoses;
	}

	public void setNumberDoses(int numberDoses) {
		this.numberDoses = numberDoses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
