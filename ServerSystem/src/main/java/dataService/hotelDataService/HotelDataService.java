package dataService.hotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CheckInPO;
import po.CheckOutPO;
import po.HotelEvaluationPO;
import po.HotelGeneralPO;
import po.HotelPO;
import po.RemainRoomInfoPO;
import po.RoomInfoPO;
import utilities.ResultMessage;
import vo.AddressVO;

public interface HotelDataService extends Remote{

	public HotelPO getHotelInfo (String hotelID) throws RemoteException;
	
	public ResultMessage updateHotelInfo(HotelPO hotelPO) throws RemoteException;
	
	public List<RoomInfoPO> getHotelRoomInfo(String hotelID) throws RemoteException;
	
	public ResultMessage updateHotelRoomInfo(List<RoomInfoPO> list) throws RemoteException;
	
	public ResultMessage updateCheckInInfo (CheckInPO checkInPO) throws RemoteException;
	
	public ResultMessage updateCheckOutInfo (CheckOutPO checkOutPO) throws RemoteException;
	
	public List<RemainRoomInfoPO> getRemainRoomInfo(String hotelID) throws RemoteException;
	
	public ResultMessage updateRemainRoomInfo(RemainRoomInfoPO remainRoomPO) throws RemoteException;
	
	public HotelPO getHotelDetail(String hotelID) throws RemoteException;

	public List<HotelEvaluationPO> getEvaluations(String hotelID) throws RemoteException;
	
//	public ResultMessage updateEvaluation (EvaluationPO evaluationPO) throws RemoteException;

	public List<HotelGeneralPO> getHotelGeneralList(AddressVO addressVO) throws RemoteException;

}
