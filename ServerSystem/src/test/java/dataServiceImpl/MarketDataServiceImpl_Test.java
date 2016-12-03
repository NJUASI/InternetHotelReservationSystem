package dataServiceImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dataService.marketDataService.MarketDataService;
import po.MarketPO;
import utilities.ResultMessage;

public class MarketDataServiceImpl_Test {

	@Test
	public void testGetMemberFormulation() {
		//test the method GetMemberFormulation
		try {
			MarketDataService market = new MarketDataServiceImpl();
			List<MarketPO> list = market.getMemberFormulation();
			MarketPO marketPO = list.get(0);
			
			assertEquals(marketPO.getMarketName(),"aa");
			assertEquals(marketPO.getMarketCredit(),0,0);
			assertEquals(marketPO.getMarketBenefit(),0.9,0);
			} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetMemberFormulation() {
		//test the method SetMemberFormulation
		try {
			MarketDataService market = new MarketDataServiceImpl();
			MarketPO marketPO = new MarketPO("aa",0,0.9);
			List<MarketPO> list = new ArrayList<MarketPO>();
			list.add(marketPO);
			
			assertEquals(market.setMemberFormulation(list),ResultMessage.SUCCESS);
			} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
