package dataService.marketDataService;

import java.util.ArrayList;
import java.util.List;

import po.MarketPO;
import utilities.ResultMessage;

public class MarketDataService_Stub implements MarketDataService {


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
