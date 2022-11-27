package inpost.pl.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import inpost.pl.demo.adapters.secondary.db.ProductRepository;
import inpost.pl.demo.services.discount.DiscountService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceCalculatorTest {

	@Mock
	private ProductRepository productRepository;

	@Mock
	private DiscountService discountService;

	@InjectMocks
	private PriceCalculator priceCalculator;

	@Test
	void calculatePrice_properData_properMethodCalledWithProperData() {
		final UUID id = UUID.randomUUID();
		final int mockedPrice = 100;
		final int quantity = 10;
		final int mockedBestPrice = 500;
		when(productRepository.findPriceById(id)).thenReturn(mockedPrice);
		when(discountService.getBestPrice(mockedPrice, quantity)).thenReturn(mockedBestPrice);
		final int bestPrice = priceCalculator.calculatePrice(id, quantity);
		assertEquals(mockedBestPrice, bestPrice);
		verify(productRepository, times(1)).findPriceById(id);
		verify(discountService, times(1)).getBestPrice(mockedPrice, quantity);
		verifyNoMoreInteractions(productRepository);
		verifyNoMoreInteractions(discountService);


	}
}