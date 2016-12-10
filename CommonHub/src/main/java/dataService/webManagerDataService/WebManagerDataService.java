package dataService.webManagerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.verificationException.UserInexistException;
import po.WebManagerPO;
import utilities.enums.ResultMessage;

public interface WebManagerDataService extends Remote{

	public WebManagerPO getSingleWebManager(String webManagerID) throws RemoteException, UserInexistException;
	
	public List<WebManagerPO> getAllWebManager() throws RemoteException;

	public WebManagerPO add(WebManagerPO newWebManagerPO) throws RemoteException;

	public ResultMessage modify(WebManagerPO webManagerPO) throws RemoteException;

}
