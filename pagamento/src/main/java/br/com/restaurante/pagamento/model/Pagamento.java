package br.com.restaurante.pagamento.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -5377102508734334559L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private LocalDate dataPagamento;

	@Enumerated(EnumType.STRING)
	private SituacaoPagamentoEnum situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public SituacaoPagamentoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPagamentoEnum situacao) {
		this.situacao = situacao;
	}

}
