package br.com.promocode.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ClientId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String mobile;

	@Column(nullable = false)
	private Date registerDate;

}