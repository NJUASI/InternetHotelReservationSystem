package businessLogic.marketBL.driver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.marketDataService.MarketDataService_Stub;
import po.MarketPO;

public class MarketDataService_DriverTest {

	@Test
	public void test() {
		MarketDataService_Stub stub = null;
		try {
			stub = new MarketDataService_Stub();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		MarketDataService_Driver driver = new MarketDataService_Driver(stub);
		
		try {
			MarketPO marketPO = driver.marketDataService.getMemberFormulation().get(0);
			
			assertEquals("aa", marketPO.getMarketName());
			assertEquals(0, marketPO.getMarketCredit(), 0);
			assertEquals(0.9, marketPO.getMarketBenefit(), 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
