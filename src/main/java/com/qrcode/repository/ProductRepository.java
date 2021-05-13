package com.qrcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qrcode.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query(value="select * from Product where ma_dn= :ma_dn ", nativeQuery=true)
	List<Product> findProductByUserId(@Param("ma_dn")Integer ma_dn);
	
	List<Product> findByTensanpham(String tensanpham);	
	List<Product> findByXuatxu(String xuatxu);

}
