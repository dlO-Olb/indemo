package inpost.pl.demo.services.discount;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PercentageDiscountTest {

	@Test
	void getDiscountedPrice_30percentDiscount_properDiscountApplied(){
		final PercentageDiscount stepDiscount = new PercentageDiscount((short)30);
		final int discountedPrice = stepDiscount.getDiscountedPrice(100, 10);
		assertEquals(700, discountedPrice);
	}
}