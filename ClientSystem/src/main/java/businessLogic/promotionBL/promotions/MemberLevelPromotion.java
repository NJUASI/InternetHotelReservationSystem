package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.MockMarket;
import businessLogic.memberBL.MockMember;
import utilities.MemberType;
import vo.MarketVO;

public class MemberLevelPromotion {

	public MemberLevelPromotion() {

	}

	public double getDiscount(String guestID){
		List<MarketVO> commonMemberRegulations = new MockMarket().getMemberFormulation();
		if(new MockMember().isMember(guestID, MemberType.COMMON)){
			//TODO 需要一个获得客户id等级的接口,返回值为int
			int degree = 1;
			if(degree == 0){
				return 0;
			}
			else
			{
				return commonMemberRegulations.get(degree-1).marketBenefit;	
			}
		}
		return 0;
	}

}
