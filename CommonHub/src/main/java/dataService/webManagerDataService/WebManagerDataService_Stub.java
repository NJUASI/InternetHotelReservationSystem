package dataService.webManagerDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.WebManagerPO;
import utilities.ResultMessage;

public class WebManagerDataService_Stub extends UnicastRemoteObject implements WebManagerDataService{

	
	public WebManagerDataService_Stub() throws RemoteException {
		super();
	}


	public WebManagerPO getSingleWebManager(String webManagerID) {
		return new WebManagerPO("0001", "123456");
	}

	
	public List<WebManagerPO> getAllWebManager() {
		 List<WebManagerPO> list = new  ArrayList<WebManagerPO>();
		 WebManagerPO a= new WebManagerPO("0001", "123456");
		 list.add(a);
		return list;
	}

	
	public WebManagerPO add(WebManagerPO newWebManagerPO) {
		return new WebManagerPO("0001", "123456");
	}

	
	public ResultMessage modify(WebManagerPO webManagerPO) {
		return ResultMessage.SUCCESS;
	}


}
