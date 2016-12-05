package dataService.webMarketerDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.WebMarketerPO;
import utilities.ResultMessage;

public class WebMarketerDataService_Stub extends UnicastRemoteObject implements WebMarketerDataService{

	
	public WebMarketerDataService_Stub() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}


	public WebMarketerPO getSingleWebMarketer(String webMarketID) {
		return new WebMarketerPO("000001", "123456");
	}

	
	public List<WebMarketerPO> getAllWebMarketer() {
		List<WebMarketerPO> list= new ArrayList<WebMarketerPO>();
		WebMarketerPO a= new WebMarketerPO("000001", "123456");
		list.add(a);
		return list;
	}
	
	
	public WebMarketerPO add(WebMarketerPO newWebMarketerPO) {
		return new WebMarketerPO("000001", "123456");
	}

	
	public ResultMessage modify(WebMarketerPO webMarketerPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage deleteWebMarketer(String webMarketerID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
