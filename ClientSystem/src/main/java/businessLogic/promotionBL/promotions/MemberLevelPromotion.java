package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.memberBL.Member;
import exception.verificationException.UserInexistException;
import utilities.enums.MemberType;
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
			/*
			 * TODO djy,我得获得不同等级的折扣，比如如果我得到这个会员等级是等级1，然后我得根据等级再拿到会员的折扣
			 * 或者你直接给我一个接口，我把客户id给你，你帮我判断是否是会员和以及计算它会员的折扣，这种方案更好，因为数据都在你那儿
			 */
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
