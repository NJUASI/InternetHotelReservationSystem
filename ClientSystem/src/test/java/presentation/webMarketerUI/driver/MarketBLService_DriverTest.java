package presentation.webMarketerUI.driver;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import businessLogic.marketBL.stub.MarketBLService_Stub;
import utilities.ResultMessage;
import vo.MarketVO;

public class MarketBLService_DriverTest {

	@Test
	public void test() {
		//test interface setMemberFormulation
		MarketBLService_Stub stub = new MarketBLService_Stub();
		MarketBLService_Driver driver = new MarketBLService_Driver(stub);
		
		List<MarketVO> list = new LinkedList<MarketVO>();
		list.add(new MarketVO("Lv1", 500, 0.9));
		
		assertEquals(ResultMessage.SUCCESS, driver.marketBLService.setMemberFormulation(list));
	}

}
