package az.developia.marketshopelmir.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")

//cox istifadecilik verilenler bazasinda saxlanilir
public class UserModel {
	@Id
	private String username;
	private String password;

	// 0 ve 1 olur aktiv olub olmamasi false ve true qaytarir
	private Boolean enabled;

}
