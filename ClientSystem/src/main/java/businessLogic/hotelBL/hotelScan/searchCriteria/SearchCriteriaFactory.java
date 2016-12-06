package businessLogic.hotelBL.hotelScan.searchCriteria;

import businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl.HotelNameCriteria;
import businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl.LevelSpanCriteria;
import businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl.NullCriteria;
import businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl.OriginPriceSpanCriteria;
import businessLogic.hotelBL.hotelScan.searchCriteria.searchCriteriaImpl.ScoreSpanCriteria;
import utilities.SearchCriteriaType;
import vo.SearchCriteriaVO;

public class SearchCriteriaFactory {
	

	public SearchCriteria createSearchCriteria(SearchCriteriaType searchCriteriaType,SearchCriteriaVO vo){
		if(searchCriteriaType == SearchCriteriaType.HOTEL_NAME){
			return new HotelNameCriteria(vo.keyHotelName);
		}
		else if(searchCriteriaType == SearchCriteriaType.LEVEL_SPAN){
			return new LevelSpanCriteria(vo.minLevel, vo.maxLevel);
		}
		else if(searchCriteriaType == SearchCriteriaType.ORGIN_PRICE_SPAN){
			return new OriginPriceSpanCriteria(vo.minPrice, vo.maxPrice);
		}
		else if(searchCriteriaType == SearchCriteriaType.SCORE_SPAN){
			return new ScoreSpanCriteria(vo.minScore, vo.maxPrice);
		}
		else if(searchCriteriaType == SearchCriteriaType.ROOM_TYPE){
			//TODO 返回根据房间类型搜索的类，构造函数需要改
		}
		return new NullCriteria();
	}
	
}
