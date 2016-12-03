package businessLogic.hotelBL.hotel;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import businessLogic.hotelBL.hotel.hotelComponents.Evaluations;
import businessLogic.hotelBL.hotel.hotelComponents.Rooms;
import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import po.HotelPO;
import utilities.Address;
import utilities.Operation;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.RemainRoomInfoVO;
import vo.RoomInfoVO;

public class Hotel{

	private HotelDataService hotelDataService;
	private HotelPO hotelPO;
	private String hotelID;
	private Rooms rooms;
	private Evaluations evaluations;

	public Hotel() {

	}

	public Hotel(String hotelWorkerID) {
		this.hotelID = hotelWorkerID;
		initHotel();
	}

	private void initHotel() {
		initHotelDataService();
		initHotelPO();
		initRooms();
		initEvaluations();
	}

	private void initEvaluations() {
		evaluations = new Evaluations(hotelID,hotelDataService);
	}

	private void initRooms() {
		rooms = new Rooms(hotelID,hotelDataService);
	}

	private void initHotelPO() {
		try {
			hotelPO = hotelDataService.getHotelInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void initHotelDataService() {
		hotelDataService = new HotelDataService_Stub();
	}

	
	
	// 对hotelInfo的操作，get、update、add
	public HotelVO getHotelInfo(String hotelWorkerID) {
		if(hotelPO == null){
			return null;
		}
		else{
			return new HotelVO(hotelPO);
		}
		
	}

	public ResultMessage updateHotelInfo(HotelVO hotelVO) {

		hotelPO = new HotelPO(hotelVO);
		try {
			return hotelDataService.updateHotelInfo(hotelPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}
	
	public ResultMessage addHotel(HotelVO hotelVO){
		// TODO
		return ResultMessage.SUCCESS;
	}

	//对roomInfo的操作，get、update
	public Iterator<RoomInfoVO> getHotelRoomInfo(String hotelWorkerID) {
		return rooms.getRoomInfo();
	}

	public ResultMessage updateHotelRoomInfo(List<RoomInfoVO> roomInfoVOList) {
		return rooms.updateHotelRoomInfo(roomInfoVOList);
	}

	
	// 对checkIn、checkOut的操作，update
	public ResultMessage updateCheckIn(CheckInVO checkInVO) {
		// TODO
		CheckInPO checkInPO = new CheckInPO(checkInVO);
		ResultMessage msg = null;
		try {
			msg = hotelDataService.updateCheckInInfo(checkInPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public ResultMessage updateCheckOut(CheckOutVO checkOutVO) {
		// TODO
		CheckOutPO checkOutPO = new CheckOutPO(checkOutVO);
		ResultMessage msg = null;
		try {
			msg = hotelDataService.updateCheckOutInfo(checkOutPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return msg;
	}

	
	// 对remainRoomInfo的操作，get、update
	public Iterator<RemainRoomInfoVO> getRemainRoomInfo(String hotelWorkerID) {
		return rooms.getRemainRooms();
	}


	public ResultMessage updateRemainRoomInfo(String hotelID, Operation operation, Map<RoomType, Integer> roomInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// 对evaluations的操作，get
	public Iterator<HotelEvaluationVO> getEvaluations(){
		return evaluations.getEvaluations();
	}

//	public ResultMessage updateEvaluation(EvaluationVO evaluationVO) {
//		return evaluations.addEvaluation(evaluationVO);
//	}
	
	public Address getHotelAddress(String hotelID){
		this.hotelID = hotelID;
		initHotelPO();
		return new Address(hotelPO.getCity(), hotelPO.getCircle());
	}
	
	
	/**
	 * 方便测试用，严格来说不能暴露，后期删除
	 * @return
	 */
	public HotelPO getHotelPO(){
		return hotelPO;
	}
}