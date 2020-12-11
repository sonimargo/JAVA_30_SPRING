package dev.springBootH2.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.springBootH2.Utilitats.EstadoLibro;
import dev.springBootH2.Utilitats.EstadoUsuario;

@Entity
@Table(name="USUARIOS")
public class Usuario 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDUSUARIO")
	private Long idUsuario;
	
	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "CONTRASENYA")
	private String contrasenya;
	
	 @Column(name = "ESTADO")
	private EstadoUsuario estado;
	
	@OneToMany(mappedBy = "usuario", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private List<Reserva> listaDeReservas;
	
	
	public Usuario() 
	{
	}



	public Usuario(Long idUsuario, String usuario, String contrasenya) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
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



	public EstadoUsuario getEstado() {
		return estado;
	}



	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}



	public List<Reserva> getListaDeReservas() {
		return listaDeReservas;
	}



	public void setListaDeReservas(List<Reserva> listaDeReservas) {
		this.listaDeReservas = listaDeReservas;
	}



	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrasenya=" + contrasenya + "]";
	}

	
	
	
}
