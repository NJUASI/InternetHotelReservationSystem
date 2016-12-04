package dataHelper;

import java.util.List;

import po.HotelGeneralPO;

/**
 * @Description:对数据库中hotel表的操作
 * @author:Harvey Gong
 * @time:2016年12月4日 上午10:10:46
 */
public interface HotelDataHelper {
	
	/**
	 * @Description:根据城市商圈返回位于该地区所有酒店的简介
	 * @param city
	 * @param circle
	 * @return
	 * List<HotelGeneralPO>
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 上午10:11:12
	 */
	public List<HotelGeneralPO> getHotelGenerals(String city,String circle);
}
