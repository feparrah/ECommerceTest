package es.inditex.ecommerce.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {

	private Long productId;
	
	private Long brandId;
	
	private Long priceId;
	
	private LocalDateTime effectiveDate;
	
	private Double price;
}
