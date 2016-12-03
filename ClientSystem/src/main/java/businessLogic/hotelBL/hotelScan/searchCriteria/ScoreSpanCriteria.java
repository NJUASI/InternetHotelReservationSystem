package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelGeneralPO;

public class ScoreSpanCriteria implements SearchCriteria {

	double minScore;
	double maxScore;
	
	public ScoreSpanCriteria(double minScore,double maxScore) {
		this.minScore = minScore;
		this.maxScore = maxScore;
	}
	
	@Override
	public List<HotelGeneralPO> meetCriteria(List<HotelGeneralPO> hotelGeneralVOList) {
		for(int i = 0;i<hotelGeneralVOList.size();i++){
			if(notInScoreSpan(hotelGeneralVOList.get(i).getScore())){
				hotelGeneralVOList.remove(i);
			}
		}
		return hotelGeneralVOList;
	}
	
	private boolean notInScoreSpan(double score){
		if(score<minScore||score>maxScore){
			return true;
		}
		else{
			return false;
		}
	}

}
