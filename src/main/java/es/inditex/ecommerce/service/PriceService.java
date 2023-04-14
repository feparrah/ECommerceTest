package es.inditex.ecommerce.service;


import es.inditex.ecommerce.dto.PriceRequest;
import es.inditex.ecommerce.dto.PriceResponse;

public interface PriceService {
	
	public PriceResponse getPriceProduct(PriceRequest request);

}
