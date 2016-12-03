package businessLogic.promotionBL.promotions;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.memberBL.Member;
import utilities.MemberType;
import vo.MarketVO;

public class MemberLevelPromotion {
		
	private List<MarketVO> commonMemberRegulations;
	private List<MarketVO> enterpriseMemberRegulations;
	
	public MemberLevelPromotion() {
		// TODO 自动生成的构造函数存根
	}
	
	public double getDiscount(String guestID){
		initMemberRegulations();
		double commonMemberDiscount = getCommonMemberDiscount(guestID);
		double enterpriseMemberDiscount = getCommonMemberDiscount(guestID);
		return commonMemberDiscount*enterpriseMemberDiscount;
	}
	
	private void initMemberRegulations(){
		Market market = new Market();
		//TODO
	}
	
	private double getCommonMemberDiscount(String guestID){
		Member member = new Member();
		if(member.isMember(guestID, MemberType.COMMON)){
			
		}
		return 0;
	}
	
	private double getEnterPriseMemberDiscount(String guestID){
		return 0;
	}
}
