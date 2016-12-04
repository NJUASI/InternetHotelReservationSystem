package dataService.marketDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.MarketPO;
import utilities.ResultMessage;

public interface MarketDataService extends Remote{
	
	public List<MarketPO> getMemberFormulation() throws RemoteException;
	
	public ResultMessage setMemberFormulation (List<MarketPO> marketPOList) throws RemoteException;
}
