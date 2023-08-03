package az.developia.marketshopelmir.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();

	private Double totalPrice;

	@Column(name = "order_date")
	private LocalDate orderDate = LocalDate.now();
}
