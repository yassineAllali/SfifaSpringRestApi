package ma.sfifa.service;

import java.util.List;

import ma.sfifa.model.Product;

public interface ProductService {

	Product createProduct(Product product);
	List<Product> getAllProducts();
	Product updateProduct(Product product, long id);
	void deleteProduct(long id);
	Product getProduct(long id);
}
