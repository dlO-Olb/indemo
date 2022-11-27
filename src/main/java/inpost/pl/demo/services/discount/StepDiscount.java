package inpost.pl.demo.services.discount;

public class StepDiscount implements Discountable {

	final float minPercentOfAFinalPrice;
	final float percentageStep;

	public StepDiscount(final short maxPercentageDiscount, final short percentageStep) {
		this.minPercentOfAFinalPrice = (float)(100 - maxPercentageDiscount)/100;
		this.percentageStep = (float) percentageStep/100;
	}

	public int getDiscountedPrice(final int singleUnitPrice, final int quantity) {

		return (int)(singleUnitPrice * quantity * getPercentOfFinalPrice(quantity));
	}

	private float getPercentOfFinalPrice(final int quantity) {
		final float stepPercentOfAFinalPrice = (float)1 - (quantity * percentageStep);
		return Math.max(minPercentOfAFinalPrice, stepPercentOfAFinalPrice);
	}
}
