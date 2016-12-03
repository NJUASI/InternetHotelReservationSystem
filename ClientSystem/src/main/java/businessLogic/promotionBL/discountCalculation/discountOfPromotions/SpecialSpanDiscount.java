package businessLogic.promotionBL.discountCalculation.discountOfPromotions;

import java.time.LocalDate;

import businessLogic.promotionBL.discountCalculation.CalculateDiscount;

public class SpecialSpanDiscount implements CalculateDiscount{

	private LocalDate toDay;
	private LocalDate startDate;
	private LocalDate endDate;
	private double discount;
	
	public SpecialSpanDiscount(double discount, LocalDate startDate, LocalDate endDate, LocalDate toDay) {
		this.discount = discount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
	}

	@Override
	public double getDiscount() {
		if(isInSpan()){
			return discount;
		}
		return 1;
	}

	private boolean isInSpan(){
		if(toDay.isAfter(startDate)&&toDay.isBefore(endDate)){
			return true;
		}
		return false;
	}

}
