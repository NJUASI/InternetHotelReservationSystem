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
		// TODO 自动生成的构造函数存根
	}


	public List<MarketPO> getMemberFormulation() {
		// TODO Auto-generated method stub
		List<MarketPO> a= new ArrayList<MarketPO>();
		MarketPO b= new MarketPO("aa",0,0.9);
		a.add(b);
		return a;
	}


	public ResultMessage setMemberFormulation(List<MarketPO> marketPOList) {
		// TODO Auto-generated method stub
		return null;
	}

}
