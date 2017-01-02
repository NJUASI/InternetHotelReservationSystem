package dataService.webMarketerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.WebMarketerPO;
import utilities.enums.ResultMessage;

/**
 * 
 * @author cuihua
 * @lastChangedBy charles
 * @updateTime 2017/1/1
 *
 */
public interface WebMarketerDataService extends Remote {

	/**
	 * 
	 * @param webMarketID 网站营销人员编号
	 * @return 该网站营销人员的信息载体
	 * @throws RemoteException RMI异常
	 */
	public WebMarketerPO getSingleWebMarketer(String webMarketID) throws RemoteException;
	
	/**
	 * 
	 * @return 所有网站营销人员的信息载体列表
	 * @throws RemoteException RMI异常
	 */
	public List<WebMarketerPO> getAllWebMarketer () throws RemoteException;

	/**
	 * 
	 * @param newWebMarketerPO 新添加的网站营销人员信息载体
	 * @return 该添加的网站营销人员信息载体
	 * @throws RemoteException RMI异常
	 */
	public WebMarketerPO add(WebMarketerPO newWebMarketerPO) throws RemoteException;

	/**
	 * 
	 * @param webMarketerPO 修正后的网站营销人员信息载体
	 * @return 是否修改成功
	 * @throws RemoteException RMI异常
	 */
	public ResultMessage modify (WebMarketerPO webMarketerPO) throws RemoteException;

//	public ResultMessage deleteWebMarketer(String webMarketerID) throws RemoteException;
}
