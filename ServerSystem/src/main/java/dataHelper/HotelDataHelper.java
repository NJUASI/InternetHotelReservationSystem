package dataHelper;

import java.util.List;

import po.HotelPO;
import utilities.enums.ResultMessage;

/**
 * @Description:对数据库中hotel表的操作
 * @author:Harvey Gong
 * @time:2016年12月4日 上午10:10:46
 */
public interface HotelDataHelper {

	//根据城市商圈返回位于该地区所有酒店的简介
	public List<HotelPO> getHotels(String city, String circle);

	//根据酒店id返回该酒店的基本信息
	public HotelPO getHotelInfo (String hotelID);

	//根据hotelPO更新一条数据库里的po
	public ResultMessage updateHotelInfo(HotelPO hotelPO);

	//根据hotelPO添加一条po
	public ResultMessage addHotelInfo(HotelPO hotelPO);
}
