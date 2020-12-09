package dev.springBootH2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "CONTRASENYA")
	private String contrasenya;
	
	
	
	public Usuario() 
	{
	}



	public Usuario(Integer idUsuario, String usuario, String contrasenya) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasenya() {
		return contrasenya;
	}



	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}



	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrasenya=" + contrasenya + "]";
	}

	
	
	
}
