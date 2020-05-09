package br.com.promocode.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.promocode.api.entity.Product;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> { 
	
	@Query(value = "select t.* from Product t where t.client_id = (:clientId)", nativeQuery = true)
	List<Product> findProductsByClientId(@Param("clientId") long clientId);
	
}