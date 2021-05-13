package com.qrcode.service;

import com.qrcode.domain.User;

public interface IUserService extends GeneralService<User> {
	public User getOne(Integer id);
}
