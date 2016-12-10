package businessLogic.hotelBL;
 import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotelScan.HotelScan;
import businessLogicService.hotelBLService.HotelBLService;
import exception.operationFailedException.GetFailedException;
import exception.verificationException.RMILinkFailedException;
import utilities.enums.ResultMessage;
import utilities.enums.RoomType;
import utilities.enums.SearchCriteriaType;
import utilities.enums.SortStrategy;
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
		hotel = new Hotel();
		hotelScan = new HotelScan();
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
	public void initHotel(String hotelID){
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
	
	public HotelVO getHotelInfo(String hotelID) {
		return hotel.getHotelInfo(hotelID);
	}

	public ResultMessage updateHotelInfo(HotelVO hotelVO) {
		return hotel.updateHotelInfo(hotelVO);
	}

	public Iterator<RoomInfoVO> getHotelRoomInfo(String hotelWorkerID) {
		return hotel.getHotelRoomInfo(hotelWorkerID);
	}

	public ResultMessage updateHotelRoomInfo(RoomInfoVO roomInfoVO) {
		return hotel.updateHotelRoomInfo(roomInfoVO);
	}

	public ResultMessage addHotel(HotelVO hotelVO) {
		return hotel.addHotelInfo(hotelVO);
	}
	
	public int getRemainRoomNum(RoomType roomType){
		return hotel.getRemainNumOfSpecificType(roomType);
	}

	
	/**
	 * @Description:线下的入住和退房操作，分别调用这两个方法
	 * @param hotelID
	 * @param RoomName
	 * @param roomNum
	 * @return
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 上午12:34:02
	 */
	@Override
	public ResultMessage checkInOffline(String hotelID,RoomType roomType, int roomNum) {
		return hotel.checkIn(hotelID,roomType,roomNum);
	}

	@Override
	public ResultMessage checkOutOffline(String hotelID,RoomType roomType, int roomNum) {
		return hotel.checkOut(hotelID,roomType,roomNum);
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
