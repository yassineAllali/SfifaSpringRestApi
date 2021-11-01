package ma.sfifa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sfifa.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
