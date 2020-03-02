package br.com.compasso.rocketEmprestimos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;
<<<<<<< HEAD

	@OneToMany(mappedBy = "agencia")
	private List<Agencia> agencias;
||||||| 52742ac
	
//	@ManyToOne(mappedBy = "agencia")
//	private List <Agencia> agencias;
=======

	@OneToMany(mappedBy = "banco")
	private List<Agencia> agencias;
>>>>>>> 2559e6fa9a5decf5fc2138934ce0df2c566f9874

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
}
