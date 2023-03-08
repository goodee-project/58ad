package goodee.gdj58.ad.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import goodee.gdj58.ad.service.CustomerService;

@RestController
public class CustomerRestController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/customer/customerIdCk")
	@ResponseBody
	public String getCustomerIdCk(@RequestParam(value="customerId") String customerId) {
		
		String ck = customerService.getCustomerIdCk(customerId);
		return ck;
	}
}
