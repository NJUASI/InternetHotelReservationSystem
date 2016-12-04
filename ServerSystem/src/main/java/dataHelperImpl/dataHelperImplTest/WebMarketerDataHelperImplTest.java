package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataHelper.WebMarketerDataHelper;
import dataHelperImpl.WebMarketerDataHelperImpl;
import po.WebMarketerPO;
import utilities.ResultMessage;

public class WebMarketerDataHelperImplTest {

	WebMarketerDataHelper helper = null;
	
	@Before
	public void setUp() throws Exception {
	
		helper = new WebMarketerDataHelperImpl();
	}

	@Test
	public void testAdd() {
		WebMarketerPO webMarketerPO = new WebMarketerPO("100002", "123456");
		assertEquals(ResultMessage.SUCCESS,helper.add(webMarketerPO));
	}

	@Test
	public void testModify() {
		WebMarketerPO webMarketerPO = new WebMarketerPO("100001", "111111");
		assertEquals(ResultMessage.SUCCESS,helper.modify(webMarketerPO));
	}

	@Test
	public void testDelete() {
		assertEquals(ResultMessage.SUCCESS,helper.delete("100002"));
	}

	@Test
	public void testGetSingle() {
		WebMarketerPO webMarketerPO = helper.getSingle("100000");
		assertEquals("123456",webMarketerPO.getPassword());
	}

	@Test
	public void testGetAll() {
		List<WebMarketerPO> list = helper.getAll();
		assertEquals("111111",list.get(1).getPassword());
	}
}
