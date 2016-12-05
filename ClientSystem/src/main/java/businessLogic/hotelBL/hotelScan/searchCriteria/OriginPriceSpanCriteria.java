package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import vo.HotelVO;

public class OriginPriceSpanCriteria implements SearchCriteria {

	double minPrice;
	double maxPrice;
	
	public OriginPriceSpanCriteria(int minPrice,int maxPrice) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	
	/**
	 * @Description:筛选出位在价格区间内的hotel
	 * @param hotelGeneralVOList
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:13:42
	 */
	@Override
	public List<HotelVO> meetCriteria(List<HotelVO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			if(notInPriceSpan(hotelVOList.get(i).minPrice)){
				hotelVOList.remove(i);
			}
		}
		return hotelVOList;
	}
	
	private boolean notInPriceSpan(double price) {
		if(price<minPrice||price>maxPrice){
			return true;
		}
		else
		{
			return false;
		}
	}

}
