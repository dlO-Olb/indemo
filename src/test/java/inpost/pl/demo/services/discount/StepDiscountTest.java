package inpost.pl.demo.services.discount;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StepDiscountTest {

	@Test
	void getDiscountedPrice_5percentStep50max_properDiscountApplied(){
		final StepDiscount stepDiscount = new StepDiscount((short)50, (short)5);
		final int discountedPrice = stepDiscount.getDiscountedPrice(100, 5);
		assertEquals(375, discountedPrice);
	}

	@Test
	void getDiscountedPrice_quantityMultiplierMoreThanMax_maxDiscountApplied(){
		final StepDiscount stepDiscount = new StepDiscount((short)10, (short)5);
		final int discountedPrice = stepDiscount.getDiscountedPrice(100, 5);
		assertEquals(450, discountedPrice);
	}
}