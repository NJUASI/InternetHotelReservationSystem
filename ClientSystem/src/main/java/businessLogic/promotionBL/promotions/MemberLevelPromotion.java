package businessLogic.promotionBL.promotions;

import businessLogic.marketBL.MarketController;
import businessLogicService.marketBLService.MarketBLService;
import exception.verificationException.UserInexistException;

public class MemberLevelPromotion {

	public MemberLevelPromotion() {

	}

	public double getDiscount(String guestID) throws UserInexistException{
		MarketBLService market = MarketController.getInstance();
		
		/*
		 * TODO gcm market.getMemberDiscout(guestID);此处返回你要的会员折扣接口，调等级的接口不变
		 */
		return 1;
	}

}
