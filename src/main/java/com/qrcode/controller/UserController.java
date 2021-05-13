package com.qrcode.controller;

import com.qrcode.domain.Role;
import com.qrcode.domain.User;
import com.qrcode.domain.UserForm;
import com.qrcode.model.Product;
import com.qrcode.repository.RoleRepository;
import com.qrcode.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

@Controller
@RequestMapping(value = {"/register"})
public class UserController {
	@Autowired
	RoleRepository roleRepository;
	@Value("${upload.path}")
	private String fileUpload;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("user") UserForm user, RedirectAttributes redirect) {
			System.out.println("User is created"); 
			User user1 = userService.findByEmail(user.getEmail());
			if(user1 != null) {
				redirect.addFlashAttribute("error", "Email này đã tồn tại trong hệ thống !!");
				return "redirect:/register";
			}
			
			 user1 = new User.UserBuilder(user.getId()).chucVuNguoiDaiDien(user.getChucvunguoidaidien())
					.daiDienDoanhNghiep(user.getDaidiendoanhnghiep()).diaChi(user.getDiachi()).email(user.getEmail())
					.nganhKinhDoanh(user.getNganhkinhdoanh()).soDienThoai(user.getSodienthoai())
					.tenDoanhnghiep(user.getTendoanhnghiep())
					.build();
			
			MultipartFile img1 = user.getAnhlogo();
			String img1Name = img1.getOriginalFilename();
			try {
				FileCopyUtils.copy(user.getAnhlogo().getBytes(), new File(this.fileUpload + img1Name));
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			user1.setAnhlogo("/images/" + img1Name);
			
			HashSet<Role> roles = new HashSet<>();
			String password = user.getPassword();
			user1.setPassword(passwordEncoder.encode(password));
			roles.add(roleRepository.findByName("ROLE_CLIENT"));
			user1.setRoles(roles);
			user1.setUsertype(2);
			userService.save(user1);
			redirect.addFlashAttribute("success", "Đăng kí thành công!");
			return "redirect:/login1";
	}

}
