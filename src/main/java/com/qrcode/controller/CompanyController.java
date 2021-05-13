package com.qrcode.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcode.domain.User;
import com.qrcode.model.Product;
import com.qrcode.service.IProductService;
import com.qrcode.service.ProductService;
import com.qrcode.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class CompanyController {	
	
	@Autowired
	private UserService userService;
	
	@Autowired IProductService productService;
	
	@GetMapping
	public String home(Model model) {
		List<User> users = (List<User>) userService.findAll();
		model.addAttribute("products", users);
		return "listUser";
	}
	
	@GetMapping("/homepage")
	public String page(Model model) {
		List<User> users = (List<User>) userService.findAll();
		model.addAttribute("products", users);
		return "homepage";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles   =     authentication.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		roles.forEach(v -> {System.out.println(v);});
		List<User> users = (List<User>) userService.findAll();
		model.addAttribute("products", users);
		return "listUser";
	}
	@GetMapping("/{id}/view")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("company", userService.getOne(id));
		return "viewUser";
	}
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
		userService.remove(id);
		redirect.addFlashAttribute("success", "Deleted doanh nghiệp successfully!");
		return "redirect:/admin/user";
	}
	
	@GetMapping("/{id}/edit")
	public String editProduct(@PathVariable Integer id, Model model){
		List<Product> products = productService.findByUserId(id);
		model.addAttribute("sanpham",products);
		return "listProductOfCompany";
	}

	

}
