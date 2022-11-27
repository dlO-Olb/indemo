package inpost.pl.demo.adapters.secondary.db.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;
@Data
@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private UUID id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private int price;
}
