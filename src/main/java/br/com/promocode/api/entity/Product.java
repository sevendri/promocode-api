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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@Column(nullable = false)
	private long clientId;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private double discount;

	@Column(nullable = false)
	private Date releaseDate;

	@Column(nullable = false)
	private Date endDate;
}