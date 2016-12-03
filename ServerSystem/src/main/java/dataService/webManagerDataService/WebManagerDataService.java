package dataService.webManagerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.WebManagerPO;
import utilities.ResultMessage;

public interface WebManagerDataService extends Remote{

	public WebManagerPO getSingleWebManager(String webManagerID) throws RemoteException;
	
	public List<WebManagerPO> getAllWebManager() throws RemoteException;

	public ResultMessage add(WebManagerPO newWebManagerPO) throws RemoteException;

	public ResultMessage modify(WebManagerPO webManagerPO) throws RemoteException;
	
}
