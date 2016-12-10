package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.memberBL.Member;
import exception.verificationException.UserInexistException;
import utilities.MemberType;
import vo.MarketVO;

public class MemberLevelPromotion {

	public MemberLevelPromotion() {

	}

	public double getDiscount(String guestID) throws UserInexistException{
		Market market = new Market();
		List<MarketVO> commonMemberRegulations = market.getMemberFormulation();
		if(new Member().isMember(guestID, MemberType.COMMON)){
			//TODO 注意怎么获取不同等级的会员折扣
			// TODO gcm 你想说什么，表达更清楚一些
			int level = market.getLevel(guestID);
			if(level == 0){
				return 0;
			}
			else
			{
				return commonMemberRegulations.get(level-1).marketBenefit;	
			}
		}
		return 0;
	}

}
