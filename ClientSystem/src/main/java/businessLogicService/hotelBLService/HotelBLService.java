package businessLogicService.hotelBLService;

import java.util.Iterator;
import java.util.List;

import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import utilities.enums.SearchCriteriaType;
import utilities.enums.SortStrategy;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;

/**
 * @Description:酒店模块的BLService
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月12日 上午12:58:17
 */
public interface HotelBLService {

	
	/**
	 * @Description:当客户需要使用hotelController时，调用该方法，将自己的IDset进去
	 * @param guestID
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:04:48
	 */
	public void setGuestID(String guestID);
	
	/**
	 * @Description:当酒店工作人员需要使用hotelController时，调用该方法，将自己的IDset进去
	 * @param hotelID
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:10:03
	 */
	public void setHotelID(String hotelID);
	/**
	 * @Description:根据酒店id获取酒店的基本信息
	 * @param hotelID
	 * @return
	 * HotelVO
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午12:58:41
	 */
	public HotelVO getHotelInfo (String hotelID);

	/**
	 * @Description:更新酒店的基本信息
	 * @param hotelVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午12:59:08
	 */
	public ResultMessage updateHotelInfo (HotelVO hotelVO);
	
	/**
	 * @Description:添加酒店
	 * @param hotelVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午12:59:29
	 */
	public ResultMessage addHotel (HotelVO hotelVO);
	
	/**
	 * @Description:线下入住,酒店工作人员操作，不需要传入hotelid
	 * @param hotelID
	 * @param RoomType
	 * @param roomNum
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午12:59:41
	 */
	public ResultMessage checkInOffline (String hotelID,RoomType RoomType,int roomNum);
	
	/**
	 * @Description:线下退房，酒店工作人员操作，不需要传入hotelid
	 * @param hotelID
	 * @param RoomType
	 * @param roomNum
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午12:59:52
	 */
	public ResultMessage checkOutOffline (String hotelID,RoomType RoomType,int roomNum);

	/**
	 * @Description:获取
	 * @param hotelID
	 * @return
	 * Iterator<RoomInfoVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:01:20
	 */
	public Iterator<RoomInfoVO> getHotelRoomInfo (String hotelID);

	/**
	 * @Description:更新客房信息
	 * @param roomInfoVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:02:11
	 */
	public ResultMessage updateHotelRoomInfo (RoomInfoVO roomInfoVO);
	
	/**
	 * @Description:TODO 待商议，可定死，现在我也偏向定死，然后订的时候到逻辑层检查一下，根据酒店id和所选房间类型获取该房间剩余数量，客户生成订单时会用到
	 * @param hotelID
	 * @param roomType
	 * @return
	 * int
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:02:31
	 */
	public int getRemainRoomNum(String hotelID,RoomType roomType);
	
	/**
	 * @Description:根据酒店id和所选房间类型，得到该房型的原始价格
	 * @param hotelID
	 * @param roomType
	 * @return
	 * double
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:04:04
	 */
	public double getOriginPrice(String hotelID, RoomType roomType);
	
	/**
	 * @Description:根据所选城市、商圈得到该城市商圈的所有酒店
	 * @param city
	 * @param circle
	 * @return
	 * Iterator<HotelVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:05:49
	 */
	public Iterator<HotelVO> getHotels(String city,String circle);
	
	/**
	 * @Description:根据排序方式，返回排序后的酒店列表，在客户查看酒店列表时使用
	 * @param sortStategy
	 * @return
	 * Iterator<HotelVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:06:23
	 */
	public Iterator<HotelVO> sortHotels(SortStrategy sortStategy);
	
	/**
	 * @Description:根据搜索标准的类型和包含搜索条件内容的vo，得到符合搜索条件的hotel列表
	 * @param searchCriteriaTypes
	 * @param vo
	 * @return
	 * Iterator<HotelVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月12日 上午1:07:29
	 */
	public Iterator<HotelVO> searchHotels(List<SearchCriteriaType> searchCriteriaTypes,SearchCriteriaVO vo);
	
}
