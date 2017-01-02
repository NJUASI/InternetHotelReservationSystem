package dataService.webManagerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.WebManagerPO;
import utilities.enums.ResultMessage;

/**
 * 
 * @author cuihua
 * @lastChangedBy charles
 * @updateTime 2017/1/1
 *
 * 对数据库中的网站管理人员信息进行修改
 */
public interface WebManagerDataService extends Remote{

	/**
	 * 
	 * @param webManagerID 网站管理人员编号
	 * @return 网站营销人员的所有信息载体
	 * @throws RemoteException RMI异常
	 */
	public WebManagerPO getSingleWebManager(String webManagerID) throws RemoteException;
	
	/**
	 * 
	 * @return 所有网站管理人员信息列表的列表
	 * @throws RemoteException RMI列表
	 */
	public List<WebManagerPO> getAllWebManager() throws RemoteException;

	/**
	 * 
	 * @param newWebManagerPO 新添加的网站管理人员的信息载体
	 * @return 该添加的网站管理人员的信息载体
	 * @throws RemoteException RMI异常
	 */
	public WebManagerPO add(WebManagerPO newWebManagerPO) throws RemoteException;

	/**
	 * 
	 * @param webManagerPO 修正后的网站管理人员的信息载体
	 * @return 是否修正成功
	 * @throws RemoteException RMI异常
	 */
	public ResultMessage modify(WebManagerPO webManagerPO) throws RemoteException;

}
