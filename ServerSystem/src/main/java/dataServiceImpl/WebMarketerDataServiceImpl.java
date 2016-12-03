package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.WebMarketerDataHelper;
import dataHelperImpl.stub.DataFactoryImpl_Stub;
import dataService.webMarketerDataService.WebMarketerDataService;
import po.WebMarketerPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class WebMarketerDataServiceImpl extends UnicastRemoteObject implements WebMarketerDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	private DataFactoryImpl_Stub factory;
	
	private WebMarketerDataHelper webMarketerHelper;
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1 构造函数，从工厂中获取webMarketerDataHlper对象
	 */
	public WebMarketerDataServiceImpl() throws RemoteException {
//		this.factory = DataFactoryImpl.getInstance();
		this.factory = DataFactoryImpl_Stub.getInstance();
		this.webMarketerHelper = this.factory.getWebMarketerDataHelper();
	
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerID 网站营销人员ID
	 * @return WebMarketerPO webMarketerInfo载体
	 */
	public WebMarketerPO getSingleWebMarketer(String webMarketerID) throws RemoteException {
		WebMarketerPO webMarketerPO = this.webMarketerHelper.getSingle(webMarketerID);
		// 从数据库中得到webMarketerPO，若不存在则为空
		return webMarketerPO;
	
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @return List<WebMarketerPO> 所有webMarketerInfo载体
	 */
	public List<WebMarketerPO> getAllWebMarketer() throws RemoteException {
		
		List<WebMarketerPO> list = this.webMarketerHelper.getAll();
		// 从数据库中得到所有webMarketerWorkerPO，若不存在则为空
		if(list.isEmpty()){return null;}
		
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param newWebMarketerPO webMarketerInfo载体
	 * @return ResultMessage 是否成功添加webMarketerInfo
	 */
	public ResultMessage add(WebMarketerPO newWebMarketerPO) throws RemoteException {
		return this.webMarketerHelper.add(newWebMarketerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerPO webMarketerInfo载体
	 * @return ResultMessage 是否成功修改webMarketerInfo
	 */
	public ResultMessage modify(WebMarketerPO webMarketerPO) throws RemoteException {
		return this.webMarketerHelper.modify(webMarketerPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerID 网站营销人员ID
	 * @return ResultMessage 是否成功删除webMarketerInfo
	 */
	public ResultMessage deleteWebMarketer(String webMarekterID) throws RemoteException {
		return this.webMarketerHelper.delete(webMarekterID);
	}

}
