package goodee.gdj58.ad.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.ad.mapper.CustomerMapper;
import goodee.gdj58.ad.vo.AdCustomer;

@Service
@Transactional
public class CustomerService {
	@Autowired CustomerMapper customerMapper;
	
	public int getAddAdCustomer(String customerId, String customerPw
								, String customerName, String customerPhone1
								, String customerPhone2, String customerPhone3
								, String customerEmail1, String customerEmail2) {
		
		String customerPhone = customerPhone1+customerPhone2+customerPhone3;
		String customerEmail = customerEmail1+"@"+customerEmail2;
		
		Map<String, Object> customer = new HashMap<String,Object>();
		customer.put("customerId", customerId);
		customer.put("customerPw",customerPw);
		customer.put("customerName", customerName);
		customer.put("customerPhone", customerPhone);
		customer.put("customerEmail", customerEmail);
		
		customerMapper.insertTotalId(customer);
		customerMapper.insertAdCustomer(customer);
		customerMapper.insertAdCustomerInfo(customer);
		
		return 0;
	}
	
	// 아이디 중복 체크 null을 반환하면 사용가능한 아이디, 아이디를 반환하면 사용불가능한 아이디
	public String getCustomerIdCk(String customerId) {
		// null을 반환하면 사용가능한 아이디, 아이디를 반환하면 사용불가능한 아이디
		String resultStr = "NO";
		
		if(customerMapper.selectTotalIdCk(customerId) == null) {
			resultStr = "YES";
		}
		return resultStr;
	}
	
	public AdCustomer getLoginCustomer(String customerId, String customerPw) {
		AdCustomer paramCustomer = new AdCustomer();
		paramCustomer.setAdCustomerId(customerId);
		paramCustomer.setAdCustomerPw(customerPw);
		
		return customerMapper.selectLoginCustomer(paramCustomer);
	}
}
