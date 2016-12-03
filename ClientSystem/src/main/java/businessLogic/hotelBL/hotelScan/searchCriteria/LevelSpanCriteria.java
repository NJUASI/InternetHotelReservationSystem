package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelGeneralPO;

public class LevelSpanCriteria implements SearchCriteria {

	int minLevel;
	int maxLevel;
	
	public LevelSpanCriteria(int minLevel,int maxLevel) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}
	
	@Override
	public List<HotelGeneralPO> meetCriteria(List<HotelGeneralPO> hotelGeneralVOList) {
		for(int i = 0;i<hotelGeneralVOList.size();i++){
			if(notInLevelSpan(new Integer(hotelGeneralVOList.get(i).getLevel()))){
				hotelGeneralVOList.remove(i);
			}
		}
		return hotelGeneralVOList;
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
