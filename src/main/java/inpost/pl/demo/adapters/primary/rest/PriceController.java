package inpost.pl.demo.adapters.primary.rest;

import inpost.pl.demo.services.PriceCalculator;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

	private final PriceCalculator calculator;
	@GetMapping("/calculate/{id}")
	public int calculatePrice(@PathVariable final UUID id, @RequestParam final int quantity) {
		return calculator.calculatePrice(id, quantity);
	}
}
