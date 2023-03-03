package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class BookingProductOption {
	private int bookingProductOptionNo;
	private int bookingProductNo;
	private String bookingProductOptionName;
	private String bookingProductOptionMemo;
	private int bookingProductOptionPrice;
	private String createdate;
}
