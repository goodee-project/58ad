package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class BookingCancel {
	private int bookingNo;
	private String cancelMemo;
	private String cancelSubject;
	private String createdate;
}
