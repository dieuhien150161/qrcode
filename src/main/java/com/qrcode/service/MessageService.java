package com.qrcode.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.model.Message;
import com.qrcode.repository.MessageRepository;

@Service
public class MessageService implements IMessageService {
	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public Iterable<Message> findAll() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}

	@Override
	public Optional<Message> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message save(Message t) {
		// TODO Auto-generated method stub
		return messageRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Message> findById(Integer id) {
		// TODO Auto-generated method stub
		return messageRepository.findById(id);
	}

	@Override
	public void remove(Integer id) {
		messageRepository.deleteById(id);
		
	}

}
