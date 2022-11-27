package inpost.pl.demo.services;

import inpost.pl.demo.adapters.secondary.db.ProductRepository;
import inpost.pl.demo.services.discount.DiscountService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceCalculator {

	private final ProductRepository productRepository;

	private final DiscountService discountService;

	public int calculatePrice(final UUID id, final int quantity) {
		int price = productRepository.findPriceById(id);
		return discountService.getBestPrice(price, quantity);
	}
}
