package goodee.gdj58.ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@PostMapping("/customer/addCustomer")
	public String addCustomer(@RequestParam(value="customerId") String customerId
							, @RequestParam(value="customerPw") String customerPw
							, @RequestParam(value="customerName") String customerName
							, @RequestParam(value="customerPhone1") String customerPhone1
							, @RequestParam(value="customerPhone2") String customerPhone2
							, @RequestParam(value="customerPhone3") String customerPhone3
							, @RequestParam(value="customerEmail1") String customerEmail1
							, @RequestParam(value="customerEmail2") String customerEmail2) {
		return "";
	}
	
	
}
