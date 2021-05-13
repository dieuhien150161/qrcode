package com.qrcode.service;

import com.qrcode.domain.User;
import com.qrcode.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

 
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User findBySodienthoai(String sodienthoai) {
    	return userRepository.findBySodienthoai(sodienthoai);
    }
    
    public User findByTendoanhnghiep(String tendoanhnghiep) {
    	return userRepository.findByTendoanhnghiep(tendoanhnghiep);
    }
    
    public User findByNganhkinhdoanh(String nganhkinhdoanh) {
    	return userRepository.findByNganhkinhdoanh(nganhkinhdoanh);
    }
    
    public User findByDiachi(String diachi) {
    	return userRepository.findByDiachi(diachi);
    }
    
	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {
		return userRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}
}
