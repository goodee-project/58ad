package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class ShoppingSearchHistory {
	private int searchHistoryNo;
	private String customerId;
	private String searchHistoryWord;
	private String createdate;
}
