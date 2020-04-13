package br.com.restaurante.microservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoItem implements Serializable {

	private static final long serialVersionUID = 9057078747646571911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantidade;

	@JoinColumn(name = "pedido", referencedColumnName = "codigo")
	@ManyToOne(optional = false)
	private Pedido pedido;

	private int idTipoComida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getIdTipoComida() {
		return idTipoComida;
	}

	public void setIdTipoComida(int idTipoComida) {
		this.idTipoComida = idTipoComida;
	}

}
