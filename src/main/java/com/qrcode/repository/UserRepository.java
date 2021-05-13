package com.qrcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrcode.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findBySodienthoai(String sodienthoai);
    User findByTendoanhnghiep(String tendoanhnghiep);
    User findByNganhkinhdoanh(String nganhkinhdoanh);
    User findByDiachi(String diachi);

}