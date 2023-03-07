package goodee.gdj58.ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {

	// 메인페이지 호출
	@GetMapping("/main")
	public String getIndex() {
		return "main";
	}
	
	//로그인 폼
	@GetMapping("/customer/login")
	public String login() {
		return "login";
	}
	
	//로그아웃 폼
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/customer/login";
	}
	
	//회원가입 폼
	@GetMapping("/customer/addCustomer")
	public String addCustomer() {
		return "addCustomer";
	}
	
	
}
