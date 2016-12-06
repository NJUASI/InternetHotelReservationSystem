package businessLogic.hotelBL;
 import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotel.RMILinkFailedException;
import businessLogic.hotelBL.hotelScan.HotelScan;
import businessLogicService.hotelBLService.HotelBLService;
import exception.operationFailedException.GetFailedException;
import utilities.ResultMessage;
import utilities.SearchCriteriaType;
import utilities.SortStrategy;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;


/**
 * @Description:对一个具体酒店的操作
 * @author:Harvey Gong
 * @time:2016年11月29日 下午6:43:08
 */
public class HotelBLController implements HotelBLService {

	private static HotelBLController hotelController = new HotelBLController();
	private Hotel hotel;
	private HotelScan hotelScan;
	private String guestID;
	
	private HotelBLController() {
		
	}
	
	/**
	 * @Description:当酒店工作人员登录时调用此方法
	 * @param hotelID
	 * void
	 * @author: Harvey Gong
	 * @throws GetFailedException 
	 * @throws RMILinkFailedException 
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月6日 下午5:08:48
	 */
	public void initHotel(String hotelID) throws RMILinkFailedException, GetFailedException{
		hotel = new Hotel(hotelID);
	}
	
	/**
	 * 当用户或者网站管理人员登陆时，则调用此初始化方法
	 * @param addressVO
	 */
	public void initHotelsScan(){
		hotelScan = new HotelScan(guestID);
	}

	public static HotelBLController getInstance(){
		return hotelController;
	}

	// 对单个hotel的操作
	
	public HotelVO getHotelInfo(String hotelWorkerID) {
		return hotel.getHotelInfo(hotelWorkerID);
	}

	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		return hotel.updateHotelInfo(hotelVO);
	}

	public Iterator<RoomInfoVO> getHotelRoomInfo(String hotelWorkerID) {
		return hotel.getHotelRoomInfo(hotelWorkerID);
	}

	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO,String oldRoomType) {
		return hotel.updateHotelRoomInfo(roomInfoVO,oldRoomType);
	}

	public ResultMessage addHotel(HotelVO hotelVO) {
		return hotel.addHotelInfo(hotelVO);
	}

	// 浏览概况时的操作
	public Iterator<HotelVO> getHotels(String city,String circle) {
		return hotelScan.getHotels(city,circle);
	}
	
	public Iterator<HotelVO> sortHotels(SortStrategy sortStrategy) {
		return hotelScan.sortHotels(sortStrategy);
	}
	
	public Iterator<HotelVO> searchHotels(List<SearchCriteriaType> searchCriteriaTypes,SearchCriteriaVO vo) {
		return hotelScan.searchHotels(searchCriteriaTypes,vo);
	}

}
