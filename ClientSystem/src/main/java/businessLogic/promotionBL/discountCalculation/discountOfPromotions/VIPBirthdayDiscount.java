package businessLogic.promotionBL.discountCalculation.discountOfPromotions;

import java.time.LocalDate;

import businessLogic.memberBL.Member;
import businessLogic.promotionBL.discountCalculation.CalculateDiscount;
import utilities.MemberType;

public class VIPBirthdayDiscount implements CalculateDiscount{

	private LocalDate date;
	private LocalDate birthDay;
	private String guestID;
	private double discount;

	public VIPBirthdayDiscount(double discount, String guestID, LocalDate today) {
		this.discount = discount;
		this.guestID = guestID;
		this.date = today;
	}





	@Override
	public double getDiscount() {
		Member member = new Member();
		if(member.isMember(guestID, MemberType.COMMON)){
			birthDay = member.getMemberInfo(guestID, MemberType.COMMON).birthday;
			if(isSameDay()){
				return discount; 
			}
		}
		return 1;
	}

	private boolean isSameDay(){
		if(birthDay.getMonth()== date.getMonth())
		{
			if(birthDay.getDayOfMonth()==date.getDayOfMonth()){
				return true;
			}
		}
		return false;
	}
}
