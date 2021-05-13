package com.qrcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.model.Product;
import com.qrcode.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> findByUserId(Integer id){
		return productRepository.findProductByUserId(id);
	}
	
	@Override
	public Optional<Product> findById(String id) {
		// TODO Auto-generated method stub
	 return productRepository.findById(id);
	}

	@Override
	public Product save(Product t) {
		// ác chưa làm hàm save bảo sao hs saVE ĐK
		
		return productRepository.save(t);
	}



	@Override
	public Product getOne(String id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

	@Override
	public List<Product> findByTensanpham(String tensanpham) {
		return productRepository.findByTensanpham(tensanpham);
	}

	@Override
	public List<Product> findByXuatxu(String xuatxu) {
		// TODO Auto-generated method stub
		return productRepository.findByXuatxu(xuatxu);
	}

	@Override
	public void remove(String id) {
		productRepository.deleteById(id);
		
	}

}
