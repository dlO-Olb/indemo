package inpost.pl.demo.services.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiscountServiceTest {

	@Test
	void getBestPrice_noDiscounts_getProperPrice(){
		final DiscountService discountService = new DiscountService();
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(500, bestPrice);
	}

	@Test
	void setPercentDiscount_50percentDiscount_getPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setPercentageDiscount((short)50);
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(250, bestPrice);
	}

	@Test
	void removePercentDiscount_50percentDiscount_getPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setPercentageDiscount((short)50);
		discountService.removePercentageDiscount();
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(500, bestPrice);
	}

	@Test
	void setStepDiscount_10percentStep_getPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setStepDiscount((short)50, (short)10);
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(250, bestPrice);
	}

	@Test
	void removeStepDiscount_10percentStep_getPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setStepDiscount((short)70, (short)10);
		discountService.removeStepDiscount();
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(500, bestPrice);
	}

	@Test
	void getBestPrice_bothDiscountAvailablePercentIsBetter_getPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setStepDiscount((short)70, (short)10);
		discountService.setPercentageDiscount((short)50);

		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(250, bestPrice);
	}
	@Test
	void getBestPrice_bothDiscountAvailableStepPercentIsBetter_getStepPercentDiscountedPrice(){
		final DiscountService discountService = new DiscountService();
		discountService.setStepDiscount((short)50, (short)10);
		discountService.setPercentageDiscount((short)10);
		final int bestPrice = discountService.getBestPrice(100, 5);
		assertEquals(250, bestPrice);
	}
}