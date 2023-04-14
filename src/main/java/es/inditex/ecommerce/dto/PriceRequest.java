package es.inditex.ecommerce.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequest {
	
	private LocalDateTime effectiveDate;
	
	private Long productId;
	
	private Long brandId;

}
