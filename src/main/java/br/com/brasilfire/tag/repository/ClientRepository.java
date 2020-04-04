package br.com.brasilfire.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilfire.tag.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { }