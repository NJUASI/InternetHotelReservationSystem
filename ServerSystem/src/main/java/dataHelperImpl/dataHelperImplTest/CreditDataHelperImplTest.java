package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dataHelper.CreditDataHelper;
import dataHelperImpl.CreditDataHelperImpl;
import po.CreditPO;
import utilities.enums.CreditRecord;
import utilities.enums.ResultMessage;

public class CreditDataHelperImplTest {

	CreditDataHelper helper = null;
	
	@Before
	public void setUp() throws Exception {
		helper = new CreditDataHelperImpl();
	}

	@Ignore
	@Test
	public void testGetAll() {
		
		List<CreditPO>  list = helper.getAllCreditDetail("1000000001");	
		
		
		assertEquals(LocalDateTime.of(2016, 12, 03, 02, 14,21),list.get(0).getTime());
		assertEquals("345620161209",list.get(1).getOrderID());
		assertEquals(222,list.get(0).getPreCredit(),0);
		assertEquals(233,list.get(1).getCredit(),0);
		assertEquals("executed",list.get(0).getCreditRecord().EXECUTE);
	}

	@Test
	public void testAdd() {
		CreditPO creditPO = new CreditPO("1234567900",LocalDateTime.of(2016, 12, 07, 18, 14,21),"",111,444,CreditRecord.CHARGE);
		
		assertEquals(ResultMessage.SUCCESS,helper.addCredit(creditPO));
	}
}
