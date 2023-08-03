package az.developia.marketshopelmir.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellRequest {
	private String barcode;
	private Integer quantity;
} 