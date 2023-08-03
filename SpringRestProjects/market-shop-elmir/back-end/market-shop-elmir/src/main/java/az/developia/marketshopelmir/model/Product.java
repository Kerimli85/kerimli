package az.developia.marketshopelmir.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String barcode;
	private Double price;
	private Double cost;
	private String description;

	@Column(name = "register_date", updatable = false)
	private LocalDate registerDate;

	@Column(name = "update_date")
	private LocalDate updateDate;
	private Integer quantity = 1;
	private Double percent;
	private String loginingUser;

}
