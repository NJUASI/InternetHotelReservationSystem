package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.HotelDataHelper;
import dataHelper.RoomDataHelper;
import dataHelperImpl.HotelDataHelperImpl;
import dataHelperImpl.RoomDataHelperImpl;
import dataService.hotelDataService.HotelDataService;
import po.CheckInPO;
import po.CheckOutPO;
import po.HotelEvaluationPO;
import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	private RoomDataHelper roomDataHelper;
	private HotelDataHelper hotelDataHelper;
	
	public HotelDataServiceImpl() throws RemoteException {
		super();
		roomDataHelper = new RoomDataHelperImpl();
		hotelDataHelper = new HotelDataHelperImpl();
	}

	@Override
	public HotelPO getHotelInfo(String hotelID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateHotelInfo(HotelPO hotelPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public ResultMessage addHotelInfo(HotelPO hotelPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	

	@Override
	public ResultMessage updateCheckInInfo(CheckInPO checkInPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateCheckOutInfo(CheckOutPO checkOutPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<HotelEvaluationPO> getEvaluations(String hotelID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

//	@Override
//	public ResultMessage updateEvaluation(EvaluationPO evaluationPO) throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}
	@Override
	public List<HotelPO> getHotels(String city, String circle) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
	/**
	 * @Description:调用roomDataHelper的方法，增删改查roominfo
	 * @throws RemoteException
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午2:02:58
	 */
	@Override
	public List<RoomInfoPO> getRoomInfo(String hotelID) throws RemoteException {
		return roomDataHelper.getRoomInfo(hotelID);
	}

	@Override
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO, String oldRoomType) throws RemoteException {
		return roomDataHelper.updateRoomInfo(roomInfoPO, oldRoomType);
	}

	@Override
	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) throws RemoteException {
		return roomDataHelper.addRoomInfo(roomInfoPO);
	}

	@Override
	public ResultMessage deleteRoomInfo(String hotelID, String roomType) throws RemoteException {
		return roomDataHelper.deleteRoomInfo(hotelID, roomType);
	}

}
