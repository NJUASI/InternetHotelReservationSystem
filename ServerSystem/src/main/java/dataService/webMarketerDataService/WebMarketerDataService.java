package dataService.webMarketerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.WebMarketerPO;
import utilities.ResultMessage;

public interface WebMarketerDataService extends Remote{

	public WebMarketerPO getSingleWebMarketer (String webMarketID) throws RemoteException;
	
	public List<WebMarketerPO> getAllWebMarketer () throws RemoteException;

	public ResultMessage add(WebMarketerPO newWebMarketerPO) throws RemoteException;

	public ResultMessage modify (WebMarketerPO webMarketerPO) throws RemoteException;

	public ResultMessage deleteWebMarketer(String webMarketerID) throws RemoteException;
}
