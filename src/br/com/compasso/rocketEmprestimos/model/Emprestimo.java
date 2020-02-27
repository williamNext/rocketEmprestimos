package br.com.compasso.rocketEmprestimos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Conta conta;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private MetodoPagamento pagamento;
	
	private BigDecimal jurosAoMes;
	private Integer parcelas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public MetodoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(MetodoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public BigDecimal getJurosAoMes() {
		return jurosAoMes;
	}

	public void setJurosAoMes(BigDecimal jurosAoMes) {
		this.jurosAoMes = jurosAoMes;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
