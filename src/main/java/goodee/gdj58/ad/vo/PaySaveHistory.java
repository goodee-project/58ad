package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class PaySaveHistory {
	private int paySaveHistoryNo;
	private String paySaveHistoryCategory;
	private int paySaveHistoryContent;
	private String customerId;
	private int price;
	private String createdate;
}
