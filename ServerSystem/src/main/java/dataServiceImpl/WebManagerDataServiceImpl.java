package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.WebManagerDataHelper;
import dataHelperImpl.stub.DataFactoryImpl_Stub;
import dataService.webManagerDataService.WebManagerDataService;
import po.WebManagerPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class WebManagerDataServiceImpl extends UnicastRemoteObject implements WebManagerDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	private DataFactoryImpl_Stub factory;
	
	private WebManagerDataHelper webManagerHelper;
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1 构造函数，从工厂中获取webManagerDataHlper对象
	 */
	public WebManagerDataServiceImpl() throws RemoteException {
//		this.factory = DataFactoryImpl.getInstance();
		this.factory = DataFactoryImpl_Stub.getInstance();
		this.webManagerHelper = factory.getWebManagerDataHelper();
	
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webManagerID 网站管理人员ID
	 * @return WebManagerPO webManagerInfo载体
	 */
	public WebManagerPO getSingleWebManager(String webManagerID) throws RemoteException {
		WebManagerPO webMangerPO = this.webManagerHelper.getSingle(webManagerID);
		// 从数据库中得到webManagrPO，若不存在则为空
		return webMangerPO;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @return List<WebManagerPO> 所有webMarketerInfo载体
	 */
	public List<WebManagerPO> getAllWebManager() throws RemoteException {
		List<WebManagerPO> list = this.webManagerHelper.getAll();
		// 从数据库中得到所有webManagrPO，若不存在则为空
		if(list.isEmpty()){return null;}
		
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param newWebManagerPO webManagerInfo载体
	 * @return ResultMessage 是否成功添加webManagerInfo
	 */
	public ResultMessage add(WebManagerPO newWebManagerPO) throws RemoteException {
		return this.webManagerHelper.add(newWebManagerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webManagerPO webManagerInfo载体
	 * @return ResultMessage 是否成功修改webManagerInfo
	 */
	public ResultMessage modify(WebManagerPO webManagerPO) throws RemoteException {
		return this.webManagerHelper.modify(webManagerPO);
	}

}
