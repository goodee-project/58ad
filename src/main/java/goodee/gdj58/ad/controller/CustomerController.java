package goodee.gdj58.ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.ad.service.CustomerService;
import goodee.gdj58.ad.vo.AdCustomer;


@Controller
public class CustomerController {
	@Autowired CustomerService customerService;

	// 메인페이지 호출
	@GetMapping("/main")
	public String getIndex(Model model, HttpSession session) {
		System.out.println(session.getAttribute("adCustomer")+"<-- session");
		
		if(session.getAttribute("adCustomer") != null) {
			model.addAttribute("adCustomer", session.getAttribute("adCustomer"));
		}
		return "main";
	}
	
	//로그인 폼
	@GetMapping("/customer/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/customer/login")
	public String login(HttpSession session
					, @RequestParam(value = "customerId") String customerId
					, @RequestParam(value="customerPw") String customerPw) {
		
		AdCustomer loginCustomer = customerService.getLoginCustomer(customerId, customerPw);
		
		if(loginCustomer == null) {
			System.out.println("로긴커스터머 널");
		} else {
			System.out.println("로긴커스터머 널아님");
		}
		
		session.setAttribute("adCustomer", loginCustomer);
		
		return "redirect:/main";
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
	
	//회원가입 
	@PostMapping("/customer/addCustomer")
	public String addCustomer(@RequestParam(value="customerId") String customerId
							, @RequestParam(value="customerPw") String customerPw
							, @RequestParam(value="customerName") String customerName
							, @RequestParam(value="customerPhone1") String customerPhone1
							, @RequestParam(value="customerPhone2") String customerPhone2
							, @RequestParam(value="customerPhone3") String customerPhone3
							, @RequestParam(value="customerEmail1") String customerEmail1
							, @RequestParam(value="customerEmail2") String customerEmail2) {
		
		customerService.getAddAdCustomer(customerId, customerPw, customerName, customerPhone1, customerPhone2, customerPhone3, customerEmail1, customerEmail2);
		System.out.println("서비스 실행");
		
		return "redirect:/customer/login";
	}
	
	
}
