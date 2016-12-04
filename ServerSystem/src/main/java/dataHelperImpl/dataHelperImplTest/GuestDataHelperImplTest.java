package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataHelper.GuestDataHelper;
import dataHelperImpl.GuestDataHelperImpl;
import po.GuestPO;
import utilities.ResultMessage;

public class GuestDataHelperImplTest {

	GuestDataHelper helper = null;
	
	@Before
	public void setUp() throws Exception {
		helper = new GuestDataHelperImpl();
	}

	@Test
	public void testAdd() {
		GuestPO guestPO = new GuestPO("1234567890", LocalDate.of(2016, 3, 2), "school", 
				"DJY", "FFFD", "000001", "13523456789", 107);
		assertEquals(ResultMessage.SUCCESS,helper.add(guestPO));
	}

	@Test
	public void testModify() {
		GuestPO guestPO = new GuestPO("1000000000", LocalDate.of(1997, 8, 1), "home", 
				"B", "BC", "100000", "12345098761", 207);
		assertEquals(ResultMessage.SUCCESS,helper.modify(guestPO));
	}

	@Test
	public void testGetSingle() {
		GuestPO guestPO = helper.getSingle("1000000001");
		
		assertEquals(LocalDate.of(2016, 3, 13),guestPO.getBirthday());
		assertEquals("学校",guestPO.getEnterprise());
		assertEquals("张三",guestPO.getName());
		assertEquals(233,guestPO.getCredit(),0);
	}

	@Test
	public void testGetAll() {
		List<GuestPO> list = helper.getAll();
		
		assertEquals(LocalDate.of(2016, 3, 13),list.get(1).getBirthday());
		assertEquals("学校",list.get(1).getEnterprise());
		assertEquals("张三",list.get(1).getName());
		assertEquals(233,list.get(1).getCredit(),0);
		
		assertEquals(LocalDate.of(1996, 1, 1),list.get(2).getBirthday());
		assertEquals("钢铁",list.get(2).getEnterprise());
		assertEquals("A",list.get(2).getName());
		assertEquals(100,list.get(2).getCredit(),0);
		
	}
}
