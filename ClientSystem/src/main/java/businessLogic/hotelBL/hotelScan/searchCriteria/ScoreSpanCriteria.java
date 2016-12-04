package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelPO;

public class ScoreSpanCriteria implements SearchCriteria {

	double minScore;
	double maxScore;
	
	public ScoreSpanCriteria(double minScore,double maxScore) {
		this.minScore = minScore;
		this.maxScore = maxScore;
	}
	
	@Override
	public List<HotelPO> meetCriteria(List<HotelPO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(notInScoreSpan(hotelVOList.get(i).getScore())){
				hotelVOList.remove(i);
			}
		}
		return hotelVOList;
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
