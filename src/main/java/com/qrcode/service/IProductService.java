package com.qrcode.service;

import java.util.List;
import java.util.Optional;

import com.qrcode.model.Product;

public interface IProductService {
	public Product getOne(String id);
	Iterable<Product> findAll();
	List<Product> findByUserId(Integer id);
	Optional<Product> findById(String id);
	Product save(Product product);
	List<Product> findByTensanpham(String tensanpham);
	List<Product> findByXuatxu(String xuatxu);
	void remove(String id);
}
