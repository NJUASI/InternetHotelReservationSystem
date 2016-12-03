package businessLogic.hotelBL;
 import java.util.Iterator;
import java.util.List;
import java.util.Map;

import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.hotelBL.hotelScan.HotelScan;
import businessLogic.hotelBL.hotelScan.SearchCriteria;
import businessLogicService.hotelBLService.HotelBLService;
import utilities.Operation;
import utilities.ResultMessage;
import utilities.RoomType;
import utilities.SortStrategy;
import vo.AddressVO;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelGeneralVO;
import vo.HotelVO;
import vo.RemainRoomInfoVO;
import vo.RoomInfoVO;


/**
 * @Description:TODO
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

	public ResultMessage updateHotelRoomInfo(List<RoomInfoVO> list) {
		return hotel.updateHotelRoomInfo(list);
	}

	public ResultMessage updateCheckIn(CheckInVO checkInVO) {
		return hotel.updateCheckIn(checkInVO);
	}

	public ResultMessage updateCheckOut(CheckOutVO checkOutVO) {
		return hotel.updateCheckOut(checkOutVO);
	}

	public Iterator<RemainRoomInfoVO> getRemainRoomInfo(String hotelWorkerID) {
		return hotel.getRemainRoomInfo(hotelWorkerID);
	}

	public ResultMessage updateRemainRoomInfo(String hotelID, Operation operation, Map<RoomType, Integer> roomInfo) {
		return hotel.updateRemainRoomInfo(hotelID, operation, roomInfo);
	}

	public ResultMessage addHotel(HotelVO hotelVO) {
		return hotel.addHotel(hotelVO);
	}

//	public ResultMessage updateEvaluation(EvaluationVO evaluationVO) {
//		return hotel.updateEvaluation(evaluationVO);
//	}

	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
		return hotel.getEvaluations();
	}
	
	
	// 浏览概况时的操作
	public Iterator<HotelGeneralVO> getHotels(AddressVO addressVO) {
		return hotelScan.getHotels(addressVO);
	}
	
	public Iterator<HotelGeneralVO> sortHotels(SortStrategy sortStrategy) {
		return hotelScan.sortHotels(sortStrategy);
	}
	
	public Iterator<HotelGeneralVO> searchHotels(List<SearchCriteria> searchCriteria) {
		return hotelScan.searchHotels(searchCriteria);
	}
	
	public Iterator<HotelGeneralVO> getBookedHotels() {
		// TODO 自动生成的方法存根
		return null;
	}

	

}
