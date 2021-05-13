package com.qrcode.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcode.domain.Role;
import com.qrcode.domain.User;
import com.qrcode.repository.UserRepository;

import lombok.val;

@Controller
public class MainController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepos;

	@GetMapping("/")
	public String index(RedirectAttributes redirect) {
		return "redirect:/home";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@RequestMapping("/login1")
	public String login1(@RequestParam(required = false) String message, final Model model) {
		logicLogin(message, model);
		return "login";
	}

	@RequestMapping("/login2")
	public String login2(@RequestParam(required = false) String message, final Model model) {
		logicLogin(message, model);
		return "login2";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/trangchu";
	}

	private void logicLogin(@RequestParam(required = false) String message, Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
	}

	@PostMapping("/loginadmin")
	public String authenticateUser(@RequestParam String username, @RequestParam String password,
			final Model model, HttpServletResponse response) throws IOException {
		User user = userRepos.findByEmail(username);
//		user.getRoles().forEach(v->{if(v.getName().equals("ROLE_CLIENT"))
//			try {
//				response.sendRedirect("/login1");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}});
		for (Role role : user.getRoles()) {
			if(role.getName().equals("ROLE_CLIENT")) { 
				model.addAttribute("message", "Tài khoản client vui lòng đăng nhập tại đây!");
				return "login";}
		}
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "redirect:/admin/user/";
	}

}