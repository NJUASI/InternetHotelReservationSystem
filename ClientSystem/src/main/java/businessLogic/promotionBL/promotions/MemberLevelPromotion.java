package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.MarketController;
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
//			TODO gcm注意：MarketController.getInstance().getLevel(guestID) 传入客户ID可获取
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
