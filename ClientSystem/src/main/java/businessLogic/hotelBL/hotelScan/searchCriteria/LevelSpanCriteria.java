package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import vo.HotelVO;

public class LevelSpanCriteria implements SearchCriteria {

	int minLevel;
	int maxLevel;
	
	public LevelSpanCriteria(int minLevel,int maxLevel) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}
	
	@Override
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(notInLevelSpan(new Integer(hotelVOList.get(i).level))){
				hotelVOList.remove(i);
			}
		}
		return hotelVOList;
	}
	
	private boolean notInLevelSpan(int level){
		if(minLevel>level||level>maxLevel){
			return true;
		}
		else
		{
			return false;
		}
	}

}
