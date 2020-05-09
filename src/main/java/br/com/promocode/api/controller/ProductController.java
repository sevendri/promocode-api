package br.com.promocode.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.promocode.api.entity.Product;
import br.com.promocode.api.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository _productRepository;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> Get() {
		System.out.println("get all");
		return _productRepository.findAll();
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> GetById(@PathVariable(value = "id") long id) {
		return _productRepository.findProductsByClientId(id);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public Product Post(@Valid @RequestBody Product product) {
		return _productRepository.save(product);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Product> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Product newProduct) {
		Optional<Product> oldProduct = _productRepository.findById(id);
		if (oldProduct.isPresent()) {
			Product product = oldProduct.get();
			product.setClientId(newProduct.getClientId());
			product.setDescription(newProduct.getDescription());
			product.setPrice(newProduct.getPrice());
			product.setDiscount(newProduct.getDiscount());
			product.setReleaseDate(newProduct.getReleaseDate());
			product.setEndDate(newProduct.getEndDate());
			_productRepository.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Product> Delete(@PathVariable(value = "id") long id) {
		Optional<Product> product = _productRepository.findById(id);
		if (product.isPresent()) {
			_productRepository.delete(product.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}