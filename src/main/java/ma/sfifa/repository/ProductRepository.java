package ma.sfifa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sfifa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
