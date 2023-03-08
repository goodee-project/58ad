package goodee.gdj58.ad.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.ad.vo.AdCustomer;

@Mapper
public interface CustomerMapper {
	
	//totalId 추가
	int insertTotalId(Map<String,Object> paramMap);
	
	// adCustomer 추가
	int insertAdCustomer(Map<String,Object> paramMap);
	
	// adCustomerInfo 추가
	int insertAdCustomerInfo(Map<String,Object> paramMap);
	
	// id 중복검사
	String selectTotalIdCk(String customerId);
	
	// 로그인
	AdCustomer selectLoginCustomer(AdCustomer paramCustomer);
}
