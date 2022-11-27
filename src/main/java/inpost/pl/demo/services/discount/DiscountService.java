package inpost.pl.demo.services.discount;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

	private final HashMap<DiscountType, Discountable> availableDiscounts = new HashMap<>();

	public int getBestPrice(int unitPrice, int quantity) {
		return availableDiscounts.values()
		                         .stream()
		                         .map(discountable -> discountable.getDiscountedPrice(unitPrice, quantity))
		                         .min(Integer::compareTo)
		                         .orElse(quantity * unitPrice);
	}

	public void setStepDiscount(final short maxPercentDiscount, final short percentStep){
		availableDiscounts.put(DiscountType.STEP, new StepDiscount(maxPercentDiscount, percentStep));
	}
	public void setPercentageDiscount(final short percentDiscount){
		availableDiscounts.put(DiscountType.PERCENT, new PercentageDiscount(percentDiscount));
	}

	public void removeStepDiscount(){
		availableDiscounts.remove(DiscountType.STEP);
	}
	public void removePercentageDiscount(){
		availableDiscounts.remove(DiscountType.PERCENT);
	}

	enum DiscountType {
		PERCENT,
		STEP
	}
}
