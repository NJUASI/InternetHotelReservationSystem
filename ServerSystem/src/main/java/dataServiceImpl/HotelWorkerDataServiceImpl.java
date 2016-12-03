package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.HotelWorkerDataHelper;
import dataHelperImpl.stub.DataFactoryImpl_Stub;
import dataService.hotelWorkerDataService.HotelWorkerDataService;
import po.HotelWorkerPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class HotelWorkerDataServiceImpl extends UnicastRemoteObject implements HotelWorkerDataService {

	private static final long serialVersionUID = 3434060152387200042L;

	private DataFactoryImpl_Stub factory;

	private HotelWorkerDataHelper hotelWorkerHelper;

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1 构造函数，从工厂中获取hotelWorkerDataHlper对象
	 */
	public HotelWorkerDataServiceImpl() throws RemoteException {
//		this.factory = DataFactoryImpl.getInstance();
		this.factory = DataFactoryImpl_Stub.getInstance();
		this.hotelWorkerHelper = this.factory.getHotelWorkerDataHelper();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param hotelWorkerID 酒店工作人员ID
	 * @return HotelWorkerPO hotelWokerInfo载体
	 */
	public HotelWorkerPO getSingleHotelWorker(String hotelWorkerID) throws RemoteException {
		HotelWorkerPO hotelWorkerPO = this.hotelWorkerHelper.getSingle(hotelWorkerID);
		// 从数据库中得到一个按ID索引的PO，若不存在则为空
		return hotelWorkerPO;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @return List<HotelWorkerPO> 所有hotelWokerInfo载体
	 */
	public List<HotelWorkerPO> getAllHotelWorker() throws RemoteException {
		List<HotelWorkerPO> list = this.hotelWorkerHelper.getAll();
		// 从数据库中得到所有HotelWorkerPO，若不存在则为空
		if (list.isEmpty()) {
			return null;
		}

		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param newHotelWorkerID 酒店工作人员ID
	 * @return ResultMessage 是否成功添加hotelWorkerInfo
	 */
	public ResultMessage add(HotelWorkerPO newHotelWorkerPO) throws RemoteException {
		return this.hotelWorkerHelper.add(newHotelWorkerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param hotelWorkerPO hotelInfo载体
	 * @return ResultMessage 是否成功修改hotelWorkerInfo
	 */
	public ResultMessage modify(HotelWorkerPO hotelWorkerPO) throws RemoteException {
		return this.hotelWorkerHelper.modify(hotelWorkerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param hotelWorkerID 酒店工作人员ID
	 * @return ResultMessage 是否成功删除hotelWorkerInfo
	 */
	public ResultMessage initHotelWorker(String hotelWorkerID) throws RemoteException {
		return this.hotelWorkerHelper.delete(hotelWorkerID);
	}

}
