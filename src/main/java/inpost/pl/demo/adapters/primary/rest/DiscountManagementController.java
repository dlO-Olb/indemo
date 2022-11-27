package inpost.pl.demo.adapters.primary.rest;

import inpost.pl.demo.services.discount.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount-management/")
@RequiredArgsConstructor
public class DiscountManagementController {

	private final DiscountService discountService;

	@PatchMapping("/percentage-discount")
	public void setPercentageDiscount(@RequestParam final short percentageDiscount) {
		discountService.setPercentageDiscount(percentageDiscount);
	}

	@PatchMapping("/step-discount")
	public void setStepDiscount(@RequestParam final short maxPercentDiscount, @RequestParam final short percentStep) {
		discountService.setStepDiscount(maxPercentDiscount, percentStep);
	}

	@DeleteMapping("/percentage-discount")
	public void deletePercentageDiscount() {
		discountService.removePercentageDiscount();
	}

	@DeleteMapping("/step-discount")
	public void deleteStepDiscount() {
		discountService.removeStepDiscount();
	}


}
