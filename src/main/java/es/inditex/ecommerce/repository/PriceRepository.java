package es.inditex.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.inditex.ecommerce.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	public List<Price> findByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThan(Long productId, Long brandId, LocalDateTime date1, LocalDateTime date2);

}
