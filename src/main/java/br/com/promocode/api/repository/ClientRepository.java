package br.com.promocode.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.promocode.api.entity.Client;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client, Long> { }