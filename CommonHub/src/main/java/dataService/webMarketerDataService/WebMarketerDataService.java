package dataService.webMarketerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.verificationException.UserInexistException;
import po.WebMarketerPO;
import utilities.enums.ResultMessage;

public interface WebMarketerDataService extends Remote {

	public WebMarketerPO getSingleWebMarketer(String webMarketID) throws RemoteException, UserInexistException;
	
	public List<WebMarketerPO> getAllWebMarketer () throws RemoteException;

	public WebMarketerPO add(WebMarketerPO newWebMarketerPO) throws RemoteException;

	public ResultMessage modify (WebMarketerPO webMarketerPO) throws RemoteException;

	public ResultMessage deleteWebMarketer(String webMarketerID) throws RemoteException;
}
