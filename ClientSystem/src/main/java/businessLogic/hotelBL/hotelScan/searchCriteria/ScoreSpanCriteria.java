package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import vo.HotelVO;

public class ScoreSpanCriteria implements SearchCriteria {

	double minScore;
	double maxScore;
	
	public ScoreSpanCriteria(double minScore,double maxScore) {
		this.minScore = minScore;
		this.maxScore = maxScore;
	}
	
	@Override
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(notInScoreSpan(hotelVOList.get(i).score)){
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
