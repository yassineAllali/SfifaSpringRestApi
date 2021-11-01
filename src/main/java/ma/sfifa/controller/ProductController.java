package ma.sfifa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.sfifa.model.Product;
import ma.sfifa.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id){
		return new ResponseEntity<Product>(productService.getProduct(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(
				productService.createProduct(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id){
		return new ResponseEntity<Product>(
				productService.updateProduct(product, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted Succesfully", HttpStatus.OK);
	}
	
	
	
	
	
}
