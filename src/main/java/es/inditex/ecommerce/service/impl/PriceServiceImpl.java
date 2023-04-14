package es.inditex.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.inditex.ecommerce.dto.PriceRequest;
import es.inditex.ecommerce.dto.PriceResponse;
import es.inditex.ecommerce.exception.BadRequestException;
import es.inditex.ecommerce.model.Price;
import es.inditex.ecommerce.repository.PriceRepository;
import es.inditex.ecommerce.service.PriceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

	private final PriceRepository repository;

	private final ModelMapper modelMapper;

	public PriceServiceImpl(PriceRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PriceResponse getPriceProduct(PriceRequest request) {
		List<Price> priceList = repository
				.findByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThan(request.getProductId(),
						request.getBrandId(), request.getEffectiveDate(), request.getEffectiveDate())
				.stream().collect(Collectors.toList());
		if (!priceList.isEmpty()) {
			PriceResponse response = modelMapper.map(priceList.stream().reduce((a, b) -> {
				return (a.getPriority() > b.getPriority() ? a : b);
			}).get(), PriceResponse.class);
			response.setEffectiveDate(request.getEffectiveDate());
			return response;
		} else {
			throw new BadRequestException("There is not exist prices for actual request data");
		}

	}

}
