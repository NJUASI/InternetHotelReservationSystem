package businessLogic.hotelBL.hotelScan;

import java.util.List;

import po.HotelPO;

/**
 * @Description:搜索标准接口
 * @author:Harvey Gong
 * @time:2016年12月3日 下午9:57:29
 */
public interface SearchCriteria {
	
	/**
	 * @Description:根据标准，将传入的酒店进行一定标准筛选之后再返回
	 * @param hotelGeneralVOList
	 * @return
	 * List<HotelGeneralPO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午9:58:19
	 */
	public List<HotelPO> meetCriteria(List<HotelPO> hotelGeneralVOList);
}
