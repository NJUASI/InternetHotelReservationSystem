package businessLogic.hotelBL;
 import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotelScan.HotelScan;
import businessLogic.hotelBL.hotelScan.SearchCriteria;
import businessLogicService.hotelBLService.HotelBLService;
import utilities.ResultMessage;
import utilities.SortStrategy;
import vo.HotelVO;
import vo.RoomInfoVO;


/**
 * @Description:对一个具体酒店的操作
 * @author:Harvey Gong
 * @time:2016年11月29日 下午6:43:08
 */
public class HotelController implements HotelBLService {

	private static HotelController hotelController = new HotelController();
	private Hotel hotel;
	private HotelScan hotelScan;
	
	private HotelController() {
		
	}
	
	public void initHotel(String hotelID){
		hotel = new Hotel(hotelID);
	}
	
	/**
	 * 当用户或者网站管理人员登陆时，则调用此初始化方法
	 * @param addressVO
	 */
	public void inithotelsScan(){
		hotelScan = new HotelScan();
	}

	public static HotelController getInstance(){
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
	
	public Iterator<HotelVO> searchHotels(List<SearchCriteria> searchCriteria) {
		return hotelScan.searchHotels(searchCriteria);
	}
	
}
