package com.qrcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrcode.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	List<Message> findByHoten(String hoten);	
	List<Message> findByEmail(String email);


}
