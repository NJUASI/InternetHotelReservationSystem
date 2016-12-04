package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelPO;

public class OriginPriceSpanCriteria implements SearchCriteria {

	int minPrice;
	int maxPrice;
	
	public OriginPriceSpanCriteria(int minPrice,int maxPrice) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	
	/**
	 * @Description:TODO  HotelGeneralVO 里面没有最大原始价格
	 * @param hotelGeneralVOList
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:13:42
	 */
	@Override
	public List<HotelPO> meetCriteria(List<HotelPO> hotelVOList) {
		for(int i = 0;i<hotelVOList.size();i++){
			
		}
		return null;
	}
	
	private boolean notInPriceSpan(int price) {
		if(price<minPrice||price>maxPrice){
			return true;
		}
		else
		{
			return false;
		}
	}

}
