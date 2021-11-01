package ma.sfifa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sfifa.model.Store;

@Repository
public interface StoreRepository  extends JpaRepository<Store, Long>{

}
