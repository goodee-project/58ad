package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class ShoppingCart {
	private int cartNo;
	private int goodsOptionNo;
	private String customerId;
	private int cartQuantity;
	private String updatedate;
	private String createdate;
}
