package businessLogic.promotionBL.discountCalculation.discountOfPromotions;

import businessLogic.memberBL.Member;
import businessLogic.promotionBL.discountCalculation.CalculateDiscount;
import utilities.MemberType;

public class EnterpriseMemberDiscount implements CalculateDiscount{

	private double discount;
	private String guestID;
	
	public EnterpriseMemberDiscount(double discount, String guestID) {
		this.discount = discount;
		this.guestID = guestID;
	}

	@Override
	public double getDiscount() {
		if(isEnterpriseMember()){
			return discount;
		}
		return 1;
	}
	
	public boolean isEnterpriseMember(){
		Member member = new Member();
		return member.isMember(guestID, MemberType.ENTERPRISE);
	}
}
