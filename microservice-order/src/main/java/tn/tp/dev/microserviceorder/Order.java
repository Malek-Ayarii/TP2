package tn.tp.dev.microserviceorder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité JPA représentant une commande.
 * Le nom de la table est changé car "order" est un mot réservé en SQL.
 */
@Entity
@Table(name = "order-db")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String product;

	private int quantity;

	private Long customerId;

	/**
	 * Constructeur vide obligatoire pour Hibernate.
	 */
	public Order() {
	}

	/**
	 * Constructeur utile pour initialiser les données.
	 */
	public Order(Long id, String product, int quantity, Long customerId) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.customerId = customerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order{id=" + id + ", product='" + product + "', quantity=" + quantity
				+ ", customerId=" + customerId + "}";
	}
}
