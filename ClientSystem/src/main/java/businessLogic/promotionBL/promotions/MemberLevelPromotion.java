package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.memberBL.Member;
import utilities.MemberType;
import vo.MarketVO;

public class MemberLevelPromotion {
		
	private List<MarketVO> commonMemberRegulations;
	
	public MemberLevelPromotion() {
		// TODO 自动生成的构造函数存根
	}
	
	public double getDiscount(String guestID){
		initMemberRegulations();
		double commonMemberDiscount = getCommonMemberDiscount(guestID);
		return commonMemberDiscount;
	}
	
	private void initMemberRegulations(){
		Market market = new Market();
		commonMemberRegulations = market.getMemberFormulation();
	}
	
	private double getCommonMemberDiscount(String guestID){
		Member member = new Member();
		if(member.isMember(guestID, MemberType.COMMON)){
			//TODO 需要一个根据客户id等级的接口,返回值为int
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
