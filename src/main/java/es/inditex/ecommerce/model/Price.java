package es.inditex.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Price {
	
	@Id
	@Column
	private Long priceId;
	
	@Column
	private Long priority;
	
	@Column
	private Double price;
	
	@Column
	private String currency;
	
	@Column 
	private LocalDateTime startDate;
	
	@Column 
	private LocalDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName = "id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="brand_id", referencedColumnName = "id")
	private Brand brand;

}
