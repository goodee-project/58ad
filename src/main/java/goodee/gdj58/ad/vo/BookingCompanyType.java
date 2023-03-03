package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class BookingCompanyType {
	private int bookingCompanyTypeNo;
	private String bookingCompanyTypeContent;
	private int parentNo;
	private int groupNo;
	private int sequence;
	private int depth;
}
