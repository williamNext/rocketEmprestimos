package br.com.compasso.rocketEmprestimos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Conta conta;

	private Status status;
	private BigDecimal valor;
	private MetodoPagamento pagamento;
	private BigDecimal jurosAoMes;
	private BigDecimal parcelas;

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

	public BigDecimal getParcelas() {
		return parcelas;
	}

	public void setParcelas(BigDecimal parcelas) {
		this.parcelas = parcelas;
	}

}
