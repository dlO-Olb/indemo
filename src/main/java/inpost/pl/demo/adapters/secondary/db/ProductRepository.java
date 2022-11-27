package inpost.pl.demo.adapters.secondary.db;

import inpost.pl.demo.adapters.secondary.db.models.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, UUID> {

	@Query("select p.price from Product p where p.id = ?1")
	int findPriceById(final UUID id);

}
