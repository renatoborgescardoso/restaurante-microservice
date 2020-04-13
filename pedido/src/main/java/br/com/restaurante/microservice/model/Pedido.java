package br.com.restaurante.microservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = -8466662942299181734L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataPedido;
	
	@Enumerated(EnumType.STRING)
	private SituacaoPedidoEnum situacao;
	
	@JsonProperty( value = "pedidoItens", access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> pedidoItens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public SituacaoPedidoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedidoEnum situacao) {
		this.situacao = situacao;
	}

	public List<PedidoItem> getPedidoItens() {
		return pedidoItens;
	}

	public void setPedidoItens(List<PedidoItem> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}
}