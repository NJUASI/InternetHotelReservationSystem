package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.marketBL.MarketController;
import businessLogic.marketBL.MockMarket;
import businessLogic.memberBL.Member;
import businessLogic.memberBL.MockMember;
import utilities.MemberType;
import vo.MarketVO;

public class MemberLevelPromotion {

	public MemberLevelPromotion() {

	}

	public double getDiscount(String guestID){
		Market market = new Market();
		List<MarketVO> commonMemberRegulations = market.getMemberFormulation();
		if(new Member().isMember(guestID, MemberType.COMMON)){
			//TODO djy注意怎么获取不同等级的会员折扣
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
