package inpost.pl.demo.services.discount;

public class PercentageDiscount implements Discountable {

	final float percentOfAFinalPrice;

	public PercentageDiscount(final short discountPercent) {
		this.percentOfAFinalPrice = (float)(100 - discountPercent)/100;
	}

	public int getDiscountedPrice(final int singleUnitPrice, final int quantity) {
		return (int)(singleUnitPrice * quantity * percentOfAFinalPrice);
	}
}
