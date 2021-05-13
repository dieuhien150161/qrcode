package com.qrcode.service;

import java.util.Optional;

import com.qrcode.model.Message;

public interface IMessageService extends GeneralService<Message> {
	Optional<Message> findById(Integer id);
	void remove(Integer id);
}
