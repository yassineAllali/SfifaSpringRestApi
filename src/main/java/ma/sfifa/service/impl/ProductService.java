package ma.sfifa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sfifa.exception.ResourceNotFoundException;
import ma.sfifa.model.Category;
import ma.sfifa.model.Product;
import ma.sfifa.model.Store;
import ma.sfifa.repository.ProductRepository;

@Service
public class ProductService implements ma.sfifa.service.ProductService{

	@Autowired
	private ProductRepository productRepository;

	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProduct(long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent())
			return product.get();
		throw new ResourceNotFoundException("Product", "Id", id);
	}
	
	@Override
	public Product createProduct(Product product) {
		product.setCategory(new Category(0, "jlaba", "jlaba", null));
		product.setStore(new Store(0, "jlaba.ma", "jlaba jdida", "address", "060606", "cover", "logo", "","","",null));
		return productRepository.save(product);
	}


	@Override
	public Product updateProduct(Product product, long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if(existingProduct.isPresent()) {
			Product toBeUpdatedProduct = existingProduct.get();
			
			toBeUpdatedProduct.setDescription(product.getDescription());
			toBeUpdatedProduct.setImages(product.getImages());
			toBeUpdatedProduct.setName(product.getName());
			toBeUpdatedProduct.setPrice(product.getPrice());
			
			return productRepository.save(toBeUpdatedProduct);
		}else {
			throw new ResourceNotFoundException("Product", "Id", id);
		}
	}

	@Override
	public void deleteProduct(long id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if(existingProduct.isPresent()) {
			Product toBeDeletedProduct = existingProduct.get();
			productRepository.delete(toBeDeletedProduct);
		}else {
			throw new ResourceNotFoundException("Product", "Id", id);
		}
	}

	
}
