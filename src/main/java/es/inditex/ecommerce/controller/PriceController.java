package es.inditex.ecommerce.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.inditex.ecommerce.dto.PriceRequest;
import es.inditex.ecommerce.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private final PriceService service;

	public PriceController(PriceService service) {
		this.service = service;
	}

	@GetMapping("/brands/{brandId}/products/{productId}")
	@ResponseBody
	public ResponseEntity<?> getPriceByProduct(
			@RequestParam(name = "effectiveDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime effectiveDate,
			@PathVariable(value = "brandId", required = true) Long brandId,
			@PathVariable(value = "productId", required = true) Long productId) {

		return new ResponseEntity<Object>(service.getPriceProduct(
				PriceRequest.builder().brandId(brandId).effectiveDate(effectiveDate).productId(productId).build()),
				HttpStatus.OK);

	}

}
