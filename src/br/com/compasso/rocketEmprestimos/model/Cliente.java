package br.com.compasso.rocketEmprestimos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false)
	private String cpf;

<<<<<<< HEAD
	@OneToOne(mappedBy = "conta")
	private Conta conta;

||||||| 52742ac
=======
	@OneToOne(mappedBy = "cliente")
	private Conta conta;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
