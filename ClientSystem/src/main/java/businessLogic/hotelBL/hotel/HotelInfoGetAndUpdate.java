package businessLogic.hotelBL.hotel;

import utilities.Address;
import utilities.ResultMessage;

/**
 * @Description:对外提供的更新和获取酒店相关信息的接口
 * @author:Harvey Gong
 * lastChangedBy:Harvey Gong
 * @time:2016年12月4日 下午9:52:00
 */
public interface HotelInfoGetAndUpdate {
	
	
	/**
	 * @Description:更新酒店评分
	 * @param score
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * lastChangedBy: Harvey Gong
	 * @time:2016年12月4日 下午9:52:56
	 */
	public ResultMessage scoreUpdate(double score);
	
	/**
	 * @Description:获取酒店所在的城市商圈
	 * @return
	 * Address
	 * @author: Harvey Gong
	 * lastChangedBy: Harvey Gong
	 * @time:2016年12月4日 下午9:56:21
	 */
	public Address getHotelAddress();
}
