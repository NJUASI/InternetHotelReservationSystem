package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.CheckInPO;
import po.CheckOutPO;
import po.HotelEvaluationPO;
import po.HotelGeneralPO;
import po.HotelPO;
import po.RoomInfoPO;
import utilities.ResultMessage;
import vo.AddressVO;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	
	public HotelDataServiceImpl() throws RemoteException {
		super();
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
	public List<RoomInfoPO> getHotelRoomInfo(String hotelID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateHotelRoomInfo(List<RoomInfoPO> list) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public HotelPO getHotelDetail(String hotelID) throws RemoteException {
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
	public List<HotelGeneralPO> getHotelGenerals(String city, String circle) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
