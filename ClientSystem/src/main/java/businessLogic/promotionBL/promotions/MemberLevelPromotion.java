package businessLogic.promotionBL.promotions;

import businessLogic.marketBL.Market;
import exception.verificationException.UserInexistException;

public class MemberLevelPromotion {

	public MemberLevelPromotion() {

	}

	public double getDiscount(String guestID) throws UserInexistException{
		Market market = new Market();
		/*
		 * TODO djy 提供一个返回折扣的接口，我把客户的id传给你，你判断是否是会员、会员等级，再获取对应的折扣
		 * 然后把折扣返回给我
		 */
		return 0;
	}

}
