package dataService.hotelWorkerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelWorkerPO;
import utilities.enums.ResultMessage;

/**
 * 
 * @author cuihua
 * @lastChangedBy charles
 * @updateTime 2017/1/1
 * 
 * 对数据库中酒店工作人员的信息进行操作
 */
public interface HotelWorkerDataService extends Remote{

	/**
	 * 
	 * @param hotelWorkerID 酒店工作人员编号
	 * @return 酒店工作人员信息载体
	 * @throws RemoteException RMI异常
	 * 
	 * 获取某一特定酒店工作人员的所有信息
	 */
	public HotelWorkerPO getSingleHotelWorker(String hotelWorkerID) throws RemoteException;
	
	/**
	 * 
	 * @return 所有酒店工作人员信息的列表
	 * @throws RemoteException RMI异常
	 */
	public List<HotelWorkerPO> getAllHotelWorker() throws RemoteException;
	
	/**
	 * 
	 * @param newHotelWorkerPO 新酒店工作人员的信息载体
	 * @return 添加成功的该酒店工作人员
	 * @throws RemoteException RMI异常
	 */
	public HotelWorkerPO add(HotelWorkerPO newHotelWorkerPO) throws RemoteException;

	/**
	 * 
	 * @param hotelWorkerPO 修正的酒店工作人员信息载体
	 * @return 是否修改成功
	 * @throws RemoteException RMI异常
	 */
	public ResultMessage modify(HotelWorkerPO hotelWorkerPO) throws RemoteException;
	
//	public ResultMessage initHotelWorker(String hotelWorkerID) throws RemoteException;


}
