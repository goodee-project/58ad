package goodee.gdj58.ad.vo;

import lombok.Data;

@Data
public class ShoppingReview {
	private int goodsOrderNo;
	private String reviewContent;
	private int reviewRating;
	private String createdate;
}
