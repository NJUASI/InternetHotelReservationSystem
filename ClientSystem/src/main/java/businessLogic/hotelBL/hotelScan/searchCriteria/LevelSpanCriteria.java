package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelPO;

public class LevelSpanCriteria implements SearchCriteria {

	int minLevel;
	int maxLevel;
	
	public LevelSpanCriteria(int minLevel,int maxLevel) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}
	
	@Override
	public List<HotelPO> meetCriteria(List<HotelPO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(notInLevelSpan(new Integer(hotelVOList.get(i).getLevel()))){
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
