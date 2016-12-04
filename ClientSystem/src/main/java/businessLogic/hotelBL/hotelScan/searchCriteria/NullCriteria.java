package businessLogic.hotelBL.hotelScan.searchCriteria;

import java.util.List;

import businessLogic.hotelBL.hotelScan.SearchCriteria;
import po.HotelPO;

public class NullCriteria implements SearchCriteria {

	/**
	 * @Description:没有任何搜索条件，不做任何操作，直接返回传进来的list
	 * @param hotelGeneralVOList
	 * @return hotelGeneralVOList
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午7:00:16
	 */
	public List<HotelPO> meetCriteria(List<HotelPO> hotelVOList) {
		return hotelVOList;
	}
	
	public void print(){
		System.out.println();
	}

}
