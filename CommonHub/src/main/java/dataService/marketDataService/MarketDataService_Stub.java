package dataService.marketDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.MarketPO;
import utilities.ResultMessage;

public class MarketDataService_Stub extends UnicastRemoteObject implements MarketDataService {


	public MarketDataService_Stub() throws RemoteException {
		super();
	}


	public List<MarketPO> getMemberFormulation() {
		List<MarketPO> a= new ArrayList<MarketPO>();
		MarketPO b= new MarketPO("aa",0,0.9);
		a.add(b);
		return a;
	}


	public ResultMessage setMemberFormulation(List<MarketPO> marketPOList) {
		return null;
	}

}
